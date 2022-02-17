class oval{
    int x, y, w, h;
    
    oval(int x, int y, int w, int h){
       
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    void print(){
        System.out.format("coordenada XY: (%d, %d), largura: (%d) e altura: (%d)!", 
        this.x, this.y, this.w, this.h);
    }
}
public class metodo{
    public static void main (String[] args){
        oval o1 = new oval(50, 50, 50, 50);
        o1.print();
    }
}