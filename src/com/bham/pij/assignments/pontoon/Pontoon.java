package com.bham.pij.assignments.pontoon;
//Implementing abstract methods from parent

import java.util.ArrayList;

import com.bham.pij.assignments.pontoon.Card.Value;

public class Pontoon extends CardGame{

	public Pontoon(int players) {
		super(players);
	}

	//dealing intial cards
	public void dealInitialCards() {
		Card oneCard = deck.dealRandomCard();
		Card oneCardTwo = deck.dealRandomCard();
		Card twoCard = deck.dealRandomCard();
		Card twoCardTwo = deck.dealRandomCard();
		playOne.dealToPlayer(oneCard);
		playOne.dealToPlayer(oneCardTwo);
		playTwo.dealToPlayer(twoCard);
		playTwo.dealToPlayer(twoCardTwo);
	}

	//comparing hands
	public int compareHands(Player hand1, Player hand2) {
	    ArrayList<Integer> numValue1 = hand1.getNumericalHandValue();
	    ArrayList<Integer> numValue2 = hand2.getNumericalHandValue();

	    boolean hand1Bust = checkForBust(numValue1);
	    boolean hand2Bust = checkForBust(numValue2);

	    // Both hands bust
	    if (hand1Bust && hand2Bust) return 0;
	    // Only Hand 1 busts
	    if (hand1Bust) return 1;
	    // Only Hand 2 busts
	    if (hand2Bust) return -1;

	    // Check for Pontoon (Ace + 10-value card)
	    boolean hand1Pontoon = isPontoon(hand1.getCards());
	    boolean hand2Pontoon = isPontoon(hand2.getCards());

	    if (hand1Pontoon && !hand2Pontoon) return -1;
	    if (hand2Pontoon && !hand1Pontoon) return 1;
	    if (hand1Pontoon) return 0; // Both have Pontoon, it's a tie

	    // Check for a Five-Card Trick
	    boolean hand1FiveCardTrick = isFiveCardTrick(numValue1) && !hand1Bust;
	    boolean hand2FiveCardTrick = isFiveCardTrick(numValue2) && !hand2Bust;

	    if (hand1FiveCardTrick && !hand2FiveCardTrick) return -1;
	    if (hand2FiveCardTrick && !hand1FiveCardTrick) return 1;
	    if (hand1FiveCardTrick) return 0; // Both have Five-Card Trick, it's a tie

	    // General hand comparison
	    int hand1Closest = closestToTwentyOne(numValue1);
	    int hand2Closest = closestToTwentyOne(numValue2);

	    if (hand1Closest > hand2Closest) return -1;
	    if (hand1Closest < hand2Closest) return 1;
	    return 0; // Equal values
	}


	private boolean isPontoon(ArrayList<Card> hand) {
	    if (hand.size() != 2) return false;
	    Card card1 = hand.get(0);
	    Card card2 = hand.get(1);
	    return (card1.getValue() == Card.Value.ACE && card2.getValue().ordinal() >= Card.Value.TEN.ordinal()) ||
	           (card2.getValue() == Card.Value.ACE && card1.getValue().ordinal() >= Card.Value.TEN.ordinal());
	}

	private boolean isFiveCardTrick(ArrayList<Integer> values) {
	    // Assuming you have logic to determine this based on hand value not busting and having 5 cards
	    return values.size() == 5; // Placeholder, adjust based on your actual logic
	}

	//checking for different scenarios
	public boolean twentyOneCheck(ArrayList<Integer> list) {
		for (int i =0; i<list.size(); i++) {
			int j = list.get(i);
			if (j == 21)
				return true;
		}
		return false;
	}

	public boolean checkForBust(ArrayList<Integer> list) {
		int z = list.get(0);
		if (z>21)
			return true;
		else
			return false;
	}

	public int closestToTwentyOne(ArrayList<Integer> list) {
	    if (list.isEmpty()) {
	        return -1; 
	    }
	    int closest = list.get(0);
	    for (int value : list) {
	  	        if (value <= 21 && value > closest) {
	            closest = value;
	        }
	    }
	    return closest;
	}

}


