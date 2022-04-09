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

                    switch (key) {
                        case KeyEvent.VK_DOWN:
                            mainFrame.getMenuPanel().menuSelection(key);
                            break;
                        case KeyEvent.VK_UP:
                            mainFrame.getMenuPanel().menuSelection(key);
                            break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
    }

    

    
}
