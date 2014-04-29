////////////////////////////////////////////////////////////////////////////////////////////////
//Stuart Thurston                                                                            ///
//CS 110                                                                                     ///
//Assignment 10  -- 4/28/14                                                                  ///
//WarGame - Deck                                                                             ///
//This class creates a Deck. Has a way to remove cards from decks as well as shuffle the     ///
//cards. Uses ArrayLists                                                                     ///
////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.util.ArrayList;

public class Deck extends ArrayList<Card>
{

   ArrayList<Card> deck;
   /**
      Constructor
      call freshDeck()
   */
   public Deck()
   {
            freshDeck();
   }
   
   
   /**
      freshDeck
      create a new ArrayList named deck, and use the Card class
      to add 52 Cards to the deck.
      call freshDeck()
   */
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      
//       deck.add(new Card(1,2));
//       deck.add(new Card(2,2));
//       deck.add(new Card(3,3));
//       deck.add(new Card(1,1));
//       deck.add(new Card(2,1));
//       deck.add(new Card(3,0));
//       deck.add(new Card(1,1));
//       deck.add(new Card(2,1));
//       deck.add(new Card(3,1));
//       deck.add(new Card(1,1));
      for (int r = 2; r<=Card.ACE;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
     
   
   }//End freshDeck
   
   
   /**
      dealCard
      get and rremove the first card from the deck
      @return Card a Card
   */
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   
   /**
      cardsRemaining
      get and return the size of the deck
      @return int size of the deck
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
   
   /**
      shuffle
      shuffle the deck, using a random number  
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   
   /**
      isEmpty
      Determine if the deck is empty
      @return boolean
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
}

