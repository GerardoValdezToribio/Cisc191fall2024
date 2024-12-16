import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    private JLabel scoreLabel;

    public GameOverPanel(GameFrame frame) {
        setLayout(null);

        JLabel gameOverLabel = new JLabel("GAME OVER", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gameOverLabel.setBounds(0, 100, 600, 60);
        add(gameOverLabel);

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setBounds(0, 180, 600, 40);
        add(scoreLabel);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(200, 250, 200, 50);
        playAgainButton.addActionListener(e -> frame.playAgain());
        add(playAgainButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 320, 200, 50);
        exitButton.addActionListener(e -> frame.exitGame());
        add(exitButton);
    }

    public void setScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
