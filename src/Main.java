public class Main {

    public Card[] deck;

    public static void main(String[] args) {
        Main blackjack = new Main();
        Player player = new Player("Bud",2);
        player.addCard(blackjack.deck[0]);
        player.addCard(blackjack.deck[1]);
        player.printPlayer();
        Player dealer = new Player("Dealer",2);
        player.addCard(blackjack.deck[2]);
        dealer.printPlayer();
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
        shuffle();
        printDeck();
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

}
