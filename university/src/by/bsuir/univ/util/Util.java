package by.bsuir.univ.util;

import by.bsuir.univ.model.Mark;
import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Util {

    private static final String EQUAL_DELIMITER = "=";
    private static final String COMMA_DELIMITER = ",";
    private static final String DOT_COMMA_DELIMITER = ";";

    public static List<Student> parseStudents(String students) {
        students = students.trim();
        List<Student> studentsList = new ArrayList<Student>();
        StringTokenizer objectsTokens = new StringTokenizer(students, DOT_COMMA_DELIMITER);
        Student student;
        while (objectsTokens.hasMoreElements()) {
            student = new Student();
            String currentrStudent = objectsTokens.nextElement().toString();

            StringTokenizer fieldsTokens = new StringTokenizer(currentrStudent, COMMA_DELIMITER);
            while (fieldsTokens.hasMoreElements()) {
                String currentField = fieldsTokens.nextElement().toString();

                StringTokenizer valuesTokens = new StringTokenizer(currentField, EQUAL_DELIMITER);

                String currentFieldName = valuesTokens.nextElement().toString().trim();
                String currentFieldValue = valuesTokens.nextElement().toString().trim();

                System.out.println(currentFieldName);
                System.out.println(currentFieldValue);

                switch (StudentFields.valueOf(currentFieldName.toUpperCase())) {
                    case ID:
                        student.setId(Long.parseLong(currentFieldValue));
                        break;

                    case AVERAGEMARK:
                        System.out.println("currentFieldValue" + currentFieldValue);
                        student.setAverageMark(new Mark(Float.parseFloat(currentFieldValue)));
                        break;

                    case EMAIL:
                        student.setEmail(currentFieldValue);
                        break;

                    case FULLNAME:
                        student.setFullName(currentFieldValue);
                        break;

                    case PASSWORD:
                        student.setPassword(currentFieldValue);
                        break;

                    default:
                        break;
                }
            }
            studentsList.add(student);
            System.out.println(student);
        }
        return studentsList;
    }

    public static void printToFile(List<? extends User> users, String fileName) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(getListAsString(users));
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

        return parseStudents(sb.toString());
    }

    public static String getListAsString(List<? extends User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append(user).append(" ");
        }

        return stringBuilder.toString();
    }
}
