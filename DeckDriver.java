import java.util.ArrayList;

public class DeckDriver
{
   public static void main(String [] args) throws IndexOutOfBoundsException 
   {
      //Create a deck object, and add 52 cards to the deck
      Deck deck = new Deck(); 
      deck.freshDeck();
      
      //This is where the cards from the war will go
      ArrayList<Card> warDeck  = new ArrayList<Card>(); 
      
      //Create two players and shuffel the deck
      Player p1 = new Player();
      Player p2 = new Player();
      deck.shuffle();
      
      //Split the deck into two hands
      while (!(deck.isEmpty()))
      {
         p1.addPlay(deck.dealCard());
         p2.addPlay(deck.dealCard());
      }
      
      ShowWindow my = new ShowWindow(p1,p2,warDeck);
      
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck);
      flipPlay(p1,p2,warDeck); 
      
      try{    
         System.out.println("Player1");
         for(int i=0;i<15;i++)
         {
            System.out.println(p1.flip2());
         }
      }
      catch (Exception e)
      {
         System.out.println("there was an error -- 1");
      }      
      
      try{
         System.out.println("Player2");
         System.out.println(p2.flip2());
         System.out.println(p2.flip2());
      }
      catch (Exception e)
      {
         System.out.println("there was an error -- 2");
      }  
      
      int i = 0;
      
   }

   
   public static void compare(Player pl1, Player pl2, ArrayList<Card> warDeck) //Compare two cards, return array List
   {
      Card card1 = pl1.flip();
      Card card2 = pl2.flip();
      
      if(card1.getRank() > card2.getRank())
      {
         if(!warDeck.isEmpty())
         {
            for(Card item : warDeck)
            {
               pl1.addReturn(item);
            }
            warDeck.clear();  
         }
         pl1.addReturn(card1); //Add both the cards to player 1, winner
         pl1.addReturn(card2);
      }
      
      else if(card1.getRank() < card2.getRank())
      {
         if(!warDeck.isEmpty())
         {
            for(Card item : warDeck)
            {
               pl2.addReturn(item);
            }
            warDeck.clear();  
         }
         pl2.addReturn(card1); //Add both the cards to player 2, winner
         pl2.addReturn(card2); 
      }
      
      else if(card1.getRank() == card2.getRank())
      {
         warDeck.add(card1);
         warDeck.add(card2);
         warDeck.add(pl1.flip());
         warDeck.add(pl2.flip());
           
         while(!warDeck.isEmpty())//While wardeck is not empty
         {
            compare(pl1,pl2,warDeck); 
         }
      }    
   }
   
   
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
   }
   
   public static void flipPlay(Player p1, Player p2, ArrayList<Card> warDeck)
   {
         if(p1.getPlayDeck() == 0)
         {
            p1.moveCards();
         }
         
         if(p2.getPlayDeck() == 0)
         {
            p2.moveCards();
         }
         
         compare(p1,p2,warDeck); 
   }
}