package by.bsuir.univ.rmi.model;

import by.bsuir.univ.model.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student extends UnicastRemoteObject implements IStudent, Comparable<Student> {

    private Mark averageMark = new Mark();
    private Map<Course, Mark> courses = new LinkedHashMap<Course, Mark>();
    private int badMarksCount = 0;
    private StudentStatus studentStatus = StudentStatus.ACTIVE;
    private long id;
    private String fullName;
    private String email;
    private String password;

    public Student() throws RemoteException {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBadMarksCount() {
        return badMarksCount;
    }

    public void setBadMarksCount(int badMarksCount) {
        this.badMarksCount = badMarksCount;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
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

    public Mark addCourseAndMark(Course course, Mark mark) throws RemoteException {
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
            studentStatus = StudentStatus.DISMISSED;
            sendSadEmail();
        }
    }

    private void sendSadEmail() {
        System.out.println("Dear, student " + fullName + "! You are dismissed! LOL! Sad email for: " + getEmail());
    }

    public int compareTo(Student otherStudent) {
        return this.getAverageMark().compareTo(otherStudent.getAverageMark());
    }

    @Override
    public String toString() {
        return "Student [averageMark=" + averageMark + ", courses=" + courses + ", badMarksCount=" + badMarksCount
                + ", studentStatus=" + studentStatus + ", id=" + id + ", fullName=" + fullName + ", email=" + email
                + ", password=" + password + "]";
    }

    public String addOneBadMark() throws RemoteException {
        addCourseAndMark(new Course("LISP"), new Mark(3));
        return "Mark was added to " + fullName + ". Current status: " + studentStatus;
    }
}
