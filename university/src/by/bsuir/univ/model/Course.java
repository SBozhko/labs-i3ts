package by.bsuir.univ.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Course {

    private long id;
    private String title;
    private Map<Student, Mark> studentsMarks = new LinkedHashMap<Student, Mark>();
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseTitle) {
        title = courseTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Map<Student, Mark> getStudentsMarks() {
        return studentsMarks;
    }

    public void setStudentsMarks(Map<Student, Mark> studentsMarks) {
        this.studentsMarks = studentsMarks;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", title=" + title + ", studentsMarks=" + studentsMarks
                + ", teacher=" + teacher + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((studentsMarks == null) ? 0 : studentsMarks.hashCode());
        result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        Course other = (Course) obj;
        if (id != other.id) {
            return false;
        }
        if (studentsMarks == null) {
            if (other.studentsMarks != null) {
                return false;
            }
        } else if (!studentsMarks.equals(other.studentsMarks)) {
            return false;
        }
        if (teacher == null) {
            if (other.teacher != null) {
                return false;
            }
        } else if (!teacher.equals(other.teacher)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        return true;
    }
}
