package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;


public class PausePanel extends JPanel {
    private final JLabel currentScore;
    private final JLabel setting;
    private final JLabel selectedSetting;
    private final JLabel restart;
    private final JLabel selectedRestart;
    private final JLabel quit;
    private final JLabel selectedQuit;
    private int score = 0;
    
    PausePanel() {
        this.setBounds(0,0,600,600);
        this.setBackground(Color.black);
        this.setLayout(null);

        currentScore = new JLabel("Score: " + score);
        setting = new JLabel("setting");
        selectedSetting = new JLabel("<setting>");
        restart = new JLabel("restart");
        selectedRestart = new JLabel("<restart>");
        quit = new JLabel("quit");
        selectedQuit = new JLabel("<quit>");

        this.add(currentScore);
        this.add(setting);
        this.add(selectedSetting);
        this.add(restart);
        this.add(selectedRestart);
        this.add(quit);
        this.add(selectedQuit);
    }

    public void pauseGame() {
        // current socre
        currentScore.setText("Score: " + score);
        currentScore.setVisible(true);
        currentScore.setForeground(Color.white);
        currentScore.setFont(new Font("Sans-serif", Font.BOLD, 36));
        currentScore.setBounds(200,0,600,200);

        // setting
        setting.setVisible(false);
        setting.setForeground(Color.white);
        setting.setBackground(Color.black);
        setting.setFont(new Font("Sans-serif", Font.BOLD, 25));
        setting.setBounds(200,200,200,50);

        // selected setting
        selectedSetting.setVisible(true);
        selectedSetting.setForeground(Color.white);
        selectedSetting.setBackground(Color.black);
        selectedSetting.setFont(new Font("Sans-serif", Font.BOLD, 25));
        selectedSetting.setBounds(200,200,200,50);

        // restart
        restart.setVisible(true);
        restart.setForeground(Color.white);
        restart.setBackground(Color.black);
        restart.setFont(new Font("Sans-serif", Font.BOLD, 25));
        restart.setBounds(200,250,200,50);

        // selected restart
        selectedRestart.setVisible(false);
        selectedRestart.setForeground(Color.white);
        selectedRestart.setBackground(Color.black);
        selectedRestart.setFont(new Font("Sans-serif", Font.BOLD, 25));
        selectedRestart.setBounds(200,250,200,50);

        // quit
        quit.setVisible(true);
        quit.setForeground(Color.white);
        quit.setBackground(Color.black);
        quit.setFont(new Font("Sans-serif", Font.BOLD, 25));
        quit.setBounds(200,300,200,50);

        // selected quit
        selectedQuit.setVisible(false);
        selectedQuit.setForeground(Color.white);
        selectedQuit.setBackground(Color.black);
        selectedQuit.setFont(new Font("Sans-serif", Font.BOLD, 25));
        selectedQuit.setBounds(200,300,200,50);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void pauseMenu(int key) {
        if(this.selectedSetting.isVisible()) {
            switch(key) {
                case KeyEvent.VK_DOWN:
                    this.selectedRestart.setVisible(true);
                    this.restart.setVisible(false);
                    break;
                case KeyEvent.VK_UP:
                    break;
            }

            this.selectedSetting.setVisible(false);
            this.setting.setVisible(true);
        } else if(this.selectedRestart.isVisible()) {
            switch(key) {
                case KeyEvent.VK_DOWN:
                    break;
                case KeyEvent.VK_UP:
                    break; 
            }

            this.selectedRestart.setVisible(false);
            this.restart.setVisible(true);
        } else if(this.selectedQuit.isVisible()) {
            switch(key) {
                case KeyEvent.VK_DOWN:
                    break;
                case KeyEvent.VK_UP:
                    break; 
            }
            this.selectedRestart.setVisible(false);
            this.quit.setVisible(true);
        }
    }
}
