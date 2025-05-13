import java.util.ArrayList;
import java.util.Collections;

public class Blackjack {
   private class Card {
       private String value;
       private String suit;

       public Card(String value, String suit) {
           this.value = value;
           this.suit = suit;
       }

       public boolean isAce(){
           return this.value.equals("A");
       }

       public int getValue() {
           if ("KQJ".contains(value)){
               return 10;
           }
           else if (value.equals("A")){
               return 11;
           }
           return Integer.parseInt(this.value);
       }

       public String getSuit() {
           return suit;
       }

       @Override
       public String toString() {
           return String.format("%s-%s", this.value, this.suit);
       }
   }

   private ArrayList<Card> deck;

   //dealer stuff
   Card hiddenCard;
   ArrayList<Card> dealerHand;
   int dealerSum;
   int dealerAceCount;

   public Blackjack() {
       startGame();
   }

   public void startGame(){
        buildDeck();
        shuffle();

        //dealer
       dealerHand = new ArrayList<Card>();
       dealerSum = 0;
       dealerAceCount = 0;

       hiddenCard = deck.removeLast();
       dealerSum += hiddenCard.getValue();
       dealerAceCount += hiddenCard.isAce() ? 1:0;

       Card card = deck.removeLast();
       dealerSum += card.getValue();
       dealerAceCount += card.isAce() ? 1:0;

       dealerHand.add(card);

       System.out.println("Dealer hand: ");
       System.out.println(hiddenCard);
       System.out.println(dealerHand);
       System.out.println(dealerSum);
       System.out.println(dealerAceCount);

       //player stuff
   }

   public void buildDeck() {
       deck = new ArrayList<Card>();
       String [] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
       String [] suits = {"C", "D", "H", "S"};

       for (String suit : suits) {
           for (String value : values) {
               Card c = new Card(value, suit);
               deck.add(c);
           }
       }
       System.out.println("Build Deck: ");
       System.out.println(deck);
   }

   public void shuffle() {
       Collections.shuffle(deck);

       System.out.println("Shuffling Deck: ");
       System.out.println(deck);
   }

}
