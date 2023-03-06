package ui;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    JFrame frame;
    JLabel image = new JLabel(new ImageIcon("./images/td.png"));
    JLabel text = new JLabel("Loading Travel Diary...");
    JProgressBar progressBar = new JProgressBar();
    JLabel message = new JLabel();

    // creates beginning splash screen
    SplashScreen() {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }

    // MODIFIES: this
    // EFFECTS: creates GUI for splash screen
    public void createGUI() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setVisible(true);
    }

    // EFFECTS: adding splash screen image
    public void addImage() {
        image.setSize(600, 200);
        frame.add(image);
    }

    // EFFECTS: adds text to splash screen
    public void addText() {
        text.setFont(new Font("arial", Font.BOLD, 30));
        text.setBounds(170, 220, 600, 40);
        text.setForeground(Color.BLACK);
        frame.add(text);
    }

    // EFFECTS: adds message to splash screen
    public void addMessage() {
        message.setBounds(250, 320, 200, 40);//Setting the size and location of the label
        message.setForeground(Color.black);//Setting foreground Color
        message.setFont(new Font("arial", Font.BOLD, 15));//Setting font properties
        frame.add(message);//adding label to the frame
    }

    // EFFECTS: adds progress bar to bottom of screen
    public void addProgressBar() {
        progressBar.setBounds(100, 280, 400, 30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.lightGray);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frame.add(progressBar);
    }

    // EFFECTS: progress bar loading
    public void runningPBar() {
        int i = 0;

        while (i <= 100) {
            try {
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING... " + Integer.toString(i) + "%");//Setting text of the message JLabel
                i++;
                if (i == 100) {
                    frame.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
