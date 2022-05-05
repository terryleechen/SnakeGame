package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.MainFrame;

/**
 * This is the main controller for the snake game
 * 
 * Field        Description
 * mainFrame    the main window
 */
public class MainController {
    private final MainFrame mainFrame;
    
    /**
     * constructor of main controller
     */
    public MainController() {
        mainFrame = new MainFrame();

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
                            System.out.println(gameType);
                            mainFrame.changePanel(gameType);
                            break;
                    }
                // if main frame is in game panel
                } else if(mainFrame.getOnGamePanel()) {
                    
                    int key = e.getKeyCode();
                    switch(key) {
                        //case KeyEvent.VK_ENTER:
                            //mainFrame.changePanel("normal");
                            //break;
                        case KeyEvent.VK_ESCAPE:
                            mainFrame.changePanel("menu");
                            break;
                    }
                }
            }
            
            // not in use
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
    }

    

    
}
