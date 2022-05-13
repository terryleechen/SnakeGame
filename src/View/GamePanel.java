package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class GamePanel extends JPanel {
    boolean running = false;
    boolean wBorders = true;
    int screenHeight = 600;
    int screenWidth = 600;
    int unitSize = 20;
    int canFitXUnits = (screenWidth*screenHeight)/unitSize;
    int Delay = 75;
    int bodyParts = 4;                       
    int miceEaten;
    int mouseX;
    int mouseY;
    char direction = 'R';
    Random random;
    // 2 arrays (x,y) that hold the coordinates for all the body parts
    int x[] = new int[canFitXUnits];
    int y[] = new int[canFitXUnits];


    GamePanel() {
        this.setBounds(0,0,screenHeight,screenWidth);
        this.setBackground(Color.black);
        this.setLayout(null);
        random = new Random();
        startGame();
    }    

    public void startGame(){
        running = true;
        newMouse();
    }

    public void newMouse(){
        mouseX = random.nextInt((int)(screenWidth/unitSize)*unitSize);

    }


    /* FOR TEST PURPOSES ONLY!!!
       Creates a grid for visualizing game- normal mode
    */
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for (int i=0;i<(screenHeight/unitSize);i++){
            g.drawLine(i*unitSize,0, i*unitSize,screenHeight);
            g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
        }
    }
}
