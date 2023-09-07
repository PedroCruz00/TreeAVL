package presenter;

import model.TreeAVL;
import view.View;

import java.util.InputMismatchException;

public class Presenter {

    private static View view;
    private static TreeAVL tree;
    public Presenter() {
        view = new View();
        tree = new TreeAVL();
        menu();
    }

    public static void main(String[] args) {
       new Presenter();

    }
    private void menu() {
        int initValue = 0;
        boolean valorValido = false;

        while (!valorValido) {
            try {
                System.out.print("Ingrese el valor inicial del árbol: ");
                initValue = view.getConsole().nextInt();
                valorValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor ingresado no es un número válido. Intente de nuevo.");
                view.getConsole().next();
            }
        }
        tree.insert(initValue);

        int option= 0;
        while (option!=3) {
            try {
                view.showMessage("Seleccione una opción:\n ");
                view.showMessage("1. Insertar nodo: ");
                view.showMessage("2. Mostrar Arbol");
                view.showMessage("3. Salir");
                view.showMessage("Seleccione una opción: ");
                option = view.readInt();

            switch (option) {
                case 1:
                    try {
                        view.showMessage(" ingrese un valor: ");
                        int value = view.readInt();
                        tree.insert(value);
                    } catch (InputMismatchException e) {
                        view.showMessage("Error: El valor ingresado no es un número válido.");
                    }
                    break;
                case 2:
                    tree.showTree(tree.getRoot(), "", true);
                    break;
                case 3:
                    view.getConsole().close();
                    System.exit(0);
                    break;
                default:
                    view.showMessage("Haz ingresado una expresion incorrecta");
            }
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor ingresado no es una opción válida.");
                view.getConsole().next();
            }
        }
    }
}
