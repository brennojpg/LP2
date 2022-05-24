package figures;

import java.awt.*;

public class Triangulo extends Figure {
    int num = -1;

    private Polygon triangulo;

    private int[] pontosX = new int[] {0, 0, 0};
    private int[] pontosY = new int[] {0, 0, 0};

    public Triangulo(int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3, boolean chek) {
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);

        this.pontosX[0] = x;
        this.pontosY[0] = y+h;

        this.pontosX[1] = x+w/2;
        this.pontosY[1] = y;

        this.pontosX[2] = x + w;
        this.pontosY[2] = y + h;

        triangulo = new Polygon();

        triangulo.addPoint(pontosX[0], pontosY[0]);
        triangulo.addPoint(pontosX[1], pontosY[1]);
        triangulo.addPoint(pontosX[2], pontosY[2]);
    }

    private void print(){
        System.out.format("Temos um Triangulo com as coordenas em x: (%d,%d, %d), y: (%d,%d, %d), e na posição (%d, %d)!\n", 
        this.pontosX[0], this.pontosX[1], this.pontosX[2], this.pontosY[0], this.pontosY[1], this.pontosY[2]);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.dentro1,this.dentro2,this.dentro3));
        g2d.fillPolygon(triangulo);
        g2d.setColor(focused ? new Color(255, 0, 132) : new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawPolygon(triangulo);

        if(focused){
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
        triangulo.translate(mx, my);
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
        triangulo.reset();

        this.pontosX[0] = x;
        this.pontosY[0] = y+h;

        this.pontosX[1] = x+w/2;
        this.pontosY[1] = y;

        this.pontosX[2] = x + w;
        this.pontosY[2] = y + h;

        triangulo.addPoint(pontosX[0], pontosY[0]);
        triangulo.addPoint(pontosX[1], pontosY[1]);
        triangulo.addPoint(pontosX[2], pontosY[2]);
    }
}