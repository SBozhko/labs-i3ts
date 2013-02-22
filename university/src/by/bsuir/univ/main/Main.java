/**
 * 
 */
package by.bsuir.univ.main;

import by.bsuir.univ.model.Mark;
import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.Teacher;

/**
 * @author SBozhko
 * 
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.setFullName("Teacher Teacher Teacher");
		System.out.println(teacher);
		
		Student student = new Student();
		student.setFullName("Student1 Student1 Student1");
		student.setAverageMark(new Mark(15));
	}

}
