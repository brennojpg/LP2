package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Polygon extends Figure {
    
    private int[] Px; 
    private int[] Py;
    private boolean aux = false;

    public Polygon(int x, int y, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3, boolean chek) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
        
        
        if (chek){
        
            this.Px = new int[] {x, x+16, x+16, x-16, x-16, x};
            this.Py = new int[] {y, y+10, y+30, y+30, y+10, y};

        }

        else{

            this.Px = new int[] {x, x+40, x+40, x-40, x-40, x};
            this.Py = new int[] {y, y+30, y+60, y+60, y+30, y};

        }
    }

    private void print(){
        System.out.format("Temos um poligono com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.Px[0], this.Px[1], this.Px[2], this.Py[0], this.Py[1], this.Py[2]);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillPolygon(this.Px, this.Py, 5);
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawPolygon(this.Px, this.Py, 5);    
    }

    public boolean clicked (int mx, int my) {
        return ((this.Px[4] <= mx && mx<= this.Px[1]  && this.Py[0] <= my && my <= this.Py[3]));
    }

    public void drag(int mx, int my){

        if(x < 105 && y < 680){
            x = 106;
            
            this.Px = new int[] {x, x+40, x+40, x-40, x-40, x};
            this.Py = new int[] {y, y+30, y+60, y+60, y+30, y};
        }else{
            this.x += mx;
            this.y += my;
            for(int i = 0; i < 6; i++){
                this.Px[i] += mx;
                this.Py[i] += my;
            }       
        }

    }

    public void resize(int rw) {
       
         
        if(rw > 0){
            rw = 5;
        }
        else if(rw < 0){
            rw = - 5;
        }
        if(w >= 200 && rw >= 0){
            return;
        }
        else if(w <= 50 && rw <= 0){
            return;
        }
        else{
            w += rw;
            h += rw;

            this.Px[1] += rw; 
            this.Px[2] += rw; 
            this.Px[3] -= rw; 
            this.Px[4] -= rw; 
        
            this.Py[1] += rw/2; 
            this.Py[2] += rw; 
            this.Py[3] += rw; 
            this.Py[4] += rw/2; 
        }
        

    }
}