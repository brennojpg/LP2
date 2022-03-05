import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;
import java.util.ArrayList;
import java.util.Random;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> es = new ArrayList<Ellipse>();
    Random rand = new Random();
    Random rand2 = new Random();


    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener(
            new KeyAdapter(){
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        //limite das figuras na tela, no caso x e y.
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        //tamanho desejado, altura e largura.
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        //as cores desejadas no fundo.
                        int borda1 = rand.nextInt(255);
                        int borda2 = rand.nextInt(255);
                        int borda3 = rand.nextInt(255);
                        //as cores desejadas nas bordas.
                        int dentro1 = rand.nextInt(255);
                        int dentro2 = rand.nextInt(255);
                        int dentro3 = rand.nextInt(255);
                        
                        rs.add(new Rect(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3)); 
                        repaint();
                    }
               
                    if (evt.getKeyChar() == 'e'){
                         //limite das figuras na tela, no caso x e y.
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        //tamanho desejado, altura e largura.
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        //as cores desejadas no fundo.
                        int borda1 = rand.nextInt(255);
                        int borda2 = rand.nextInt(255);
                        int borda3 = rand.nextInt(255);
                        //as cores desejadas nas bordas.
                        int dentro1 = rand.nextInt(255);
                        int dentro2 = rand.nextInt(255);
                        int dentro3 = rand.nextInt(255);
                        
                        es.add(new Ellipse(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3));
                        repaint();                    
               
                }
            }
        }
    );

        this.setTitle("retanguloes e circulos aletaorios :)");
        this.setSize(350, 350);
        this.getContentPane().setBackground(Color.black);
        }

        public void paint (Graphics g){
            super.paint(g);
            for (Rect r: this.rs){
                r.paint(g);
            }

            for (Ellipse e: this.es){
                e.paint(g);
        }
    }
}