package Main;
import Trees.AVL;
import java.util.Scanner;
import Node.Node;

public class Main{

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AVL tree = new AVL<>();
        int data;


        while(true){
            System.out.println("--------------------------------------MENU--------------------------------------");
            System.out.println("1. Insertar un dato");
            System.out.println("2. Borrar un dato");
            System.out.println("3. Mostrar todos los datos ordenados con su FE");
            System.out.println("Para salir presione cualquier tecla");
            String option = input.next();
            switch(option){
                case "1":
                    System.out.println("Ingresar valor que quieres insertar en el árbol");
                    data = input.nextInt();
                    tree.insert(data);
                    break;
                case "2":
                    System.out.println("Ingrese valor que desea borrar del árbol");
                    data = input.nextInt();
                    if (!tree.delete(data)) {
                        System.out.println("La lista esta vacia");
                    }
                    break;
                case "3":
                    System.out.println("Valores ordenados (inorden):");
                    tree.traversalAVL();
                    break;
                default:
                    return;
            } 
        }
    }
}
