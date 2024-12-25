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

/**
 * short desc of app
 *
 * <p>This class also includes a splash screen implementation to display an introductory animation
 * before the main menu launches.</p>
 * 
 * @author Thevindu
 * @version 1.0
 * @since 2024-12-03
 */
public class mainMenu extends JFrame {
    public static long startTime;

    /**
     * This constructs the main menu window with buttons for various actions and developer information.
     * It sets up the layout, buttons, and event listeners.
     */
    public static void showWindow() {
        startTime = System.currentTimeMillis();
        
        // Create the window
        JFrame frame = new JFrame("Trigger Tamer");  // Corrected: JFrame instead of Frame
        frame.setSize(800, 600);  // This sets the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null);  // This centers the frame on the screen
        frame.setLayout(new BorderLayout());  // Set layout for the window
        frame.setVisible(true);  // This displays the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the title image
        JPanel imagePanel = new JPanel(new BorderLayout());
        JLabel imageLabel = new JLabel(new ImageIcon("images/title.png"));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Add image panel to the top
        frame.add(imagePanel, BorderLayout.NORTH);

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

    /**
     * This displays the splash screen with an introductory animation and background music.
     * Once the animation completes, the main menu is launched.
     *
     * @param onComplete a Runnable to execute when the splash screen animation is finished
     */
    public static void showSplashScreen(Runnable onComplete) {
        JFrame splashScreen = new JFrame();
        splashScreen.setUndecorated(true);
        splashScreen.setSize(800, 600);
        splashScreen.setLocationRelativeTo(null);

        // Add an image to the splash screen
        JLabel splashImage = new JLabel(new ImageIcon("images/title.png"));
        splashImage.setHorizontalAlignment(JLabel.CENTER);
        splashScreen.add(splashImage);

        splashScreen.setOpacity(1.0f);
        splashScreen.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.02f;
                if (opacity <= 0.0f) {
                    splashScreen.dispose();
                    ((Timer) e.getSource()).stop();
                    onComplete.run();  // Launch the main menu
                } else {
                    splashScreen.setOpacity(opacity);
                }
            }
        });

        timer.start();
    }

    /**
     * The main method, serving as the entry point for the application.
     * It first displays the splash screen and then launches the main menu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Show the splash screen, then launch the main menu
        showSplashScreen(() -> showWindow());
    }
}