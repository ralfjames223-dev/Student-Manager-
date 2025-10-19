import java.util.ArrayList;
import java.util.Scanner;

class GradeRecord {
    private final String subject;
    private final double[] score;
    private final double average;

    public GradeRecord(String subject, double q1, double q2, double q3) {
        this.subject = subject;

        if (q1 >= 0 && q1 <= 100 && q2 >= 0 && q2 <= 100 && q3 >= 0 && q3 <= 100) {
            this.score = new double[]{q1, q2, q3};
            this.average = (q1 + q2 + q3) / 3.0;
        } else {
            this.score = new double[]{0, 0, 0};
            this.average = 0;
            System.out.println("Invalid scores provided. Scores must be between 0 and 100.");
        }
    }
    public String getSubject() {
        return subject;
    }
    public double[] getScores() {
        return score.clone();
    }
    public double getAverage() {
        return average;
    }
    public void displayReport() {
        // Format: "Math | Quizzes: [85.0, 90.0, 88.0] | Average: 87.67"
        System.out.printf("%s | Quizzes: [%.1f, %.1f, %.1f] | Average: %.2f%n",
        subject, score[0], score[1], score[2], average);
    }
}

public class GradeRecordDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GradeRecord> records = new ArrayList<>();
        
        while (true) {
            System.out.print("Enter subject name (or 'done' to finish): ");
            String subject = sc.nextLine();
            
            if (subject.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter score for Quiz 1: ");
            double q1 = sc.nextDouble();
            System.out.print("Enter score for Quiz 2: ");
            double q2 = sc.nextDouble();
            System.out.print("Enter score for Quiz 3: ");
            double q3 = sc.nextDouble();
            sc.nextLine(); // consume newline

            if (q1 >= 0 && q1 <= 100 && q2 >= 0 && q2 <= 100 && q3 >= 0 && q3 <= 100) {
                GradeRecord record = new GradeRecord(subject, q1, q2, q3);
                records.add(record);
            } else {
                System.out.println("Invalid score! All scores must be between 0 and 100. Record not saved.");
            }
        }

            if (records.isEmpty()) {
                System.out.println("No records to display.");
            } else {
                double totalAverage = 0;
                for (GradeRecord r : records) {
                    r.displayReport();
                    totalAverage += r.getAverage();
                }
                double overallAverage = totalAverage / records.size();
                System.out.printf("Overall Average Across All Subjects: %.2f%n", overallAverage);
                System.out.println("Total Subjects Recorded: " + records.size());
            }
        sc.close();
    }
}