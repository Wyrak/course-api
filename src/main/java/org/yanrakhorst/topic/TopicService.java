package org.yanrakhorst.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	TopicService() {}

	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java", "Java1", "Java Descr"),
			new Topic("javascript", "JavaScript", "JavaScript Descr"),
			new Topic("Python", "Pyth2", "Pyth Descr")));

	public List<Topic> getAllTopics() {

		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}
	
	public Topic addTopic(Topic topic) {
		topics.add(topic);
		return topic;
	}

	public void updateTopic(Topic topic, String id) {
		for (Topic t : topics) {
			if (t.getId().equals(id)) {
				topics.set(topics.indexOf(t), topic);
			}
		}
		
	}

	public void deleteTopic(String id) {
		int index = 0;
		for (Topic t : topics) {
			if (t.getId().equals(id)) {
				index = topics.indexOf(t);
			}
		
	}
		topics.remove(index);
	}
}

