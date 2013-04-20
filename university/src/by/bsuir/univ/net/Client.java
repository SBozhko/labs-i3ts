package by.bsuir.univ.net;

import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.init.Initializer;
import by.bsuir.univ.util.json.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {

    private static final int PORT = 7744;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Client side");

        Socket fromserver = null;

        /*if (args.length == 0) {
         System.out.println("use: client hostname");
         System.exit(-1);
         }*/

        System.out.println("Connecting to... localhost");

        fromserver = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fuser, fserver;
        List<Student> students = Initializer.getListOfStudents();

        while ((fuser = inu.readLine()) != null) {
            if (fuser.equalsIgnoreCase("1") || fuser.equalsIgnoreCase("2") || fuser.equalsIgnoreCase("3")) {
                out.println(Util.getStudentAsString(students.get(Integer.parseInt(fuser, 10) - 1)));
            } else {
                if (fuser.equalsIgnoreCase("close") || fuser.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            fserver = in.readLine();
            System.out.println(fserver);
            System.out.println("***");
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
}