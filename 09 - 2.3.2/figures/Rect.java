package figures;

import java.awt.*;
import java.awt.Color;

public class Rect {
    private int x, y, w, h;

    public Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    private void print () {
        System.out.format("Tamanho do retangulo equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, Color borda, Color dentro) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(dentro);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(borda);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}