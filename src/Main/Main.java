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
            int option = input.nextInt();
            switch(option){
                case 1:
                    System.out.println("Ingresar valor que quieres insertar en el árbol");
                    data = input.nextInt();
                    tree.insertAVL(data);
                    System.out.println("Valor insertado");
                    break;
                case 2:
                    System.out.println("Ingrese valor que desea borrar del árbol");
                    data = input.nextInt();
                    tree.delete(data);
                    System.out.println("Valor borrado");
                    break;
                case 3:
                    System.out.println("Valores ordenados:");
                    tree.traversal();
                    break;
            } 
        }
    }
}
