
import javax.swing.JOptionPane;

import java.util.*;

public class ERScheduler {

    public static void main(String args[ ]){

        int choice;

        boolean done = false;

        boolean occupied = false;

        ArrayList<ERPatient> ER = new ArrayList<ERPatient>();

        String[ ] choices = {

                "Admit",

                "Treat",

                "Release",

                "Done"};

        String output = "";

        while (!done) {

            choice = JOptionPane.showOptionDialog(

                null,

                "Click a choice",

                "Function Menu",

                JOptionPane.YES_NO_CANCEL_OPTION,

                JOptionPane.QUESTION_MESSAGE,

                null,

                choices,

                choices[0]);

            switch (choice) {

                case 0:

                String newfirstName = JOptionPane.showInputDialog("Enter the patient's first name.");
                String newlastName = JOptionPane.showInputDialog("Enter the patient's last name.");
                int newAge = Integer.parseInt(JOptionPane.showInputDialog("Enter the patient's age."));
                int newPriority = Integer.parseInt(JOptionPane.showInputDialog("Enter the 1-3 for the priority of the patient: 1 being high priority and 3 being low priority."));
                ERPatient newErPatient = new ERPatient(newfirstName, newlastName, newAge, newPriority);
                int i = 0;
                while (i<ER.size() && (newErPatient.getpriority()<ER.get(i).getpriority())){
                    i++;
                }
                ER.add(i, newErPatient);
                JOptionPane.showMessageDialog(null, "Patient Admitted: Name: " + ER.get(i).getfirstName() + ", " + ER.get(i).getlastName()+ " " + " Age: " + ER.get(i).getage() + " Priority: " + ER.get(i).getpriority());
                break;
                case 1:
                if (occupied == true){
                    JOptionPane.showMessageDialog(null, "The ER treatment room is occupied.");
                }
                else if (occupied == false){
                    if(ER.size() == 0){
                        JOptionPane.showMessageDialog(null, "The ER treatment room is empty.");
                    }

                    if(ER.size() > 0){

                        JOptionPane.showMessageDialog(null, ER.get(0).getfirstName() + ", " + ER.get(0).getlastName() + " is being treated.");

                        output = "Released: " + ER.get(0).getfirstName() + ", " + ER.get(0).getlastName() + ", Age: " + ER.get(0).getage() + ", Priority: " + ER.get(0).getpriority();

                        ER.remove(0);

                        occupied = true; 
                    }
                }

                break;
                case 2:
                if(occupied == false){
                    JOptionPane.showMessageDialog(null, "The ER treatment room is empty.");
                }
                if(occupied == true){
                    JOptionPane.showMessageDialog(null, output);
                    occupied = false;
    
                }

                break;
                case 3:
                JOptionPane.showMessageDialog(null, "Done for this shift.");
                done = true;
                break;
                default:
                JOptionPane.showMessageDialog(null, "...quitting");
                done = true;
            }
        }
    }
}
