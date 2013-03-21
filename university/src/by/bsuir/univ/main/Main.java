/**
 * 
 */
package by.bsuir.univ.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.bsuir.univ.model.Mark;
import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.Teacher;
import by.bsuir.univ.util.Util;

/**
 * @author SBozhko
 * 
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		Teacher teacher = new Teacher();
		teacher.setFullName("Teacher Teacher Teacher");
		System.out.println(teacher);

		Student student1 = new Student();
		student1.setFullName("Student1 Student1 Student1");
		student1.setAverageMark(new Mark(15));
		System.out.println(student1);

		Student student2 = new Student();
		student2.setFullName("Student2 Student2 Student2");
		student2.setAverageMark(new Mark(10));
		System.out.println(student2);

		Student student3 = new Student();
		student3.setFullName("Student3 Student3 Student3");
		student3.setAverageMark(new Mark(18));
		System.out.println(student3);

		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);

		Collections.sort(students);

		System.out.println("------------------1");
		
		System.out.println(Util.getListAsString(students));
		Util.printToFile(students, "students.txt");
		

		String studentsToParse = Util.getListAsString(students);
		
		System.out.println("------------------2");

		List<Student> parsedStudents = Util.readFromFile("students.txt");

		System.out.println("------------------3");

		for (Student s : parsedStudents) {
			System.out.println(s);
		}

	}
}
