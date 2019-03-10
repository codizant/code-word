package com.krishna.work.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class TopicService {

	List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Boot","Spring Boot Learning"),
			new Topic("java", "java Core","java Core"),
			new Topic("java script", "java script work","java script Learning")
			)); 
	
	public List<Topic> getAllTopics() {
		System.out.println("I m TopicService:getAllTopics !");
		return topics;
	}

	public Topic getTopicId(String id) {
		System.out.println("I m TopicService:getTopicId ! id->"+id);
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		System.out.println("I m TopicService:getTopicId ");
		topics.add(topic);
	}
	
	
	
	public void updateId(String id, Topic topic) {
		System.out.println("I m TopicService:updateId !id->"+id);
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(topic.getId())) {
				topics.set(i, topic);
			}
		}
	}

	public void deleteId(String id) {
		System.out.println("I m TopicService:deleteId ! id->"+id);
		topics.removeIf(t->t.getId().equals(id));
	}
}
