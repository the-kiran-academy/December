package com.jbk;
import java.util.Random;


public class A {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(99) + 10; // Generates a random number between 10 and 99 (inclusive)
        System.out.println("Random Number: " + randomNumber);
        
    }
}
