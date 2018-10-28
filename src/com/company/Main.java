package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayDeque<Integer> gamer1 = new ArrayDeque<>();
        ArrayDeque<Integer> gamer2 = new ArrayDeque<>();
        Scanner myScanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            gamer1.addLast(myScanner.nextInt());
            gamer2.addLast(myScanner.nextInt());
        }

        int count = 0;
        boolean result = false;

        while (count < 106 ) {

            count++;

            System.out.println(Arrays.toString(gamer1.toArray()));
            System.out.println(Arrays.toString(gamer2.toArray()));
            System.out.println();

            if (gamer1.getLast() == 0 && gamer2.getLast() == 9){

                gamer1.push(gamer1.pollLast());
                gamer1.push(gamer2.pollLast());
            }

            else if (gamer2.getLast() == 0 && gamer1.getLast() == 9){
                gamer2.push(gamer2.pollLast());
                gamer2.push(gamer1.pollLast());
            }

            else if (gamer1.getLast() > gamer2.getLast()){

                gamer1.push(gamer1.pollLast());
                gamer1.push(gamer2.pollLast());
            }

            else if (gamer2.getLast() > gamer1.getLast()){

                gamer2.push(gamer2.pollLast());
                gamer2.push(gamer1.pollLast());
            }


            if (gamer1.isEmpty()){
                System.out.println("Second " + count);
                result = true;
                break;
            }

            else if (gamer2.isEmpty()){
                System.out.println("First " + count);
                result = true;
                break;
            }
        }

        if (!result)
            System.out.println("botva");
    }
}
