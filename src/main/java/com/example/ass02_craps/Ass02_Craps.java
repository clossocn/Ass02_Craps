package com.example.ass02_craps;
import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            while (true) {
                int point = 0;
                int sum = rollDice(random);
                System.out.println("Initial roll: " + sum);

                if (sum == 2 || sum == 3 || sum == 12) {
                    System.out.println("Craps! You lose.");
                } else if (sum == 7 || sum == 11) {
                    System.out.println("Natural! You win.");
                } else {
                    point = sum;
                    System.out.println("Point is set to " + point);
                    while (true) {
                        int nextRoll = rollDice(random);
                        System.out.println("Next roll: " + nextRoll);

                        if (nextRoll == point) {
                            System.out.println("Made point and won!");
                            break;
                        } else if (nextRoll == 7) {
                            System.out.println("Got a seven and lost.");
                            break;
                        }
                    }
                }

                System.out.print("Play again? (yes/no): ");
                String playAgain = scanner.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        private static int rollDice(Random random) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            return die1 + die2;
        }
}
