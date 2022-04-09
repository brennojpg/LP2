import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

import java.awt.event.MouseEvent;

import figures.*;
import java.util.ArrayList;
import java.util.Random;
import figures.Polygon;

class Projeto_1 {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
        frame.setFocusTraversalKeysEnabled(false);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    
    //posições do mouse e do foco dele
    Point PositionMouse = null;
    Figure foco = null;
    Point mouse = null;

    int i, x, y, w, h, borda1, borda2, borda3, dentro1, dentro2, dentro3;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

       this.addMouseListener(
           new MouseAdapter(){
               public void mousePressed(MouseEvent evt){
                   mouse = getMousePosition();
                   foco = null;

                   for (int i = 0; i < figs.size(); i++) {
                        if (figs.get(i).clicked(mouse.x,mouse.y)) {
                            foco = figs.get(i); 
                        }
                        else{
                            figs.get(i).bordinha((0),(0),(0)); 
                     }
                    }
            
                    if (foco != null) {
                        figs.remove(foco);
                        figs.add(foco);
                        foco.bordinha(255, 0, 132);
                    }
               repaint();
           }
        }
    );
       
       
        this.addKeyListener(
            new KeyAdapter(){
                public void keyPressed (KeyEvent evt) {
                    PositionMouse = getMousePosition();
                        int x = PositionMouse.x;
                        int y = PositionMouse.y;
                       
                        //tamanho desejado, altura e largura.
                        int w = 50;
                        int h = 50;
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
                         if (evt.getKeyChar() == 'r' || evt.getKeyCode() == 'R') {
                            Rect r = new Rect(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3);
                                figs.add(r);

                         //adicionando ao apertar "l", Linhas
                        } else if (evt.getKeyChar() == 'l' || evt.getKeyCode() == 'L') {
                                figs.add(new Line(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3));
                            
                        
                        //adicionando ao apertar "E", Elípses
                        } else if (evt.getKeyChar() == 'e' || evt.getKeyCode() == 'E') {
                                figs.add(new Ellipse(x,y,w,h,borda1,borda2,borda3,dentro1,dentro2,dentro3));

                        //adicionando ao apertar "P", Polígonos
                        } else if (evt.getKeyChar() == 'p' || evt.getKeyCode() == 'P') {
                                figs.add(new Polygon(x, y, 5,borda1,borda2,borda3,dentro1,dentro2,dentro3));

                        //adicionando ao apertar "P", Polígonos
                        } else if (evt.getKeyChar() == 't' || evt.getKeyCode() == 'T') {
                                figs.add(new Triangulo(x, y, 5,borda1,borda2,borda3,dentro1,dentro2,dentro3));
                        }
                        
                        if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){ 
                            figs.remove(foco);
                        }

                        if (evt.getKeyCode() == 'a' || evt.getKeyCode() == 'A'){
                            foco.drag(-6,0);
                        }
                        
                        if (evt.getKeyCode() == 'd' || evt.getKeyCode() == 'D'){
                            foco.drag(6,0);
                        }
                        
                        if (evt.getKeyCode() == 'w' || evt.getKeyCode() == 'W'){
                            foco.drag(0,-6);
                        }
                        
                        if (evt.getKeyCode() == 's' || evt.getKeyCode() == 'S'){
                            foco.drag(0,6);
                        }

                        if (evt.getKeyCode() == KeyEvent.VK_UP){
                            foco.resize(6, 6);
                        }

                        if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                            foco.resize(-6, -6);
                        }

                        if (evt.getKeyCode() == 'c' || evt.getKeyCode() == 'C'){ 
                            foco.colorismo(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                        }

                        if (evt.getKeyCode() == 'b' || evt.getKeyCode() == 'B'){ 
                            foco.bordinha(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                        }
                        if (evt.getKeyCode() == KeyEvent.VK_TAB){
                            if(foco != null){
                                if (figs.size() > 0){
                                    for(Figure fig: figs){
                                        if(fig == figs.get(i)){
                                            foco = figs.get(i);
                                            foco.bordinha(255, 0, 132);
                                        }
                                        else{
                                            fig.bordinha(0,0,0);
                                        }
                                    }
                                    
                                    figs.remove(foco);
                                    figs.add(foco);
                                    i++;
                               
                                    if (i >= figs.size()){
                                    i = 0;}
                                }
                        }      
                   }
                repaint();
            }
        }

    );

    this.addMouseMotionListener(
        new MouseAdapter(){
            public void mouseDragged (MouseEvent event){
                if (foco != null){

                    int mx = event.getX() - mouse.x;
                    int my = event.getY() - mouse.y;
                    foco.drag(mx, my);
                    repaint();
                }   mouse = ((MouseEvent)event).getPoint();
            }
        }
    );

        this.setTitle("Primeiro Projeto :D");
        this.setSize(450, 450);
        this.getContentPane().setBackground(Color.darkGray);
       
    }

        public void paint (Graphics g){
            super.paint(g);
            for (Figure fig: this.figs){
                fig.paint(g);
        }
    }
}