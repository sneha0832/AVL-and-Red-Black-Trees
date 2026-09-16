//Main Program 
//Sneha Patel
// 12 Nov 2024

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        BinaryTree BinaryTree = new BinaryTree();
        BinaryTree AVL = new AVL();
        BinaryTree REDBLACK = new RedBlack();
        try{
            String Filename = "SciFiLiSorted.txt";
            //read the file
            File file = new File(Filename);
            Scanner sc = new Scanner(file);
            //time to create the trees
            long screate1 = System.nanoTime();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                BinaryTree.insert(line);
            }
            long ecreate1 = System.nanoTime();
            long total1 = ecreate1 - screate1;
            System.out.println("Time taken to create Binary tree: " + total1 + " ns");

            File file2 = new File(Filename);
            Scanner sc2 = new Scanner(file2);
            long screate2 = System.nanoTime();
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                AVL.insert(line);
            }
            long ecreate2 = System.nanoTime();
            long total2 = ecreate2 - screate2;
            System.out.println("Time taken to create AVL tree: " + total2 + " ns");
          

            File file3 = new File(Filename);
            Scanner sc3 = new Scanner(file3);
            long screate3 = System.nanoTime();
            while (sc3.hasNextLine()) {
                String line = sc3.nextLine();
                REDBLACK.insert(line);
            }
            long ecreate3 = System.nanoTime();
            long total3 = ecreate3 - screate3;
            System.out.println("Time taken to create Red Black tree: " + total3 + " ns");

            sc.close();
            sc2.close();
            sc3.close();

        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return; // Exit the program if the file is not found
        }
        System.out.println();

        //time take for searching
        long ssearch1 = System.nanoTime();
        BinaryTree.search("ff");
        long esearch1 = System.nanoTime();
        long total4 = esearch1 - ssearch1;
        System.out.println("Time taken to search in binary tree: " + total4 + " ns");

        long ssearch2 = System.nanoTime();
        AVL.search("ff");
        long esearch2 = System.nanoTime();
        long total5 = esearch2 - ssearch2;
        System.out.println("Time taken to search in AVL tree: " + total5 + " ns");

        long ssearch3 = System.nanoTime();
        REDBLACK.search("ff");
        long esearch3 = System.nanoTime();
        long total6 = esearch3 - ssearch3;
        System.out.println("Time taken to search in Red Black tree: " + total6 + " ns");

        System.out.println();

        //time taken to remove
        long sremove1 = System.nanoTime();
        BinaryTree.remove("Chronicles Of Amber");
        long eremove1 = System.nanoTime();
        long total7 = eremove1 - sremove1;
        System.out.println("Time taken to remove in Binary tree: " + total7 + " ns");

        long sremove2 = System.nanoTime();
        AVL.remove("Chronicles Of Amber");
        long eremove2 = System.nanoTime();
        long total8 = eremove2 - sremove2;
        System.out.println("Time taken to remove in AVL tree: " + total8 + " ns");

        long sremove3 = System.nanoTime();
        REDBLACK.remove("Chronicles Of Amber");
        long eremove3 = System.nanoTime();
        long total9 = eremove3 - sremove3;
        System.out.println("Time taken to remove in Red Black tree: " + total9 + " ns");

    
    } 
}
/*
 * It was faster to create a Red Black tree then others. reason: fewer rotations due to less rebalancing
 * To search it was faster in AVL for sorted and it was faster in Red Black for unsorted. reason: reason for AVL beacuse of its strict balancing properties.
 * To remove Red Black tree was faster. reason: same reason as insertion, fewer rotations due to less rebalancing
 * Overall Red black tree was faster.  It really depends on what you what to do with the data if it's searching 
 *  it is better to use AVL and for insertion and deletion it is better to use Red Black tree.
 */