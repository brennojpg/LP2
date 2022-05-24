package figures;
import java.awt.Graphics;
import java.io.Serializable;
import ivisible.Ivisible;
import java.awt.*;

public abstract class Figure implements Ivisible, Serializable {

    public int x, y, w = 50, h = 50, cont = 0;
    public int borda1, borda2, borda3, dentro1, dentro2, dentro3;
    public int[] Px = new int []{x};
    public int[] Py = new int []{y};
    int num= -1;
    boolean boo = false;

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

    //public abstract void paint (Graphics g, boolean focused);
    //public abstract boolean clicked (int mx, int my);


    public void bordinha(int a, int b, int c){
        this.borda1 = a;
        this.borda2 = b;
        this.borda3 = c;
    }

    public void colorismo(int a, int b, int c){
        this.dentro1 = a;
        this.dentro2 = b;
        this.dentro3 = c;
    }

    public void drag(int mx, int my) {
        if(x < 65){
            x = 66;
        }else{
            this.x += mx;
            this.y += my;
        }
    }

    public abstract void resize(int x, int y, int tipo);
}