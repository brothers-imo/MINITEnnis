package com.company;
import java.awt.*   ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*        ;

/**
 * Created by khashayarbarooti on 25/01/15.
 */
 class KeyboardExample extends JPanel {




   /* public KeyboardExample() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener)    ;
        setFocusable(true);



    }
    */


    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        KeyboardExample keyboardExample = new KeyboardExample();
        frame.add(keyboardExample);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    class MyKeyListener implements KeyListener

    {
        @Override
        public void keyTyped (KeyEvent keyEvent){

    }

        @Override
        public void keyPressed (KeyEvent keyEvent){
            System.out.println("keyPressed="+KeyEvent.getKeyText(keyEvent.getKeyCode()));

    }

        @Override
        public void keyReleased (KeyEvent keyEvent){
            System.out.println("keyReleased="+KeyEvent.getKeyText(keyEvent.getKeyCode()));
    }
    }
}