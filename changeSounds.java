import javax.swing.*;
import java.awt.*;

public class changeSounds {

    public void showWindow() {
        // this sets the window title
        JFrame frame = new JFrame("Change Sounds");
        frame.setSize(800, 600); // This sets the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(new BorderLayout()); // Set the layout to BorderLayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel that will stack components vertically
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add the title at the top
        JLabel pageTitle = new JLabel("Change Sounds", JLabel.CENTER);
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment for the label
        mainPanel.add(pageTitle); // Add the title to the main panel

        // Add some space between the title and the button
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Adds vertical space (20px)

        // Create the "Random Noise" button and add it under the title
        JButton randomButton = new JButton("Add Sound");
       randomButton.addActionListener(e -> {
            mainMenu.showWindow(); // Return to main menu
            soundPlayer.playSound("sounds/button_click.wav");
            frame.dispose(); // Close the current window
        });
        randomButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        mainPanel.add(randomButton); // Add the button to the main panel

        // Add the mainPanel (with stacked title and button) to the center of the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create a back button and add it to the bottom
        JButton backToMenu = new JButton("<-- Back to Menu");
        backToMenu.addActionListener(e -> {
            mainMenu.showWindow(); // Return to main menu
            soundPlayer.playSound("sounds/button_click.wav");
            frame.dispose(); // Close the current window
        });
        frame.add(backToMenu, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
