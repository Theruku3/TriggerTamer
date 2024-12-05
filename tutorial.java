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

public class tutorial {

    public void showWindow() {
        // this sets the window title
        Frame frame = new JFrame("Tutorial");
        frame.setSize(800, 600); // This sets the width to 500px and the height to 400px
        frame.setLocationRelativeTo(null); // this centers the frame on the screen
        frame.setLayout(null);

        // this adds a title to the frame
        JLabel pageTitle = new JLabel("Tutorial");
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
}
    
}
