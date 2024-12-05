import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class startManual {

    public void showWindow() {
        // this sets the window title
        Frame frame = new JFrame("Manual Sounds");
        frame.setSize(800, 600); // This sets the width to 500px and the height to 400px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(null);

        // this adds a title to the frame
        JLabel pageTitle = new JLabel("Manual Sounds");
        pageTitle.setBounds(130, 25, 225, 30); // these numbers represent: x, y, width, height respectivley
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pageTitle);
        frame.setVisible(true); // this displays the frame
        JButton backToGame = new JButton("<-- Back to Menu");
        backToGame.setBounds(600, 20, 140, 40); // x, y, width, height
        frame.add(backToGame);
        backToGame.addActionListener(e ->{
        mainMenu.showWindow();
        soundPlayer.playSound("sounds/button_click.wav");
        frame.dispose();

    });
    // Create a panel for the menu buttons
    JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));

    // Create buttons for each menu option
    JButton startAutoButton = new JButton("Automatic soundboard");
    JButton startManualButton = new JButton("Manual Soundboard");
    JButton tutorialButton = new JButton("Tutorial / Instructions");
    JButton changeSoundsButton = new JButton("Change sounds");
    JButton exitButton = new JButton("Exit");

    // Add buttons to the panel
    buttonPanel.add(startAutoButton);
    buttonPanel.add(startManualButton);
    buttonPanel.add(tutorialButton);
    buttonPanel.add(changeSoundsButton);
    buttonPanel.add(exitButton);

    // Add the button panel to the center
    frame.add(buttonPanel, BorderLayout.CENTER);

    // Create a panel for developer information
    JPanel infoPanel = new JPanel(new GridLayout(3, 1));
    JLabel explanationLabel = new JLabel("This program can play sounds automatically or manually to help desensitize your pet to sounds", JLabel.CENTER);
    JLabel namesLabel = new JLabel("Developer: Thevindu", JLabel.CENTER);
    JLabel termLabel = new JLabel("Winter 2024", JLabel.CENTER);

    // Add developer info to the panel
    infoPanel.add(explanationLabel);
    infoPanel.add(namesLabel);
    infoPanel.add(termLabel);

    // Add the info panel to the bottom
    frame.add(infoPanel, BorderLayout.SOUTH);

    // Set up event listeners for each button
    startAutoButton.addActionListener(e -> {
        frame.dispose();
        soundPlayer.playSound("sounds/button_click.wav");
        startAuto StartAuto = new startAuto();
        StartAuto.showWindow();
    });

    startManualButton.addActionListener(e -> {
        frame.dispose();
        soundPlayer.playSound("sounds/button_click.wav");
        startManual StartManual = new startManual();
        StartManual.showWindow();
    });

    tutorialButton.addActionListener(e -> {
        frame.dispose();
        soundPlayer.playSound("sounds/button_click.wav");
        tutorial Tutorial = new tutorial();
        Tutorial.showWindow();
    });

    changeSoundsButton.addActionListener(e -> {
        frame.dispose();
        soundPlayer.playSound("sounds/button_click.wav");
        changeSounds ChangeSounds = new changeSounds();
        ChangeSounds.showWindow();
    });

    exitButton.addActionListener(e -> {
        frame.dispose();
        soundPlayer.playSound("sounds/button_click.wav");
        System.exit(0);  // Exit the application
    });
}
    
}
