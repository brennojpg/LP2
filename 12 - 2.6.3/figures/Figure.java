package figures;

import java.awt.Graphics;

public abstract class Figure {

    int borda1, borda2, borda3, dentro1, dentro2, dentro3;

    public Figure(int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3){
        
        this.borda1 = borda1;
        this.borda2 = borda2;
        this.borda3 = borda3;
        this.dentro1 = dentro1;
        this.dentro2 = dentro2;
        this.dentro3 = dentro3;
    }

    public abstract void paint (Graphics g);
}