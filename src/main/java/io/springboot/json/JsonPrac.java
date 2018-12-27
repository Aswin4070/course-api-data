package io.springboot.json;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/json")
public class JsonPrac {
	
	JsonRepository jsonRepository;
	
	@PostMapping("/set")
	public void setData(@RequestBody JsonPojo1 jp) {
		jsonRepository.save(jp);
	}
	
	@GetMapping("/get/{id}")
	public void getData(@PathVariable int id) {
		jsonRepository.findOne(id);
	}
}
