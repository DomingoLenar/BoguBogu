package Tree;
import java.lang.*;
import java.util.Scanner;

public class MyBinaryTree {
    TNode root;

    MyBinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRecursive(root, key);
    }

    TNode insertRecursive(TNode root, int key) {
        if (root == null) {
            root = new TNode(key, null, null);
            return root;
        }

        if (key < root.getKey()) {
            root.setLeft(insertRecursive(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(insertRecursive(root.getRight(), key));
        }

        return root;
    }

    TNode search(TNode root, int key) {
        if (root == null || root.getKey() == key) {
            return root;
        }

        System.out.print(" -> " + root.getKey()); // Display the current node while traversing

        if (key < root.getKey()) {
            return search(root.getLeft(), key);
        }

        return search(root.getRight(), key);
    }

    void inorderTraversal(TNode root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.print(" -> " + root.getKey()); // Display the current node while traversing
            inorderTraversal(root.getRight());
        }
    }
    void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBinary Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Exit");

            System.out.print("Enter choice (1-4): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int key = Integer.parseInt(scanner.nextLine());
                    insert(key);
                    System.out.println("Key " + key + " inserted into the tree.");
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    int searchKey = Integer.parseInt(scanner.nextLine());
                    TNode result = search(root, searchKey);
                    if (result != null) {
                        System.out.println(" Key " + searchKey + " found in the tree.");
                    } else {
                        System.out.println(" Key " + searchKey + " not found in the tree.");
                    }
                    break;
                case 3:
                    System.out.print("Inorder Traversal: ");
                    inorderTraversal(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }
        }
    }
}
