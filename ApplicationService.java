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
public class ApplicationService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedtemplate;

	public Map insertapplication(Applications applications) {
		HashMap<String, String> hm = new HashMap<>();
		int id = applications.getId();
		String applicant_name = applications.getApplicant_name();
		long applicant_contact_info = applications.getApplicant_contact_info();
		int job_id = applications.getJob_id();
		StatusEnum status =applications.getStatus();
		int user_id = applications.getUser_id();

		String sql = "INSERT INTO application (id, applicant_name, applicant_contact_info, job_id, status, user_id) values(:id,:applicant_name,:applicant_contact_info,:job_id,:status,:user_id)";
		SqlParameterSource ps = new MapSqlParameterSource().addValue("id", id)
				.addValue("applicant_name", applicant_name)
				.addValue("applicant_contact_info", applicant_contact_info).addValue("job_id", job_id)
				.addValue("status", status.toString()).addValue("user_id", user_id);
		int i = namedtemplate.update(sql, ps);
		if (i > 0) {
			hm.put("Successs", "values inserted");
		} else {
			hm.put("Failure", "values not inserted");
		}
		return hm;
	}
	
	
	//fetch
	public List getapplicationdata() {
		List getData=new ArrayList();
		HashMap dataList=null;
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		String sql="select * from application";
		data=jdbcTemplate.queryForList(sql);
		for(Map listdata:data) {
			dataList=new HashMap();
			dataList.put("id", listdata.get("id"));
			dataList.put("applicant_name", listdata.get("applicant_name"));
			dataList.put("applicant_contact_infopartment", listdata.get("applicant_contact_info"));
			dataList.put("job_id", listdata.get("job_id"));
			dataList.put("status", listdata.get("status"));
			dataList.put("user_id", listdata.get("user_id"));
			getData.add(dataList);
		}
		return getData;
	}
	
	//update
	public int updateapplication(Applications applications) {
		int id = applications.getId();
		String applicant_name = applications.getApplicant_name();
		long applicant_contact_info = applications.getApplicant_contact_info();
		int job_id = applications.getJob_id();
		StatusEnum status = applications.getStatus();
		int user_id = applications.getUser_id();
		String fieldname;
		StatusEnum valueb;
		long valuel;
		int valuei;
		String value;
		String adding ="update application set ";
		if (applications.getApplicant_name() != null) {
			fieldname = "applicant_name";
			value = applications.getApplicant_name();
			adding += fieldname + "='" + value + "',";
		}
		if (applications.getApplicant_contact_info() != 0) {
			fieldname = "applicant_contact_info";
			valuel = applications.getApplicant_contact_info();
			adding += fieldname + "=" + valuel + ",";
		}
		if (applications.getJob_id() != 0) {
			fieldname = "job_id";
			valuei = applications.getJob_id();
			adding += fieldname + "=" + valuei + ",";
		}
		if (applications.getStatus() != null) {
			fieldname = "status";
			valueb = applications.getStatus();
			adding += fieldname + "='" + valueb + "',";
		}
		if (applications.getUser_id() != 0) {
			fieldname = "user_id";
			valuei = applications.getUser_id();
			adding += fieldname + "=" + valuei + ",";
		}
		int length = adding.length();
		adding = adding.substring(0, length - 1);
		int Id = applications.getId();
		adding += " where id=?";
		System.out.println(adding);
		return jdbcTemplate.update(adding, Id);
	}
	
	public int deleteapplication(Applications applications) {
		int id = applications.getId();
		String sql = "delete from application where id=?";
		int i = jdbcTemplate.update(sql, id);
		return i;
	}
}
