import ivisible.Ivisible;
import figures.Figure;
import java.awt.*;

public class Button implements Ivisible {
    static int SPC = 20;
    static int DIM = 40;
    static int PAD = 4;

    public  int    idx;
    private Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = PAD+SPC;
        this.fig.y = PAD+SPC + idx*DIM;
        this.fig.w = DIM-PAD*2;
        this.fig.h = DIM-PAD*2;
    }

    public boolean clicked (int x, int y) {
        return SPC<=x && x<=SPC+DIM && SPC+this.idx*DIM<=y && y<=SPC+this.idx*DIM+DIM;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(focused ? Color.magenta : Color.white);
        g2d.fillRect(SPC, SPC+this.idx*DIM, DIM, DIM);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(SPC, SPC+this.idx*DIM, DIM, DIM);
        
        switch(idx) {
            
            case 2:
            this.fig.y = PAD+SPC + idx*DIM + 15;
            break;

            case 3:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            
            break;

            case 5:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            break;

            case 9:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            this.fig.x = PAD+SPC + 2;
            break;
            
            case 10:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            this.fig.x = PAD+SPC + 3;
            break;

            case 11:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            this.fig.x = PAD+SPC - 2;
            this.fig.w = DIM-PAD*2 - 12;
            break;

            case 12:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            this.fig.x = PAD+SPC + 2;
            break;

            case 13:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            this.fig.x = PAD+SPC + 2;
            break;

            case 15:
            this.fig.y = PAD+SPC + idx*DIM + 20;
            this.fig.x = PAD+SPC + 6;
            break;
        }
       
        this.fig.paint(g, false);
    }
}