package io.springboot.topic;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	@ResponseStatus(HttpStatus.OK)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}") //("/topics/{foo}")
	public Response getTopic(@PathVariable String id) { //(@PathVariable("foo") String id) (We can do this in this way as well)
		return Response.accepted(topicService.getTopic(id)).status(201).build();
				//topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) { 
		topicService.deleteTopic(id);
	}
	
}
