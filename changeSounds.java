import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class changeSounds {

    // Constructor (if needed, otherwise the default constructor is fine)
    public changeSounds() {
    }


     // Method to copy the selected file to the trigger_noises folder
    public static void copyFileToFolder(String sourceFilePath, String destinationFolder) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File destinationDir = new File(destinationFolder);

        // Create the directory if it doesn't exist
        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        // Define the target file path
        Path targetPath = Paths.get(destinationDir.getAbsolutePath(), sourceFile.getName());

        // Check if the file already exists
        if (Files.exists(targetPath)) {
            int overwrite = JOptionPane.showConfirmDialog(null, "File already exists. Overwrite?", "Overwrite Confirmation", JOptionPane.YES_NO_OPTION);
            if (overwrite == JOptionPane.NO_OPTION) {
                return; // Exit if the user does not want to overwrite the file
            }
        }

        // Copy the file to the destination folder
        Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

     // Helper method to open a file chooser at the specified directory
     public static String getFileFromDirectory(String directoryPath) {
        String filepath = "file not chosen";
        JFileChooser chooser = new JFileChooser(directoryPath); // Open file chooser in the given directory
        chooser.setCurrentDirectory(new File(directoryPath));
        int result = chooser.showOpenDialog(chooser);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            filepath = selectedFile.getAbsolutePath();
        }
        return filepath;
    }

    // Method to choose a file from the explorer
    public static String getFileName(){
        String filepath = "file not chosen";
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        int result = chooser.showOpenDialog(chooser);

        if (result == JFileChooser.APPROVE_OPTION){
            File selectedFile = chooser.getSelectedFile();
            filepath = selectedFile.getAbsolutePath();
        }
        return filepath;
    }

    public void showWindow() {
        // This sets the window title for change sounds
        JFrame frame = new JFrame("Change Sounds");
        frame.setSize(800, 600); // This sets the width to 800px and the height to 600px
        frame.setLocationRelativeTo(null); // This centers the frame on the screen
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

        // Create the "Add Sound" button and add it under the title
        JButton addSoundButton = new JButton("Add Sound");
        addSoundButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/button_click.wav"); // Plays sound when button is clicked
            // Get the user-selected file path
            String selectedFilePath = getFileName();

            // If the user chose a file, copy it to the "trigger_noises" folder
            if (!selectedFilePath.equals("file not chosen")) {
                String destinationFolder = "sounds/trigger_noises"; // Folder where the file will be saved

                // Call the method to copy the file
                try {
                    copyFileToFolder(selectedFilePath, destinationFolder);
                    JOptionPane.showMessageDialog(null, "Sound added successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding sound: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No file chosen.");
            }
        });
        addSoundButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        mainPanel.add(addSoundButton); // Add the button to the main panel

        // Create the "Remove Sound" button and add it under the "Add Sound" button
        JButton removeSoundButton = new JButton("Remove Sound");
        removeSoundButton.addActionListener(e -> {
            soundPlayer.playSound("sounds/button_click.wav"); // Plays sound when button is clicked

            // Open file explorer starting from the trigger_noises folder
            String triggerNoisesFolder = "sounds/trigger_noises";
            String selectedFilePath = getFileFromDirectory(triggerNoisesFolder);

            if (!selectedFilePath.equals("file not chosen")) {
                File selectedFile = new File(selectedFilePath);

                // Check if the selected file is inside the trigger_noises folder
                if (selectedFile.getParent().equals(new File(triggerNoisesFolder).getAbsolutePath())) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this file?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                    // If the user confirms, delete the file
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            Files.delete(selectedFile.toPath());
                            JOptionPane.showMessageDialog(null, "File removed successfully!");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error removing file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error: You can only remove files from the trigger_noises folder.", "Invalid File", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No file chosen.");
            }
        });
        removeSoundButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        mainPanel.add(removeSoundButton); // Add the button to the main panel

        // Add the mainPanel (with stacked title and button) to the center of the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create a back button and add it to the bottom
        JButton backToMenu = new JButton("<-- Back to Menu");
        backToMenu.addActionListener(e -> {
            soundPlayer.playSound("sounds/button_click.wav"); // Plays sound when button is clicked
            mainMenu.showWindow(); // Return to main menu
            frame.dispose(); // Close the current window
        });
        frame.add(backToMenu, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
