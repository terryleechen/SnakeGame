package View;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

class GamePanel extends JPanel {
    boolean running = false;
    boolean wBorders = true;
    int screenHeight = 600;
    int screenWidth = 600;
    int unitSize = 20;
    int canFitXUnits = (screenWidth*screenHeight)/unitSize;
    int mouseX;
    int mouseY;
    Random random;

    GamePanel() {
        this.setBounds(0,0,screenHeight,screenWidth);
        this.setBackground(Color.black);
        this.setLayout(null);
        random = new Random();
        startGame();
    }
    
    public void startGame(){
        running = true;
    }

    public void newMouse(Graphics g){
        // generate the coordinates of the new Mouse. Can be used when the game begins, apples gets eaten etc
        mouseX = random.nextInt((int)(screenWidth/unitSize)*unitSize);   // X coordinate
        mouseY = random.nextInt((int)(screenHeight/unitSize)*unitSize);  // Y coordinate
        g.fillOval(mouseX, mouseY, unitSize, 2);
        g.setColor(Color.gray);
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
