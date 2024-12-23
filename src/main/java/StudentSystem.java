import java.util.Scanner;

public class StudentSystem {
    private static StudentSystem instance;
    private final StudentManager repository;
    private final FileHandler fileHandler;

    private StudentSystem() {
        repository = new StudentManager();
        fileHandler = new FileHandler();
    }

    public static StudentSystem getInstance() {
        if (instance == null) {
            instance = new StudentSystem ();
        }
        return instance;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String filename = "students.txt";
        int choice;

        do {
            System.out.println("\n--- Studenthanteringssystem ---");
            System.out.println("1. Lägg till student");
            System.out.println("2. Sök student via ID");
            System.out.println("3. Visa alla studenter");
            System.out.println("4. Spara poster till fil");
            System.out.println("5. Läs poster från fil");
            System.out.println("6. Avsluta");
            System.out.print("Välj ett alternativ: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Rensa buffert

            switch (choice) {
                case 1 -> {
                    System.out.print("Ange Student-ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Ange namn: ");
                    String name = scanner.nextLine();
                    System.out.print("Ange betyg: ");
                    String grade = scanner.nextLine();
                    repository.addStudent(new Student(id, name, grade));
                }
                case 2 -> {
                    System.out.print("Ange Student-ID: ");
                    String id = scanner.nextLine();
                    Student student = repository.searchStudent(id);
                    if (student != null) {
                        System.out.println("Student hittad: " + student);
                    } else {
                        System.out.println("Ingen student hittades med ID: " + id);
                    }
                }
                case 3 -> {
                    System.out.println("Lista över studenter:");
                    for (Student student : repository.getAllStudents().values()) {
                        System.out.println(student);
                    }
                }
                case 4 -> fileHandler.saveToFile(repository.getAllStudents(), filename);
                case 5 -> fileHandler.loadFromFile(repository, filename);
                case 6 -> System.out.println("Avslutar programmet...");
                default -> System.out.println("Ogiltigt val, försök igen.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
