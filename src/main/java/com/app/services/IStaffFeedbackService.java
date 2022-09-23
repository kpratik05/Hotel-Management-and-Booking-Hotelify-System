package com.app.services;

import java.util.List;

import com.app.entities.StaffFeedback;

public interface IStaffFeedbackService {
	public List<StaffFeedback> getFeedbackFromEmployeeId(int id);
	
	public StaffFeedback getFeedbackFromId(int id);
	
	public StaffFeedback saveFeedback(StaffFeedback feedback);
	
	public List<StaffFeedback> getFeedbackFromDept(int id);
	
}
