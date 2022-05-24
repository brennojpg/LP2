package figures;

import java.awt.*;

public class Poly extends Figure {
    
    private int[] Px = new int[]{0, 0, 0, 0, 0, 0};
    private int[] Py = new int[]{0, 0, 0, 0, 0, 0};
    // private boolean aux = false;
    int num  = -1;

    private Polygon poly;
    public Poly(int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3, boolean chek) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);

        this.Px[0] = x + w/2;
        this.Py[0] = y;

        this.Px[1] = x+w;
        this.Py[1] = y+h/2;

        this.Px[2] = x + w;
        this.Py[2] = y+h;

        this.Px[3] = x;
        this.Py[3] = y+h;

        this.Px[4] = x;
        this.Py[4] = y + h/2;

        poly = new Polygon();

        poly.addPoint(Px[0], Py[0]);
        poly.addPoint(Px[1], Py[1]);
        poly.addPoint(Px[2], Py[2]);
        poly.addPoint(Px[3], Py[3]);
        poly.addPoint(Px[4], Py[4]);
    }

    private void print(){
        System.out.format("Temos um poligono com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.Px[0], this.Px[1], this.Px[2], this.Py[0], this.Py[1], this.Py[2]);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1, this.dentro2, this.dentro3));
        g2d.fillPolygon(poly);
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1, this.borda2, this.borda3));
        g2d.drawPolygon(poly);

        if (focused) {
            g2d.setColor(Color.white);
            g2d.drawRect(x, y, w, h);
        }
    }


    public boolean clicked(int clickX, int clickY) {
        return clickX >= this.x && clickX <= (this.x + this.w) &&
                clickY >= this.y && clickY <= (this.y + this.h);
    }

    public void drag(int mx, int my) {
        this.x += mx;
        this.y += my;
        poly.translate(mx, my);
    }

    public void resize(int dx, int dy, int tipo){
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
        poly.reset();

        this.Px[0] = x + w/2;
        this.Py[0] = y;

        this.Px[1] = x+w;
        this.Py[1] = y+h/2;

        this.Px[2] = x + w;
        this.Py[2] = y+h;

        this.Px[3] = x;
        this.Py[3] = y+h;

        this.Px[4] = x;
        this.Py[4] = y + h/2;

        poly.addPoint(Px[0], Py[0]);
        poly.addPoint(Px[1], Py[1]);
        poly.addPoint(Px[2], Py[2]);
        poly.addPoint(Px[3], Py[3]);
        poly.addPoint(Px[4], Py[4]);
    }
}