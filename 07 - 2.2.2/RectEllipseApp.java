import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;
    Rect r4;
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
    Ellipse e4;
    Ellipse e5;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
         this.setTitle("colorindo retangulos e elipses :D");
        this.setSize(500, 500);
        this.r1 = new Rect(200,200, 100,30);
        this.r2 = new Rect(225,230, 50,100);
        this.r3 = new Rect(240,120, 20,80);
        this.e1 = new Ellipse(0,330, 500,60);
        this.e2 = new Ellipse(225,230, 50,100);
        this.e3 = new Ellipse(0,330, 500,60);
        this.e4 = new Ellipse(240,120, 20,80);
        this.e5 = new Ellipse(225, 70, 50, 50);
        this.getContentPane().setBackground(Color.gray);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint2(g);
        this.r3.paint3(g);
        this.e1.paint4(g);
        this.e2.paint5(g);
        this.e3.paint6(g);
        this.e4.paint7(g);
        this.e5.paint8(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(255,20,147));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.green);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }  

    void paint2 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(75,0,130));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.white);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
           
    void paint3 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(139,0,0));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.yellow);
        g2d.drawRect(this.x,this.y, this.w,this.h);    
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void paint4 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(255,0,0));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.green);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }  

    void paint5 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(178,34,34));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.white);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
        
    void paint6 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(255,99,71));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.blue);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }

    void paint7 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(200,162,200));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.black);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }

    void paint8 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(220, 20, 60));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.pink);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }


}