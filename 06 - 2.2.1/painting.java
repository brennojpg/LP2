import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class painting {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;
    Rect r4;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("colorindo retangulos :D");
        this.setSize(500, 500);
        this.r1 = new Rect(200,200, 100,30);
        this.r2 = new Rect(225,230, 50,100);
        this.r3 = new Rect(0,330, 500,60);
        this.r4 = new Rect(240,120, 20,80);
        this.getContentPane().setBackground(Color.gray);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint2(g);
        this.r3.paint3(g);
        this.r4.paint4(g);
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

    void print(){
        System.out.format("coordenada XY: (%d, %d), largura: (%d) e altura: (%d)!\n", 
        this.x, this.y, this.w, this.h);
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
            
        g.setColor(new Color(0,255,255));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.black);
        g2d.drawRect(this.x,this.y, this.w,this.h);    
    }

    void paint4 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(139,0,0));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.yellow);
        g2d.drawRect(this.x,this.y, this.w,this.h);    
    }


}

