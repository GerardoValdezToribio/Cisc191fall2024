import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Music {
    private Clip audioClip;
    private boolean loops;
    private String fn;

    public Music(String fileName, boolean loops) {
        this.fn = fileName;
        this.loops = loops;
        loadAudioFile();
    }

    private void loadAudioFile() {
        try {
            File audioFile = new File(fn);
            if (!audioFile.exists()) {
                System.err.println("Error: Audio file not found: " + fn);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Error: Unsupported audio file format for " + fn);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Unable to load audio file " + fn);
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("Error: Audio line unavailable for " + fn);
            e.printStackTrace();
        }
    }

    public void play() {
        if (audioClip != null) {
            audioClip.setFramePosition(0);
            if (loops) {
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                audioClip.start();
            }
            System.out.println("Playing audio: " + fn);
        } else {
            System.err.println("Error: No audio loaded to play.");
        }
    }

    public void stop() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            System.out.println("Audio stopped: " + fn);
        }
    }
}
