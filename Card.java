////////////////////////////////////////////////////////////////////////////////////////////////
//Stuart Thurston                                                                            ///
//CS 110                                                                                     ///
//Assignment 10  -- 4/28/14                                                                  ///
//WarGame - Card                                                                             ///
//This class creates a card. Has methods to access the cards class and suit, both as an int  ///
//and as a string.                                                                           ///
////////////////////////////////////////////////////////////////////////////////////////////////

public class Card 
{     
    // Constants     
    // suits
    public final static int SPADES = 0,      
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
    // ranks
    // Cards 2 through 9 have face value
    public final static int ACE = 14, //Ace is higer than everything else           
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    // instance variables
    private int suit;   // The suit of this card, one of the constants
                              // SPADES, HEARTS, DIAMONDS, CLUBS.
                              
    private int rank;  // The rank of this card, from 1 to 13.
   
                             
   /**
      Creates a new playing card.
      @param suit the suit value of this card.
      @param rank the rank rank of this card.
   */
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }
   
   
    
    
   /**
      Creates a new playing card as exact copy of otherCard
      @param otherCar the card to be copied
   */
    public Card(Card otherCard) 
    {
         this.rank = otherCard.rank;
         this.suit = otherCard.suit;
    }
    
    
    
    
   /**
      Returns the suit of the card.
      @return int Suit constant representing the suit value of the card.
   */
    public int getSuit() 
    {
      return suit;
    }
    
    
    
    
   /**
       Returns the rank of the card.
      @return int Rank constant representing the rank value of the card.
   */
    public int getRank() 
    {
            // Return the int that codes for this card's rank.
        return rank;
    }
    
    
    
    
   /**
      Returns a description of the suit of this card.
      @return String suit value of the card as a string.
   */
    public String getSuitAsString() 
    {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
        switch ( suit ) {
           case SPADES:   return "s";
           case HEARTS:   return "h";
           case DIAMONDS: return "d";
           case CLUBS:    return "c";
           default:       return "Invalid";
        }
    }
    
    
    
    
   /**
      Returns a description of the rank of this card.
      @return String the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
        switch ( rank ) {
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "j";
           case 12:  return "q";
           case 13:  return "k";
           case 14:   return "a";
           default:  return "??";
        }
    }
    
    
    
    
   /**
      Returns a description of this card.
      @return String the name of the card.
   */
    public String toString() 
    {
        return getRankAsString() + getSuitAsString();
    }
    
    
    
    
   /**
      Compares two cards to determine if they have the same value.
      @param card the other card
      @return true if the two cards have the same rank and suitvalues,
      falseotherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank != otherCard.rank ) || ( suit != otherCard.suit ) )
         return false;
      else
         return true;
   }

}
    


