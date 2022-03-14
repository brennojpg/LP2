import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;
import java.util.ArrayList;
import java.util.Random;
import figures.Polygon;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    int x, y, w, h, borda1, borda2, borda3, dentro1, dentro2, dentro3;


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
                        //limite das figuras na tela, no caso x e y.
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        //tamanho desejado, altura e largura.
                        int w = rand.nextInt(100);
                        int h = rand.nextInt(100);
                        //as cores desejadas no fundo.
                        int borda1 = rand.nextInt(255);
                        int borda2 = rand.nextInt(255);
                        int borda3 = rand.nextInt(255);
                        //as cores desejadas nas bordas.
                        int dentro1 = rand.nextInt(255);
                        int dentro2 = rand.nextInt(255);
                        int dentro3 = rand.nextInt(255);
                        //tamanho das bordas do triângulo

                        //adicionando ao apertar "R", Retângulos
                        if (evt.getKeyChar() == 'r') {
                            Rect r = new Rect(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3);
                            figs.add(r);
                        
                        //adicionando ao apertar "E", Elípses
                        } else if (evt.getKeyChar() == 'e') {
                            figs.add(new Ellipse(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3));

                        //adicionando ao apertar "P", Polígonos
                        } else if (evt.getKeyChar() == 'p') {
                            int[] Px = {
                                rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)};
                            
                            int[] Py = {
                                rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)};
                                figs.add(new Polygon(Px, Py, 4,borda1,borda2,borda3,dentro1,dentro2,dentro3));

                        }
                    repaint();
            }
        }
    );

        this.setTitle("Aperte R, E ou P: <3)");
        this.setSize(350, 350);
        this.getContentPane().setBackground(Color.black);
       
    }

        public void paint (Graphics g){
            super.paint(g);
            for (Figure fig: this.figs){
                fig.paint(g);
        }
    }
}