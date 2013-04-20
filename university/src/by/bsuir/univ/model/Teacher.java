package by.bsuir.univ.model;

public class Teacher extends User {

    public Teacher() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " []" + super.toString();
    }
}
