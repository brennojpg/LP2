import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class hm {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Elipse e1;
    Elipse e2;
    Elipse e3;
    Elipse e4;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("colorindo elipses :)");
        this.setSize(500, 500);
        this.e1 = new Elipse(200,200, 100,30);
        this.e2 = new Elipse(225,230, 50,100);
        this.e3 = new Elipse(0,330, 500,60);
        this.e4 = new Elipse(240,120, 20,80);
        this.getContentPane().setBackground(Color.black);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint2(g);
        this.e3.paint3(g);
        this.e4.paint4(g);
    }
}

class Elipse {
    int x, y;
    int w, h;

    Elipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print(){
        System.out.format("coordenada XY: (%d, %d), largura: (%d) e altura: (%d)!\n", 
        this.x, this.y, this.w, this.h);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(255,0,0));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.green);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }  

    void paint2 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(178,34,34));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.white);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
        
    void paint3 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(255,99,71));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.blue);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }

    void paint4 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(139,0,0));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.yellow);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }
}