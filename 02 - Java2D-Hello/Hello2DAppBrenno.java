    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    
    public class Hello2DAppBrenno {
        public static void main (String[] args) {
            Hello2DFrame frame = new Hello2DFrame();
        }
    }
    
    class Hello2DFrame extends JFrame {
        public Hello2DFrame () {
            this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
            );
            this.setTitle("as 3 marias");
            this.setSize(350, 350);
            this.setVisible(true);
            this.getContentPane().setBackground(Color.black); //colocando o fundo escuro, pretendo ser a noite
        }
    
        public void paint (Graphics g) {
            super.paint(g);

            Graphics2D g2d = (Graphics2D) g;
           
            g2d.setPaint(Color.lightGray); //fazendo um cícrulo preenchido branco, pretendo ser a lua
            g2d.fillOval(5, 30, 100, 100);

            g2d.setPaint(Color.blue);
            g2d.fillRect(0, 270, 360, 360);//fazendo um retângulo, pretendendo ser um mar

            //triangulo 1, para a estrela 1
            g2d.setPaint(Color.yellow);
            int[] x = {130, 175, 220};
            int[] y = {160, 100, 160};
            g2d.fillPolygon(x, y, 3); 
            
            //triangulo 2, para a estrela 1
            int[] x1 = {130, 175, 220};
            int[] y1 = {120, 180, 120};
            g2d.fillPolygon(x1, y1, 3);

             //triangulo 3, para a estrela 2
            int[] x2 = {250, 295, 340};
            int[] y2 = {100, 40, 100};
            g2d.fillPolygon(x2, y2, 3);
           
            //triangulo 4, para a estrela 2
            int[] x3 = {250, 295, 340};
            int[] y3 = {60, 120, 60};
            g2d.fillPolygon(x3, y3, 3);

            //triangulo 5, para a estrela 3
            int[] x4 = {30, 75, 120};
            int[] y4 = {250, 190, 250};
            g2d.fillPolygon(x4, y4, 3);
            
            //triangulo 6, para a estrela 3
            int[] x5 = {30, 75, 120};
            int[] y5 = {210, 270, 210};
            g2d.fillPolygon(x5, y5, 3);

            g2d.drawOval(50, 50, width, height);
        }
    }