package com.company;
import java.awt.*   ;
import javax.swing.*    ;
import java.io.File   ;
import java.io.FileNotFoundException;
import java.util.Scanner    ;

/**
 * Created by khashayarbarooti on 27/01/15.
 */
public class Map extends JPanel {
    private final int MAX = 128;

    String[] myMap = new String[MAX];
    Main game;


    //the position of the tank in the map


    private int tankX;
    private int tankY;
    Image incUp , incDown , straight , straightTop , Grass_Tile_Slope_Connector_r ,Grass_Tile_Slope_Connector_l ;


    public Map(Main _game)  {
        game = _game;

    }



    //this part is running in some mistakes for now I'm giving a single Map input to test
    // read the map with the name given



    public void readMap(File _file) throws FileNotFoundException {
        int i = 0;

        Scanner in = new Scanner(_file);


        while (in.hasNext()) {

            String TEMP = in.nextLine();
            myMap[i] = TEMP ;
            i++;



            //to upload to github
            for(int j =0 ; j< 10 ;j++)
            {
                System.out.print("HHHH");
            }

        }


    }





    //return the x & y
    public int getTankX()
    {
        return tankX    ;

    }
    public int getTankY()
    {
        return tankY    ;
    }


      //drawing the Map
      @Override
      public void paintComponent(Graphics g)
      {


          ImageIcon ii = new ImageIcon("Assets/Grass_Tile_lower.png");
          straight = ii.getImage()  ;
          ii = new ImageIcon("Assets/Grass_Tile_Slope_Up.png");
          incUp = ii.getImage();

          ii = new ImageIcon("Assets/Grass_Tile_Slope_down.png");
          incDown =    ii.getImage()   ;


          ii = new ImageIcon("Assets/Grass_Tile_Flat.png");
          straightTop = ii.getImage()   ;


          ii = new ImageIcon("Assets/Grass_Tile_Slope_Connector_r.png");
          Grass_Tile_Slope_Connector_r = ii.getImage();

          ii = new ImageIcon("Assets/Grass_Tile_Slope_Connector_l.png");
          Grass_Tile_Slope_Connector_l = ii.getImage()  ;






          Graphics2D g2d = (Graphics2D) g   ;

          for (int i =1 ; i< myMap.length ; i++)
          {
              for (int j =0 ; j< myMap[0].length() ; j++)
              {
                  if(myMap[i].charAt(j) == '#')
                  {
                      if (myMap[i-1].charAt(j) == '1')
                      {
                          g2d.drawImage(Grass_Tile_Slope_Connector_l,j*50 , i*50 , null);
                      }

                      else if (myMap[i-1].charAt(j) == '2')
                      {
                          g2d.drawImage(Grass_Tile_Slope_Connector_r, j*50 , i*50 , null);
                      }
                     else if(myMap[i-1].charAt(j) == '0' || myMap[i-1].charAt(j) == 'T')
                      {
                          g2d.drawImage(straightTop,j*50,i*50 , null);

                      }
                      else
                          g2d.drawImage(straight,j*50,i*50 , null);
                  }


                  if(myMap[i].charAt(j) == '1')
                  {
                      g2d.drawImage(incUp,j*50,i*50 , null);
                  }
                  if(myMap[i].charAt(j) == '2')
                  {
                      g2d.drawImage(incDown,j*50,i*50 , null);
                  }

              }
          }


      }



    /* show the string in the file for debugging */
    public void showMapString()
    {
         for(int i =0 ; i<myMap.length ; i++)
         {
             System.out.println(myMap[i]);
         }




        System.out.println(tankX);
        System.out.println(tankY);
    }







}
