package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStaffFeedbackRepo;
import com.app.entities.StaffFeedback;

@Service
@Transactional
public class StaffFeedbackServiceImpl implements IStaffFeedbackService {
	
	@Autowired
	private IStaffFeedbackRepo staffFeedbackRepo;
	
	@Override
	public List<StaffFeedback> getFeedbackFromEmployeeId(int id) {
		
		return staffFeedbackRepo.getFromEmployeeId(id);
	}

	@Override
	public StaffFeedback getFeedbackFromId(int id) {
		// TODO Auto-generated method stub
		return staffFeedbackRepo.getFromId(id);
	}

	@Override
	public StaffFeedback saveFeedback(StaffFeedback feedback) {
		// TODO Auto-generated method stub
		return staffFeedbackRepo.save(feedback);
	}

	@Override
	public List<StaffFeedback> getFeedbackFromDept(int id) {
		// TODO Auto-generated method stub
		return staffFeedbackRepo.getEmployeeFeedbackFromDept(id);
	}

}
