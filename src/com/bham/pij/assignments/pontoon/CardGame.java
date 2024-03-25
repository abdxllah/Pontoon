package com.bham.pij.assignments.pontoon;
//This is an abstract class that can be used as the base class for other card game classes

import java.util.ArrayList;

public abstract class CardGame {
	int noPlayers;
	Deck deck= new Deck();
	ArrayList<Player> players = new ArrayList<Player>();
	Player playOne = new Player("one");
	Player playTwo = new Player("two");

	//This constructor creates the deck and sets the number of players for this game.
	public CardGame (int nplayers) {
		deck.shuffle();
		noPlayers = nplayers;
		players.add(playOne);
		players.add(playTwo);


	}

	//deals the number of initial cards to each player in the game
	public abstract void dealInitialCards();

	/*This abstract method compares the hands of two players. If hand1 is better than hand2 the method should
	return -1. If hand2 is better than hand1 the method should return +1. If the two hands are equal then
			the method should return 0*/
	public abstract int compareHands(Player hand1, Player hand2);

	
	//returns the deck
	public Deck getDeck() {
		return deck;
	}

	//This method gets the player at the index
	public Player getPlayer(int i) {
		Player retrieve = players.get(i);
		return retrieve;

	}

	// gets the number of players in the game
	public int getNumPlayers() {
		return noPlayers;
	}

}
