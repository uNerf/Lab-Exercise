package com.ust.test;
import com.ust.domain.Student;
public class TestStudent
{
	public static void main(String args[])
	{
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.setName("Jubhert");
		s2.setName("");
		s3.setName("Jon");
		
		s1.setStudNo(6721);
		s2.setStudNo(1234);
		s3.setStudNo(-5672);
		
		s1.setCourse("BSCS");
		s2.setCourse("");
		s3.setCourse("BSIT");
		
		System.out.println(s1.showDetails());
		System.out.println(s2.showDetails());
		System.out.println(s3.showDetails());
	}
}