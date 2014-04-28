import java.util.ArrayList;
public class compare
{
   public compare()
   {
      
   }
   public void compareCard(Player pl1, Player pl2, ArrayList<Card> warDeck) //Compare two cards, return array List
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
               compareCard(pl1,pl2,warDeck); 
            }
         }    
      }
}