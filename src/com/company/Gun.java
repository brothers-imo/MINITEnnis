package com.company;
import java.awt.*   ;
import java.awt.event.KeyEvent;
import java.beans.IntrospectionException;

/**
 * Created by khashayarbarooti on 26/01/15.
 */
public class Gun {
    int posX  = 0   ;
    int posY  = 580  ;
    int forceX , forceY ;
    Main game ;
    Ball bull   ;
    public Gun(Main _game)
    {
        game = _game    ;
    }

    public void shoot(int _forceX , int _forceY) throws InterruptedException
    {
        forceX =    _forceX ;
        forceY =   _forceY  ;
        bull = new Ball(this , game)    ;
        int i = 0 ;
        while (true)
        {
            game.repaint();
            bull.move();
            Thread.sleep(12);
            i++ ;


        }

    }
    public void paint(Graphics2D g)
    {
        g.fillRect(posX, posY, 60, 10);
        this.bull.paint(g);
    }


    public void keyPressed(KeyEvent ev) throws InterruptedException {
        if (ev.getKeyCode() == KeyEvent.VK_SPACE)
            this.shoot(20, -20);
    }



}
