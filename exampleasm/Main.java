package exampleasm;
import java.util.*;

class Student {
    private int studentId;
    private String name;
    private double marks;
    private String rank;

    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.rank = getRank();
    }

    public String getRank() {
        if (marks >= 0 && marks < 5.0) {
            return "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else if (marks >= 7.5 && marks < 9.0) {
            return "Very Good";
        } else if (marks >= 9.0 && marks <= 10.0) {
            return "Excellent";
        }
        return "Invalid";
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRankDisplay() {
        return rank;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(int studentId, String name, double marks) {
        students.add(new Student(studentId, name, marks));
    }

    public void editStudent(int studentId, String name, Double marks) {
        Student student = findStudent(studentId);
        if (student != null) {
            if (name != null) {
                student = new Student(studentId, name, student.getMarks());
            }
            if (marks != null) {
                student = new Student(studentId, student.getName(), marks);
            }
        }
    }

    public void deleteStudent(int studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            students.remove(student);
        }
    }

    public Student findStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchStudent(String searchTerm) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchTerm.toLowerCase()) || 
                Integer.toString(student.getStudentId()).contains(searchTerm)) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void handleError(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Example usage
        manager.handleError(() -> manager.addStudent(1, "Alice", 8.5));
        manager.handleError(() -> manager.addStudent(2, "Bob", 6.0));
        manager.handleError(() -> manager.addStudent(3, "Charlie", 4.5));

        System.out.println("\nAll Students:");
        manager.displayStudents();

        // Edit student details
        manager.handleError(() -> manager.editStudent(2, null, 7.5));

        // Sort students by marks
        manager.handleError(manager::sortStudents);

        System.out.println("\nSorted Students:");
        manager.displayStudents();

        // Search for a student
        List<Student> result = manager.searchStudent("Alice");
        System.out.println("\nSearch Results:");
        for (Student student : result) {
            System.out.println(student);
        }

        // Delete a student
        manager.handleError(() -> manager.deleteStudent(3));

        System.out.println("\nAfter Deletion:");
        manager.displayStudents();
    }
}
