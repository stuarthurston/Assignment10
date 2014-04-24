public class DeckDriver
{
   public static void main(String [] args) 
   {
      // for (int i = 0; i < args.length;i++)
//          // System.out.println(args[i]);
      Deck deck = new Deck();
      displayDeck(deck);
      deck.freshDeck();
      deck.shuffle();
      int i = 0;
      displayDeck(deck);
   }
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
 
   
   
   }
}