import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.*;
import figures.Polygon;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1, r2, r3;
    Ellipse e1, e2;
    Polygon p1, p2, p3;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Pacotes em Java :D");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.r2 = new Rect(50,150, 30,100);
        this.r3 = new Rect(50,270, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
        this.e2 = new Ellipse(120,150, 30,100);
        this.p1 = new Polygon(new int[] {200, 250, 300}, new int[] {50, 100, 50}, 3);
        this.p2 = new Polygon(new int[] {200, 250, 300}, new int[] {100, 50, 100}, 3);
        this.p3 = new Polygon(new int[] {200, 250, 300}, new int[] {300, 120, 300}, 3);
        this.getContentPane().setBackground(Color.pink);

    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g, Color.green, new Color(255,20,147));
        this.e1.paint(g, Color.white, new Color(75,0,130));
        this.r2.paint(g, Color.yellow, new Color(139,0,0));
        this.e2.paint(g, new Color(255,0,0), new Color(144, 238, 144));
        this.r3.paint(g, new Color(200,162,200), new Color(0, 0, 0));
        this.p1.paint(g, Color.black, new Color(0,255,255));
        this.p2.paint(g, new Color(0, 0, 0), new Color(238, 173, 45));
        this.p3.paint(g, Color.cyan, Color.magenta);
    }
}