import java.util.Random;
import java.util.ArrayList;

public class Deck extends ArrayList<Card>
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

