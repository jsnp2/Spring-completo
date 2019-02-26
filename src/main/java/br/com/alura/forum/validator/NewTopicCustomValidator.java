package br.com.alura.forum.validator;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.alura.forum.configuration.NewTopicInputDto;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.repository.TopicRepository;

public class NewTopicCustomValidator implements Validator {

	@Autowired
	private TopicRepository topicRepository;
	private User loggerUser;

	public NewTopicCustomValidator(TopicRepository topicRepository2, User loggerUser) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return NewTopicInputDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Instant oneHourAgo = Instant.now().minus(1, ChronoUnit.HOURS);
		List<Topic> topics = topicRepository.findByOwnerAndCreationInstantAfterOrderByCreationInstantAsc(loggerUser,
				oneHourAgo);

		PossibleSpam possibleSpam = new PossibleSpam(topics);
		
		if(possibleSpam.hasTopicLimitExceed()) {
			long minutesToNextTopic = possibleSpam.minutesToNextTopic(oneHourAgo);
			errors.reject("newTopicInputDto.limit.exceeded", new Object[] {minutesToNextTopic}, "O limite individual de novos topicos por hora foi executado");
		}
	}
	
	

}
