public class Student {
    private final String id;
    private final String name;
    private final String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Namn: " + name + ", Betyg: " + grade;
    }
}
