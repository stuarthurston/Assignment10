////////////////////////////////////////////////////////////////////////////////////////////////
//Stuart Thurston                                                                            ///
//CS 110                                                                                     ///
//Assignment 4  -- 2/14/14                                                                   ///
//Challenge problem 8                                                                        ///
//Roll dice trying to get as close to maxNumber, without going over. Will use the Die class  /// 
//Uses a while loop, and if statements                                                       ///
////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;


public class Player
{
   //Create two decks, one to hold the players cards, the other to hold the cards won.
   ArrayList<Card> playDeck  = new ArrayList<Card>(); 
   ArrayList<Card> returnDeck = new ArrayList<Card>();
   
   public void addPlay(Card inCard) //Add cards to the playDeck
   {
      playDeck.add(inCard);
   }
   
   public void addReturn(Card inCard) //Add cards to the returnDeck
   {
      returnDeck.add(inCard);
   }
   
   public Card flip() //Get the card off the top of the "deck"
   {
      Card topCard;
      
      topCard = playDeck.get(0); //Get the card at element 0, and then delete it.
      playDeck.remove(0);
      
      
      return topCard;
   }  
   
   
   //////This will be delatead
      public Card flip2() //Get the card off the top of the "deck"
   {
      Card topCard2;
      
      topCard2 = returnDeck.get(0); //Get the card at element 0, and then delete it.
      returnDeck.remove(0);
      
      
      return topCard2;
   }  
}