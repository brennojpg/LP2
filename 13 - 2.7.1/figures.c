#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y; 
    char txt[12];
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Tamanho do retangulo equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup -> print = (Figure_Print) rect_print;
    sup -> x = x;
    sup -> y = y;
    this -> w = w;
    this -> h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Tamanho da elipse equivale a: (%d, %d), e se encontra nas posicoes: (%d, %d).\n", this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup -> print = (Figure_Print) Ellipse_print;
    sup -> x = x;
    sup -> y = y;
    this -> w = w;
    this -> h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h; 

} Linha;

void line_print(Linha* this){
    Figure* sup = (Figure*) this;
    printf("A linha desenhada se encontra na posição: (%d,%d), com o tamanho (%d,%d).\n",  sup -> x, sup -> y, this -> w, this -> h);
}
Linha* line_new (int x, int y, int w, int h){
    Linha* this = malloc(sizeof(Linha));
    Figure* sup = (Figure*) this;
    sup -> print = (Figure_Print) line_print;
    sup -> x = x;
    sup -> y = y;
    this -> w = w;
    this -> h = h;

}
                                                                                            
////////////////////////////////////////////////////////////////////////////////


void main (void){
    
    Figure* figs[6] = {

        (Figure*) rect_new(13, 26, 350, 350),
        (Figure*) ellipse_new(60, 30, 200, 390),
        (Figure*) line_new(60, 80, 20, 40),
        (Figure*) rect_new(10, 10, 100, 100),
        (Figure*) ellipse_new(210, 110, 305, 130),
        (Figure*) line_new(100, 20, 50, 80),
    };

    for (int i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    for (int i=0; i<6; i++) {
        free(figs[i]);
     }
}
