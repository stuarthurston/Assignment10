////////////////////////////////////////////////////////////////////////////////////////////////
//Stuart Thurston                                                                            ///
//CS 110                                                                                     ///
//Assignment 10  -- 4/28/14                                                                  ///
//WarGame - Player                                                                           ///
//This class designs a Player object. Creates two Decks (ArrayList), one to hold the current ///
//hand, and one the return hand. Methods all access to cards.                                ///
////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;


public class Player
{
   //Create two decks, one to hold the players cards, the other to hold the cards won.
   Deck playDeck  = new Deck(); 
   Deck returnDeck = new Deck();
   
   
   /**
      Add a card to the playDeck - the active deck 
      @param inCard a Card object
   */
   public void addPlay(Card inCard)
   {
      playDeck.add(inCard);
   }
   
   
   /**
      Add a card to the addReturn - the won deck 
      @param inCard a Card object
   */
   public void addReturn(Card inCard) 
   {
      returnDeck.add(inCard);
   }
   
   
   /**
      Get the top card off of the deck and remove from the deck
      @return Card topCard a Card object
   */
   public Card flip() 
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
   
   
   /**
      Get the top card off of the deck and remove from the deck
      @return Card topCard a Card object
   */
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
   
   
   /**
      Get the the size of the active (play) deck, return an int
      @return int playDeck.size() The size of the active deck
   */
   public int getPlayDeck()
   {
      return playDeck.size();
   }
   
   
   /**
      Get the the size of the return deck, return an int
      @return int returnDeck.size() The size of the return deck
   */
   public int getReturnDeck()
   {
      return returnDeck.size();
   }
   
   
   /**
      Get the amount of cards in both the return and play deck
      @return int totalCount The amount of cards a player has
   */   
   public int totalCards()
   {
      int totalCount = playDeck.size() + returnDeck.size();
      
      return totalCount;
   }
   
   
   /**
      Move cards from the return deck to the playdeck.
      Shuffle the cards, move, and then clear the return deck
   */ 
   public void moveCards()
   {
    returnDeck.shuffle();
    for(Card object : returnDeck)
    {
      
      playDeck.add(object);
    }
    returnDeck.clear();  
   } 
}