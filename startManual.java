import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class startManual {

    public void showWindow() {
        // this sets the window title
        JFrame frame = new JFrame("Manual Sounds");
        frame.setSize(800, 600); // This sets the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Use BorderLayout instead of null layout

        // this adds a title to the frame
        JLabel pageTitle = new JLabel("Manual Sounds");
        pageTitle.setHorizontalAlignment(JLabel.CENTER); // Center the title
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pageTitle, BorderLayout.NORTH); // Add the title to the top

        // Create a panel for the menu buttons using GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(6, 5, 10, 10));

        // Create buttons for each sound
        JButton thunderNoiseButton = new JButton("Thunder Noise");
        JButton meowNoiseButton = new JButton("Meowing");
        JButton barkNoiseButton = new JButton("Barking");
        JButton bellNoiseButton = new JButton("Door Bell");
        JButton whistleButton = new JButton("Whistle");

        // Add buttons to the panel
        buttonPanel.add(thunderNoiseButton);
        buttonPanel.add(meowNoiseButton);
        buttonPanel.add(barkNoiseButton);
        buttonPanel.add(bellNoiseButton);
        buttonPanel.add(whistleButton);

        // Add the button panel to the center
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Create a back button and add it to the bottom
        JButton backToMenu = new JButton("<-- Back to Menu");
        backToMenu.addActionListener(e -> {
            mainMenu.showWindow();
            soundPlayer.playSound("sounds/button_click.wav");
            frame.dispose();
        });
        frame.add(backToMenu, BorderLayout.SOUTH); // Add the back button to the bottom

        // Set up event listeners for each button
        thunderNoiseButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/trigger_noises/thunder.wav");
        });

        meowNoiseButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/trigger_noises/meow.wav");
        });

        barkNoiseButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/trigger_noises/bark.wav");
        });

        bellNoiseButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/trigger_noises/bell.wav");
        });

        whistleButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/trigger_noises/whistle.wav");
        });

        // Finally, set the frame to be visible
        frame.setVisible(true);
    }
}
