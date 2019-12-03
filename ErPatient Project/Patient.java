import javax.swing.JOptionPane;
public class Patient {

    private String lastName;

    private String firstName;

    private int age;

    public Patient(String lastName, String firstName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setfirstName(String firstName){

        this.firstName = firstName;

    }

    public String getfirstName(){

        return firstName;

    }

    public void setlastName(String lastName){

        this.lastName = lastName;

    }

    public String getlastName(){

        return lastName;

    }

    public void setage(int age){

        this.age = age;

    }

    public int getage(){

        return age;

    }

}

