import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class startAuto implements ChangeListener {

    private Timer timer; // Timer to randomly output sound
    private JLabel sliderLabel = new JLabel(); // Class-level slider label
    private JSlider slider; // Class-level slider

    public void showWindow() {
        // Set the window title
        JFrame frame = new JFrame("Automatic Sounds");
        frame.setSize(800, 600); // Set the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setLayout(new BorderLayout()); // Set the layout to BorderLayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a title to the frame
        JLabel pageTitle = new JLabel("Automatic Sounds", JLabel.CENTER);
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pageTitle, BorderLayout.NORTH); // Add the title to the top

        // Create a back button
        JButton backToMenu = new JButton("<-- Back to Menu");
        backToMenu.addActionListener(e -> {
            mainMenu.showWindow(); // Return to main menu
            soundPlayer.playSound("sounds/button_click.wav");
            frame.dispose(); // Close the current window
            timer.stop();
        });
        frame.add(backToMenu, BorderLayout.PAGE_END); // Add back button to the bottom

        // Create a combined panel to hold buttons and other content
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BorderLayout());

        // Create a panel for menu buttons using GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        JButton randomButton = new JButton("Random Noise");
        buttonPanel.add(randomButton);
        combinedPanel.add(buttonPanel, BorderLayout.NORTH); // Add button panel to the top

        // Create and configure the slider for changing how often sound automatically plays
        slider = new JSlider(0, 300, 150);
        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(30);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        slider.addChangeListener(this); // Add a change listener to the slider

        // Set initial text for the slider label
        sliderLabel.setText("Current Interval Between Random Sounds: " + slider.getValue() + "s");
        sliderLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // Create a new panel to hold both the slider and the label
        JPanel sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.add(sliderLabel, BorderLayout.NORTH); // Add label above the slider
        sliderPanel.add(slider, BorderLayout.CENTER);     // Add the slider below the label
        combinedPanel.add(sliderPanel, BorderLayout.SOUTH); // Add the sliderPanel to the bottom

        // Add the combined panel to the frame
        frame.add(combinedPanel, BorderLayout.CENTER);

        // Set up the random noise functionality
        final File dir = new File("sounds/trigger_noises");
        File[] files = dir.listFiles();
        timer = new Timer(7000, e -> randomNoisePlayer(files)); // Timer to play random sound
        timer.start(); // Start the timer

        randomButton.addActionListener(e -> randomNoisePlayer(files)); // Play random noise on button click

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to play random sound
    private void randomNoisePlayer(File[] files) {
        int rand = new Random().nextInt(files.length);
        File randomSoundFile = files[rand];
        soundPlayer.playSound("sounds/trigger_noises/" + randomSoundFile.getName());
    }

    // Handle slider state changes
    @Override
    public void stateChanged(ChangeEvent e) {
        sliderLabel.setText("Current Interval Between Random Sounds: " + slider.getValue() + "s");
    }
}
