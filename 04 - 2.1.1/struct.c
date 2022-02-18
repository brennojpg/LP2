#include <stdio.h>

typedef struct { 

    int a, b;
    int c, d;
    int e, f; 
} triangulinhos;

    void print (triangulinhos* vx){
    printf ("o triangulo esta localizado nas coordenadas: (%d,%d), (%d,%d), (%d,%d)\n", 
    vx -> a, vx -> b, vx -> c, vx -> d, vx -> e, vx -> f);
}

int main(void){

    triangulinhos vx1 = {250, 100, 295, 40, 340, 100}; 
    print(&vx1);
}