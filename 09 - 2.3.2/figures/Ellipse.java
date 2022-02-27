package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Color;

public class Ellipse {
    private int x, y, w, h;
    private Color borda, dentro;

    public Ellipse (int x, int y, int w, int h, Color borda, Color dentro) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.borda = borda;
        this.dentro = dentro;
    }

    private void print() {
        System.out.format("Tamanho das elipses equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(dentro);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setColor(borda);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}
