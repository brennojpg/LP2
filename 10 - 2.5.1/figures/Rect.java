package figures;

import java.awt.*;
import java.awt.Color;

public class Rect {
    private int x, y, w, h, borda1, borda2, borda3, dentro1, dentro2, dentro3;

    //mudando as formas de coloração para int, para poder ser manipulável depois, no caso para as bordas e o fundo.

    public Rect (int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.borda1 = borda1;
        this.borda2 = borda2;
        this.borda3 = borda3;
        this.dentro1 = dentro1;
        this.dentro2 = dentro2;
        this.dentro3 = dentro3;
    }

    private void print () {
        System.out.format("Tamanho do retangulo equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}