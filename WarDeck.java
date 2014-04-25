import java.util.ArrayList;

public class DeckDriver
{
   public static void main(String [] args) throws IndexOutOfBoundsException 
   {
      // for (int i = 0; i < args.length;i++)
//          // System.out.println(args[i]);
      Deck deck = new Deck();
      // displayDeck(deck);
      deck.freshDeck();
      
      ArrayList<Card> warDeck  = new ArrayList<Card>(); //This is where the cards from the war will go
      
      Player p1 = new Player();
      Player p2 = new Player();
      deck.shuffle();
      
      //Split the deck into two hands
      while (!(deck.isEmpty()))
      {
         p1.addPlay(deck.dealCard());
         p2.addPlay(deck.dealCard());
      }
      
      
      
//       System.out.println("----");
//       for(int i = 0; i<24; i++)
//       {
//          System.out.print(i + ": ");
//          System.out.println(p1.flip());
//          
//       }
//       System.out.println("--nn--");
//       for(int i = 0; i<24; i++)
//       {
//          System.out.print(i + ": ");
//          System.out.println(p2.flip());
//          
//       }

         compare(p1,p2,warDeck);

      try{    
         System.out.println("Player1");
         System.out.println(p1.flip2());
         System.out.println(p1.flip2());
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
            compare(pl1,pl1,warDeck); 
         }
         
      }
         
   }
   
   
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
  
   }
}