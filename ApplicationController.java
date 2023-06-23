package com.sb.sample;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	@Autowired
	ApplicationService applicationService;

	@PostMapping("/ApplicationInsert")
	public Map insertApplication(@RequestBody Applications applications) {
		return applicationService.insertapplication(applications);

	}
	@GetMapping("/ApplicationFetch")
	public List getApplicationData() {
		return applicationService.getapplicationdata();
	}
	@PutMapping("/ApplicationUpdate")
	public int updateApplication(@RequestBody Applications applications) {
		return applicationService.updateapplication(applications);
	}
	@DeleteMapping("/ApplicationDelete")
	public String deleteApplication(@RequestBody Applications applications){
		int i=applicationService.deleteapplication(applications);
		if(i>0) {
			return "Data Deleted";
		}
		else
			return "Data Not Deleted";
	}

}
