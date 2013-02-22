/**
 * 
 */
package by.bsuir.univ.model;

/**
 * @author SBozhko
 * 
 */
public class Teacher extends User {
	/**
	 * 
	 */
	public Teacher() {
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " []" + super.toString();
	}

}
