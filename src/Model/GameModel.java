package Model;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import View.GamePanel;

import java.util.Random;


public class GameModel extends KeyAdapter implements ActionListener {

    private static final int UNIT_SIZE = 25;
    private static final int SCREEN_SIZE = 600;
    private static final int GAME_UNITS = SCREEN_SIZE * SCREEN_SIZE / UNIT_SIZE;
    private static final int TEMPO = 75;
    private int x[];
    private int y[];
    private int bodyParts;
    private Random random;
    private int appleX, appleY;
    private String direction = "R";
    private boolean isRunning;
    private Timer timer;
    private GamePanel gamePanel;

    public GameModel() {
        isRunning = false;
        random = new Random();
        bodyParts = 6;
        
    }
    public void startGame()
    {
        isRunning = true;
        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];
        timer = new Timer(TEMPO, this);
        timer.start();
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isRunning()
    {
        return isRunning;
    }

    public int getBodyParts()
    {
        return bodyParts;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_SIZE/UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_SIZE/UNIT_SIZE)) * UNIT_SIZE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isRunning) {
            move();
            checkApple();
            checkCollisions();
        } else {
            //newApple();
        }
        gamePanel.repaint();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if(!direction.equals("D")) {
                    direction = "U";
                }
                break;
            case KeyEvent.VK_DOWN:
                if(!direction.equals("U")) {
                    direction = "D";
                }
                break;
            case KeyEvent.VK_LEFT:
                if(!direction.equals("R")) {
                    direction = "L";
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(!direction.equals("L")) {
                    direction = "R";
                }
                break;
        }
    }

    private void move() {
        for(int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
			y[i] = y[i - 1];
        }
        
        switch(direction) {
            case "U":
                y[0] = y[0] - UNIT_SIZE;
                break;
            case "D":
                y[0] = y[0] + UNIT_SIZE;
                break;
            case "L":
                x[0] = x[0] - UNIT_SIZE;
                break;
            case "R":
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    private void checkCollisions() {
        //checks if head collides with body
		for(int i = bodyParts;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				isRunning = false;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			isRunning = false;
		}
		//check if head touches right border
		if(x[0] > 600) {
			isRunning = false;
		}
		//check if head touches top border
		if(y[0] < 0) {
			isRunning = false;
		}
		//check if head touches bottom border
		if(y[0] > 600) {
			isRunning = false;
		}

        if(!isRunning) {
            timer.stop();
        }
    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			//applesEaten++;
			newApple();
		}
    }

    public void GameOver() {

    }
    
}