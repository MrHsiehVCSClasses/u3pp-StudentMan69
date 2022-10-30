package u3pp;

public class Blackjack {
    
}







// For Part C you are going to use your newly made Deck to create a basic version of the game Blackjack.

// Simplified Blackjack Gameplay
// Skip to the TLDR if you already know how blackjack works.

// Full Explanation
// The goal of the game is to get as close as possible to 21 points without going over. [2-10] are worth their face value as points, [Jack, Queen, King] are worth 10 points. In our simplified version of the game, [Ace] is worth 11 points.

// There are two Players, the User and the Dealer. Each are dealt two Cards, alternating with the User getting the first Card dealt.

// If either Player scores 21 points in the opening hand, the game is over because they have scored a Blackjack. If both Players score a Blackjack, the game ends in a Push or tie.

// If neither Player has Blackjack, then the User gets to choose to Hit or Stay. If they choose to Hit they are dealt another Card from the top of the Deck. If the new Card makes their points go over 21, they Bust and the game ends in their defeat. If they have 21 or less, they are prompted again to Hit or Stay. This continues until either the User Busts or Stays.

// If the User Stays, the Dealer now must Hit until their score is greater than or equal to 17, or they Bust. If they Bust the game is over and the User wins. Otherwise, if their score is 17 or higher, the Cards are revealed.

// When the Cards are revealed, the User and the Dealer's scores are compared. Whoever has the higher score wins. In the case of a tie, the game ends in a Push.

// When the game ends, be sure to print the result Blackjack, Bust, Win, Lose, or Push. Then, prompt the User to play again. If they select yes, do not shuffle the Deck and start over. If not, thank them for their time and end the program. Only shuffle the Deck if the Deck runs out of Cards during gameplay.

// TLDR Simplified rules
// Normal blackjack rules, except aces are always worth 11 points. See Sample Run below.

// PART C Required Methods
// public Blackjack(): This should instantiate any instance variables you have, especially your Deck.
// public void play(Scanner scanner): The method to be called to actually play a game. This is where you implement the flow of the Gameplay. The output should clearly communicate what is happening - cards dealt, comparisons made, etc.
// public static int calcPoints(Card[] hand): This helper method takes an array of Cards and returns the amount of points that hand is worth. Post condition: the parameter should remain unaltered.
// public static String determineResult(Card[] userHand, Card[] dealerHand): Returns a String in one of the following formats: "User Wins", "User Loses", or "User Pushes". Does not alter parameters.
// public static boolean isBust(Card[] hand): returns true if the hand is a Bust, false otherwise. Does not alter parameters.
// public static boolean isBlackjack(Card[] hand): returns true if the hand is a Blackjack, false otherwise. Remember, it is only a blackjack in the opening hand (2 card hand). Does not alter parameters.
// public static boolean shouldDealerKeepHitting(Card[] hand): return true if the dealer should keep hitting (score of hand is 16 or less), false otherwise. Does not alter parameters.
// You may include any other private methods and instance variables you think applicable. You should have nothing else that is public other than what is listed above.

// Part C Other Requirements
// User experience (UX) must be very clear. You might, for the sake of clarity, have extra pauses in gameplay so the player does not get lost.
// Must print the outcome of the game: Blackjack, Win, Lose, or Push
// Regularly print the state of the user hand, the state of the dealer hand, and the state of the deck.
// Your game should account for bad input. Bad input should not break the game.
// Finish your main method Make a Scanner, and call Blackjack's play method with it.
// Must not shuffle the deck between games. Only shuffle when we would deal a card when the deck is empty.