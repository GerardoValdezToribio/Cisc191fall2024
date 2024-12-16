import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;

    public GameFrame() {
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        // Use CardLayout to manage different screens
        setLayout(new CardLayout());

        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this);
        gameOverPanel = new GameOverPanel(this);

        add(menuPanel, "Menu");
        add(gamePanel, "Game");
        add(gameOverPanel, "GameOver");

        showMenu();
        setVisible(true);
    }

    public void showMenu() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Menu");
    }

    // Called when the user clicks "Start" in the menu
    public void startGame() {
        gamePanel.restartGame(); // Now this will really start the game
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Game");
        gamePanel.requestFocusInWindow();
    }

    public void showGameOver(int score) {
        gameOverPanel.setScore(score);
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "GameOver");
    }

    public void playAgain() {
        startGame();
    }

    public void exitGame() {
        System.exit(0);
    }
}