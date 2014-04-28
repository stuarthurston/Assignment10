import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;


public class War extends JFrame
{
      //Buttons   
      private JButton startGame = new JButton("Start");  
      private JButton quit = new JButton("Quit");
      private JButton flip = new JButton("Flip Card");
      
      //Panels
      private JPanel panel = new JPanel(new BorderLayout(40,10)); //Holds everything
      private JPanel top = new JPanel(new BorderLayout(10,10)); //Hold name and stats
      private JPanel gameName = new JPanel(new BorderLayout()); //Name
      private JPanel stats = new JPanel(new BorderLayout()); // Score, and results
      private JPanel middle = new JPanel(new GridLayout(2,1,5,5)); //This has the buttons
      private JPanel table = new JPanel(new GridLayout(1,3,25,25)); //Cards and middle, center
      private JPanel bottom = new JPanel(new GridLayout(1,3,30,30)); //Caption for cards
      
      //Labels
      JLabel playerDeck1;
      JLabel playerDeck2;
      JLabel result;
      
      //The background color
      private Color lightPurple = new Color(206,0,113);
      
      //Deck of cards
      private Deck deck;
      private ArrayList<Card> warDeck;
      
      private Player p1,p2;
      
      //Card Images
      // private	ImageIcon cardback = new ImageIcon("Images/b1fv.png");
      private ImageIcon cardback = new ImageIcon("bigImages/back.jpg");
      private JLabel back = new JLabel(cardback);
      private JLabel back2 = new JLabel(cardback);
      private JLabel cardImage;
      private JLabel playerCard1;
      private JLabel playerCard2;
      
      //Height and Width of the overall frame
      private final int WINDOW_WIDTH = 350;
      private final int WINDOW_HEIGHT = 250;
   
   public War()
   {
      //Create the frame
      setTitle("A Game of War - Stuart Thurston"); //Set the name
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //Set the size
      setResizable(false);
      
      //Add a border around the main panel, space it out from the frame
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      
      //Close the window
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Add to the middle section
      middle.add(startGame);
      middle.add(quit);
      //Link the buttons to an action
      startGame.addActionListener(new beginGame());
      quit.addActionListener(new exitGame());
      
      //Add two cards, and buttons to the GUI
      table.add(back);
      table.add(middle);
      table.add(back2);

      //Create the name of the game
      JLabel welcome = new JLabel("The Game of War",SwingConstants.CENTER);
      welcome.setLayout(new BorderLayout());
      welcome.setFont(welcome.getFont().deriveFont(40.0f));
      gameName.add(welcome);
      gameName.setBorder(BorderFactory.createLineBorder(Color.black));
      
      //Create my name
      JLabel name = new JLabel("By: Stuart Thurston");
      name.setLayout(new BorderLayout());
      name.setFont(name.getFont().deriveFont(20.0f));
      bottom.add(name, BorderLayout.CENTER);
      

      //Add everything to the main panel
      panel.add(gameName, BorderLayout.PAGE_START);
      panel.add(table, BorderLayout.CENTER);
      panel.add(bottom, BorderLayout.PAGE_END);
      
      
      // panel.setBackground(lightPurple);
      
      //Make visible
      this.getContentPane().add(panel);
      pack();
      setVisible(true);
   }
   class exitGame implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {
         System.exit(0);
      }
   }
   
 
     
  class beginGame implements ActionListener
  {    
      public void actionPerformed(ActionEvent e)
      {
         //Create a deck object, and add 52 cards to the deck
         deck = new Deck(); 
         deck.freshDeck();
      
         //This is where the cards from the war will go
         warDeck  = new ArrayList<Card>(); 
      
         //Create two players and shuffel the deck
         p1 = new Player();
         p2 = new Player();
         deck.shuffle();
      
         //Split the deck into two hands
         while (!(deck.isEmpty()))
         {
            p1.addPlay(deck.dealCard());
            p2.addPlay(deck.dealCard());
         }
         
         //Change buttons
         middle.remove(quit);
         middle.remove(startGame);
         middle.add(flip);
         middle.add(quit);
         
         //Add the button to the action listener
         flip.addActionListener(new flipCard());
         
         //Create the headings
         JLabel playerDeck1 = new JLabel("Player 1's Deck: " + p1.totalCards(),SwingConstants.CENTER);
         JLabel playerDeck2 = new JLabel("Player 2's Deck: " + p2.totalCards(),SwingConstants.CENTER);
         JLabel result = new JLabel("Click \"Flip Card\" to start the game",SwingConstants.CENTER);
         result.setFont(result.getFont().deriveFont(13.0f)); //Format the name/winner
         
         //Add the players information to the stats panel
         stats.add(playerDeck1, BorderLayout.WEST);
         stats.add(result, BorderLayout.CENTER);
         stats.add(playerDeck2, BorderLayout.EAST);
         
         //Add the game name and the stats to the top panel
         top.add(gameName, BorderLayout.NORTH);
         top.add(stats, BorderLayout.CENTER);
         
         //Add top to the main panel
         panel.add(top, BorderLayout.PAGE_START);
         
         // playerCard1 = new JLabel();
//          playerCard2 = new JLabel();
         
         pack();
      
      }
      //End
   
   class flipCard implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         ImageIcon y = new ImageIcon("bigImages/2d.jpg");
         JLabel playerCard1 = new JLabel(y);
         JLabel playerCard2 = new JLabel(y);
         
         // table.remove(back);
//          table.remove(back2);
         table.remove(playerCard1);
         table.add(playerCard1);
         
//          table.add(middle);
//          table.add(playerCard2);

         // table.remove(playerCard1);
//          table.remove(playerCard2);
         
         // panel.add(table);
         panel.remove(table);
         
         panel.add(table);
         
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
   
         System.out.println("Player1");
         for(int i=0;i<15;i++)
         {
            System.out.println(p1.flip2());
         }

         System.out.println("Player2");
         System.out.println(p2.flip2());
         System.out.println(p2.flip2());
     






         
         
         pack();         
      }
      
   }//End FlipCard
      
      
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
   }//End Compare
   
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
   }//EndFlipPlay  
      public JLabel displayCardFace(Card card)
      {

	  	String ext = ".jpg";
      String pfx = "bigImages\"";
	  	ImageIcon image = new ImageIcon(pfx + card.toString() + ext);
	  	JLabel label = new JLabel(image);

	  	return label;
	  }
   
   
   public static void main (String[] args)
   {
      War my = new War();
   }
}