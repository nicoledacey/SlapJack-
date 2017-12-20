import java.util.Random;
import java.util.Arrays;
import java.lang.*;
public class TestSlapJackMethods
{
////////////////////////////////
public static void populateArrayOfPlayerCards(Card[] arrayOfCardsPassed)
{
   for(int i = 0; i < arrayOfCardsPassed.length; ++i)
   {
      arrayOfCardsPassed[i] = new Card();
   }//end loop
}//end method

///////////////////////////////
public static void splitArrayOfCards(Card[] originalDeck, Card[] player1Deck, Card[] player2Deck)
{
   for(int i = 0; i < originalDeck.length / 2; ++ i)
   {
      player1Deck[i] = originalDeck[i];
      player2Deck[i] = originalDeck[i + 26];
   }//end loop
}//end method

///////////////////////////////
public static void shuffleArrayOfCards(Card[] arrayCardsPassed)
{
Random rng = new Random();
Card temp;
int r1, r2;
   for(int i = 0; i < arrayCardsPassed.length; ++ i)
      {
         r1 = rng.nextInt(arrayCardsPassed.length);
         r2 = rng.nextInt(arrayCardsPassed.length);
         temp = arrayCardsPassed[r1];
         arrayCardsPassed[r1] = arrayCardsPassed[r2];
         arrayCardsPassed[r2] = temp;
      }//end loop

}//end method

///////////////////////////////
public static void populateArrayOfCards(Card[] arrayCardsPassed, String[] arrayStringPassed,
                                         int limitPassed)
{

int count = 0;
   for(int i = 0; i < arrayStringPassed.length; ++i)
   {
      for(int j = 0; j < limitPassed; ++j)
      {
         arrayCardsPassed[count] = new Card(arrayStringPassed[i], (count % limitPassed) + 1);
         ++count;
      }//end inner loop
   
   }//end outer loop

}//end method

////////////////////////////////
public static void printArrayOfCards(Card[] arrayCardsPassed)
{
   for(int i = 0; i < arrayCardsPassed.length; ++i)
      System.out.println(arrayCardsPassed[i].toString());
}//end method

//returns index of the first non-occupied position in an array of Cards
//return -1 if the array is full
////////////////////////////////
public static int findFirstOpenPosition(Card[] arrayPassed)
{
   for(int i = 0; i < arrayPassed.length; ++i)
   {
      if(arrayPassed[i].getValue() == 0)
         return i;
   }//end for loop
         return -1;
}//end method


//returns the last Card in an array
//DO NOT call method if array is empty
//////////////////////////////////
public static Card popCard(Card[] arrayPassed)
{
   Card cardToReturn = arrayPassed[findFirstOpenPosition(arrayPassed) - 1];
   arrayPassed[findFirstOpenPosition(arrayPassed) - 1] = new Card();
   return cardToReturn;
}//end method

//pushes the Card passed onto an array
//DO NOT call method if array is full
//////////////////////////////////
public static void pushCard(Card[] arrayPassed, Card cardPassed)
{
   arrayPassed[findFirstOpenPosition(arrayPassed)] = cardPassed;
}//end method

/////////////////////////////////
public static boolean slapCard(Card[] arrayPassed)
{
if(Arrays.asList(arrayPassed).indexOf(11) == 0)
{
return true;
}
else
return false;
}//end method

public static Card[] add(Card[] arrayPassed, int x, Card[] pilePassed, int y, int z)
{
//Card[] newPlayer = arrayPassed;
System.arraycopy(pilePassed, x ,arrayPassed, y, z);
return arrayPassed;
}//end method

public static boolean testIfWinner(Card[] player1Passed,Card[] player2Passed)
{
if(findFirstOpenPosition(player1Passed) == - 1)
{
System.out.println("Player 1 won!");
return true;
}
else 
if(findFirstOpenPosition(player2Passed) == - 1)
{
System.out.println("Player 2 won!");
return true;
}
else
return false;
}//end method

}//end class