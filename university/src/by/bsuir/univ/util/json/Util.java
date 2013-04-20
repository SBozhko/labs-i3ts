package by.bsuir.univ.util.json;

import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.init.Initializer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Util {

    private static final String DELIMITER = "<;;>";

    public static List<Student> parseStudents(List<String> students) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> studentsList = new ArrayList<Student>();
        try {
            for (String s : students) {
                studentsList.add(mapper.readValue(s, Student.class));
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public static void printToFile(List<Student> studs, String fileName) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(getListAsString(studs));
        fileWriter.flush();
        fileWriter.close();
    }

    public static List<Student> readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        try {
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

        } finally {
            br.close();
        }

        String[] splitedStudentsString = sb.toString().split(DELIMITER);
        return parseStudents(Arrays.asList(splitedStudentsString));
    }

    public static String getListAsString(List<Student> studentsList) {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();

        try {

            for (Student s : studentsList) {
                sb.append(mapper.writeValueAsString(s)).append(DELIMITER);
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.replace(sb.lastIndexOf(DELIMITER), sb.length(), "");

        return sb.toString();

    }

    public static String getStudentAsString(Student student) {
        ObjectMapper mapper = new ObjectMapper();
        String studentString = new String();

        try {
            studentString = mapper.writeValueAsString(student);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentString;

    }

    public static Student getStringAsStudent(String studentSting) {
        ObjectMapper mapper = new ObjectMapper();
        Student student = new Student();
        try {
            student = mapper.readValue(studentSting, Student.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void main(String[] args) throws IOException {
        Util.printToFile(Initializer.getListOfStudents(), "students.txt");
        List<Student> studlist = Util.readFromFile("students.txt");

        for (Student s : studlist) {
            System.out.println(s);
            System.out.println();
        }

    }
}
