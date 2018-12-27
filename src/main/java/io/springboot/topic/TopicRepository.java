package io.springboot.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TopicRepository extends PagingAndSortingRepository<Topic, String> {
	
	
}
