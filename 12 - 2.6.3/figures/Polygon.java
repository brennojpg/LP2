package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Polygon extends Figure {
    private int[] Px; 
    private int[] Py;
    private int z;

    public Polygon(int[] x, int[] y, int z, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3) {
        super(borda1, borda2, borda3, dentro1, dentro2, dentro3);
        this.Px = x;
        this.Py = y;
        this.z = z;
    }

    private void print(){
        System.out.format("Temos um poligono com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.Px[0], this.Px[1], this.Px[2], this.Py[0], this.Py[1], this.Py[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillPolygon(this.Px, this.Py, this.z);
        g2d.setColor(new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawPolygon(this.Px, this.Py, this.z);    
    }
}