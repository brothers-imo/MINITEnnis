package com.company;
import java.awt.*   ;
import java.awt.event.KeyEvent;

/**
 * Created by khashayarbarooti on 25/01/15.
 */
public class Racquet {
    int x =0  ;
    int xa =0 ;
    Main game ;
    public Racquet(Main _game)
    {
        game = _game ;

    }


    public void move()
    {
        if (x + xa > 0 && x + xa < game.getWidth()-60)
            x = x + xa;
    }


    public void paint(Graphics2D g)
    {
        g.fillRect(x, 330, 60, 10);
    }


    public void keyReleased(KeyEvent keyEvent)
    {
        xa = 0 ;
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            xa = -2     ;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            xa = 2  ;

        }
    }
}
