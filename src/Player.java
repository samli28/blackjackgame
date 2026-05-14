public class Player {

    public String name;
    public int cardNum;
    public int numPlayer;
    public boolean isDealer = false;
    public Card[] hand;
    public int cardSum = 0;
    public int totalSum = 0;

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
        for(int i = 0; i < cardNum; i++){
            cardSum = hand[i].value;
            hand[i].printCard();
                if (i<hand[i].value){
                    cardSum = hand[i].value+1;
            }
        }
        System.out.println(name + " has a total of: " + cardSum);
    }

    public void printPlayer(){
        System.out.println(name + " 's hand: ");
        for(int i = 0; i < cardNum; i++){
            hand[i].printCard();
        }
    }

    public void sumCards(){
        for(int i = 0; i < cardNum; i++){
            cardSum = hand[i].value+1;
            hand[i].printCard();
        }
        System.out.println(name + " has a total of: " + cardSum);
    }


}
