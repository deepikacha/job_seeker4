package com.sb.sample;

public class Applications {
	private int id;
	private String applicant_name;
	private long applicant_contact_info;
	private int job_id;
    private StatusEnum status;
	private int user_id;

    

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public long getApplicant_contact_info() {
		return applicant_contact_info;
	}

	public void setApplicant_contact_info(long applicant_contact_info) {
		this.applicant_contact_info = applicant_contact_info;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
