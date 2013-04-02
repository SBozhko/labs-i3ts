/**
 * 
 */
package by.bsuir.univ.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author SBozhko
 * 
 */
public class Student extends User implements Comparable<Student> {
	private Mark averageMark = new Mark();
	private Map<Course, Mark> courses = new LinkedHashMap<>();
	private int badMarksCount = 0;
	private StudentStatus studentStatus = StudentStatus.ACTIVE;

	public Student() {
	}

	/**
	 * @return the averageMark
	 */
	public Mark getAverageMark() {
		return averageMark;
	}

	/**
	 * @param averageMark
	 *            the averageMark to set
	 */
	public void setAverageMark(Mark averageMark) {
		this.averageMark = averageMark;
	}

	public Map<Course, Mark> getCourses() {
		return courses;
	}

	public void setCourses(Map<Course, Mark> courses) {
		this.courses = courses;
	}

	/**
	 * 
	 * @param course
	 * @param mark
	 * @return average mark after adding new mark
	 */
	public Mark addCourseAndMark(Course course, Mark mark) {
		courses.put(course, mark);

		Mark marksSum = new Mark();
		for (Map.Entry<Course, Mark> e : courses.entrySet()) {
			marksSum.add(e.getValue());
		}

		averageMark = marksSum.calculateAverage(courses.size());

		checkBadMaksCount(mark);
		mark.isPositive();

		return averageMark;
	}

	private void checkBadMaksCount(Mark mark) {
		if (!mark.isPositive()) {
			badMarksCount++;
		}

		if (badMarksCount == Mark.BAD_MARKS_COUNT_TO_DISMISS) {
			studentStatus = StudentStatus.DISMISSED;
			sendSadEmail();
		}
	}

	private void sendSadEmail() {
		System.out.println("You are dismissed! LOL! Sad email for: " + getEmail());
	}

	@Override
	public int compareTo(Student otherStudent) {
		return (int) (this.averageMark.getGrade() - otherStudent.averageMark.getGrade());
	}

	@Override
	public String toString() {
		return "averageMark=" + averageMark + ", " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((averageMark == null) ? 0 : averageMark.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (averageMark == null) {
			if (other.averageMark != null)
				return false;
		} else if (!averageMark.equals(other.averageMark))
			return false;
		return true;
	}

}
