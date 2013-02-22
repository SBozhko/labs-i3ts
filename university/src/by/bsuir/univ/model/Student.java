/**
 * 
 */
package by.bsuir.univ.model;

/**
 * @author SBozhko
 * 
 */
public class Student extends User implements Comparable<Student> {
	private Mark averageMark = new Mark();

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

	@Override
	public int compareTo(Student otherStudent) {
		return (int) (this.averageMark.getGrade() - otherStudent.averageMark.getGrade());
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [averageMark=" + averageMark + "]" + super.toString();
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
