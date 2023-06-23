package com.sb.sample;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class Job_Service {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map insertjob(Job job) {
		HashMap<String, String> hm = new HashMap<>();
		int id = job.getId();
		String title = job.getTitle();
		String jobType = job.getJobType();
		int company_id = job.getCompany_id();
		String location = job.getLocation();
		int salary = job.getSalary();
		String companyName = job.getCompanyName();
		String jobSkills = job.getJobSkills();
		LocalDateTime date_posted = LocalDateTime.now();
		String sql = "INSERT INTO Jobs (id, title, jobType, company_id, location, salary, date_posted,companyName,jobSkills) values(:id,:title,:jobType,:company_id,:location,:salary,:date_posted,:companyName,:jobSkills)";
		SqlParameterSource sqlParamSource = new MapSqlParameterSource().addValue("id", id).addValue("title", title)
				.addValue("jobType", jobType).addValue("company_id", company_id).addValue("location", location)
				.addValue("salary", salary).addValue("date_posted", date_posted).addValue("companyName", companyName)
				.addValue("jobSkills", jobSkills);
//LocalDateTime date_posted = LocalDateTime.now();
		int i = namedParameterJdbcTemplate.update(sql, sqlParamSource);
		if (i > 0) {
			hm.put("Successs", "values inserted");
		} else {
			hm.put("Failure", "values not inserted");
		}
		return hm;
	}


	public List getjobdata() {
		List getData = new ArrayList();
		HashMap dataList = null;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		String sql = "select * from Jobs";
		data = jdbcTemplate.queryForList(sql);
		for (Map listdata : data) {
			dataList = new HashMap();
			dataList.put("id", listdata.get("id"));
			dataList.put("title", listdata.get("title"));
			dataList.put("jobType", listdata.get("jobType"));
			dataList.put("company_id", listdata.get("company_id"));
			dataList.put("location", listdata.get("location"));
			dataList.put("salary", listdata.get("salary"));
			dataList.put("date_posted", listdata.get("date_posted"));
			dataList.put("companyName", listdata.get("companyName"));
			dataList.put("jobSkills", listdata.get("jobSkills"));
			getData.add(dataList);
		}
		return getData;
	}

	public int updatejob(Job job) {
		int id = job.getId();
		String title = job.getTitle();
		String jobType = job.getJobType();
		int company_id = job.getCompany_id();
		String location = job.getLocation();
		int salary = job.getSalary();
		String companyName = job.getCompanyName();
		String jobSkills = job.getJobSkills();
		LocalDateTime date_posted = LocalDateTime.now();
		System.out.println(location);
		String fieldname;
		int valuei;
		String value;
		String adding ="update Jobs set ";
		if (job.getTitle() != null) {
			fieldname = "title";
			value = job.getTitle();
			adding += fieldname + "='" + value + "',";
		}
		if (job.getJobType() != null) {
			fieldname = "jobType";
			value = job.getJobType();
			adding += fieldname + "='" + value + "',";
		}
		if (job.getCompany_id() != 0) {
			fieldname = "company_id";
			valuei = job.getCompany_id();
			adding += fieldname + "=" + valuei + ",";
		}
		if (job.getLocation() != null) {
			fieldname = "location";
			value = job.getLocation();
			adding += fieldname + "='" + value + "',";
		}
		if (job.getSalary() != 0) {
			System.out.println(job.getSalary());
			fieldname = "salary";
			valuei = job.getSalary();
			adding += fieldname + "=" + valuei + ",";
		}
		if (job.getCompanyName() != null) {
			fieldname = "companyName";
			value = job.getCompanyName();
			adding += fieldname + "='" + value + "',";
		}
		if (job.getJobSkills() != null) {
			fieldname = "jobSkills";
			value = job.getJobSkills();
			adding += fieldname + "='" + value + "',";
		}
		int length = adding.length();
		adding = adding.substring(0, length - 1);
		int Id = job.getId();
		adding += " where id=?";
		System.out.println(adding);
		return jdbcTemplate.update(adding, Id);
	}

//delete

	public int deletejob(Job job) {
		int id = job.getId();
		String sql = "delete from Jobs where id=?";
		int i = jdbcTemplate.update(sql, id);
		return i;
	}
	

}
