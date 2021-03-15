
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Arboles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario bt = new ArbolBinario();

        int opcion = 0, elemento;
        do {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1-Ver Tamano del nodo\n"
                        + "2-Agregar Nodo\n"
                        + "3-Ver Nodo InOrder\n"
                        + "4-Salir\n"), JOptionPane.QUESTION_MESSAGE);
                switch (opcion) {
                     case 1:
                         if(bt.vacio()==true){
                             JOptionPane.showMessageDialog(null, "El Arbol esta vacio");
                         }else{
                        bt.mostrarInOrden(bt.raiz);
                        
                         }
                         break;
                    case 2:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el Numero para el nodo",
                                "Agregando nodo", JOptionPane.QUESTION_MESSAGE));
                        bt.agregar(elemento);
                        break;
                    case 3:
                       
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } while (opcion != 10);

    }

}

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {

        raiz = null;
    }

    public void agregar(int numero) {

        Nodo nuevo = new Nodo(numero);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo auxiliar = raiz;
            Nodo padre;
            while (true) {
                padre = auxiliar;
                if (numero < auxiliar.value) {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean vacio() {
        return raiz == null;
    }

    public void mostrarInOrden(Nodo r) {
        if (r != null) {
            mostrarInOrden(r.izq);
            System.out.println(r.value);
            mostrarInOrden(r.der);
        }
    }
}

class Nodo {
    //NO MODIFICAR

    int value;
    Nodo izq;
    Nodo der;

    public Nodo(int value, Nodo izq, Nodo der) {
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    public Nodo(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {

        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

}
