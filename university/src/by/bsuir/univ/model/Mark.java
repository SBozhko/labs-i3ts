package by.bsuir.univ.model;

public class Mark implements Comparable<Mark> {

    private static final float MIN_POSITIVE_GRADE = 4;
    public static final int BAD_MARKS_COUNT_TO_DISMISS = 4;
    private float grade;

    public Mark() {
    }

    public Mark(float grade) {
        this.grade = grade;
    }

    public Mark(String text) {
        grade = Float.parseFloat(text);
    }

    public float getGrade() {
        return grade;
    }

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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) obj;
        if (Float.floatToIntBits(grade) != Float.floatToIntBits(other.grade)) {
            return false;
        }
        return true;
    }

    public Mark add(Mark value) {
        grade += value.getGrade();
        return this;
    }

    public Mark calculateAverage(int marksCount) {
        return new Mark(grade / marksCount);
    }

    public boolean checkPositive() {
        return grade >= MIN_POSITIVE_GRADE;
    }

    public int compareTo(Mark o) {
        float diff = this.grade - o.getGrade();
        if (diff < 0) {
            return -1;
        } else {
            if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        }

    }
}
