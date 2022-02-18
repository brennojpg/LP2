public class area {
    public static void main (String[] args) {
        rect r1 = new rect(1,1,10,10);
        r1.drag(30, 30);
        r1.print();
    
    }
} 

class rect {
    int x, y;
    int w, h;
    rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    
int area(){
    return (this.w * this.h);
    }

void drag (int dx, int dy){

    this.x = dx+x;
    this.y = dy+y;
    }


    void print (){
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d, %d).\n\n", this.w, this.h, this.x, this.y);

        System.out.format("A area do retangulo eh equivalente a: (%d).\n\n", this.w * this.h);

        System.out.format("Houve um deslocamento do retangulo para (%d, %d)\n", this.x, this.y);
    }
}