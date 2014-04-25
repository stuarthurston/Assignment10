public class DeckDriver
{
   public static void main(String [] args) 
   {
      // for (int i = 0; i < args.length;i++)
//          // System.out.println(args[i]);
      WarDeck deck = new WarDeck();
      displayDeck(deck);
      deck.freshDeck();
      deck.shuffle();
      int i = 0;
      displayDeck(deck);
   }
   public static void displayDeck(WarDeck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
 
   
   
   }
}