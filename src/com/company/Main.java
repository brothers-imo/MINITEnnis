package com.company;
import java.awt.*   ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel   ;
import javax.swing.*   ;



@SuppressWarnings("serial")
public class Main extends JPanel{


    public Main()
    {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                    racquet.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                    racquet.keyReleased(keyEvent);
            }
        });


        setFocusable(true);
    }

    public Ball ball = new Ball(this)  ;
    public Racquet racquet = new Racquet(this);

    private void move()
    {
        ball.move();
        racquet.move()  ;
    }

    /*
    int x=0 ,y=0    ;
    int xa=1 , ya=1 ;
    private void moveBall()
    {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > getHeight() - 30)
            ya = -1;

        x = x + xa;
        y = y + ya;

    }
    */



    @Override
    public void paint(Graphics g)
    {
        //clear the screen
        super.paint(g)  ;



        Graphics2D g2d = (Graphics2D)   g   ;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        ball.paint(g2d);
        racquet.paint(g2d);

    }




    public static void main(String[] args) throws InterruptedException {
            JFrame  frame = new JFrame("Tennis ")   ;
        Main game = new Main()  ;
            frame.add(game) ;
            frame.setSize(300,400);
            frame.setVisible(true);


        //animation
        while (true)
        {
            game.move();
            game.repaint();
            Thread.sleep(10);

        }


         }



    //game over
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }


}
