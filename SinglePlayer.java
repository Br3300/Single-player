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
    	int pCount, aiScore=0, aiTurn=0, turnPoint=0, die1=0, die2=0, thisPoint=0, userTurn=0, begin =0; //AI ints
    	int Player1S=0, Player2S=0; //Starts score off at zero points
    	int Player1RS=0, Player2RS=0; //Adds up total points in the round
    	final int FINAL=100;
    	
    	String Turn="P1"; //Starts while game on Player 1's turn each game
    	String Roll="y"; //Starts off the player as rolling unless told otherwise
    	String test="y";
    	System.out.println("Welcome to the game of PIG!");
    	
    		System.out.println("How many people are playing? (1 or 2)");	//Decide the number of players
    		pCount =input.nextInt();
    		if (pCount ==1){
    			while(Player1S<=FINAL||aiScore<=FINAL){
    			
    				aiTurn =1;	
    				while (aiTurn==1){ //runs the AI turn
    					die1=(int)((Math.random()*6)+1);
    					die2=(int)((Math.random()*6)+1);
    					thisPoint= die1+die2;
    				
    				if (die1 == 1 && die2 == 1) { //if both dice rolled are 1's, erases score and trades turns.
    					System.out.println("The Computer rolled two zeros, lost its score and it is now your turn.");
    					aiScore=0;
    					userTurn=1;
    					aiTurn=2;
    				}
    				else if (die1 == 1 || die2==1){ //if either of the AI's first roll of dice is zero, it should end.
    					System.out.println("The Computer rolled one zero, it lost its points for the turn and it is now your turn to roll.");
    					aiScore = aiScore - turnPoint;
    					turnPoint=0;
    					userTurn=1;
    					aiTurn=2;
    				}
    				else {
    					aiScore=(aiScore + thisPoint);
    					System.out.println("The AI rolled a "+die1+" and a "+die2+" for a new total of "+ aiScore);
    						if (turnPoint+thisPoint>=20){
    							System.out.println("The AI ends their turn.");
    							turnPoint = turnPoint + thisPoint;
    							aiScore = aiScore + turnPoint;
    							userTurn=1;
    							aiTurn=2;
    						}
    						else if (turnPoint<20){
    							System.out.println("The AI rolls again");
    							turnPoint = turnPoint + thisPoint;
    							userTurn=1;
    						}
    				}
   	 	}
    			
    		//RUNS UNTIL THE END OF ITS FIRST TURN	
    			//user turn
    			while (userTurn==1){
    				Player1RS=0;
   					System.out.println("It is currently your turn");
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
    					if(die1==1||die2==1){
    						if(die1==die2){
    							System.out.println("You rolled two 1's, your entire score has reset and you loose your turn.");
    						Player1S=0;
    						begin=0;
    						userTurn=0;
    						}
    						else {
    							System.out.println("You rolled a 1. Your score this round has been reset, and  your turn ends.");
    							Player1RS=0;
    							begin=0;
    							userTurn=0;
    						}
    						y=0;
    						begin=0;
    					}
    					else if (die1 != 1 || die2 !=1){
    						Player1RS=Player1RS+(die1+die2);
    						System.out.println("Your total score this round is: "+Player1RS);
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
    		}
    	}
   	}

    		//END OF AI GAME