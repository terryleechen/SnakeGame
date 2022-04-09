package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final MenuPanel menuPanel = new MenuPanel();
    private final boolean onMenuPanel;

    public MainFrame() {
        initialize();
        onMenuPanel = true;
    }

    private void initialize() {
        this.add(menuPanel);
        this.setSize(600,600);
        this.setBackground(Color.black);
        this.setResizable(false);
        this.setVisible(true);
    }

    public boolean getOnMenuPanel() {
        return this.onMenuPanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }


}
