package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
    private final JLabel gameTitle;
    private final JLabel normalGame;
    private final JLabel selectedNormalGame;
    private final JLabel noBorder;
    private final JLabel selectedNoBorder;
    private final JLabel exit;
    private final JLabel selectedExit;
    private ImageIcon snake;

    MenuPanel() {
        gameTitle = new JLabel("Snake Game");
        normalGame = new JLabel("Normal Game");
        selectedNormalGame = new JLabel("<Normal Game>");
        noBorder = new JLabel("No Border");
        selectedNoBorder = new JLabel("<No Border>");
        exit = new JLabel("Exit");
        selectedExit = new JLabel("<Exit>");
        snake = new ImageIcon("snake.png");

        this.setBounds(0,0,600,600);
        this.setBackground(Color.black);
        this.setLayout(null);

        //set game title
        gameTitle.setForeground(Color.white);
        gameTitle.setFont(new Font("Sans-serif", Font.BOLD, 36));
        gameTitle.setBounds(25,0,600,200);

        //set normal game
        normalGame.setVisible(false);
        normalGame.setForeground(Color.white);
        normalGame.setBackground(Color.black);
        normalGame.setFont(new Font("Sans-serif", Font.BOLD, 25));
        normalGame.setBounds(200,200,200,50);

        //set selected normal game
        selectedNormalGame.setVisible(true);
        selectedNormalGame.setForeground(Color.white);
        selectedNormalGame.setBackground(Color.black);
        selectedNormalGame.setFont(new Font("Sans-serif", Font.BOLD, 25));
        selectedNormalGame.setBounds(200,200,200,50);

        //set no Border game
        selectedNoBorder.setVisible(true);
        noBorder.setForeground(Color.white);
        noBorder.setBackground(Color.black);
        noBorder.setFont(new Font("Sans-serif", Font.BOLD, 25));
        noBorder.setBounds(200,250,200,50);

        //set selected no Border game
        selectedNoBorder.setVisible(false);
        selectedNoBorder.setForeground(Color.white);
        selectedNoBorder.setBackground(Color.black);
        selectedNoBorder.setFont(new Font("Sans-serif", Font.BOLD, 25));
        selectedNoBorder.setBounds(200,250,200,50);

        //set exit game
        exit.setVisible(true);
        exit.setForeground(Color.white);
        exit.setBackground(Color.black);
        exit.setFont(new Font("Sans-serif", Font.BOLD, 25));
        exit.setBounds(200,300,200,50);

        //set selected exit game
        selectedExit.setVisible(false);
        selectedExit.setForeground(Color.white);
        selectedExit.setBackground(Color.black);
        selectedExit.setFont(new Font("Sans-serif", Font.BOLD, 25));
        selectedExit.setBounds(200,300,200,50);
        
        //change image size
        Image i = snake.getImage();
        i = i.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        snake = new ImageIcon(i);

        gameTitle.setIcon(snake);
        this.add(gameTitle);
        this.add(normalGame);
        this.add(selectedNormalGame);
        this.add(noBorder);
        this.add(selectedNoBorder);
        this.add(exit);
        this.add(selectedExit);
    }

    public void menuSelection(int key) {
        if(this.selectedNormalGame.isVisible()) {
            switch(key) {
                case KeyEvent.VK_DOWN:
                    this.selectedNoBorder.setVisible(true);
                    this.noBorder.setVisible(false);
                    break;
                case KeyEvent.VK_UP:
                    this.selectedExit.setVisible(true);
                    this.exit.setVisible(false);
                    break;
            }

            this.selectedNormalGame.setVisible(false);
            this.normalGame.setVisible(true);
        } else if(this.selectedNoBorder.isVisible()) {
            switch(key) {
                case KeyEvent.VK_DOWN:
                    this.selectedExit.setVisible(true);
                    this.exit.setVisible(false);
                    break;
                case KeyEvent.VK_UP:
                    this.selectedNormalGame.setVisible(true);
                    this.normalGame.setVisible(false);
                    break;
            }

            this.selectedNoBorder.setVisible(false);
            this.noBorder.setVisible(true);
        } else if(this.selectedExit.isVisible()) {
            switch(key) {
                case KeyEvent.VK_DOWN:
                    this.selectedNormalGame.setVisible(true);
                    this.normalGame.setVisible(false);
                    break;
                case KeyEvent.VK_UP:
                    this.selectedNoBorder.setVisible(true);
                    this.noBorder.setVisible(false);
                    break;
            }

            this.exit.setVisible(true);
            this.selectedExit.setVisible(false);
        }   
    }
}
