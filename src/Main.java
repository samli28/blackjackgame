import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;


public class Main {

    Image backgroundImg;
    public Card[] deck;

    public JFrame frame;
    public Canvas canvas;
    public BufferStrategy bufferStrategy;
    public JPanel panel;

    public static void main(String[] args) {
        Main blackjack = new Main();
        Player player = new Player("Bud",2);
        player.addCard(blackjack.deck[0]);
        player.addCard(blackjack.deck[1]);
        player.printPlayer();
        Player dealer = new Player("Dealer",2);
        dealer.addCard(blackjack.deck[2]);
        dealer.printPlayer();
    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(800, 600));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0,800,600);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    public Main() {
        deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            if (i < 13) {
                deck[i] = new Card(i, "Spades", false);
            } else if (i < 26) {
                deck[i] = new Card(i%13, "Diamonds", false);
            } else if (i < 39) {
                deck[i] = new Card(i%13, "Hearts", false);
            } else if (i < 52) {
                deck[i] = new Card(i%13, "Clubs", false);
            }
        }
        backgroundImg = new ImageIcon("background.jpg").getImage();
        shuffle();
        printDeck();
        setUpGraphics();
        render();
    }

    public void printDeck(){
        System.out.println("This deck contains");
        for (int i = 0; i < deck.length; i++) {
            deck[i].printCard();
        }
    }

    public void shuffle(){
        for (int i = 0; i < deck.length; i++){
            int randNum = (int) (Math.random() * 52);
            Card holdCard = deck[randNum];
            deck[randNum] = deck[i];
            deck[i] = holdCard;
        }
    }
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,800,600);
        g.drawImage(backgroundImg, 0, 0, 800,600, null);
        g.dispose();
        bufferStrategy.show();
    }
}
