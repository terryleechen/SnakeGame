package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.MainFrame;

public class MainController {
    private final MainFrame mainFrame;
    
    public MainController() {
        mainFrame = new MainFrame();

        mainFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
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

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
    }

    

    
}
