import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private final Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("En student med detta ID finns redan.");
        } else {
            students.put(student.getId(), student);
            System.out.println("Student tillagd!");
        }
    }

    public Student searchStudent(String id) {
        return students.get(id);
    }

    public Map<String, Student> getAllStudents() {
        return students;
    }
}
