package com.bham.pij.assignments.pontoon;
/*Card class -This class represents a single playing card.
 * 
A playing card has a suit and a value. Each card also has a numerical value, described below.
The suit of a playing card is one of the following:
CLUBS, HEARTS, DIAMONDS, SPADES
The values of playing cards are as follows. This list also shows,in parentheses, the numerical value of each
card:
ACE (1 or 11)
TWO (2)
THREE (3)
FOUR (4)
FIVE (5)
SIX (6)
SEVEN (7)
EIGHT (8)
NINE (9)
TEN (10)
JACK (10)
QUEEN (10)
KING (10)
 * 
 */

import java.util.ArrayList;

public class Card {

	public static enum Suit{CLUBS, HEARTS, DIAMONDS, SPADES, NULL};
	public static enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, NULL};
	public Suit storedSuit = Suit.NULL;
	public Value storedValue = Value.NULL;

	public Suit getSuit() {
		return storedSuit;
	}

	public Value getValue() {
		return storedValue;
	}

	public void setSuit(Suit s) {
		storedSuit = s;
	}

	public void setValue(Value v) {
		storedValue = v;
	}

	public Card(Suit s, Value v) {
		storedSuit = s;
		storedValue= v;
	}
	
	//A method to compute the numerical value of a card. 
	public ArrayList<Integer> getNumericalValue(){
		ArrayList<Integer> ace = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();
		ArrayList<Integer> three = new ArrayList<Integer>();
		ArrayList<Integer> four = new ArrayList<Integer>();
		ArrayList<Integer> five = new ArrayList<Integer>();
		ArrayList<Integer> six = new ArrayList<Integer>();
		ArrayList<Integer> seven = new ArrayList<Integer>();
		ArrayList<Integer> eight = new ArrayList<Integer>();
		ArrayList<Integer> nine = new ArrayList<Integer>();
		ArrayList<Integer> ten = new ArrayList<Integer>();
		ArrayList<Integer> zero = new ArrayList<Integer>();
		ace.add(1);
		ace.add(11);
		two.add(2);
		three.add(3);
		four.add(4);
		five.add(5);
		six.add(6);
		seven.add(7);
		eight.add(8);
		nine.add(9);
		ten.add(10);
		zero.add(0);

		switch(storedValue) {

		case NULL: return zero;
		case ACE: return ace;
		case TWO: return two;
		case THREE: return three;
		case FOUR: return four;
		case FIVE: return five;
		case SIX: return six;
		case SEVEN: return seven;
		case EIGHT: return eight;
		case NINE: return nine;
		default: return ten;

		}


	}

}
