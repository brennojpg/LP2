package figures;

import java.awt.*;

public class Text extends Figure{
    
    private String txt;

        public Text (String txt, int x, int y, int w, int h, int borda1, int borda2, int borda3, int dentro1, int dentro2, int dentro3){
        super(x, y, borda1, borda2, borda3, dentro1, dentro2, dentro3);
        
        this.txt = txt;

    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setFont(new Font("Agency FB", 1, this.w/2));
        g2d.setColor(new Color(this.borda1,this.borda2,this.borda3));
        g2d.drawString(this.txt, this.x, this.y);
    }
    public boolean clicked (int mx, int my) {
        return (this.x <= mx && mx<= this.x + this.w  && this.y <= my && my <= this.y + this.h);
    }

    @Override
    public void resize(int x, int y, int tipo) {

    }
}
