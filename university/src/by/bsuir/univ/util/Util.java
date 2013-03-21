/**
 * 
 */
package by.bsuir.univ.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import by.bsuir.univ.model.Mark;
import by.bsuir.univ.model.Student;

/**
 * @author SBozhko
 * 
 */
public class Util {
	public static List<Student> parseStudents(String students) {
		students = students.trim();
		List<Student> studentsList = new ArrayList<>();
		StringTokenizer objectsTokens = new StringTokenizer(students, ";");
		Student student;
		while (objectsTokens.hasMoreElements()) {
			student = new Student();
			String currentrStudent = objectsTokens.nextElement().toString();

			StringTokenizer fieldsTokens = new StringTokenizer(currentrStudent, ",");
			while (fieldsTokens.hasMoreElements()) {
				String currentField = fieldsTokens.nextElement().toString();

				StringTokenizer valuesTokens = new StringTokenizer(currentField, "=");

				String currentFieldName = valuesTokens.nextElement().toString().trim();
				String currentFieldValue = valuesTokens.nextElement().toString().trim();

				System.out.println(currentFieldName);
				System.out.println(currentFieldValue);
				
				switch (StudentFields.valueOf(currentFieldName.toUpperCase())) {
				case ID:
					student.setId(Long.parseLong(currentFieldValue));
					break;

				case AVERAGEMARK:
					System.out.println("currentFieldValue" + currentFieldValue);
					student.setAverageMark(new Mark(Float.parseFloat(currentFieldValue)));
					break;

				case EMAIL:
					student.setEmail(currentFieldValue);
					break;

				case FULLNAME:
					student.setFullName(currentFieldValue);
					break;

				case PASSWORD:
					student.setPassword(currentFieldValue);
					break;

				default:
					break;
				}
			}
			studentsList.add(student);
			System.out.println(student);
		}
		return studentsList;
	}
}
