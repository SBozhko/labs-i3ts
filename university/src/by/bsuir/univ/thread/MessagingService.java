package by.bsuir.univ.thread;

import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.init.Initializer;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessagingService {
    public static final int THREADS_NUMBER = 5;

    public static void main(String[] args) {
        List<Student> students = Initializer.getListOfStudents();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUMBER);
        for (Student s : students) {
            Runnable worker = new WorkerThread(s);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }
}