package com.bham.pij.assignments.pontoon;

//class to run the game of Pontoon

import java.util.ArrayList;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
    	//main method setting up and running game
        Scanner scanner = new Scanner(System.in);
        Pontoon game = new Pontoon(2);

        game.dealInitialCards();

        Player humanPlayer = game.getPlayer(0);
        Player dealer = game.getPlayer(1);

        
        boolean playerTurn = true;
        
        //players turn
        while (playerTurn) {
            System.out.println("Your hand: " + formatHand(humanPlayer.getCards()) + " | Current Total: " + calculateTotal(humanPlayer));
            System.out.print("Hit (H) or Stand (S)? ");
            String action = scanner.nextLine();

            if ("H".equalsIgnoreCase(action)) {
                humanPlayer.dealToPlayer(game.getDeck().dealRandomCard());
                if (game.checkForBust(humanPlayer.getNumericalHandValue())) {
                    System.out.println("Bust! Your final hand: " + formatHand(humanPlayer.getCards()) + " | Final Total: " + calculateTotal(humanPlayer));
                    playerTurn = false;
                }
            } else if ("S".equalsIgnoreCase(action)) {
                playerTurn = false;
            }
        }

        //dealers turn if player hasnt busted
        boolean dealerTurn = !game.checkForBust(humanPlayer.getNumericalHandValue());
        while (dealerTurn) {
            if (calculateTotal(dealer) < 17) {
                System.out.println("Dealer hits.");
                dealer.dealToPlayer(game.getDeck().dealRandomCard());
            } else {
                System.out.println("Dealer stands.");
                dealerTurn = false;
            }
        }

        //compare hands
        if (!playerTurn && !dealerTurn) {
            int result = game.compareHands(humanPlayer, dealer);
            System.out.println("Dealer's final hand: " + formatHand(dealer.getCards()) + " | Dealer's Total: " + calculateTotal(dealer));
            // Outcome
            if (result == -1) {
                System.out.println("You win!");
            } else if (result == 1) {
                System.out.println("Dealer wins.");
            } else {
                System.out.println("It's a tie.");
            }
        }

        scanner.close();
    }

    private static String formatHand(ArrayList<Card> hand) {
        StringBuilder formattedHand = new StringBuilder();
        for (Card card : hand) {
            if (formattedHand.length() > 0) {
                formattedHand.append(", ");
            }
            formattedHand.append(card.getValue()).append(" of ").append(card.getSuit());
        }
        return formattedHand.toString();
    }

    //calculating total of hand to show the user
    private static int calculateTotal(Player player) {
        int total = 0;
        boolean hasAce = false;
        for (Card card : player.getCards()) {
            int cardValue = card.getNumericalValue().get(0);
            if (cardValue == 1) { 
                hasAce = true;
                cardValue = 11;
            }
            total += cardValue;
        }
        if (total > 21 && hasAce) {
            total -= 10; 
        }
        return total;
    }
}

