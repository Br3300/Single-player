/**
 * @(#)PP5.java
 *
 *
 * @author 
 * @version 1.00 2018/12/10
 */

import java.util.Scanner;
public class FinalPig{
    public static void main(String[]args){
    	Scanner input=new Scanner(System.in);
    	int x=1, y=1;
    	int Player1S=0, Player2S=0; //Starts score off at zero points
    	int Player1RS=0, Player2RS=0; //Adds up total points in the round
    	final int FINAL=100;
    	int die1, die2; //Starts the Dice off
    	String Turn="P1"; //Starts while game on Player 1's turn each game
    	String Roll="y"; //Starts off the player as rolling unless told otherwise
    	String test="y";
    	System.out.println("Welcome to the game of PIG!");
    	while(Player1S<=FINAL||Player2S<=FINAL){
   			if(Turn.equalsIgnoreCase("P1")){
   				Player1RS=0;
   				System.out.println("It is currently Player one's turn");
   				System.out.println("Player one's total score is: "+Player1S);
   				System.out.print("Would you like to roll? [y, n]: ");
    			Roll=input.nextLine();
    			System.out.println("\n----------------------------------------\n");
    			y=1;
    			while(x==y){
    				if(Roll.equalsIgnoreCase("y")){
    					die1=(int)((Math.random()*6)+1);
    					die2=(int)((Math.random()*6)+1);
    					System.out.println("Player one rolled a "+die1+" on the first dice and a "+die2+" on the second dice");
    					if(die1==1||die2==1){
    						Player1RS=0;
    						if(die1==1&&die2==1){
    							Player1S=0;
    						}
    						y=0;
    					}
    					else{
    						Player1RS=Player1RS+(die1+die2);
    						System.out.println("Player one's total score this round is: "+Player1RS);
    						System.out.print("Would you like to roll again and be a PIG? [y, n]: ");
    						Roll=input.nextLine();
    					}
    				}
    				else{
    					System.out.println("Player one's turn has been skipped!");
    					y=0;
    				}
    				System.out.println("\n----------------------------------------\n");
   				}
   				Player1S=Player1S+Player1RS;
   				Turn="P2";
    		}
    		else if(Turn.equalsIgnoreCase("P2")){
    			Player1RS=0;
   				System.out.println("It is currently Player two's turn");
   				System.out.println("Player two's total score is: "+Player2S);
   				System.out.print("Would you like to roll? [y, n]: ");
    			Roll=input.nextLine();
    			System.out.println("\n----------------------------------------\n");
    			y=1;
    			while(x==y){
    				if(Roll.equalsIgnoreCase("y")){
    					die1=(int)((Math.random()*6)+1);
    					die2=(int)((Math.random()*6)+1);
    					System.out.println("Player two rolled a "+die1+" on the first dice and a "+die2+" on dice the second");
    					if(die1==1||die2==1){
    						Player2RS=0;
    						if(die1==1&&die2==1){
    							Player2S=0;
    						}
    						y=0;
    					}
    					else{
    						Player2RS=Player2RS+(die1+die2);
    						System.out.println("Player two's total score this round is: "+Player2RS);
    						System.out.print("Would you like to roll again and be a PIG? [y, n]: ");
    						Roll=input.nextLine();
    					}
    				}
    				else{
    					System.out.println("Player two's turn has been skipped!");
    					y=0;
    				}
    				System.out.println("\n----------------------------------------\n");
   				}
   				Player2S=Player2S+Player2RS;
   				Turn="P1";
    		}
    	}
    }
}