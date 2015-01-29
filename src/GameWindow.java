import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


class GameWindow extends JFrame
{
    private static final String game_map_image_path = "created_map.png";
    private static final int windows_width = 768;
    private static final int windows_height = 700;
    private static final int default_space = 10;
    private static final int player_space = 30;
    private static final int header_space = 150;
    private static final int info_space = 10;

    Image game_map_image;
    JLabel game_map;

    JLabel turn_label = new JLabel("Turn: Player 1");
    JLabel time_label = new JLabel("00:00.00");
    JLabel wind_label = new JLabel("Wind: 12 KM/H");

    JLabel health1_label = new JLabel("Player 1 Health: 200");
    JLabel health2_label = new JLabel("Player 2 Health: 200");

    JLabel force_label = new JLabel("  Force: ");
    JLabel degree_label = new JLabel("Degree:");

    JLabel deposit1_label = new JLabel("Player 1 Money: 1000");
    JLabel deposit2_label = new JLabel("Player 2 Money: 1000");

    JSlider force_slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
    JSlider degree_slider = new JSlider(JSlider.HORIZONTAL, 0, 180, 90);

    JComboBox bullet_list = new JComboBox(new String[] {"Type1", "Type2", "Type3"});

    JButton fire_button = new JButton("Fire!");
    JButton buy_type2_button = new JButton("Buy Type 2 Bullet");
    JButton buy_type3_button = new JButton("Buy Type 3 Bullet");

    JPanel header_panel = new JPanel();
    JPanel info_panel = new JPanel();
    JPanel game_map_panel = new JPanel();

    JPanel player_panel = new JPanel();
    JPanel player1_panel = new JPanel();
    JPanel player2_panel = new JPanel();

    JPanel force_panel = new JPanel();
    JPanel degree_panel = new JPanel();
    JPanel fire_panel = new JPanel();
    JPanel buy_panel = new JPanel();
    JPanel game_panel = new JPanel();

    GameWindow() throws IOException
    {
        super("Tank");

        //setting the buttons
        fire_button.setPreferredSize(new Dimension(150, 25));
        buy_type2_button.setPreferredSize(new Dimension(150, 25));
        buy_type3_button.setPreferredSize(new Dimension(150, 25));
        //end of setting the buttons

        //setting the sliders
        force_slider.setMajorTickSpacing(10);
        force_slider.setMinorTickSpacing(1);
        force_slider.setPaintTicks(true);
        force_slider.setPaintLabels(true);
        force_slider.setSnapToTicks(true);
        force_slider.setPreferredSize(new Dimension(300,50));

        degree_slider.setMajorTickSpacing(30);
        degree_slider.setMinorTickSpacing(1);
        degree_slider.setPaintTicks(true);
        degree_slider.setPaintLabels(true);
        degree_slider.setSnapToTicks(true);
        degree_slider.setPreferredSize(new Dimension(300,50));
        // end of setting the sliders

        //setting the bullet list
        bullet_list.setPreferredSize(new Dimension(150, 25));
        //end of detting the bullet list

        //setting lables allignment
        turn_label.setHorizontalAlignment(JLabel.CENTER);
        turn_label.setVerticalAlignment(JLabel.CENTER);

        time_label.setHorizontalAlignment(JLabel.CENTER);
        time_label.setVerticalAlignment(JLabel.CENTER);

        wind_label.setHorizontalAlignment(JLabel.CENTER);
        wind_label.setVerticalAlignment(JLabel.CENTER);

        deposit1_label.setHorizontalAlignment(JLabel.CENTER);
        deposit1_label.setVerticalAlignment(JLabel.CENTER);

        deposit2_label.setHorizontalAlignment(JLabel.CENTER);
        deposit2_label.setVerticalAlignment(JLabel.CENTER);

        health1_label.setHorizontalAlignment(JLabel.CENTER);
        health1_label.setVerticalAlignment(JLabel.CENTER);

        health2_label.setHorizontalAlignment(JLabel.CENTER);
        health2_label.setVerticalAlignment(JLabel.CENTER);

        force_label.setHorizontalAlignment(JLabel.CENTER);
        force_label.setVerticalAlignment(JLabel.CENTER);

        degree_label.setHorizontalAlignment(JLabel.CENTER);
        degree_label.setVerticalAlignment(JLabel.CENTER);
        //end of setting allignments


        //loading background image
        game_map_image = ImageIO.read(new File(game_map_image_path));
        game_map = new JLabel(new ImageIcon(game_map_image));
        //end of loading background image

        //constructing header panel
        GridLayout header_layout = new GridLayout(1,3);
        header_layout.setHgap(header_space);
        header_panel.setLayout(header_layout);
        header_panel.add(turn_label);
        header_panel.add(time_label);
        header_panel.add(wind_label);
        //end of constructing header panel

        //constructing info panel
        GridLayout info_layout = new GridLayout(1,4);
        info_layout.setHgap(info_space);
        info_panel.setLayout(info_layout);
        info_panel.add(health1_label);
        info_panel.add(deposit1_label);
        info_panel.add(deposit2_label);
        info_panel.add(health2_label);
        //end of constructing health panel

        //constructing map panel
        game_map_panel.setLayout(new FlowLayout());
        game_map_panel.add(game_map);
        //end of constructing map panel

        //constructing player1 panel
        player1_panel.setLayout(new BoxLayout(player1_panel, BoxLayout.Y_AXIS));
        player2_panel.setLayout(new BoxLayout(player2_panel, BoxLayout.Y_AXIS));

        //constructing force panel
        force_panel.setLayout(new FlowLayout());
        force_panel.add(force_label);
        force_panel.add(force_slider);
        player1_panel.add(force_panel);
        //end of constructing force panel

        //constructing degree panel
        degree_panel.setLayout(new FlowLayout());
        degree_panel.add(degree_label);
        degree_panel.add(degree_slider);
        player2_panel.add(degree_panel);
        //end of constructing degree panel

        //constructing fire panel
        fire_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        fire_panel.add(new JScrollPane(bullet_list));
        fire_panel.add(fire_button);
        player1_panel.add(fire_panel);
        //end of constructing fire panel

        //constructing buy panel
        buy_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        buy_panel.add(buy_type2_button);
        buy_panel.add(buy_type3_button);
        player2_panel.add(buy_panel);
        //end of constructing buy1 panel
        //end of constructing player1 panel

        //constructing player panel
        GridLayout player_layout = new GridLayout(1,2);
        player_layout.setHgap(player_space);
        player_panel.setLayout(player_layout);
        player_panel.add(player1_panel);
        player_panel.add(player2_panel);
        //end of constructing player panel

        //constructing game_panel
        game_panel.setLayout(new BoxLayout(game_panel, BoxLayout.Y_AXIS));
        game_panel.add(header_panel);
        game_panel.add(info_panel);
        game_panel.add(game_map_panel);
        game_panel.add(player_panel);
        add(game_panel);
        //end of constructing game_panel

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //setResizable(false);
    }
    /*
    public static void main(String[] args) throws IOException
    {
        Window test = new GameWindow();
        test.setSize(windows_width, windows_height);

        test.setVisible(true);
    }
    */

}