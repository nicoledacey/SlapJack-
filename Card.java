public class Card
{
  //variables
  private String suit;
  private int value;
  
  //constructors
  public Card()
  {
    suit = "";
    value = 0;    
  }//end default constructor
  
  public Card(String suitPassed, int valuePassed)
  {
    suit = suitPassed;
    value = valuePassed;    
  }//end constructor
  
  //getters
  
  public String getSuit()
  {
    return this.suit;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
    
  //setters
  
  public void setSuit(String suitPassed)
  {
   suit = suitPassed; 
  }
  
  public void setValue(int valuePassed)
  {
   value = valuePassed; 
  }
  
    
  //toString Method
  public String toString()
  {
  
  if(value > 0)
     return     
          "Suit: " + this.getSuit()
           + "\n" +
          "Value: " + this.getValue()
           + "\n";       
  else
   return "";
  }
  
}//end class