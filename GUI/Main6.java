import javax.swing.*;

public class Main6 {
    
    public static void main(String args[]) {
        startScoreboard();
    }
    
    private static void createAndShowGUI() {
        
        // The code in this method creates the JFrame that all will hold the
        // GUI. The JFrame is not the GUI. It is a special window that must be
        // constructed to work with the operating system, as opposed to your 
        // Java application. That is, on Winodws it acts like any other Window.
        // It can be dragged, minimized, closed, etc.
        
        // set the JFrame class to have the default look and feel of other windows
        // for this OS by calling the static method in the JFrame as shown.
        JFrame.setDefaultLookAndFeelDecorated(true);
        // Create a new JFrame object and set its title to be as shown.
        JFrame frame = new JFrame("[=] JButton Scores! [=]");
        // Instantiate a new Scoreboard5 object with reference variable scoreboard.
        Scoreboard6 scoreboard = new Scoreboard6();
        // set frame to have the Jpanel content created by a call to method 
        // createContentPane() in in class Scoreboard2
        frame.setContentPane(scoreboard.createContentPane());
        // Set frame dimensions to 280 pixels wide by 190 pixels high; the frame
        // dimensions must be able to contain everything one wants in the GUI.
        frame.setSize(280, 260);
        // Set the frame to be visible
        frame.setVisible(true);
        // Set the application to quit when this window frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void startScoreboard() {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        // Don't be concerned with how this works. Essentially, this
        // results in a thread that will handle events, such as button clicks.
        // As seen, it creates a new Runnable object that overrides the run()
        // method in the Runnable class; when the thread is started, it begins
        // with this run method, which simply calls the createAndShowGUI method
        // (just above) to get the scoreboard GUI started.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    } 
}

