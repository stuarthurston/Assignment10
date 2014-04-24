import java.util.Random;
import java.util.ArrayList;

public class Deck 
{
   final int CARDS_IN_DECK = 52;

   ArrayList<Card> deck;
   public Deck()
   {
            freshDeck();
   }
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      System.out.println(deck.size());

      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
     
   
   }
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   public int cardsRemaining()
   {  
      return deck.size();
   }
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
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   // by rank only
//    public static void main(String [] args) 
//    {
//       Deck1 deck = new Deck1();
//       deck.shuffle();
//       int i = 0;
// //      while (deck.cardsRemaining() > 0)
//       while (!(deck.isEmpty()))
//          System.out.println(i++ + " : " + deck.dealCard().toString());
//       System.out.println(deck.cardsRemaining());
//       deck.freshDeck();
//       while (!(deck.isEmpty()))
//          System.out.println(i++ + " : " + deck.dealCard().toString());
//          
//       Card c1 = new Card(Card.ACE,Card.HEARTS);
//       Card c2 = new Card(Card.JACK,Card.SPADES);
//       Card c3 = new Card(4,Card.HEARTS);
//       
//       System.out.println(highCard(c1,c2,c3));
//       
// 
//    }
   public static Card highCard(Card...cards)
   {
   
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high;
   
   }
}

