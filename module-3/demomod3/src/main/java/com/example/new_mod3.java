//Amanda New
//CSD420-A311
//Module 3 Programming Assignment
//ArrayList; Remove Duplicates from new List

package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class new_mod3 {
    public static void main(String[] args) {
        //create ArrayList
        ArrayList<Integer> originalList = new ArrayList<>();
        //insert random values into ArrayList
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        //print random integers list
        System.out.println("Random Integers: " + originalList);

        //remove duplicates
        ArrayList<Integer> noDupeList = noDuplicates(originalList);

        //print list with no duplicates
        System.out.println("No Duplicates List: " + noDupeList);
    }

    //method for removing duplicates
    public static <E> ArrayList<E> noDuplicates(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        //removing duplicates
        Set<E> set = new HashSet<>(list);
        return  new ArrayList<>(set);
    }
}