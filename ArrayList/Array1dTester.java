import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Array1dTester {
    public static void main(String args[]) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of students in the class."));
        // Student[] student = new Student[n];
        List<Student> students = new ArrayList<Student>();
        for (int i = 1; i <= n; i++) {
            String studentName = JOptionPane.showInputDialog("Enter a name for student[" + i + "].");
            int studentScore = Integer.parseInt(JOptionPane.showInputDialog("Enter a score for student[" + i + "]."));
            Student newStudent = new Student(studentName, studentScore);
            // student[i] = newStudent;
            students.add(newStudent);
        }

        int sumOfScores = 0;
        for (int i = 1; i <= students.size(); i++) {
            sumOfScores += students.get(i).getScore();
        }

        float averageScore = (float) sumOfScores / (float) n;
        int maxScore = students.get(0).getScore();

        for (int i = 1; i <= n; i++) {

            if (students.get(i).getScore() > maxScore) {
                maxScore = students.get(i).getScore();
            }
        }

        int minScore = students.get(0).getScore();
        for (int i = 1; i <= n; i++) {
            if (students.get(i).getScore() < minScore) {
                minScore = students.get(i).getScore();
            }
        }

        JOptionPane.showMessageDialog(null, "The class average is "+ averageScore + "\n" + "The class maximum score is "+ maxScore + "\n" + "The class minimum score is " +minScore+ "\n" + "Click OK run the ArrayList version.");
        // ArrayList1dTester.arrayListMain();
    }
}