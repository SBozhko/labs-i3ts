package by.bsuir.univ.rmi;

import by.bsuir.univ.rmi.model.Student;
import by.bsuir.univ.model.Course;
import by.bsuir.univ.model.Mark;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public static List<Student> getListOfStudents() throws RemoteException {
        Course mongoDB = new Course("MongoDB");
        Course scala = new Course("Scala");
        Course erlang = new Course("Erlang");
        Course ror = new Course("RoR");
        Course haskell = new Course("Haskell");

        Student s1 = new Student();
        s1.setFullName("Student111111");
        s1.setEmail("stud1@gmail.com");
        s1.addCourseAndMark(mongoDB, new Mark(3));
        s1.addCourseAndMark(ror, new Mark(2));
        s1.addCourseAndMark(haskell, new Mark(5));
        s1.addCourseAndMark(scala, new Mark(9));
        s1.addCourseAndMark(erlang, new Mark(3));
        //System.out.println(s1);

        Student s2 = new Student();
        s2.setFullName("Student2222222");
        s2.setEmail("stud2@gmail.com");
        s2.addCourseAndMark(mongoDB, new Mark(7));
        s2.addCourseAndMark(ror, new Mark(7));
        s2.addCourseAndMark(haskell, new Mark(9));
        s2.addCourseAndMark(scala, new Mark(2));
        s2.addCourseAndMark(erlang, new Mark(8));
        //System.out.println(s2);

        Student s3 = new Student();
        s3.setFullName("Student33333333");
        s3.setEmail("stud3@gmail.com");
        s3.addCourseAndMark(mongoDB, new Mark(10));
        s3.addCourseAndMark(ror, new Mark(4));
        s3.addCourseAndMark(haskell, new Mark(4));
        s3.addCourseAndMark(scala, new Mark(6));
        s3.addCourseAndMark(erlang, new Mark(7));
        //System.out.println(s3);



        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        return students;
    }
}
