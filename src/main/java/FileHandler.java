import java.io.*;
import java.util.Map;

public class FileHandler {
    public void saveToFile(Map<String, Student> students, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students.values()) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
                writer.newLine();
            }
            System.out.println("Poster sparade till fil.");
        } catch (IOException e) {
            System.out.println("Fel vid sparande till fil: " + e.getMessage());
        }
    }

    public void loadFromFile(StudentManager repository, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    repository.addStudent(new Student(parts[0], parts[1], parts[2]));
                }
            }
            System.out.println("Poster lästa från fil.");
        } catch (IOException e) {
            System.out.println("Fel vid läsning från fil: " + e.getMessage());
        }
    }
}
