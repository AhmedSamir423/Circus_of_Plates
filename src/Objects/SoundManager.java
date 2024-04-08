/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Youssef
 */
import javax.sound.sampled.*;
import java.io.File;

public class SoundManager {

    private static Clip gameStartClip;
    private static Clip scoreClip;

    public static void playGameStartSound() {
        stopGameStartSound();
        gameStartClip = playSound("Circus   Theme Song.wav", 0.25f);
    }

    public static void playScoreSound() {
        stopScoreSound();
        scoreClip = playSound("Checkpoint Sound Effect.wav", 1.5f);
    }

    public static void playGameOverSound() {
        stopGameStartSound();
        stopScoreSound();
        playSound("goofy ahh sound.wav", 1.5f);
    }

    private static void stopGameStartSound() {
        if (gameStartClip != null && gameStartClip.isRunning()) {
            gameStartClip.stop();
        }
    }

    private static void stopScoreSound() {
        if (scoreClip != null && scoreClip.isRunning()) {
            scoreClip.stop();
        }
    }

    private static Clip playSound(String fileName, float volume) {
        try {
            File file = new File(fileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Adjust the volume
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(volume));

            clip.start();
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

