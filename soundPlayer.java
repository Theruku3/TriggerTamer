import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class soundPlayer {
        public static void playSound(String soundFile) {
        try {
            AudioInputStream foundAudio = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(foundAudio);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Sound file could not be found");
            ex.printStackTrace();
        }
    }
}
