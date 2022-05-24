package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Line extends Figure {

    int num = -1;

    public Line (int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
       
        this.w = 50;
        this.h = 50;
    }
    private void print () {
        System.out.format("Tamanho da linha equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    public boolean clicked (int mx, int my) {
        return (this.x - 3 <= mx && mx<= this.x + this.w + 3 && this.y - 10 - 3<= my && my <= this.y + 10 +3);
    }

    public void resize(int dx, int dy, int tipo)
    {
        if(tipo == 4) //W
        {
            this.w += dx*2;
            this.x -= dx;

            if(this.w <= 10)
            {
                this.w -= dx*2;
                this.x += dx;
            }
        }
        else if(tipo == 3) // E
        {
            this.w -= dx*2;
            this.x += dx;

            if(this.w <= 10)
            {
                this.w += dx*2;
                this.x -= dx;
            }
        }
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawLine(this.x, this.y, this.x + this.w, this.y);

    }
}