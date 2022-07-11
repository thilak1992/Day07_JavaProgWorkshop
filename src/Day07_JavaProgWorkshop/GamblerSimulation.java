package Day07_JavaProgWorkshop;

import  java.util.Scanner;

public class GamblerSimulation {
    public static int INITIAL_STAKE = 100;
    public static int BET_AMOUNT = 1;

    public static void main(String[] args) {
        gambler();
    }
    public static void gambler() {
        System.out.println("Welcome to gambler simulation");
        System.out.println("initial amount is " + INITIAL_STAKE + " Daily bet amount " + BET_AMOUNT);
        int allAmount = 100;
        int minStack = (allAmount * 50) / 100;
        int maxStack = allAmount + minStack;
        int winCount = 0;
        int lostCount = 0;
        int winAmount = 0;
        int lostAmount = 0;
        int winDay = 0;
        int lostDay = 0;
        int totalAmount = 0;
        for (int i = 1; i <= 31; i++) {
            totalAmount = INITIAL_STAKE;
            while (totalAmount < maxStack && totalAmount > minStack) {
                double randomNumber = Math.random();
                System.out.println(i + "Random number is :" + randomNumber);
                if (randomNumber > 0.5) {
                    System.out.println(i + " day gambler won the bet total amount is " + totalAmount);
                    totalAmount += BET_AMOUNT;
                } else {
                    System.out.println(i + " day gambler lose the bet total amount is " + totalAmount);
                    totalAmount -= BET_AMOUNT;
                }
            }
            System.out.println(i + " day Gambler resign the bet after that he has total amount " + totalAmount);
            if (totalAmount == maxStack) {
                System.out.println("total amount won at " + i + " is " + (totalAmount - INITIAL_STAKE));
                winAmount += (totalAmount - INITIAL_STAKE);
                winDay=i;
                winCount += 1;
            } else {
                System.out.println("total amount lost at " + i + " is " + (INITIAL_STAKE - totalAmount));
                lostAmount += (INITIAL_STAKE - totalAmount);
                lostDay=i;
                lostCount += 1;
            }
        }
        System.out.println("you win " + winCount + " days in a month and total win amount is " + winAmount);
        System.out.println("you lost " + lostCount + " days in a month and total lost amount is " + lostAmount);
        System.out.println("you lukiest day is " +winDay+" you win "+winAmount);
        System.out.println("your unlukiest day is "+lostDay+" you lost " +lostAmount);
        Scanner sc = new Scanner(System.in);
        System.out.println("to play again enter 1 otherwise any number to exit : ");
        int choice = sc.nextInt();
        if (choice==1){
            gambler();
        }
        else{
            System.out.println("you exit the game.");
        }
    }
}
