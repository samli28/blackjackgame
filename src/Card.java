public class Card {

    public int value;
    public String suit;
    public boolean isUp;

//    public static void main(String[] args) {
//        Card card = new Card();
//    }

    public Card(int pvalue, String psuit, boolean pisUp){
        value = pvalue;
        suit = psuit;
        isUp = pisUp;
    }

    public void printCard() {
        if (value == 0) {
            System.out.println("The Ace of " + suit);
        } else if (value == 10) {
            System.out.println("Jack of " + suit);
        } else if (value == 11) {
            System.out.println("Queen of " + suit);
        } else if (value == 12) {
            System.out.println("King of " + suit);
        } else {
            System.out.println((value + 1) + " of " + suit);
        }
    }
}