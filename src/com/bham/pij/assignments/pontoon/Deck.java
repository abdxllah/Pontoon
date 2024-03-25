package com.bham.pij.assignments.pontoon;
/* The Deck class represents a whole deck of cards. There are 52 cards in a deck which is comprised of 13
cards from each of the four suits. Each suit has the following same 13 cards:
ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING.
There are no repeated cards in the deck. The ‘TWO of HEARTS’ and ‘TWO of DIAMONDS’, for example,
are distinct cards. */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bham.pij.assignments.pontoon.Card.Suit;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	ArrayList<Card> spades = new ArrayList<Card>();
	ArrayList<Card> clubs = new ArrayList<Card>();
	ArrayList<Card> hearts = new ArrayList<Card>();
	ArrayList<Card> diamonds = new ArrayList<Card>();
	int deckSize = 52;


	//Creates deck of cards
	public Deck() {

		spades = cards(Suit.SPADES);
		clubs = cards(Suit.CLUBS);
		hearts = cards(Suit.HEARTS);
		diamonds = cards(Suit.DIAMONDS);
		deck.addAll(spades);
		deck.addAll(clubs);
		deck.addAll(hearts);
		deck.addAll(diamonds);


	}

	
	// This method re-creates a full deck of cards in an existing deck. Thus, this method will always result in the
	//creation of 52 distinct cards in the deck
	public void reset() {

		ArrayList<Card> deckReset = new ArrayList<Card>();
		spades = cards(Suit.SPADES);
		clubs = cards(Suit.CLUBS);
		hearts = cards(Suit.HEARTS);
		diamonds = cards(Suit.DIAMONDS);
		deckReset.addAll(spades);
		deckReset.addAll(clubs);
		deckReset.addAll(hearts);
		deckReset.addAll(diamonds);
		deck = deckReset;
		deckSize = 52;
	}

	
	/*This method shuffles the deck. After this method has been called the current cards that are still in the
	deck (which might be less than 52) should be shuffled. In general this means that if a card exists at a
	particular index in the deck, it should exist at a different index after the method has been called*/ 
	public void shuffle() {
		//Random random = new Random();
		//Collections.shuffle(deck, random);
		shuffleOne(deck);

	}




	//This method returns the card at the given index
	public Card getCard(int i) {
		Card get = deck.get(i);
		return get;
	}

	//This method deals a random card. A random card should be selected from those remaining in the deck
	//and returned. The selected card should be removed from the deck
	public Card dealRandomCard() {
		Random random = new Random();
		int limit = deckSize;
		int ranNum = random.nextInt(limit);
		Card generatedCard = deck.get(ranNum);
		deck.remove(ranNum);
		deckSize = deckSize - 1;
		return generatedCard;


	}

	//Returns the number of cards currently in the deck
	public int size() {
		int size = deck.size();
		return size;
	}

	public ArrayList<Card> cards(Card.Suit s){

		Card ace = new Card(s, Card.Value.ACE);
		Card two = new Card(s, Card.Value.TWO);
		Card three = new Card(s, Card.Value.THREE);
		Card four = new Card(s, Card.Value.FOUR);
		Card five = new Card(s, Card.Value.FIVE);
		Card six = new Card(s, Card.Value.SIX);
		Card seven = new Card(s, Card.Value.SEVEN);
		Card eight = new Card(s, Card.Value.EIGHT);
		Card nine = new Card(s, Card.Value.NINE);
		Card ten = new Card(s, Card.Value.TEN);
		Card jack = new Card(s, Card.Value.JACK);
		Card queen = new Card(s, Card.Value.QUEEN);
		Card king = new Card(s, Card.Value.KING);

		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(ace);
		cards.add(two);
		cards.add(three);
		cards.add(four);
		cards.add(five);
		cards.add(six);
		cards.add(seven);
		cards.add(eight);
		cards.add(nine);
		cards.add(ten);
		cards.add(jack);
		cards.add(queen);
		cards.add(king);

		return cards;


	}

	//helper function to shuffle
	public void shuffleOne(List<Card> list) {
		int limit = list.size();
		Random random = new Random();
		for (int i = 0; i < limit; i++) {
			int randomised = i + random.nextInt(limit - i);
			swapPos(list, i, randomised);
		}
	}
	//helper function to swap position of cards
	public void swapPos(List<Card> list, int i, int randomised) {
		Card swapping = list.get(i);
		list.set(i, list.get(randomised));
		list.set(randomised, swapping);
	}
}

