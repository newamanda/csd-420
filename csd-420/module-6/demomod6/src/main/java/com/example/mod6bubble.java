//Amanda New 
//Module 6
//CSD420-A311

package com.example;

//import util Comparator and Arrays (Arrays to String for printing)
import java.util.Comparator;
import java.util.Arrays;

public class mod6bubble {
    //Comparable bubble sort
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i=0; i < list.length - i - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i -1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; //stop once sorted
        }
    }
    //Comparator bubble sort 
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i=0; i < list.length - 1; i++) {
            swapped = false;
            for (int j=0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
    //Test with integers and character strings
    public static void main(String[] args) {
        //create and print integers list before sort
        Integer [] sort1 = {6, 13, 8, 16, 29, 30, 19, 14, 3};
        System.out.println("Numbers before sorting: " + Arrays.toString(sort1));
        //sort integers comparable
        bubbleSort(sort1);
        //print after sorting
        System.out.println("Numbers after sorting (Comparable): " + Arrays.toString(sort1));

        //create and print character list before sort
        String[] sort2 = {"Baines", "Brown", "McFly", "Parker", "Tennen"};
        System.out.println("Characters before sorting: " + Arrays.toString(sort2));
        //sort characters with comparator reverse order
        bubbleSort(sort2, Comparator.reverseOrder());
        //print sorted list
        System.out.println("Characters after sorting (Comparator - Reverse): " + Arrays.toString(sort2));

    }
}
