import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class startAuto {

    public void showWindow() {
        // this sets the window title
        JFrame frame = new JFrame("Automatic Sounds");
        frame.setSize(800, 600); // This sets the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(new BorderLayout()); // Set the layout to BorderLayout

        // this adds a title to the frame
        JLabel pageTitle = new JLabel("Automatic Sounds", JLabel.CENTER);
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));

        // Add the title to the top (BorderLayout.NORTH)
        frame.add(pageTitle, BorderLayout.NORTH);

        // Create a back button
        JButton backToMenu = new JButton("<-- Back to Menu");
        backToMenu.addActionListener(e -> {
            mainMenu.showWindow(); // Return to main menu
            soundPlayer.playSound("sounds/button_click.wav");
            frame.dispose(); // Close the current window
        });

        // Add the back button to the bottom (BorderLayout.SOUTH)
        frame.add(backToMenu, BorderLayout.SOUTH);

        // Create a combined panel to hold the buttons and other content
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BorderLayout());

        // Create a panel for the menu buttons using GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        JButton randomButton = new JButton("Random Noise");
        buttonPanel.add(randomButton);

        // Add button panel to the top of the combined panel
        combinedPanel.add(buttonPanel, BorderLayout.NORTH);

        // Add additional content panel to the center
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(new JLabel("Automatic Soundboard Controls"));
        combinedPanel.add(contentPanel, BorderLayout.CENTER);

        // Add the combined panel to the CENTER of the frame
        frame.add(combinedPanel, BorderLayout.CENTER);

        // Set up the random noise functionality
        final File dir = new File("sounds/trigger_noises");
        File[] files = dir.listFiles();
        Random rand = new Random();

        randomButton.addActionListener(e -> {
            File randomSoundFile = files[rand.nextInt(files.length)];
            soundPlayer.playSound("sounds/trigger_noises/" + randomSoundFile.getName());
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
