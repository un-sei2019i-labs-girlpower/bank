#include <iostream>

using namespace std;

double sumar(double a, double b){

   return a+b;
}
double restar(double a, double b){
   return a-b;
}
double multiplicar(double a, double b){
   return 0;
}
double dividir(double a, double b){
   return 0;
}

int main()
{
    int opcion;
    double a , b, respuesta;
    bool flag;
    while (flag==true){
    cout << "Bienvenido a la calculadora, porfavor elija una opcion: " << endl;
    cout << "1. Sumar 2 numeros." << endl;
    cout << "2. Restar 2 numeros." << endl;
    cout << "3. Multiplicar 2 numeros." << endl;
    cout << "4. Dividir 2 numeros." << endl;
    cin>> opcion;
    switch(opcion){
        case 1: {
                cout << "ingrese el numero uno "<< endl;
                cin>>a;
                cout << "ingrese el numero dos "<<endl;
                cin>>b;
           respuesta=sumar(a, b);
            break;
        }
        case 2: {
                cout << "ingrese el numero uno "<< endl;
                cin>>a;
                cout << "ingrese el numero dos "<<endl;
                cin>>b;
            respuesta=restar(a, b);
            break;
        }
        case 3: {
            respuesta=multiplicar(a, b);
            break;
        }
        case 4: {
            respuesta=dividir(a, b);
            break;
        }
        default : {
            cout << "opcion no valida"<<endl;
            break;
        }
    }
    cout << "Su respuesta es: " <<respuesta<<endl;
    cout << "Si desea realizar otra operacion oprima 1, si desea salir oprima 0" << endl;
    cin>>flag;
    }
    return 0;
}
