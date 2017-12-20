import java.util.Random;
import java.util.Arrays;
public class SlapJack
{
public static void main(String[] args)
{
Card[] deck = new Card[52];
Card[] player1 = new Card[52];
Card[] player2 = new Card[52];
Card[] pile = new Card[52];
String[] suits = {"Clubs", "Diamonds", "Spades", "Hearts"};
int n = 13;
int count = 0;

SlapJackMethods.populateArrayOfCardsWithDefaultValues(player1);
SlapJackMethods.populateArrayOfCardsWithDefaultValues(player2); 
SlapJackMethods.populateArrayOfCardsWithDefaultValues(pile); 
SlapJackMethods.populateArrayOfCards(deck, suits, n);
SlapJackMethods.shuffleArrayOfCards(deck);
SlapJackMethods.splitArrayOfCards(deck, player1, player2);


while(SlapJackMethods.testIfWinner(player1, player2) != true)
 {
 if(count % 2 == 0 && SlapJackMethods.findFirstOpenPosition(player1) != 0)
  {
   Card topCard = SlapJackMethods.popCard(player1);
   System.out.println("______________________");
   System.out.println("Player 1 draws a: " + "\n" +topCard);
   System.out.println("Player 1 has " + (SlapJackMethods.findFirstOpenPosition(player1)) + " cards left");
   SlapJackMethods.pushCard(pile, topCard);
  }//end if
 else if(count %2 != 0 && SlapJackMethods.findFirstOpenPosition(player2) != 0)
  {
   Card topCard = SlapJackMethods.popCard(player2);
   System.out.println("______________________");
   System.out.println("Player 2 draws a: " + "\n" +topCard);
   System.out.println("Player 2 has " + (SlapJackMethods.findFirstOpenPosition(player2)) + " cards left");
   SlapJackMethods.pushCard(pile, topCard);
   }//end if


 if(SlapJackMethods.slapCard(pile) == true)
  {
   Random rng = new Random();
   int x = rng.nextInt();
    if(x % 2 == 0)
     {
      System.out.println("______________________");
      System.out.println("Player 1 slapped the pile first!");
      player1 = SlapJackMethods.add(player1,pile);
      pile = new Card[52];
      SlapJackMethods.populateArrayOfCardsWithDefaultValues(pile);
       
     }//end if
    else
     if(x % 2 == 1)
      {
       System.out.println("______________________");
       System.out.println("Player 2 slapped the pile first!");
       System.out.println("Player 2's card: ");
       player2 = SlapJackMethods.add(player2,pile);
       pile = new Card[52];
       SlapJackMethods.populateArrayOfCardsWithDefaultValues(pile);
       }//end if
    }//end if
System.out.println("Pile: " + (SlapJackMethods.findFirstOpenPosition(pile)));
System.out.println("Round: " + count);

++count;
}//end while



}//end main



}//end class 