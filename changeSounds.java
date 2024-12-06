import javax.swing.*;
import java.awt.*;

public class changeSounds {

    public void showWindow() {
        // this sets the window title
        JFrame frame = new JFrame("Change Sounds");
        frame.setSize(800, 600); // This sets the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(new BorderLayout()); // Set the layout to BorderLayout

        // this adds a title to the frame
        JLabel pageTitle = new JLabel("Change Sounds", JLabel.CENTER);
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

        // Create a panel in the center for additional content (if needed)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout()); // Example layout for central content
        contentPanel.add(new JLabel("Automatic Soundboard Controls")); // Example content
        frame.add(contentPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
