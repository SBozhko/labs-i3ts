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
public class Course {
	private long id;
	private String title;
	private Map<Student, Mark> studentsMarks = new LinkedHashMap<Student, Mark>();
	private Teacher teacher;

	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher
	 *            the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the studentsMarks
	 */
	public Map<Student, Mark> getStudentsMarks() {
		return studentsMarks;
	}

	/**
	 * @param studentsMarks
	 *            the studentsMarks to set
	 */
	public void setStudentsMarks(Map<Student, Mark> studentsMarks) {
		this.studentsMarks = studentsMarks;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + id + ", title=" + title + ", studentsMarks=" + studentsMarks
				+ ", teacher=" + teacher + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((studentsMarks == null) ? 0 : studentsMarks.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		if (studentsMarks == null) {
			if (other.studentsMarks != null)
				return false;
		} else if (!studentsMarks.equals(other.studentsMarks))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
