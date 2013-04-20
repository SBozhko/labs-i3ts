package by.bsuir.univ.rmi;

import by.bsuir.univ.rmi.model.IStudent;
import java.rmi.Naming;

public class Client {

    private static final String SERVER_NAME = "Server";
    private static final String HOST = "localhost";
    private static final String PORT = "7711";

    public static void main(String[] args) throws Exception {
        String lookupString = "//" + HOST + ":" + PORT + "/" + SERVER_NAME;
        IStudent student = (IStudent) Naming.lookup(lookupString);
        System.out.println("RMI object found");
        System.out.println("Student: " + student.getFullName());
        System.out.println("Status before: " + student.getStudentStatus());
        System.out.println(student.addOneBadMark());
    }
}