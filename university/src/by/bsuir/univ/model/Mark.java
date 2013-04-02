/**
 * 
 */
package by.bsuir.univ.model;

/**
 * @author SBozhko
 * 
 */
public class Mark {
	private static final float MIN_POSITIVE_GRADE = 4;
	public static final int BAD_MARKS_COUNT_TO_DISMISS = 4;
	private float grade;

	/**
	 * 
	 */
	public Mark() {
	}

	/**
	 * @param grade
	 */
	public Mark(float grade) {
		this.grade = grade;
	}

	/**
	 * @return the grade
	 */
	public float getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(float grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "" + grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(grade);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Mark))
			return false;
		Mark other = (Mark) obj;
		if (Float.floatToIntBits(grade) != Float.floatToIntBits(other.grade))
			return false;
		return true;
	}

	public Mark add(Mark value) {
		grade += value.getGrade();
		return this;
	}

	public Mark calculateAverage(int marksCount) {
		return new Mark(grade / marksCount);
	}

	public boolean isPositive() {
		return grade >= MIN_POSITIVE_GRADE;
	}

}
