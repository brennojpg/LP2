package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Ellipse extends Figure{

    public Ellipse (int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
        
        this.w = w;
        this.h = h;
    }

    private void print() {
        System.out.format("Tamanho das elipses equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    public boolean clicked (int mx, int my) {
        return (this.x <= mx && mx<= this.x + this.w  && this.y <= my && my <= this.y + this.h);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1,this.borda2,this.borda3));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
