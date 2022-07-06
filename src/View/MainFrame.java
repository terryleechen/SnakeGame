package View;

import javax.swing.*;
import java.awt.*;

/**
 * This is the main frame of snake game
 * 
 * Fields           Description
 * container        container stores all the different panels
 * cardLayout       card layout allows it to switch betweend different panels
 * menuPanel        front end of menu panel
 * gamePanel        front end of game panel
 * onMenuPanel      flag to indicate it's on menu
 * onGamePanel      flag to indicate it's on game
 */
public class MainFrame extends JFrame {
    private Container container;
    private CardLayout cardLayout;
    private final MenuPanel menuPanel = new MenuPanel();
    private final GamePanel gamePanel = new GamePanel();
    private final PausePanel pausePanel = new PausePanel();
    private boolean onMenuPanel;
    private boolean onGamePanel;
    private boolean onPausePanel;
    int screenHeight = 600;
    int screenWidth = 600;

    /**
     * This is the constructor of main frame
     */
    public MainFrame() {
        initialize();
        this.onMenuPanel = true;
    }

    /**
     * This function initialize all the panels
     */
    private void initialize() {
        this.cardLayout = new CardLayout();
        container = this.getContentPane();
        container.setLayout(this.cardLayout);

        container.add(menuPanel, "menu");
        container.add(gamePanel, "game");
        container.add(pausePanel, "pause");

        this.setSize(600,600);
        this.setBackground(Color.black);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * This is a getter method of flag for menu panel
     * @return (Boolean)
     */
    public boolean getOnMenuPanel() {
        return this.onMenuPanel;
    }

    /**
     * This is a getter method for menu panel
     * @return (MenuPanel)
     */
    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    /**
     * This is a getter method of flag for game panel
     * 
     * @return (Boolean)
     */
    public boolean getOnGamePanel() {
        return this.onGamePanel;
    }

    public boolean getOnPausePanel() {
        return this.onPausePanel;
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    public PausePanel getPausePanel() {
        return this.pausePanel;
    }

    /**
     * This function changes between panels
     * 
     * @param gameType (String) the option
     */
    public void changePanel(String gameType) {
        switch(gameType) {
            case "normal":
                this.onMenuPanel = false;
                this.onGamePanel = true;
                this.onPausePanel = false;
                this.cardLayout.show(this.container, "game");
                break;
            case "no border":
                this.onMenuPanel = false;
                this.onGamePanel = true;
                this.cardLayout.show(this.container, "game");
                break;
            case "menu":
                this.onMenuPanel = true;
                this.onGamePanel = false;
                this.onPausePanel = false;
                this.cardLayout.show(this.container, "menu");
                break;
            case "pause":
                this.cardLayout.show(this.container, "pause");
                this.onPausePanel = true;
                this.onGamePanel = false;
                break;
        }
    }
}
