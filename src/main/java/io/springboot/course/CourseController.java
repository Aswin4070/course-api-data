package io.springboot.course;

import java.util.Arrays;
import java.util.List;

import org.opensaml.saml.ext.saml2aslo.Asynchronous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.topic.Topic;
import nu.xom.IllegalAddException;
import nu.xom.NoSuchAttributeException;

@RestController

public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/topics/{id}/courses")
	
	
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}") //("/topics/{foo}")
	public Course getCourse(@PathVariable String id) { //(@PathVariable("foo") String id) (We can do this in this way as well)
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) { 
		courseService.deleteCourse(id);
	}
	
}
