package com.ust.domain;
public class Student
{
	private String name;
	private int studNo;
	private String course;

	public Student(String n, int s, String c)
	{
		setName(n);
		setStudNo(s);
		setCourse(c);
	}
	public Student()
	{}

	//setters
	public void setName(String n)
	{
		if(n ==""||n==" ")
			name = "noValue";
		else
			name = n;
	}
	public void setCourse(String c)
	{
		if(c==""||c==" ")
			course = "noValue";
		else
			course = c;
	}
	public void setStudNo(int s)
	{
		if(s>=0)
			studNo = s;
		else
			studNo = 0;
	}
	//getters
	public String showDetails()
	{
		return (name + " has a student number of " + studNo + " and taking up " + course);
	}
}
