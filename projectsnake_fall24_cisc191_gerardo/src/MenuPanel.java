import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MenuPanel extends JPanel {
    private BufferedImage logo;

    public MenuPanel(GameFrame frame) {
        setLayout(null);

        // Attempt to load the logo from the res folder
        try {
            logo = ImageIO.read(getClass().getResource("/res/snake_logo.png"));
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Could not load snake_logo.png. Make sure it's placed in src/res/");
            logo = null; 
        }

        // Title "SNAKE EATER" with Gothic font style
        // "Century Gothic" is a common gothic-style font.
        // If not available on your system, try another font name or a fallback.
        JLabel titleLabel = new JLabel("SNAKE EATER", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
        titleLabel.setBounds(0, 20, 600, 60);
        add(titleLabel);

        // Move buttons higher: y = 200
        JButton startButton = new JButton("Start");
        startButton.setBounds(50, 200, 150, 50); 
        startButton.addActionListener(e -> frame.startGame());
        add(startButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 200, 150, 50); 
        exitButton.addActionListener(e -> frame.exitGame());
        add(exitButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the logo if loaded, at y=100
        if (logo != null) {
            int x = (getWidth() - logo.getWidth()) / 2;
            int y = 100; // Position below the title
            g.drawImage(logo, x, y, this);
        }
    }
}
