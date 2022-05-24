package figures;

import java.awt.*;
import java.awt.Color;

public class Rect extends Figure {
    

    public Rect (int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
       
        this.w = w;
        this.h = h;
    }

    private void print () {
        System.out.format("Tamanho do retangulo equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this.w, this.h, this.x, this.y);
    }

    public boolean clicked(int clickX, int clickY) {
        return clickX >= this.x && clickX <= (this.x + this.w) &&
                clickY >= this.y && clickY <= (this.y + this.h);
    }

    public void resize(int dx, int dy, int tipo)
    {
        if(tipo == 5) //SE
        {
            this.w += dx*2;
            this.h += dx*2;
            this.x -= dx;
            this.y -= dx;

            if(this.w <= 10 || this.h <= 10)
            {
                this.w -= dx*2;
                this.x += dx;

                this.h -= dx*2;
                this.y += dx;
            }
        }
        else if(tipo == 4) //W
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
        else if(tipo == 2) //S
        {
            this.h += dy*2;
            this.y -= dy;

            if(this.h <= 10)
            {
                this.h -= dy*2;
                this.y += dy;
            }
        }
        else if(tipo == 1) //N
        {
            this.h -= dy*2;
            this.y += dy;

            if(this.h <= 10)
            {
                this.h += dy*2;
                this.y -= dy;
            }
        }
    }

    public void paint (Graphics g, boolean focused) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawRect(this.x, this.y, this.w, this.h);

        if(focused){
            g2d.setColor(Color.white);
            g2d.fillOval((x + w/2) - 3, y - 3, 6, 6);
            g2d.fillOval((x + w) - 3, y - 3, 6, 6);
            g2d.fillOval((x + w) - 3, (y + h/2) - 3, 6, 6);
            g2d.fillOval((x + w) - 3, (y + h) - 3, 6, 6);
            g2d.fillOval((x + w/2) - 3, (y+h) -3, 6, 6);
            g2d.fillOval(x - 3, (y+h) -3, 6, 6);
            g2d.fillOval(x - 3, (y + h/2) - 3, 6, 6);
            g2d.fillOval(x - 3, y - 3, 6, 6);
        }
    }

}