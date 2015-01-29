package com.company;
import java.awt.*   ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JPanel   ;
import javax.swing.*   ;



@SuppressWarnings("serial")
public class Main extends JPanel{

    public Gun  gun = new Gun(this);
    public Ball ball = new Ball(gun,this)  ;
    public Map map = new Map(this) ;
    public Tank tank = new Tank(this);



    public Main()
    {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                    //racquet.keyPressed(keyEvent);
                try {
                    gun.keyPressed(keyEvent)    ;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });


        setFocusable(true);
    }



    //public Racquet racquet = new Racquet(this);

   /* private void move()
    {
       //ball.move();
       // racquet.move()  ;
    }

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

       // gun.paint(g2d);
        //racquet.paint(g2d);
        g2d.setBackground(Color.blue);

        this.map.paint(g2d);
        this.tank.paint(g2d);




    }




    public static void main(String[] args) throws InterruptedException , IOException{
            JFrame  frame = new JFrame("Tennis ")   ;
            Main game = new Main()  ;





            //  testing with a simple map !
             game.map.myMap  = new String[]{
                "000000000000000" ,
                "01##20000000000" ,
                "1####20000T0000" ,
                "###############" ,
                "###############"};





        File file = new File("map.txt") ;


        Scanner in = new Scanner(file);


        while (in.hasNext())
        {
            System.out.println(in.nextLine());
        }








             frame.add(game) ;


            game.add(game.map);
            game.add(game.tank) ;

            frame.setSize(game.map.myMap[0].length()*50  , game.map.myMap.length *50 );
            frame.setVisible(true);


           /* game.map.readMap(new File("map.txt"));
            game.map.showMapString();
*/






            game.map.showMapString();


            //create the game view with the map represented
            for(int i =0 ; i <game.map.myMap.length ; i++)
            {
                for (int j =0   ;   j<game.map.myMap[0].length();j++)
                {

                }
            }



        game.tank.showTankPos();










        //animation for the mini tennis game ! :D
        /*while (true)
        {
           game.move();
           game.repaint();
           Thread.sleep(100);
           i++ ;
            if (i>6) {
                game.ball.dispose();
            }
       }
       */
          //    game.gun.shoot(20 , -20);

    }



    //game over
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }





}
