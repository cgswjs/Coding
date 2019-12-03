import javax.swing.JOptionPane;
public class ERPatient extends Patient{

    private int priority;

    public ERPatient(String firstName, String lastName, int age, int priority){

        super(firstName, lastName, age);

        this.priority = priority;
    }

    public void setpriority(int priority){

        priority = Integer.parseInt(JOptionPane.showInputDialog("Enter the 1-3 for the priority of the patient: 1 being high priority and 3 being low priority."));

    }

    public int getpriority(){

        return priority;

    }

}
