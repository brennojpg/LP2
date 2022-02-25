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
    Rect r1, r2, r3, r4;

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
        this.r1.paint(g, Color.green, new Color(255,20,147));
        this.r2.paint(g, Color.white, new Color(75,0,130));
        this.r3.paint(g, Color.black, new Color(0,255,255));
        this.r4.paint(g, Color.yellow, new Color(139,0,0));
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
        System.out.format("coordenada XY: (%d, %d), largura: (%d) e altura: (%d)!\n", 
        this.x, this.y, this.w, this.h);
    }

    void paint (Graphics g, Color borda, Color dentro){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(dentro);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(borda);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    
    }  
}