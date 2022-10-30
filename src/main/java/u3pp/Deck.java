package u3pp;
import u3pp.Card;
import java.util.Arrays;
import java.util.Random;
public class Deck {

    Card[] deck = new Card[52]; 
    int dealt = 0;

    public Deck() {

        for (int i = 0; i < 4; i++){
            String suit = Card.SUITS[i];

            for (int j = 0; j < 13; j++){
                String value = Card.VALUES[j];
                deck[this.dealt] = new Card(suit, value); 
                this.dealt++; 
            }
        }

        this.shuffle();
  
    }
    public int numLeft() {
        return 52 - this.dealt;


}
    public Card deal() {
        Card c = this.deck [this.dealt];
        this.dealt++;
        System.out.println (c.toString());
        return c;
}
    public void shuffle() {
        this.dealt = 0;
        Random rand = new Random();
		
		for (int i = 0; i < deck.length; i++) {
			int randomIndexToSwap = rand.nextInt(deck.length);
			Card temp = deck[randomIndexToSwap];
			deck[randomIndexToSwap] = deck[i];
			deck[i] = temp;
		}
}









}


// A Card class has been provided for you in this project. (Read the file - it has many useful attributes & methods) You will use the Cards to create a Deck. A Deck contains 52 unique Cards. The potential values are [2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace] and the potential suits are [Clubs, Spades, Diamonds, Hearts].

// Your Deck class must include the following:

// PART B Required Methods
// public Deck(): Default constructor. Creates 52 unique Cards
// public int numLeft(): Returns how many cards have not been dealt in the Deck
// public Card deal(): Takes a card off the "top" of the Deck and returns it.
// public void shuffle(): Restores the Deck to "full" and randomizes the order of the Cards to be dealt
// You may include any other private methods and instance variables you think applicable. You should have nothing else that is public other than what is listed above.