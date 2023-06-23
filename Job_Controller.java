package com.sb.sample;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Job_Controller {
	@Autowired
	Job_Service es;

	@PostMapping("/JobInsert")
	public Map insertJob(@RequestBody Job job) {
		return es.insertjob(job);
		
	}
	
	@GetMapping("/JobFetch")
	public List getJobData() {
		return es.getjobdata();
		
	}
	@PutMapping("/JobUpdate")
	public int updateJob(@RequestBody Job job) {
		return es.updatejob(job);
	}
	
	@DeleteMapping("/JobDelete")
	public String deleteJob(@RequestBody Job job) {
		int i=es.deletejob(job);
		if(i>0) {
			return "Data Deleted";
		}
		else
			return "Data Not Deleted";
	}

}