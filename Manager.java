import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double grade;
    private final int ID;
    private static int totalStudents;

    Student(String name, int age, double grade, int ID) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.ID = ID;
        totalStudents++;
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public static int getTotalStudents() {
        return totalStudents;
    }
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class Manager {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to the Student Manager");
        System.out.println("------------------------------" +
                        "\n1. Add Student" +
                        "\n2. View Students" +
                        "\n3. Update Student" +
                        "\n4. Delete Student" +
                        "\n5. Exit"  +
                        "\n------------------------------");
        while (true) {
            System.out.print("Choose an option (1-5): "); // Changed to print instead of println
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();

                case 2 -> viewStudents();

                case 3 -> updateStudent();

                case 4 -> deleteStudent();

                case 5 -> {
                    System.out.println("Goodbye");;
                }

                default -> System.out.println("Invalid option!");
            }
        }
    }
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Student Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine(); // Consume newline

        students.add(new Student(name, age, grade, id));
        System.out.println("Student added successfully." + " Total Students: " + Student.getTotalStudents());
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("Student List:"); // MOVED THIS OUTSIDE THE LOOP
            for(Student student : students) {
                System.out.println("ID: " + student.getID() +
                                ", Name: " + student.getName() +
                                ", Age: " + student.getAge() +
                                ", Grade: " + student.getGrade());
                System.out.println("Total Students: " + Student.getTotalStudents());
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (Student student : students) {
            if (student.getID() == id) {
                System.out.print("Enter new name (current: " + student.getName() + "): ");
                String name = sc.nextLine();
                student.setName(name);

                System.out.print("Enter new age (current: " + student.getAge() + "): ");
                int age = sc.nextInt();
                student.setAge(age);

                System.out.print("Enter new grade (current: " + student.getGrade() + "): ");
                double grade = sc.nextDouble();
                student.setGrade(grade);
                sc.nextLine(); // Consume newline

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
    private static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (Student student : students) {
            if (student.getID() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
    }
}