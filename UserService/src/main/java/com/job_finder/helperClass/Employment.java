package com.job_finder.helperClass;

import lombok.Data;

@Data
public class Employment {

	public Employment(boolean currentlyEmployed2, int totalWorkExperienceYears2, String previousCompany2,
			String previousJobTitle2, String currentCity2, double annualSalary2) {
		// TODO Auto-generated constructor stub
	}
	
	private boolean currentlyEmployed;
    private int totalWorkExperienceYears;
    private int totalWorkExperienceMonths;
    private String previousCompany;
    private String previousJobTitle;
    private String currentCity;
    private double annualSalary;
    
}
