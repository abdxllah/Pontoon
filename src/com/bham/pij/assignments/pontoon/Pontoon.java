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
		ArrayList<Card> handOne = hand1.getCards();
		ArrayList<Card> handTwo = hand2.getCards();
		ArrayList<Integer> numValue = hand1.getNumericalHandValue();
		ArrayList<Integer> numValueTwo = hand2.getNumericalHandValue();

		int handOneCheck = closestToTwentyOne(numValue);
		int handTwoCheck = closestToTwentyOne(numValueTwo);

		Card unoOne = handOne.get(0);
		Card.Value un = unoOne.getValue();
		Card unoTwo = handOne.get(1);
		Card.Value deux= unoTwo.getValue();
		Card dosOne = handTwo.get(0);
		Card.Value trois = dosOne.getValue();
		Card dosTwo = handTwo.get(1);
		Card.Value quatre = dosTwo.getValue();


		if (checkForBust(numValue) == false && checkForBust(numValueTwo) == true)
			return -1;
		else
			if (checkForBust(numValue) == true && checkForBust(numValueTwo) == true)
				return 0;
			else
				if (checkForBust(numValueTwo) == false && checkForBust(numValue) == true)
					return 1;
				else
					if(((un == Value.ACE && deux == Value.TEN) || (un == Value.TEN && deux == Value.ACE)) && ((trois != Value.ACE && quatre != Value.ACE)))
						return -1;
					else 
						if (((un == Value.ACE && deux == Value.TEN) || (un == Value.TEN && deux == Value.ACE)) && ((trois == Value.ACE && quatre == Value.TEN) || (trois == Value.TEN && quatre == Value.ACE)))
							return 0;
						else
							if (((un != Value.ACE &&  deux != Value.ACE)) && ((trois == Value.ACE && quatre == Value.TEN) || (trois == Value.TEN && quatre == Value.ACE)))
								return 1;
							else
								if (handOne.size() == 5 && twentyOneCheck(numValue) == true && handTwo.size() !=5)
									return -1;
								else
									if (handOne.size() == 5 && twentyOneCheck(numValue) == true && handTwo.size() ==5 && twentyOneCheck(numValueTwo) == true)
										return 0;
									else
										if (handTwo.size() == 5 && twentyOneCheck(numValueTwo) == true && handOne.size() !=5)
											return 1;
										else
											if (twentyOneCheck(numValue) == true && twentyOneCheck(numValueTwo) == false)
												return -1;
											else
												if (twentyOneCheck(numValue) == true && twentyOneCheck(numValueTwo) == true)
													return 0;
												else
													if (twentyOneCheck(numValueTwo) == true && twentyOneCheck(numValue) == false)
														return 1;
													else
														if(handOneCheck > handTwoCheck)
															return -1;
														else
															if (handOneCheck == handTwoCheck)
																return 0;
															else
																if(handTwoCheck > handOneCheck)
																	return 1;
		return 0;





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


