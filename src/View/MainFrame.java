package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Container container;
    private CardLayout cardLayout;
    private final MenuPanel menuPanel = new MenuPanel();
    private final GamePanel gamePanel = new GamePanel();
    private boolean onMenuPanel;
    private boolean onGamePanel;

    public MainFrame() {
        initialize();
        this.onMenuPanel = true;
    }

    private void initialize() {
        this.cardLayout = new CardLayout();
        container = this.getContentPane();
        container.setLayout(this.cardLayout);

        container.add(menuPanel);
        container.add(gamePanel);

        this.setSize(600,600);
        this.setBackground(Color.black);
        this.setResizable(false);
        this.setVisible(true);
    }
    //random comment

    public boolean getOnMenuPanel() {
        return this.onMenuPanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public boolean getOnGamePanel() {
        return this.onGamePanel;
    }

    public void changePanel(String gameType) {
        switch(gameType) {
            case "normal":
                this.onMenuPanel = false;
                this.onGamePanel = true;
                this.cardLayout.next(this.container);
                break;
            case "no border":
                this.onMenuPanel = false;
                this.onGamePanel = true;
                this.cardLayout.next(this.container);
                break;
            case "menu":
                this.onMenuPanel = true;
                this.onGamePanel = false;
                this.cardLayout.next(this.container);
                break;
        }
    }
}
