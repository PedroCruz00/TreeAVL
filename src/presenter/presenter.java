package presenter;

import model.TreeAVL;

public class presenter {
    public static void main(String[] args) {
        TreeAVL tree = new TreeAVL();

        tree.insert(100);
        tree.insert(29);
        tree.insert(71);
        tree.insert(82);
        tree.insert(48);
        tree.insert(39);
        tree.insert(101);
        tree.insert(22);


//        System.out.println("Árbol AVL antes de la inserción:");
//        tree.showInOrder(tree.getRoot());
        tree.showTree(tree.getRoot(), "", true);

//        tree.insert(5);
//
//        System.out.println("\nÁrbol AVL después de la inserción:");
//        tree.showInOrder(tree.getRoot());
    }
}
