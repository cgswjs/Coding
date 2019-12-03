import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.sound.sampled.*;

public class Scoreboard6 extends JPanel implements ActionListener{

    // Definition of global values and items that are part of the GUI.
    int redScoreAmount = 0;
   
    int blueScoreAmount = 0;
    
    JPanel titlePanel, scorePanel, buttonPanel;
    JLabel redLabel, blueLabel, redScore, blueScore;
    JButton red1Button, red2Button,red3Button,blue1Button,blue2Button,blue3Button, resetButton;
    private static Clip buttonClickSound;
    AudioInputStream audioInput;



    public JPanel createContentPane (){

        // The main JPanel object (with reference variable totalGUI) is the one
        // in which the other JPanels will be nested.
        JPanel totalGUI = new JPanel();
        // The layout is initially empty (null); as we add subpanels, it will
        // become populated. Its dimensions will be determined by adding the
        // dimensions of the subpanels placed inside it
        totalGUI.setLayout(null);

        // create a new JPanel object with reference variable titlePanel to hold
        // the Red Team and Blue Team titles
        titlePanel = new JPanel();
        // set its layout to null (it will be filled later with the titles)
        titlePanel.setLayout(null);
        // set its size to be 250 pixels wide and 30 pixels high
        titlePanel.setSize(260, 30);
        // position this subpanel to be 10 pixels from the left and 0 pixels from
        // the top of its containing panel (which will be the totalGUI panel
        titlePanel.setLocation(10, 0);
        // add the titlePanel object to the totalGUI object
        totalGUI.add(titlePanel);
        
        redLabel = new JLabel("Red Team");
        redLabel.setLocation(0, 0);
        redLabel.setSize(120, 30);
        redLabel.setHorizontalAlignment(0);
        redLabel.setForeground(Color.red);
        titlePanel.add(redLabel);

        blueLabel = new JLabel("Blue Team");
        blueLabel.setLocation(130, 0);
        blueLabel.setSize(120, 30);
        blueLabel.setHorizontalAlignment(0);
        blueLabel.setForeground(Color.blue);
        titlePanel.add(blueLabel);

        // Creation of a Panel to contain the score labels, similar to titlePanel
        // above
        scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(10, 40);
        scorePanel.setSize(260, 30);
        totalGUI.add(scorePanel);
        
        redScore = new JLabel(""+redScoreAmount);
        redScore.setLocation(0, 0);
        redScore.setSize(120, 30);
        redScore.setHorizontalAlignment(0);
        scorePanel.add(redScore);

        blueScore = new JLabel(""+blueScoreAmount);
        blueScore.setLocation(130, 0);
        blueScore.setSize(120, 30);
        blueScore.setHorizontalAlignment(0);
        scorePanel.add(blueScore);


        // Creation of a Panel to contain all the buttons, similar to titlePanel
        // above.
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 80);
        buttonPanel.setSize(260, 150);
        totalGUI.add(buttonPanel);
        
        red1Button = new JButton("Red 1 Score!");
        red1Button.setLocation(5, 0);
        red1Button.setSize(120, 30);
        red1Button.addActionListener(this);
        buttonPanel.add(red1Button);
        
        red2Button = new JButton("Red 2 Score!");
        red2Button.setLocation(5, 40);
        red2Button.setSize(120, 30);
        red2Button.addActionListener(this);
        buttonPanel.add(red2Button);
        
        red3Button = new JButton("Red 3 Score!");
        red3Button.setLocation(5, 80);
        red3Button.setSize(120, 30);
        red3Button.addActionListener(this);
        buttonPanel.add(red3Button);

        blue1Button = new JButton("Blue 1 Score!");
        blue1Button.setLocation(135, 0);
        blue1Button.setSize(120, 30);
        blue1Button.addActionListener(this);
        buttonPanel.add(blue1Button);
        
        blue2Button = new JButton("Blue 2 Score!");
        blue2Button.setLocation(135, 40);
        blue2Button.setSize(120, 30);
        blue2Button.addActionListener(this);
        buttonPanel.add(blue2Button);
        
        blue3Button = new JButton("Blue 3 Score!");
        blue3Button.setLocation(135, 80);
        blue3Button.setSize(120, 30);
        blue3Button.addActionListener(this);
        buttonPanel.add(blue3Button);

        resetButton = new JButton("Reset Score");
        resetButton.setLocation(5, 120);
        resetButton.setSize(250, 30);
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == red1Button)
        {
            redScoreAmount = redScoreAmount + 1;
            redScore.setText(""+redScoreAmount);
        }
        else if(e.getSource()==red2Button)
        {
            redScoreAmount = redScoreAmount + 2;
            redScore.setText(""+redScoreAmount);
        }
        else if(e.getSource()==red3Button)
        {
            redScoreAmount = redScoreAmount + 3;
            redScore.setText(""+redScoreAmount);
        }
        else if(e.getSource() == blue1Button)
        {
            blueScoreAmount = blueScoreAmount + 1;
            blueScore.setText(""+blueScoreAmount);
        }
        else if(e.getSource() == blue2Button)
        {
            blueScoreAmount = blueScoreAmount + 2;
            blueScore.setText(""+blueScoreAmount);
        }
        else if(e.getSource() == blue3Button)
        {
            blueScoreAmount = blueScoreAmount + 3;
            blueScore.setText(""+blueScoreAmount);
        }
        
        else if(e.getSource() == resetButton)
        {
            redScoreAmount = 0;
            blueScoreAmount = 0;
            redScore.setText(""+redScoreAmount);
            blueScore.setText(""+blueScoreAmount);
            try {
                buttonClickSound = AudioSystem.getClip();
                audioInput = AudioSystem.getAudioInputStream(
                    Scoreboard6.class.getResource("buzzer.wav"));
                buttonClickSound.open(audioInput);
            }
            catch (javax.sound.sampled.UnsupportedAudioFileException x){System.out.println("x");}
            catch (java.io.IOException y){System.out.println("File not found");}
            catch (javax.sound.sampled.LineUnavailableException z){System.out.println("z");}
            buttonClickSound.start();
        }
    }
}
