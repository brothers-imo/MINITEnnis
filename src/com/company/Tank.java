package com.company;



import java.awt.*   ;
import javax.swing.*    ;

/**
 * Created by khashayarbarooti on 28/01/15.
 */
public class Tank extends JPanel{


    private String tankName = "Assets/tank.png"    ;
    Image image     ;


    int x , y   ;



    Main game   ;
    Gun     gun ;

    public Tank(Main _game)
    {
        game    =   _game   ;
        gun =   new Gun(game);



    }


    @Override
    public void paintComponent(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g ;
        ImageIcon ii = new ImageIcon(tankName);
        image = ii.getImage()   ;


        //g.fillRect(y*50, x*50, 60, 10);
        //g2d.drawImage(image,y*4,x*4,null);





    }




    public void shoot(int _forceX , int _forceY) throws InterruptedException {

        this.gun.shoot(_forceX,_forceY);

    }




    //debug
    public void showTankPos()
    {
        System.out.println(x);
        System.out.println(y);
    }



}
