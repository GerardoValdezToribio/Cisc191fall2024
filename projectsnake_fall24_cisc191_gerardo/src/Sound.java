import javax.sound.sampled.*;
import java.net.URL;
import java.io.IOException;

public class Sound {
    private Clip clip;
    private URL[] soundURL = new URL[30];

    public Sound() {
        // Example: load a test sound file from res folder
        soundURL[0] = getClass().getResource("/res/test.wav");
        if (soundURL[0] == null) {
            System.err.println("Error: test.wav not found in /res.");
        }
    }

    public void setFile(int index) {
        try {
            if (soundURL[index] == null) {
                throw new IOException("Sound file at index " + index + " not found.");
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[index]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            System.out.println("Sound file loaded successfully.");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error: Unable to load audio file.");
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            System.out.println("Sound is playing...");
        } else {
            System.err.println("Error: Clip is null. Cannot play sound.");
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("Sound is looping...");
        } else {
            System.err.println("Error: Clip is null. Cannot loop sound.");
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            System.out.println("Sound stopped.");
        } else {
            System.err.println("Error: Clip is null. Cannot stop sound.");
        }
    }
}
