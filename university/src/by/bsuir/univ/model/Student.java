package by.bsuir.univ.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student extends User implements Comparable<Student> {

    private Mark averageMark = new Mark();
    private Map<Course, Mark> courses = new LinkedHashMap<Course, Mark>();
    private int badMarksCount = 0;
    private StudentStatus status = StudentStatus.ACTIVE;

    public Student() {
    }

    public int getBadMarksCount() {
        return badMarksCount;
    }

    public void setBadMarksCount(int badMarksCount) {
        this.badMarksCount = badMarksCount;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus studentStatus) {
        this.status = studentStatus;
    }

    public Mark getAverageMark() {
        return averageMark;
    }

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
        mark.checkPositive();

        return averageMark;
    }

    private void checkBadMaksCount(Mark mark) {
        if (!mark.checkPositive()) {
            badMarksCount++;
        }
        if (badMarksCount == Mark.BAD_MARKS_COUNT_TO_DISMISS) {
            sendEmail();
        }

    }

    public void sendEmail() {
        if (badMarksCount == Mark.BAD_MARKS_COUNT_TO_DISMISS) {
            status = StudentStatus.DISMISSED;
            System.out.println("Dear, student " + getFullName()
                    + "! You are dismissed! LOL! Sad email for: " + getEmail());
        } else {
            System.out.println("Student (" + getFullName() + ") is stil alive! Congrats!");
        }
    }

    public int compareTo(Student otherStudent) {
        return this.getAverageMark().compareTo(otherStudent.getAverageMark());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + super.toString()
                + " [averageMark=" + averageMark + ", courses=" + courses
                + ", badMarksCount=" + badMarksCount + ", studentStatus=" + status + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.averageMark != null ? this.averageMark.hashCode() : 0);
        hash = 53 * hash + (this.courses != null ? this.courses.hashCode() : 0);
        hash = 53 * hash + this.badMarksCount;
        hash = 53 * hash + (this.status != null ? this.status.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.averageMark != other.averageMark && (this.averageMark == null || !this.averageMark.equals(other.averageMark))) {
            return false;
        }
        if (this.courses != other.courses && (this.courses == null || !this.courses.equals(other.courses))) {
            return false;
        }
        if (this.badMarksCount != other.badMarksCount) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }
}
