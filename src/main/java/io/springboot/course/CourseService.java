package io.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId){
		//return courses;
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
		//return (List<course>) courseRepository.findAll();
	}
	
	public Course getCourse(String id) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRepository.save(course); 
			
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
		//courses.removeIf(t ->t.getId().equals(id));
		
	}
}
