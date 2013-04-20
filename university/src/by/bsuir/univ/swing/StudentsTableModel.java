package by.bsuir.univ.swing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import by.bsuir.univ.model.Student;

public class StudentsTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<Student> students;

    public StudentsTableModel(List<Student> students) {
        this.students = students;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Full name";
            case 1:
                return "Average mark";
            case 2:
                return "Bad marks count";
            case 3:
                return "Status";
        }

        return "";
    }

    public int getRowCount() {
        return students.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student bean = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getFullName();
            case 1:
                return bean.getAverageMark();
            case 2:
                return bean.getBadMarksCount();
            case 3:
                return bean.getStatus();
        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
}
