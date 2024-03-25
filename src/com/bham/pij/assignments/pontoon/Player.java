package com.bham.pij.assignments.pontoon;
/* The Player class represents a player in a card game. The main responsibility of this class, however, is to
represent the player’s ‘hand’ of cards. A ‘hand’ is a collection of cards held by a player. The number of
cards per player varies depending on the game and the current state of the game. That detail is not dealt
with by this class, however
*/

import java.util.ArrayList;

import com.bham.pij.assignments.pontoon.Card.Value;

public class Player {

	public String playerName;
	public ArrayList<Card> hand = new ArrayList<Card>();
	public int bestValue;

	public Player(String name) {
		playerName = name;
	}

	//Returns the player’s name.
	public String getName() {
		return playerName;
	}
	
	//This method deals a card to a player, i.e. it adds a card to a player’s hand
	public void dealToPlayer(Card card) {
		hand.add(card);
	}

	//This method removes a card from a player’s hand
	public void removeCard(Card card) {
		for (int i=0; i< hand.size(); i++) {
			if (hand.get(i) == card)
				hand.remove(i);

		}

	}

	/*This method returns all of the possible numerical values of a hand. This will comprise multiple values if
	the hand contains ACE cards since each ACE card can have the value 1 or 11. The numerical values of
	the hand should be returned in low to high order (i.e. the lowest value is returned at index 0).*/
	public ArrayList<Integer> getNumericalHandValue(){
		ArrayList<Integer> poss = new ArrayList<Integer>();
		int totalNoAce=0;
		int counter =0;
		for (int j =0; j<hand.size(); j++) {
			Card nuAce = hand.get(j);
			if (nuAce.getValue() == Value.ACE)
				counter++;}

		for(int i=0; i<hand.size(); i++) {
			Card check=hand.get(i);
			ArrayList<Integer> cardVal = new ArrayList<Integer>();
			cardVal = check.getNumericalValue();
			int cv = cardVal.get(0);
			if (cv != 1)
				totalNoAce = totalNoAce + cardVal.get(0);


		}


		switch(counter) {
		case 1:{
			int one = totalNoAce + 1;
			int eleven = totalNoAce +11;
			poss.add(one);
			poss.add(eleven);
			bestValue = eleven;
			return poss;
		}
		case 2:{
			int oneOne = totalNoAce + 1 + 1;
			int oneEleven = totalNoAce + 1 + 11;
			int elevenEleven = totalNoAce + 11 + 11;
			poss.add(oneOne);
			poss.add(oneEleven);
			poss.add(elevenEleven);
			bestValue = elevenEleven;
			return poss;
		}

		case 3:{
			int oneOneOne = totalNoAce + 1 + 1 + 1;
			int oneOneEleven = totalNoAce + 1 + 1 + 11;
			int oneElevenEleven = totalNoAce + 1 + 11 + 11;
			int elevenElevenEleven = totalNoAce + 11 + 11 + 11;
			poss.add(oneOneOne);
			poss.add(oneOneEleven);
			poss.add(oneElevenEleven);
			poss.add(elevenElevenEleven);
			bestValue = elevenElevenEleven;
			return poss;
		}

		case 4:{
			int oneOneOneOne = totalNoAce + 1 + 1 + 1 + 1;
			int oneOneOneEleven =totalNoAce + 1 + 1 + 1 + 11;
			int oneOneElevenEleven = totalNoAce + 1 + 1 + 11 + 11;
			int oneElevenElevenEleven = totalNoAce + 1 + 11 + 11 + 11;
			int elevenElevenElevenEleven = totalNoAce + 11 + 11 + 11 + 11;
			poss.add(oneOneOneOne);
			poss.add(oneOneOneEleven);
			poss.add(oneOneElevenEleven);
			poss.add(oneElevenElevenEleven);
			poss.add(elevenElevenElevenEleven);
			bestValue = elevenElevenElevenEleven;
			return poss;

		}

		default:{
			poss.add(totalNoAce);
			bestValue = totalNoAce;
			return poss;
		}

		}




	}
	
	
	//This method returns the maximum numerical value of the player’s hand of cards.
	public int getBestNumericalHandValue() {
		return bestValue;
	}

	//Returns the cards in the player’s hand.
	public ArrayList<Card> getCards(){
		return hand;
	}

	//Returns the number of cards in the player’s hand.
	public int getHandSize() {
		int size = hand.size();
		return size;
	}
}
