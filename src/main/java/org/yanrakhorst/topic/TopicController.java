package org.yanrakhorst.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	TopicService topicService;
	
	
	@GetMapping
	public List<Topic> getAllTopics() {
		System.out.println("in getAllTopics controller");
		return topicService.getAllTopics();
	
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)	
	public Topic getTopic(@PathVariable String id){
		System.out.println("in getTopic controller");
		return topicService.getTopic(id);
	}
	
	@PostMapping
	public Topic addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topic;
	}
	
	@PutMapping("/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
		return topic;
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		
	}
	
}
