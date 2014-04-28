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
   // ArrayList<Card> playDeck  = new ArrayList<Card>(); 
//    ArrayList<Card> returnDeck = new ArrayList<Card>();
   Deck playDeck  = new Deck(); 
   Deck returnDeck = new Deck();
   
   public void addPlay(Card inCard) //Add cards to the playDeck
   {
      playDeck.add(inCard);
   }
   
   public void addReturn(Card inCard) //Add cards to the returnDeck
   {
      returnDeck.add(inCard);
   }
   
   public Card flip() //Get the card off the top of the "deck", and remove
   {
      Card topCard = null;
      
      if(getPlayDeck() == 0)
      {
            moveCards();
      }
      
      if(!(getPlayDeck() == 0))
      {
         topCard = playDeck.get(0); //Get the card at element 0, and then delete it.
         playDeck.remove(0);
      }
      
      return topCard;
   }  
   
   public Card getTopCard() //Get the card off the top, DO NOT Delete
   {
      Card topCard = null;
      
      
      if(getPlayDeck() == 0)
      {         
            moveCards();

      }
         
      if(!(getPlayDeck() == 0))
      {
         topCard = playDeck.get(0);
      }
      
      return topCard;
   }
   
   public int getPlayDeck() //Get the size of the play deck
   {
      return playDeck.size();
   }
   
   public int getReturnDeck() //Get the size of the return deck
   {
      return returnDeck.size();
   }
   
   //////This will be delatead
   public Card flip2()  //Get the card off the top of the "deck"
   {
      Card topCard2;
      
      topCard2 = returnDeck.get(0); //Get the card at element 0, and then delete it.
      returnDeck.remove(0);
      
      
      return topCard2;
   } 
   
   public int totalCards()
   {
      int totalCount = playDeck.size() + returnDeck.size();
      
      return totalCount;
   }
   
   public void moveCards()//This will switch all the cards from the return deck, to the play deck. Clear return.
   {
    returnDeck.shuffle();
    for(Card object : returnDeck)
    {
      
      playDeck.add(object);
    }
    returnDeck.clear();  
   } 
}