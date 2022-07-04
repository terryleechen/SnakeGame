package View;
import java.awt.*;
import javax.swing.*;
import Model.GameModel;
import java.util.Random;

public class GamePanel extends JPanel {
    boolean running = false;
    boolean wBorders = true;
    int screenHeight = 600;
    int screenWidth = 600;
    int unitSize = 25;
    int canFitXUnits = (screenWidth*screenHeight)/unitSize;
    int mouseX;
    int mouseY;
    Random random;
    Timer timer;

    private GameModel gameModel;
    
    GamePanel() {
        this.setBounds(0,0,screenHeight,screenWidth);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.addKeyListener(new GameModel());
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
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
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        for (int i=0;i<(screenHeight/unitSize);i++){
            g.drawLine(i*unitSize,0, i*unitSize, screenHeight);
            g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
        }
        
        if(gameModel.isRunning()) {
            // set apple
            g.setColor(Color.red);
            g.fillOval(gameModel.getAppleX(), gameModel.getAppleY(),
                25, 25);

            int bodyParts = gameModel.getBodyParts();
            int[] x = gameModel.getX();
            int[] y = gameModel.getY();          
            
            for(int i = 0; i< bodyParts;i++) {
                // set head
                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], 25, 25);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], 25, 25);
                }			
            }
        } else {
            //gameModel.GameOver();
        }
    }

    public void panelRepaint() {
        repaint();
    }
}
