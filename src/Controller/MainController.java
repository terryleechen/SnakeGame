package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.GameModel;
import View.MainFrame;

/**
 * This is the main controller for the snake game
 * 
 * Field        Description
 * mainFrame    the main window
 */
public class MainController {
    private final MainFrame mainFrame;
    private final GameModel gameModel;
    private int count;
    
    /**
     * constructor of main controller
     */
    public MainController() {
        mainFrame = new MainFrame();
        gameModel = new GameModel();

        mainFrame.getGamePanel().setGameModel(gameModel);
        gameModel.setGamePanel(mainFrame.getGamePanel());

        // add key listener for main frame
        mainFrame.addKeyListener(new KeyListener() {
            // not in use
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                // if main frame is in menu panel
                if (mainFrame.getOnMenuPanel()) {
                    int key = e.getKeyCode();

                    switch(key) {
                        case KeyEvent.VK_DOWN:
                            mainFrame.getMenuPanel().menuSelection(key);
                            break;
                        case KeyEvent.VK_UP:
                            mainFrame.getMenuPanel().menuSelection(key);
                            break;
                        case KeyEvent.VK_ENTER:
                            String gameType = mainFrame.getMenuPanel().menuOption();
                            mainFrame.changePanel(gameType);

                            if(mainFrame.getOnGamePanel()) {
                                gameOn();
                            }
                            break;
                    }
                // if main frame is in game panel
                } else if(mainFrame.getOnGamePanel()) {
                    int key = e.getKeyCode();

                    switch(key) {
                        case KeyEvent.VK_UP:
                            if(!gameModel.getDirection().equals("D")) {
                                gameModel.setDirection("U");
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if(!gameModel.getDirection().equals("U")) {
                                gameModel.setDirection("D");
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if(!gameModel.getDirection().equals("L")) {
                                gameModel.setDirection("R");
                            }
                            break;
                        case KeyEvent.VK_LEFT:
                            if(!gameModel.getDirection().equals("R")) {
                                gameModel.setDirection("L");
                            }
                            break;
                        //case KeyEvent.VK_ENTER:
                            //mainFrame.changePanel("normal");
                            //break;
                        case KeyEvent.VK_ESCAPE:
                            if(count % 2 == 0) {
                                System.out.println(KeyEvent.VK_ESCAPE);
                                int score = gameModel.getAppleEatten();
                                mainFrame.getPausePanel().setScore(score);
                                mainFrame.getPausePanel().pauseGame();
                                mainFrame.changePanel("pause");
                                gameModel.pauseTimer();
                                count++;
                            } else {
                                mainFrame.changePanel("normal");
                                gameModel.restartTimer();
                                count++;
                            }
                            break;
                            
                    }
                } else if(mainFrame.getOnPausePanel()) {
                    int key = e.getKeyCode();
                    
                    switch(key) {
                        case KeyEvent.VK_UP:
                            mainFrame.getPausePanel().pauseMenu(key);
                            break;
                        case KeyEvent.VK_DOWN:
                            mainFrame.getPausePanel().pauseMenu(key);
                            break;
                    }
                }
            }
            
            // not in use
            @Override
            public void keyReleased(KeyEvent e) {}
        });
           
    }

    private void gameOn() {
        gameModel.startGame();
        gameModel.newApple();
    }

}
