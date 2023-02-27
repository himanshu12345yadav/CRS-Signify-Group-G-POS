package com.signify.exception;


/**
 * Exception to check if course is available in catalog
* @author
 *
 */
public class CourseNotFoundException extends Exception{
	private String courseCode;
	/**
	 * Constructor
	 * @param courseCode
	 */
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	/**
	 * Getter function for course code
	 * @return
	 */
	public String getCourseCode()
	{
		return courseCode;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "\nCOURSE WITH COURSE CODE \""+courseCode+"\" NOT PRESENT IN CATALOG!\n";
	}
}
