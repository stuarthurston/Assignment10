import java.util.ArrayList;

public class DeckDriver
{
   public static void main(String [] args) 
   {
      // for (int i = 0; i < args.length;i++)
//          // System.out.println(args[i]);
      Deck deck = new Deck();
      displayDeck(deck);
      deck.freshDeck();
      
      Player p1 = new Player();
      Player p2 = new Player();
      deck.shuffle();
      
      //Split the deck into two hands
      while (!(deck.isEmpty()))
      {
         p1.addPlay(deck.dealCard());
         p2.addPlay(deck.dealCard());
      }
      
      
      
      System.out.println("----");
      for(int i = 0; i<24; i++)
      {
         System.out.print(i + ": ");
         System.out.println(p1.flip());
         
      }
      System.out.println("--nn--");
      for(int i = 0; i<24; i++)
      {
         System.out.print(i + ": ");
         System.out.println(p2.flip());
         
      }
      System.out.println(compare(p1,p2));
      
      System.out.println(p1.flip2());
       System.out.println(p1.flip2());
      int i = 0;
      displayDeck(deck);
   }

   
   public static ArrayList<Card> compare(Player pl1, Player pl2) //Compare two cards, return array List
   {
      ArrayList<Card> warDeck  = new ArrayList<Card>();
      Card card1 = pl1.flip();
      Card card2 = pl2.flip();
      
      if(card1.getRank() > card2.getRank())
      {

         pl1.addReturn(card1); //Add both the cards to player 1, winner
         pl1.addReturn(card2);
      }
      else if(card1.getRank() < card2.getRank())
      {
         pl2.addReturn(card1); //Add both the cards to player 2, winner
         pl2.addReturn(card2); 
      }
      
      else if(card1.getRank() == card2.getRank())
      {
         warDeck.add(card1);
         warDeck.add(card2);
         warDeck.add(pl1.flip());
         warDeck.add(pl2.flip());
      }
      return warDeck;     
   }
   
   
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
  
   }
}