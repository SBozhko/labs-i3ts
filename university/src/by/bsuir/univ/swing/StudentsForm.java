package by.bsuir.univ.swing;

import by.bsuir.univ.model.Course;
import by.bsuir.univ.model.Mark;
import by.bsuir.univ.model.Student;
import by.bsuir.univ.model.init.Initializer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class StudentsForm implements ActionListener {

    private JFrame frame;
    private int selectedStudent = -1;
    private List<Student> students = Initializer.getListOfStudents();
    private JTextField courseEdit = new JTextField(10);
    private JTextField markEdit = new JTextField(10);
    private TableModel studentsTableModel = new StudentsTableModel(students);
    private JTable table = new JTable(studentsTableModel);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                StudentsForm window = new StudentsForm();
                window.frame.setVisible(true);
            }
        });
    }

    /**
     * Create the application.
     */
    public StudentsForm() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(table);
        JPanel tablePanel = new JPanel(new FlowLayout());
        tablePanel.add(scrollPane);
        frame.getContentPane().add(tablePanel, BorderLayout.NORTH);

        JPanel footerPanel = new JPanel(new FlowLayout());

        JButton addCourseMarkButton = new JButton("Add");
        addCourseMarkButton.addActionListener(this);

        footerPanel.add(addCourseMarkButton, BorderLayout.WEST);

        JLabel courseLabel = new JLabel("Course:");
        footerPanel.add(courseLabel);
        footerPanel.add(courseEdit, BorderLayout.EAST);

        JLabel markLabel = new JLabel("Mark:");
        footerPanel.add(markLabel);
        footerPanel.add(markEdit, BorderLayout.EAST);
        footerPanel.setVisible(true);

        frame.getContentPane().add(footerPanel, BorderLayout.SOUTH);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();

                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    System.out.println("row = " + row + " col = " + column);
                    selectedStudent = row;
                }
            }
        });

        frame.setBounds(100, 100, 412, 508);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent event) {

        if (!isEmpty(courseEdit.getText()) && !isEmpty(markEdit.getText())) {
            Student student = students.get(selectedStudent);
            student.addCourseAndMark(new Course(courseEdit.getText()), new Mark(markEdit.getText()));
            Collections.sort(students);
            Collections.reverse(students);
            table.setModel(studentsTableModel);
            table.updateUI();
        }

    }

    private boolean isEmpty(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        return false;
    }
}
