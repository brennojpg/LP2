package figures;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {

    int x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3;

    public Figure(int x, int y, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3){
        this.x = x;
        this.y = y;
        this.borda1 = borda1;
        this.borda2 = borda2;
        this.borda3 = borda3;
        this.dentro1 = dentro1;
        this.dentro2 = dentro2;
        this.dentro3 = dentro3;
    }

    public abstract void paint (Graphics g);

    public boolean clicked (int mx, int my) {
        return (this.x <= mx && mx<= this.x + 60 && this.y <= my && my <= this.y + 60);
    }
    
    public void bordinha(int a, int b, int c){
        this.borda1 = a;
        this.borda2 = b;
        this.borda3 = c;
    }

    public void drag(int mx, int my) {
        this.x += mx;
        this.y += my;
    }

}