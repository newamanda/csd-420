//Amanda New
//CSD-420
//Module 8
//Text Area

package com.example;

//imports
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

//Set text area and limit to 10,000 characters
public class AmandaThreeThreads extends JFrame {
    private JTextArea textArea;
    private static final int CHAR_COUNT = 10000;

    //set output display
    public AmandaThreeThreads() {
        setTitle("AmandaThreeThreads");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        setVisible(true);

        //run threads
        startThreads();
    }

    //establish threads
    private void startThreads() {
        Thread letters = new Thread(new randomLetters());
        Thread digits = new Thread(new randomDigits());
        Thread symbols = new Thread(new randomSymbols());

        letters.start();
        digits.start();
        symbols.start();
    }

    //append
    private void appendToTextArea(char c) {
        SwingUtilities.invokeLater(() -> textArea.append(Character.toString(c)));
    }

    //generate random letters
    private class randomLetters implements Runnable {
        public void run() {
            Random rr = new Random();
            for (int i = 0; i < CHAR_COUNT; i++) {
                char c = (char) ('a' + rr.nextInt(26));
                appendToTextArea(c);
            }
        }
    }
    //generate random digits
    private class randomDigits implements Runnable {
        public void run() {
            Random rr = new Random();
            for (int i=0; i < CHAR_COUNT; i++) {
                char c = (char) ('0' + rr.nextInt(10));
                appendToTextArea(c);
            }
        }
    }
    //generate random symbols
    private class randomSymbols implements Runnable {
        public void run() {
            char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
            Random rr = new Random();
            for (int i = 0; i < CHAR_COUNT; i++) {
                char c = symbols[rr.nextInt(symbols.length)];
                appendToTextArea(c);
            }
        }
    }

    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AmandaThreeThreads::new);
    }

}