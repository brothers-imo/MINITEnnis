package com.company;
import java.awt.*   ;

/**
 * Created by khashayarbarooti on 25/01/15.
 */
public class Ball {
    int  x =0 , y =0     ;

    int xa =1;
    int ya =1;


    Main _game  ;

    public Ball(Main game)
    {
        this._game = game ;

    }


    void move()
    {

        if (x + xa < 0)
            xa = 1;
        if (x + xa > _game.getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > 300)
        {
            if(y>_game.getHeight() - 30 )
            {
                _game.gameOver();
            }
            else {
                if (x >= (_game.racquet.x - 30) && x <= (_game.racquet.x + 30)) {
                    ya *= -1;
                }
            }
        }


        //ya += accely    ;
        x = x + xa;
        y = y + ya;
    }



    void paint(Graphics2D   g)
    {
        g.fillOval(x, y, 30, 30);
    }

}
