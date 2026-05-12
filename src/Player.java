public class Player {

    public String name;
    public int cardNum;
    public int numPlayer;
    public boolean isDealer = false;
    public Card[] hand;
    public int cardSum;

    public Player(String pname,int pnumPlayer){
        name = pname;
        numPlayer = pnumPlayer;
        cardNum = 0;
        hand = new Card[11];
    }

    public void addCard(Card newCard){
        hand[cardNum]= newCard;
        cardNum++;
    }

    public void sumCard(){
        System.out.println(name + " has a total of: " + cardSum);
        for(int i = 0; i < cardNum; i++){
            cardSum = hand[i].value;
            hand[i].printCard();
        }
    }

    public void printPlayer(){
        System.out.println(name + " 's hand: ");
        for(int i = 0; i < cardNum; i++){
            hand[i].printCard();
        }
    }



}
