import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args){
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}
class RectEllipseFrame extends JFrame {
    Rect r1, r2, r3, r4;
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
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
        this.e1 = new Ellipse(225, 70, 50, 50);
        this.e2 = new Ellipse(260, 180, 20, 20);
        this.e3 = new Ellipse(124, 230, 100, 100);
        this.getContentPane().setBackground(Color.gray);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g, Color.green, new Color(255,20,147));
        this.r2.paint(g, Color.white, new Color(75,0,130));
        this.r3.paint(g, Color.black, new Color(0,255,255));
        this.r4.paint(g, Color.yellow, new Color(139,0,0));
        this.e1.paint(g, new Color(255,0,0), new Color(144, 238, 144));
        this.e2.paint(g, new Color(200,162,200), new Color(0, 0, 0));
        this.e3.paint(g, new Color(0, 0, 0), new Color(238, 173, 45));
    }
}

class Rect {
    int x, y, w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print(){
        System.out.format("Tamanho do retangulo equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g, Color borda, Color dentro) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(dentro);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(borda);
        g2d.drawRect(this.x, this.y, this.w, this.h);
        
    }
}
class Ellipse {
    int x, y, w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
}

    void print(){
        System.out.format("Tamanho das elipses equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g, Color borda, Color dentro) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(dentro);
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(borda);
        g2d.drawOval(this.x, this.y, this.w, this.h);
    }

}