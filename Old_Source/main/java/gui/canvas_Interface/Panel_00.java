package gui.canvas_Interface;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Panel_00 extends JPanel implements ActionListener {

    // dimension variables
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private JButton userNLogin;
    private JButton passWLogin;

    // animation variables
    BufferedImage backgroundImage;
    private Timer timer;
    private int xVelocity = 1;
    private int yVelocity = 1;
    private int xPosition = 0;
    private int yPosition = 0;

    Panel_00(int width, int height) {

        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        // userNLogin.setText("username");
        // passWLogin.setText("password");

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.DARK_GRAY);
        // this.add(userNLogin);
        // this.add(passWLogin);
        timer = new Timer(1000, null);
        timer.start();

        try {
            backgroundImage = ImageIO.read(new File("images/BG_001.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void paint(Graphics g) {

        super.paint(g); // paints background
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage, xVelocity, yVelocity, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        xPosition+= xVelocity;
        repaint();
    }


    
}
