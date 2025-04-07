//Amanda New
//CSD420-A311
//Module 4: Progamming Assignment
//LinkedList Test

package com.example;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListTest {
    //method to run tests
    public static void main(String[] args) {
        testListTest(50000);
        testListTest(500000);
    }

    public static void testListTest(int size) {
        //create LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i < size; i ++) {
            list.add(i);
        }
        //print testing size
        System.out.println("Testing with " + size + " integers:");

        //Iterator Tests:
        long startTimeIterator = System.nanoTime();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        long endTimeIterator = System.nanoTime();
        long durationIterator = endTimeIterator - startTimeIterator;
        System.out.println("  Iterator time: " + durationIterator + " nanoseconds");

        //get(index) Tests:
        long startTimeGet = System.nanoTime();
        for(int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endTimeGet = System.nanoTime();
        long durationGet = endTimeGet - startTimeGet;
        System.out.println("  get(index) time: " + durationGet + " nanoseconds");

        //print results
        System.out.println();
    }
}

//Results when I ran:
 //Testing with 50000 integers:
 //Iterator time: 2349800 nanoseconds
 //get(index) time: 742027000 nanoseconds
 
 //Testing with 500000 integers:
 //Iterator time: 6337400 nanoseconds
 //get(index) time: 215601946300 nanoseconds
 
 //For 50,000 integers:
 //When traversing using iterator, it finished a lot faster than get(index). However, with
 //this size of integers, it didn't make a large difference in terms of output, only a second or two.
 
 //For 500,000 integers:
 //When traversing using get(index), it took a noticeably longer time than using the iterator method.
 //The iterator time took only a second or so, while the get(index) time took almost 4 minutes,
 //to where I had to question if I was running it correctly. 

 //The reason get(index) takes longer is because it essentially traverses using a loop, since it accesses
 //each item by it's index, like a nested loop. The iterator method is moving linearly through the list, 
 //making the call time significantly shorter.
