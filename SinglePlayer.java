/*
 *
 *
 *
 *
 *
 */


import java.util.Scanner;
public class SinglePlayer{
    public static void main(String[]args){
    	Scanner input=new Scanner(System.in);
    	int x=1, y=1;
    	int pCount, aiScore=0, aiTurn=0, turnPoint=0, die1=0, die2=0, thisRoll = 0, userTurn=0, begin =0; //AI ints
    	int Player1S=0, Player2S=0; //Starts score off at zero points
    	int Player1RS=0, Player2RS=0; //Adds up total points in the round
    	final int FINAL=100;
    	
    	String Turn="P1"; //Starts while game on Player 1's turn each game
    	String Roll="y"; //Starts off the player as rolling unless told otherwise
    	String test="y";
    	System.out.println("Welcome to the game of PIG!");
    	System.out.println("The rules are simple. \nEach turn a Player rolls two dice. If one dice rolls a 1, you loose all points for that round, and both dice go to your opponent.\nIf both of your dice land on a 1, you lose your entire score (across all rounds) and your turn.\nOtherwise, if neither of the dice land on a 1, the total of the two dice will be added to your score.\nYou can keep rolling for as long as you like, but the more you roll the more points you will be likely to loose if you roll a 1.\nHave fun!\n\n");
    	
    		System.out.println("How many people are playing? (1 or 2)");	//Decide the number of players
    		pCount =input.nextInt();
    		if (pCount ==1){
    			while(Player1S<=FINAL&&aiScore<=FINAL){
    			
    				aiTurn =1;	
    				while (aiTurn==1){ //runs the AI turn
    					die1=(int)((Math.random()*6)+1);
    					die2=(int)((Math.random()*6)+1);
    					thisRoll = (die1+die2);
    					turnPoint=turnPoint+ thisRoll;
    				
    				if (die1 == 1 && die2 == 1) { //if both dice rolled are 1's, erases score and trades turns.
    					System.out.println("The Computer rolled two ones. It lost its score and it is now your turn.");
    					aiScore=0;
    					turnPoint=0;
    					userTurn=1;
    					aiTurn=2;
    				}
    				else if (die1 == 1 || die2==1){ //if either of the AI's first roll of dice is zero, it should end.
    					System.out.println("The Computer rolled a one, it lost its points for the turn and it is now your turn to roll.");
    					aiScore= aiScore-turnPoint;
    					turnPoint=0;
    					userTurn=1;
    					aiTurn=2;
    				}
    				else {
    				
    					System.out.println("The AI rolled a "+die1+" and a "+die2+" for a new total of "+ turnPoint);
    					aiScore=(aiScore + thisRoll);
    						if (turnPoint>=15){
    							System.out.println("The AI ends their turn.");
    							System.out.println("The AI has a current total score of: "+aiScore);
    							turnPoint=0;
    							userTurn=1;
    							aiTurn=2;
    							if (aiScore>=100)
    								{
    								System.out.println("This is your last turn! The AI has a winning score!");
    								}
    						}
    						else if (turnPoint<20){
    							System.out.println("The AI rolls again");
    							aiTurn=1;
    						}
    						
    				}
   	 	}
    			
    		//RUNS UNTIL THE END OF ITS FIRST TURN	
    			//user turn
    			while (userTurn==1){
    				Player1RS=0;
   					System.out.println("\n\nIt is currently your turn");
   					System.out.println("Your total score is: "+Player1S);
   					System.out.print("Would you like to roll? [1 for yes, 2 for no]: \n");
   				
    				begin=input.nextInt();
    				System.out.println("\n----------------------------------------\n");
    				y=1;
    			while(x==y){
    				if(begin ==1){
    					die1=(int)((Math.random()*6)+1);
    					die2=(int)((Math.random()*6)+1);
    					System.out.println("You rolled a "+die1+" and a "+die2);
    					thisRoll = (die1 + die2);
    					if(die1==1||die2==1){
    						if(die1==die2){
    							System.out.println("You rolled two 1's, your entire score has reset and you loose your turn.");
    						Player1S=0;
    						begin=0;
    						userTurn=0;
    						}
    						else {
    							System.out.println("You rolled a 1. Your points for this round has been reset, and  your turn ends.");
    							System.out.println("Your current score is "+Player1S);
    							Player1RS=0;
    							begin=0;
    							userTurn=0;
    						}
    						y=0;
    						begin=0;
    					}
    					else if (die1 != 1 || die2 !=1){
    						Player1RS=Player1RS+thisRoll;
    						System.out.println("Your total score this round is: "+Player1RS);
    						System.out.println("Your total score is " +(Player1S+Player1RS));
    						System.out.print("Would you like to roll again and be a PIG? [1 for yes, 2 for no]: ");
    						begin = input.nextInt();
    						

    					}
    				}
    				else {
    					System.out.println("Your turn ends.");
    					y=0;
    					userTurn=0;
    					Player1S=Player1S+Player1RS;
    				}
    				}
    				System.out.println("\n----------------------------------------\n");
   				}
   			
   				
    			}
    			System.out.println("That's game! ");
    			if (Player1S>=100 && aiScore<=100){
    				System.out.print("You beat the AI! that's no easy feat.");
    			}
    			else if(aiScore>=100 && Player1S<=100){
    				System.out.print("The AI beat you. Better luck next time!");
    			}
    			else if (aiScore>=100 && Player1S>=100){
    				System.out.print("A tie? That's uncommon. Better try again!");
    			}
    		}
    	}
   	}


    		//END OF AI GAME