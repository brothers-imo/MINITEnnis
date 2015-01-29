package com.company;
import javax.swing.*;
import java.awt.*   ;

/**
 * Created by khashayarbarooti on 25/01/15.
 */
public class Ball extends JFrame{
    //int  x =0 , y =770     ;
     int x , y ;
    //int xa =10;
    //int ya =-30;
    int xa , ya ;
    int acY     =   1   ;

    Main _game  ;

    public Ball(Gun gun,Main game)
    {
        x = gun.posX    ;
        y = gun.posY    ;

        xa = gun.forceX     ;
        ya  =   gun.forceY      ;

        this._game = game ;

    }


    void move()
    {

        x += xa    ;
        y += ya     ;
        ya += acY    ;





    }



    void paint(Graphics2D   g)
    {
        g.fillOval(x, y, 5, 5);
    }



}
