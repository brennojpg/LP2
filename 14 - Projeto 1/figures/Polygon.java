package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Polygon extends Figure {
    
    private int[] Px; 
    private int[] Py;

    public Polygon(int x, int y, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3, int dentro32) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
        this.Px = new int[] {x, x+40, x+40, x-40, x-40, x};
        this.Py = new int[] {y, y+30, y+60, y+60, y+30, y};
    }

    private void print(){
        System.out.format("Temos um poligono com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.Px[0], this.Px[1], this.Px[2], this.Py[0], this.Py[1], this.Py[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillPolygon(this.Px, this.Py, 5);
        g2d.setColor(new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawPolygon(this.Px, this.Py, 5);    

    }

    public boolean clicked (int mx, int my) {
        return ((this.Px[4] <= mx && mx<= this.Px[1]  && this.Py[0] <= my && my <= this.Py[3]));
    }

    public void drag(int dx, int dy){
        this.x += dx;
        this.y += dy;

        for(int i = 0; i < 6; i++){
            this.Px[i] += dx;
            this.Py[i] += dy;
        }       
    }

    public void resize(int rw, int rh) {
        if (this.w >= 20 && this.w <= 300){
            if(this.w == 300){
                rw = -6;
                rh = -6;
            }
            else if (this.w == 20 ){
                rw = +6;
                rh = +6;
            }
        }

        this.x += rw;
        this.y += rh;
    
        this.Px[1] += rw; this.Px[2] += rw; this.Px[3] -= rw; this.Px[4] -= rw; 

        this.Py[1] += rh/2; this.Py[2] += rh; 
        
        this.Py[3] += rh; this.Py[4] += rh/2; 
    }
}