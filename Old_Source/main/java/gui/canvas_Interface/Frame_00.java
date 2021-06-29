package gui.canvas_Interface;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class Frame_00 extends JFrame{

    Panel_00 panela;
    Panel_00 panelb;
    

    public Frame_00(){

        

        this.setTitle("vIndex   -   version 0.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panela = new Panel_00(500, 600));
        //this.add(panelb = new Panel_00(500, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
        
    }
    
    
}
