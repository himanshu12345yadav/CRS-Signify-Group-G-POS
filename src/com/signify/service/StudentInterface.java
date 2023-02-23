/**
 * 
 */
package com.signify.service;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Grades;
import com.signify.bean.OfflinePayment;
import com.signify.bean.OnlinePayment;
import com.signify.bean.Payment;
import com.signify.bean.RegisteredCourse;

/**
 * @author dp201
 *
 */
public interface StudentInterface {
	public void register();
	public String getStudentId(String userid);
	public int getApprovedStatus(String studentId);
	public void semesterRegstration();
	public void addCourse(String studentId, String courseCode, int type);
	public void dropCourse(String studentId, String courseId);		
//	public List<RegisteredCourse> viewRegisterCourses(String studentId);
//	public List<Grades> viewGrades(String studentId);
	public void viewRegisterCourses(String studentId);
	public void viewGrades(String studentId);
	public double getFees(String studentId);
	public void payFeesByCard(OnlinePayment onp, Payment p);
	public void payFeesByNetBanking(OnlinePayment onp, Payment p);
	public void payFeesByCash(OfflinePayment ofp, Payment p);
	public void payFeesByCheque(OfflinePayment ofp, Payment p);
	public List<Course> getAvailableCourses();

}
