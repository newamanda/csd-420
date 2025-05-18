//Amanda New
//Module 5
//CSD420-A311
//Word Sorter

package com.example;

//imports
import java.io.*;
import java.util.*;

public class newWords {

    public static void main(String[] args) {

        //put textfile data in string
        String filename = "collection_of_words.txt";
        Set<String> words = readWords(filename);

        if (words.isEmpty()) {
            System.out.println("List is empty: ");
            return;
        }

        List<String> sortedWords = new ArrayList<>(words);

        //sort in ascending order
        Collections.sort(sortedWords);
        System.out.println("Ascending Order: ");
        for (String word : sortedWords) {
            System.out.println(word);
        
        }

        //sort in descending order
        Collections.sort(sortedWords, Collections.reverseOrder());
        System.out.println("\nDescending Order: ");
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }

    //scanner to read text file data 
    public static Set<String> readWords(String filename) {
        Set<String> words = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }

        //not found error
        catch (FileNotFoundException e) {
            System.out.println("Not Found " + filename);
        }

        return words;
    }

}