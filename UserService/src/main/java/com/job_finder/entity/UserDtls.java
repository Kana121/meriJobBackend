package com.job_finder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_DTLS")
public class UserDtls {
	@Id
	 @Column(name = "Serial_No")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long srno;
    private String fullName;
    private String emailId;
    private String mobileNumber;
    private String username;
    private String password;
    private String description;
    private String workStatus;
    @Lob
    private byte[] resume;
    
    private boolean currentlyEmployed;
    private int totalWorkExperienceYears;
    private int totalWorkExperienceMonths;
    private String previousCompany;
    private String previousJobTitle;
    private String currentCity;
    private double annualSalary;
    
    
   
}
