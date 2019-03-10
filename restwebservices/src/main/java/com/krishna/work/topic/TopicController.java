package com.krishna.work.topic;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		System.out.println("I m TopicController::getAllTopics !");
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopicId(@PathVariable String id){
		
		System.out.println("I m TopicController::getTopicId !id->"+id);
		return topicService.getTopicId(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopics(@RequestBody Topic topic){
		System.out.println("I m TopicController::addTopics !");
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}")
	public void updateId(@PathVariable String id, @RequestBody Topic topic){
		System.out.println("I m TopicController::updateId !id->"+id);
		topicService.updateId(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/topic/{id}")
	public void deleteId(@PathVariable String id){
		System.out.println("I m TopicController::deleteId ! id->"+id);
		topicService.deleteId(id);
	}
	
}
