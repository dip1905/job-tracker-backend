package com.app.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String jobTitle;
    private String status;
    private String email;
    private String contact;
    private String jobLink;
    private LocalDate appliedDate;

    @Column(length = 1000)
    private String notes;

    @ManyToOne
    private User user;

    public JobApplication() {}

    

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getJobLink() {
		return jobLink;
	}



	public void setJobLink(String jobLink) {
		this.jobLink = jobLink;
	}



	public LocalDate getAppliedDate() {
		return appliedDate;
	}



	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}
