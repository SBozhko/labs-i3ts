package by.bsuir.univ.thread;

import by.bsuir.univ.model.Student;

public class WorkerThread implements Runnable {

    private Student student;

    public WorkerThread(Student s) {
        this.student = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Student = " + student);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            student.sendEmail();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}