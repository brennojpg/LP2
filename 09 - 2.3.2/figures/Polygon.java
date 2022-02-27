package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Polygon {
    private int[] x; 
    private int[] y;
    private int z; 
    private Color borda, dentro;

    public Polygon(int[] x, int[] y, int z, Color borda, Color dentro) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.borda = borda;
        this.dentro = dentro;       
    }

    private void print(){
        System.out.format("Temos um poligono com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.x[0], this.x[1], this.x[2], this.y[0], this.y[1], this.y[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(dentro);
        g2d.fillPolygon(this.x, this.y, this.z);
        g2d.setColor(borda);
        g2d.drawPolygon(this.x, this.y, this.z);    
    }
}