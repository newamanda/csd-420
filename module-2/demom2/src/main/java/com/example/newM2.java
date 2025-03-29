package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class newM2 {
    public static void main(String[] args) {
        //set file name
        String filename = "new_datafile.dat";

        //Get random integers and doubles
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        Random random = new Random();

        //Place random values into arrays
        for (int i = 0; i <5; i++) {
            intArray[i] = random.nextInt(100);
            doubleArray[i] = random.nextDouble() * 100;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            //write data to file
            writer.write("Integers:\n");
            for (int value : intArray) {
                writer.write(value + " ");
            }
            writer.newLine();

            writer.write("Doubles:\n");
            for (double value : doubleArray) {
                //write doubles with limit of 3 decimal places
                writer.write(String.format("%.3f", value) + " ");
            }
            writer.newLine();
            //print data writing confirmation
            System.out.println("Data written to " + filename);
        }
        //catch exception error
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}