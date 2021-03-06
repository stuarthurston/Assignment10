////////////////////////////////////////////////////////////////////////////////////////////////
//Stuart Thurston                                                                            ///
//CS 110                                                                                     ///
//Assignment 10  -- 4/28/14                                                                  ///
//WarGame - War                                                                              ///
//This creates a GUI to play WAR. Has methods to flip cards, as well as display the correct  ///
//results and the winner                                                                     ///
////////////////////////////////////////////////////////////////////////////////////////////////
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
      private JButton again = new JButton("Play Again");
      
      //Panels
      private JPanel panel = new JPanel(new BorderLayout(40,10)); //Holds everything
      private JPanel top = new JPanel(new BorderLayout(10,10)); //Hold name and stats
      private JPanel gameName = new JPanel(new BorderLayout()); //Name
      private JPanel stats = new JPanel(new BorderLayout()); // Score, and results
      private JPanel middle = new JPanel(new GridLayout(2,1,5,5)); //This has the buttons
      private JPanel table = new JPanel(new GridLayout(1,3,25,25)); //Cards and middle, center
      private JPanel bottom = new JPanel(new GridLayout(1,3,30,30)); //My Name
      
      //Labels
      private JLabel playerDeck1;
      private JLabel playerDeck2;
      private JLabel result;
      private JLabel name;
      private JLabel welcome;
      
      //The background color
      private Color lightPurple = new Color(206,0,113);
      
      //Deck of cards
      private Deck deck;
      private ArrayList<Card> warDeck;
      
      //Player
      private Player p1,p2;
      
      //Card
      private Card player1,player2;
      
      //Card Images
      private ImageIcon cardback = new ImageIcon("bigImages/back.jpg");
      private JLabel back = new JLabel(cardback);
      private JLabel back2 = new JLabel(cardback);
      private JLabel cardImage;
      private JLabel playerCard1;
      private JLabel playerCard2;
      
      //GAME OVER SWITCH
      private boolean end = false;
      
      //Height and Width of the overall frame
      private final int WINDOW_WIDTH = 400;
      private final int WINDOW_HEIGHT = 300;
   
   
   
   
   /**
      Constructor
      Create the initial interface, buttons to start the game
   */
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
      welcome = new JLabel("The Game of War",SwingConstants.CENTER);
      welcome.setLayout(new BorderLayout());
      welcome.setFont(welcome.getFont().deriveFont(40.0f));
      gameName.add(welcome);
      gameName.setBorder(BorderFactory.createLineBorder(Color.black));
      
      //Create my name
      name = new JLabel("By: Stuart Thurston");
      name.setLayout(new BorderLayout());
      name.setFont(name.getFont().deriveFont(20.0f));
      bottom.add(name, BorderLayout.CENTER);
      

      //Add everything to the main panel
      panel.add(gameName, BorderLayout.PAGE_START);
      panel.add(table, BorderLayout.CENTER);
      panel.add(bottom, BorderLayout.PAGE_END);

      //Make visible
      this.getContentPane().add(panel);
      pack();
      setVisible(true);
   }//End War




   /**
      ActionListener
      Exit the program
   */
   class exitGame implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {
         System.exit(0);
      }
   }
   
   
   
   
   /**
      ActionListener
      resetGame. Restart the game, remove everything, and add it back
   */ 
   class resetGame implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {
         War.this.dispose();
         new War();
      }
   }    
  
  
  
  
  /**
      ActionListener
      Create a Deck and two new players, change the buttons to flip/quit
  */ 
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
         playerDeck1 = new JLabel("Player 1's Deck: " + p1.totalCards(),SwingConstants.CENTER);
         playerDeck2 = new JLabel("Player 2's Deck: " + p2.totalCards(),SwingConstants.CENTER);
         result = new JLabel("Click \"Flip Card\" to start the game",SwingConstants.CENTER);
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
         
         playerCard1 = new JLabel();
         playerCard2 = new JLabel();
         
         
         pack();
      }      
   }//End Begin
   
   
   
   
   /**
      ActionListener
      play the game. Make the cards in the GUI represent the cards that are being
      flipped and compared. If there is a winner, change the GUI to represent that.
  */
   class flipCard implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //Remove the two players cards
         table.remove(playerCard1);
         table.remove(playerCard2);
         
         //Remove the two card Backs
         table.remove(back);
         table.remove(back2);
         
         //Make sure neither player has no cards left
         if(p1.totalCards() == 0)
         {
            stats.remove(result);
            result = new JLabel("PLAYER 2 WINS",SwingConstants.CENTER);
            result.setFont(result.getFont().deriveFont(25.0f)); //Format the name/winner
            
            //Remove things from the panel
            table.remove(playerCard1);
            table.remove(middle);
            table.remove(playerCard2);
            top.remove(stats);
            table.add(result);
            table.setBackground(lightPurple);
            
            
            //Add the items back into the bottom
            bottom.add(again, BorderLayout.CENTER);
            again.addActionListener(new resetGame()); //Connect the button to the action
            bottom.add(name, BorderLayout.WEST);
            bottom.add(quit, BorderLayout.EAST);
            
            //Add the bottom section back into the panel
            panel.add(bottom, BorderLayout.PAGE_END);
            pack();
            end = true;  
         }
         if(p2.totalCards() == 0)
         {
            stats.remove(result);
            result = new JLabel("PLAYER 1 WINS",SwingConstants.CENTER);
            result.setFont(result.getFont().deriveFont(25.0f)); //Format the name/winner 
            
            //Remove things from the panel
            table.remove(playerCard1);
            table.remove(middle);
            table.remove(playerCard2);
            top.remove(stats);
            table.add(result);
            table.setBackground(lightPurple);
            
            //Add the items back into the bottom
            bottom.add(again, BorderLayout.CENTER);
            again.addActionListener(new resetGame()); 
            
            //Add the items back into the bottom
            bottom.add(again, BorderLayout.CENTER);
            bottom.add(name, BorderLayout.WEST);
            bottom.add(quit, BorderLayout.EAST);
            
            //Add the bottom section back into the panel
            panel.add(bottom, BorderLayout.PAGE_END);
            pack();
            end = true;
         }
         
         if(!end) //if end is true, there is a winner
         {
            //Only run if both players still have cards
            if(!(p1.totalCards() == 0) && (!(p2.totalCards() == 0)))
            {
               //Display the card that is being compared (played)
               player1 = p1.getTopCard();
               player2 = p2.getTopCard();
               playerCard1 = displayCardFace(player1);
      	      playerCard2 = displayCardFace(player2);
            }
            
            //Add items back to table
            table.add(playerCard1);
            table.add(middle);
            table.add(playerCard2);
         
            //PLAY WAR
            flipPlay(p1,p2,warDeck); //This is what makes eveything happen
   
            //Remove the 'stats' from the frame
            stats.remove(playerDeck1);
            stats.remove(playerDeck2);
            
            //Create two new cards
            playerDeck1 = new JLabel("Player 1's Deck: " + p1.totalCards(),SwingConstants.CENTER);
            playerDeck2 = new JLabel("Player 2's Deck: " + p2.totalCards(),SwingConstants.CENTER);
            
            //Add the elements to 'stats'
            stats.add(playerDeck1, BorderLayout.WEST);
            stats.add(result, BorderLayout.CENTER);
            stats.add(playerDeck2, BorderLayout.EAST);
            
            //Add 'stats' into the top panel, top into main
            top.add(stats, BorderLayout.CENTER);
            panel.add(top, BorderLayout.PAGE_START);
            
            pack(); 
         }              
      }
      
   }//End FlipCard
   



   /**
      compare
      Use the player flipCard methods to access the cards in the decks
      compare them, and update the decks accordingly. Update the result with the winner
      @param pl1 Player 1, all access to the decks
      @param pl2 Player 2, allow access to the decks
      @param warDeck the deck that is used to deal with the wars
   */
   public  void compare(Player pl1, Player pl2, ArrayList<Card> warDeck) //Compare two cards, return array List
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
        
         //Display the winner
         stats.remove(result);
         result = new JLabel("Winner: Player 1",SwingConstants.CENTER);
         result.setFont(result.getFont().deriveFont(13.0f)); //Format the name/winner
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
         
         //Display the winner
         stats.remove(result);
         result = new JLabel("Winner: Player 2",SwingConstants.CENTER);
         result.setFont(result.getFont().deriveFont(13.0f)); //Format the name/winner 
      }
      
      else if(card1.getRank() == card2.getRank())
      {
         warDeck.add(card1);
         warDeck.add(card2);
         warDeck.add(pl1.flip());
         warDeck.add(pl2.flip());
//          warDeck.add(pl1.flip());    THIS GAME WOULD BE 
//          warDeck.add(pl2.flip());    BETTER IF WE WERE
//          warDeck.add(pl1.flip());    ABLE TO ADD 3 CARDS
//          warDeck.add(pl2.flip());    FOR A WAR
         
         //Display the winner
         stats.remove(result);
         result = new JLabel("War!!!",SwingConstants.CENTER);
         result.setFont(result.getFont().deriveFont(13.0f)); //Format the name/winner

      }    
   }//End Compare
   
   
   
   
   /**
      flipPlay
      Check to make sure the decks aren't empty, if they are, move the cards
      and then call the compare method
      @param p1 Player 1, all access to the decks
      @param p2 Player 2, allow access to the decks
      @param warDeck the deck that is used to deal with the wars
   */
   public void flipPlay(Player p1, Player p2, ArrayList<Card> warDeck)
   {
         if(p1.getPlayDeck() == 0)
         {
            p1.moveCards();
         }
         
         if(p2.getPlayDeck() == 0)
         {
            p2.moveCards();
         }
         
         //Do not run if either player is out of cards
         if(!(p1.totalCards() == 0) && (!(p2.totalCards() == 0)))
         {
            compare(p1,p2,warDeck); 
         }
        
   }//EndFlipPlay  
   
   
   
   
   /**
      displayCardFace
      Get the name of the card, and match with the correct image.
      Add the image to a JLable, and return
      @param card A card object
      @return label JLable, with the card icon.
   */
   public JLabel displayCardFace(Card card)
   {
	  	String ext = ".jpg";
      String pfx = "bigImages\\";
	  	ImageIcon image = new ImageIcon(pfx + card.toString() + ext);
	  	JLabel label = new JLabel(image);

	  	return label;
	  }
   
   
   
   
   /**
      war
      Create and run a new instance of the War class, main method
   */
   public static void main (String[] args)
   {
      War my = new War();
   }
}