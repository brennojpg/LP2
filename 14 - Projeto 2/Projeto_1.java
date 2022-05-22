import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

import java.lang.String;
import java.io.*;

import java.awt.event.MouseEvent;
import static java.awt.event.KeyEvent.*;

import figures.*;
import java.util.ArrayList;
import java.util.Random;
import figures.Polygon;
// import ivisible.IVisible;


class Projeto_1 {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
        frame.setFocusTraversalKeysEnabled(false);
    }
}


class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();

    Random rand = new Random();
    Rect aux = new Rect (0, 0, 10, 10, 64, 64, 64, 255, 0, 132);
    
    //posições do mouse e do foco dele
    Point PositionMouse = null;
    Figure foco = null;
    Point mouse = null;
    
    //add o foco e o clique para os botões
    Button focoBut = null;
    boolean clickedBut = false;
    boolean auxB = false;
    boolean verifica = false;

    int i, x, y, w, h, borda1, borda2, borda3, dentro1, dentro2, dentro3, posX = 0, posY = 0, indice, numBut = -1;
    boolean auxKey = false, auxKey2 = false, quadAux = true;
    Color butBack, butLine;

    ListFrame (){
    
    //adicionando os botões

    buts.add(new Button(1, new Ellipse(0,0, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(2, new Line(24,24, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(3, new Triangulo(40,142, 0,0, 0,0, 0,0, true)));
    buts.add(new Button(4, new Rect(0,0, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(5, new Polygon(40,225, 0,0, 0,0, 0,0, true)));

    buts.add(new Button(9, new Text("borda",0,0, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(10, new Text("fundo",0,0, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(11, new Text("background",0,0, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(12, new Text("delete",0,0, 0,0, 0,0,0, 0,0,0)));
    buts.add(new Button(13, new Text("save", 0,0, 0,0, 0,0,0, 0,0,0)));

    buts.add(new Button(15, new Text("exit",0,0, 0,0, 0,0,0, 0,0,0)));
   
    
    try {
        FileInputStream f = new FileInputStream("proj.bin");
        ObjectInputStream o = new ObjectInputStream(f);
        figs = (ArrayList<Figure>) o.readObject();
        o.close();
    } 
    
    catch (Exception x) {
        System.out.println("ERRO! em abrir o arquivo>");
    }
    
    this.addWindowListener (
        new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                
                try {
                    FileOutputStream f = new FileOutputStream("proj.bin");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(figs);
                    o.flush();
                    o.close();
                } 
                
                catch (Exception x) {
                    System.out.println("ERRO! <em abrir o arquivo>");
                }
                
                System.exit(0);

                }
            }
        );

       this.addMouseListener(
           new MouseAdapter(){
               public void mousePressed(MouseEvent evt){
                   quadAux = true;
                   foco = null;
                   mouse  = evt.getPoint();
                   auxKey = false;
                   verifica = false;

                     
                   if(auxB && focoBut != null){
                        if(!(mouse.x < 60 && mouse.y < 680)){
                            figureBut(focoBut.idx, mouse.x, mouse.y);
                            auxB = false;
                            focoBut = null;
                        }
                    }  

                
                   for (int i = 0; i < figs.size(); i++) {

                        if (figs.get(i).clicked(mouse.x,mouse.y)) {
                            verifica = true;
                            foco = figs.get(i); 
                        }
                        
                        else if(aux.clicked(mouse.x, mouse.y)){
                            foco = figs.get(i);  
                            auxKey = true;
                            
                        }
                        
                        else{
                            auxKey = false;
                            
                        }
                    }

                    if (foco != null) {
                        figs.remove(foco);
                        figs.add(foco);
                    }

                    for(Button but: buts){
                        if(but.clicked(mouse.x, mouse.y)){
                         focoBut = but;
                         auxB = true;
    
                         if(but.idx > 5 ){
                             figureBut(focoBut.idx, mouse.x, mouse.y);
                            }

                        if(numBut != but.idx){
                            auxKey2 = false;
                            indice = -1;
                        }
                        numBut = but.idx;
                        }
                    }
                    
                    
                    if(foco == null && auxKey2 || focoBut == null && foco == null){

                        focoBut = null;
                        auxKey2 = false;
                        indice = 0;
                    }
                    if(foco != null){

                        if(indice == 9){
                            foco.bordinha(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                            auxKey2 = true;
                            focoBut = buts.get(indice-4);
                        }
                        else if(indice == 10){
                            foco.colorismo(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                            auxKey2 = true;
                            focoBut = buts.get(indice-4);
                        }
                        else if(indice == 12){
                            figs.remove(foco);
                            auxKey2 = true;
                            quadAux =  false;
                            focoBut = buts.get(indice-4);
                        }

                    }
               repaint();
           }
        }
    );

     this.addMouseMotionListener(
        new MouseAdapter(){
            public void mouseDragged (MouseEvent event){
                
                if(auxKey){
                    foco.resize(event.getX() - mouse.x);
                }
                
                else{
                    if (foco != null){
                        
                        int mx = event.getX() - mouse.x;
                        int my = event.getY() - mouse.y;

                        foco.drag(mx, my);
                    }   
                }
                mouse = event.getPoint();
                repaint(); 
            }
        }
    );
       
       
        this.addKeyListener(
            new KeyAdapter(){
                public void keyPressed (KeyEvent evt) {
                    PositionMouse = getMousePosition();
                       
                        if (PositionMouse != null) {
                            x = PositionMouse.x;
                            y = PositionMouse.y;
                        }else{
                            x = rand.nextInt(350);
                            y = rand.nextInt(350);
                        }

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
                                figs.add(new Polygon(x, y, 5,borda1,borda2,borda3,dentro1,dentro2, false));

                        //adicionando ao apertar "P", Polígonos
                        } else if (evt.getKeyChar() == 't' || evt.getKeyCode() == 'T') {
                                figs.add(new Triangulo(x, y, 5,borda1,borda2,borda3,dentro1,dentro2, false));
                        }

                        if(evt.getKeyChar() == 'g' || evt.getKeyChar() == 'G'){
                            JFileChooser fileChooser = new JFileChooser();
                            fileChooser.setDialogTitle("Salvar no formato SVG. Qual o local gostaria de salvar e o nome do arquivo?");   
                            int userSelection = fileChooser.showSaveDialog(null);
                             if (userSelection == JFileChooser.APPROVE_OPTION){
                                File fileToSave = fileChooser.getSelectedFile();
                                criandoSVG(figs, fileToSave.getAbsolutePath());
                            }
                        }
                        
                        if(foco != null){
                            if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){ 
                                figs.remove(foco);
                                foco = null;
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
                                foco.resize(6);
                            }
    
                            if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                                foco.resize(-6);
                            }
    
                            if (evt.getKeyCode() == 'c' || evt.getKeyCode() == 'C'){ 
                                foco.colorismo(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                            }
                        
                            if (evt.getKeyCode() == 'b' || evt.getKeyCode() == 'B'){ 
                                foco.bordinha(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                            }
                        }
                        
                        if (evt.getKeyCode() == KeyEvent.VK_TAB){

                            if(figs.size() > 0){
                        
                                if(i > figs.size()-1){
                                    i = 0;
                                }
    
                                for(Figure fig: figs){
                                    if(fig == figs.get(i)){
                                        foco = figs.get(i);
                                    }
                                }
                                i++;
                            }

                        }
                        repaint();
                    }
                }

        );

        this.setTitle("Projeto final <3");
        this.setSize(700, 700);
        this.getContentPane().setBackground(Color.darkGray);
       
    }

    public void figureBut(int idx, int x, int y){
        if (idx == 1) {
            Figure fig = new Ellipse(x,y, 50, 50, borda1, borda2, borda3, dentro1, dentro2, dentro3);
                    figs.add(fig);
                    foco = fig;
                   }

        else if (idx == 2) {
            Figure fig = new Line(x,y, w, h, borda1, borda2, borda3, dentro1, dentro2, dentro3);
                    figs.add(fig);
                    foco = fig;
                    }

        else if (idx == 3) {
            Figure fig = new Triangulo(x,y, 5,borda1,borda2,borda3,dentro1,dentro2, false);
                    figs.add(fig);
                    foco = fig;
                    }

        else if (idx == 4) {
            Figure fig = new Rect(x,y, 50, 50, borda1, borda2, borda3, dentro1, dentro2, dentro3);
                    figs.add(fig);
                    foco = fig;
                }

        else if (idx == 5) {
            Figure fig = new Polygon(x,y, 5,borda1,borda2,borda3,dentro1,dentro2, false);
                    figs.add(fig);
                    foco = fig;
                }

        else if (idx == 9) {
            indice = idx;
                }
        else if (idx == 10) {
            indice = idx;
                }

        else if (idx == 11) {
            getContentPane().setBackground(JColorChooser.showDialog(null, "escolha a cor de fundo", Color.darkGray));
        }

        else if (idx == 12){
            indice = idx;
        }

        else if (idx == 13){
            if (i == JOptionPane.YES_OPTION) {
                
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("salvando no formato SVG.qual o local gostaria de salvar e o nome do arquivo?");   
                int userSelection = fileChooser.showSaveDialog(null);
                 if (userSelection == JFileChooser.APPROVE_OPTION){
                    File fileToSave = fileChooser.getSelectedFile();
                    criandoSVG(figs, fileToSave.getAbsolutePath());
            }

        }
    }


        else if (idx == 15) {
            int i = JOptionPane.showConfirmDialog(null, "deseja fechar o programa e nao salvar o processo?", "fechando...",
            JOptionPane.YES_NO_OPTION);
            
            if (i == JOptionPane.YES_OPTION) {
                System.exit(0);
                }
            else if(i == JOptionPane.NO_OPTION) {
                System.out.close();

            } 
        }
    }

       
     

        public void paint (Graphics g){
            super.paint(g);
            
            
            for (Figure fig: this.figs){
                fig.paint(g, fig == foco);
            }

            for (Button but: this.buts){
                but.paint(g, but == focoBut);
            }
            if(foco != null && quadAux){
                aux.x = foco.x + (foco.w + 10);
                aux.y = foco.y + (foco.h + 10);

                if(foco.getClass().getSimpleName().equals("Line")){
                    aux.x = foco.x + (foco.w + 10);
                    aux.y = foco.y - 5;
                }
                else if(foco.getClass().getSimpleName().equals("Triangulo")){
                    aux.x = foco.x + (foco.w - 15);
                    aux.y = foco.y + (foco.h - 5);    
                }
                aux.paint(g, true);
            }
        }
    
        public void criandoSVG(ArrayList<Figure> figura, String arquivo){
            String format = ".svg";
            try{
                  File Stream = new File(arquivo + format );
    
                  if (!Stream.createNewFile() ) {
                      System.out.println("Arquivo já existe\n");
                  }
    
                  FileWriter Writer = new FileWriter(arquivo+format);
                  Writer.write("<svg width=\"1500\" height=\"1000\">\n");
    
                  Writer.write(" <rect width=\"100%\" height=\"100%\" fill=\"white\" />\n");
    
                  for(Figure fig: figura){
                    String borda = String.format("borda(%d,%d,%d)", borda1,  borda2, borda3);
                    String dentro = String.format("borda(%d,%d,%d)", dentro1, dentro2, dentro3);
                    if(fig instanceof Rect){
                        Writer.write("<Rect x=\""+ fig.x +"\" y=\""+ fig.y +"\" width=\""+ fig.w +
                        "\" height=\"" + fig.h + "\" style=\"fill:"+ dentro +
                        ";stroke-width:3;stroke:"+ borda +"\" />\n");
                    }
                    else if( fig instanceof Line){
                        Writer.write("<Line x=\""+ fig.x +"\" y=\""+ fig.y +
                        "\" rx=\"10\" ry=\"10\" width=\""+ fig.w +
                        "\" height=\"" + fig.h + "\" style=\"fill:"+ borda2 +
                        ";stroke-width:3;stroke:"+ borda +"\" />\n");
                    }
                    else if( fig instanceof Ellipse){
                        Writer.write("<Ellipse cx=\""+ (fig.x + (fig.w*0.5)) +"\" cy=\""+ (fig.y + (fig.h*0.5))+ "\" rx=\""+ (fig.w*0.5) + "\"" +
                        " ry=\""+ (fig.h*0.5) + "\""+
                        " style=\"fill:"+ borda2 +
                        ";stroke-width:3;stroke:"+ borda +"\" />\n");
                    }
                    else if( fig instanceof Triangulo){
                        String points = String.format("%d,%d %d,%d %d,%d", fig.x, fig.y, fig.x-(int)(fig.w/2.0), fig.y+fig.w, fig.x+(int)(fig.w/2.0), fig.y+fig.w);
                        Writer.write("<polygon points=\""+ points +"\" "+ "style=\"fill:"+ dentro + ";stroke-width:3;stroke:"+ borda +"\" />\n");	
                    }
                }
                  Writer.write("</svg>");
                  Writer.close();
            }
            catch (IOException e){
                  System.out.println("Ocorreu um erro.");
                  e.printStackTrace();
            }
        }
        
}
