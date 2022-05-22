package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Triangulo extends Figure {
   
    private int[] Px; 
    private int[] Py;

    public Triangulo(int x, int y, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3, boolean chek) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
        
        if (chek){

            this.Px = new int[] {x, x+17, x-17};
            this.Py = new int[] {y, y+35, y+35};
        }

        else{
            this.Px = new int[] {x, x+20, x-20};
            this.Py = new int[] {y, y+40, y+40};
        }
    }

    private void print(){
        System.out.format("Temos um Triangulo com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.Px[0], this.Px[1], this.Px[2], this.Py[0], this.Py[1], this.Py[2]);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillPolygon(this.Px, this.Py, 3);
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawPolygon(this.Px, this.Py, 3);    

    }

    public boolean clicked (int mx, int my) {
        return (this.Px[2] <= mx && mx<= this.Px[1]  && this.Py[0] <= my && this.Py[2] >= my);
    }

    public void drag(int mx, int my){

        if(x < 85 && y < 680){
            x = 86;
            
            this.Px = new int[] {x, x+20, x-20};
            this.Py = new int[] {y, y+40, y+40};
        }else{
            this.x += mx;
            this.y += my;
            for(int i = 0; i < 3; i++){
                this.Px[i] += mx;
                this.Py[i] += my;
            }       
        }
    }

    public void resize(int rw) {
        if (this.w >= 20 && this.w <= 300){
            if(this.w == 300){
                rw = -6;
            }
            else if (this.w == 20 ){
                rw = +6;
            }
        }
         
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
            this.Px[2] += -rw; 
            
            this.Py[1] += rw; 
            this.Py[2] += rw; 
        }
        
    }
}