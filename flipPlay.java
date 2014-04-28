import java.util.ArrayList;
public class flipPlay
{
   public flipPlay(Player p1, Player p2, ArrayList<Card> warDeck)
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