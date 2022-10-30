package u3pp;
import u3pp.Deck;
import java.util.Scanner;

import javax.security.auth.callback.TextOutputCallback;

import org.w3c.dom.UserDataHandler;
public class Blackjack {

    Scanner scanner = new Scanner(System.in);
    Deck b; 
    Card[] userHand;
    Card[] dealerHand;
    public Blackjack(){
         this.b = new Deck();
    }   
    
    public static int calcPoints(Card[] hand){
        int points = 0;
        for (Card c : hand) {
          if (c.getValue().equals("King") || c.getValue().equals("Queen") || c.getValue().equals("Jack")) {
            points += 10;
          } else if (c.getValue().equals("Ace")) {
            points += 11;
          } else {
            points += Integer.parseInt(c.getValue()); 
          }
        }

        
        return points;

    }

    public static boolean isBust(Card[] hand) {
        int totalPoints = Blackjack.calcPoints(hand); 
        if (totalPoints > 21) {
            return true;
        }
        else {
            return false;
    }
    }


    public static boolean isBlackjack(Card[] hand) {
        int totalPoints = Blackjack.calcPoints(hand);
        if (totalPoints == 21 && hand.length == 2){
            return true;
        
        } 
        else {
            return false;
        }
    }



    public static boolean shouldDealerKeepHitting(Card[] hand){
        int totalPoints = Blackjack.calcPoints(hand);
        if (totalPoints <= 16) {
            return true;
        }
        else{
            return false;
        }
    }


    public static String determineResult(Card[] userHand, Card[] dealerHand){
        int userPoint = Blackjack.calcPoints(userHand);
        int dealerPoint = Blackjack.calcPoints(dealerHand);
        if (isBust(userHand)){
            return "User Loses";
        }
        else if (isBust(dealerHand)){
            return "User Wins";
        }

        if (userPoint > dealerPoint) {
            return "User Wins"; 
        }
        else if ( userPoint == dealerPoint){
            return "User Pushes";
        }
        else {
            return "User Loses";
        }
    }

    public void play(Scanner scanner) {
        System.out.println("Welcome to BlackJack, Start game? Y/N");
        String userInput = scanner.next(); 
        Boolean answer = userInput.equals("Y") || userInput.equals("y");

        if (answer) {
        System.out.println ("Starting Game");
        }
        else {
            System.out.println ("Goodbye");
            return;
        }
        

    while(true){ 
        System.out.println("=====================");
        
        this.initRound();
        if (isBlackjack(userHand)) { 
            System.out.println("BlackJack");
            continue;
        }
        if (isBlackjack(dealerHand)){ 
            System.out.println("You lose");
            continue;
        }
        // Step 1: User's turn 
        while (!isBust(userHand)) {
            System.out.println ("Do you want to Hit?  Y|N");
            userInput = scanner.next();
            Boolean answerInGame = userInput.equals("Y") || userInput.equals("y");
            if (answerInGame) {
                this.userHand = this.deal(this.userHand);
                Boolean bustedUser = Blackjack.isBust(this.userHand); 

                if (bustedUser) { 
                    continue;
                }
            } else {
                // if user selected "no" to hitting
                break;
            }
        }
        Boolean bustedUser = Blackjack.isBust(this.userHand); 

        if (bustedUser) { 
            System.out.println ("Busted, total point: " + calcPoints(userHand));
            continue;
        }
        // Step 2: Dealers' turn

        System.out.println("Dealer's turn: ");
        while (Blackjack.shouldDealerKeepHitting(dealerHand)) {
            dealerHand = this.deal(dealerHand);
        } 
        Boolean bustedDealer = Blackjack.isBust(this.dealerHand);
        if (bustedDealer) { 
            System.out.println("Dealer has busted, User wins. Dealer points: " + calcPoints(dealerHand));
            continue;
        }
        String result = determineResult(userHand, dealerHand);
        System.out.println("Result: " + result + " User points are: " + calcPoints(userHand) + " Dealer points are: " + calcPoints(dealerHand));
        continue;    
    }
    }
    private void initRound() { 
        userHand = new Card[2];
        dealerHand = new Card[2];
        userHand[0] = this.b.deal();
        dealerHand[0] = this.b.deal();
        userHand[1] = this.b.deal();
        dealerHand[1] = this.b.deal();
        
        System.out.println("User has: " + userHand[0].toString() + " and " + userHand[1].toString() + " Total points are: " + Blackjack.calcPoints(userHand));
        System.out.println("Dealer has: " + dealerHand[0].toString() + " and the rest are hidden");
    }
    private Card[] deal (Card[] hand) {
        if (this.b.dealt >= 52){ 
            System.out.println ("~~~~~~~~~~~~~~~~~~~~~");
            System.out.println ("Reshuffling cards");
            System.out.println ("~~~~~~~~~~~~~~~~~~~~~");
            this.b.shuffle();
        }
        Card newCard = this.b.deal();
        Card[] newHand = new Card[hand.length + 1];
        for (int i = 0; i < hand.length; i++) {
          newHand[i] = hand[i];
        }
        newHand[hand.length] = newCard;
        return newHand;
      }
    // while (true) {
    //     // ask user if wants to hit
    //     // if yes, deal one more card to user, check if busted 
    //     // dealer to deal until reach 16 points, check if dealer busted
    //     // compare results 
    //   }

    // while (true) {
    //     days += 1;
    //     Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    //     System.out.println("Day " + days + " | Enter Raid? Y/N");
        
    //     String userInput = myObj.next(); 
    //     Boolean enterRaid = userInput.equals("Y") || userInput.equals("y");
        
    //     if (enterRaid){
    //         System.out.println("Commencing Raid"); 
    //         raid(myWater, myFood, myMaterial);
    //     } 
    //     else {
    //         System.out.println("Sitting at home");
    //         continue;
    //     }


}


// public void play(Scanner scanner): The method to be called to actually play a game. This is where you implement the flow of the Gameplay. The output should clearly communicate what is happening - cards dealt, comparisons made, etc






// For Part C you are going to use your newly made Deck to create a basic version of the game Blackjack.

// Simplified Blackjack Gameplay
// Skip to the TLDR if you already know how blackjack works.

// Full Explanation
// The goal of the game is to get as close as possible to 21 points without going over. [2-10] are 
//worth their face value as points, [Jack, Queen, King] are worth 10 points. In our simplified version of 
//the game, [Ace] is worth 11 points.

// There are two Players, the User and the Dealer. Each are dealt two Cards, alternating with the User getting 
//the first Card dealt.

// If either Player scores 21 points in the opening hand, the game is over because they have scored a Blackjack. If both Players score a Blackjack, the game ends in a Push or tie.

// If neither Player has Blackjack, then the User gets to choose to Hit or Stay. If they choose to Hit they are dealt another Card from the top of the Deck. If the new Card makes their points go over 21, they Bust and the game ends in their defeat. If they have 21 or less, they are prompted again to Hit or Stay. This continues until either the User Busts or Stays.

// If the User Stays, the Dealer now must Hit until their score is greater than or equal to 17, or they Bust. If they Bust the game is over and the User wins. Otherwise, if their score is 17 or higher, the Cards are revealed.

// When the Cards are revealed, the User and the Dealer's scores are compared. Whoever has the higher score wins. In the case of a tie, the game ends in a Push.

// When the game ends, be sure to print the result Blackjack, Bust, Win, Lose, or Push. Then, prompt the User to play again. If they select yes, do not shuffle the Deck and start over. If not, thank them for their time and end the program. Only shuffle the Deck if the Deck runs out of Cards during gameplay.

// TLDR Simplified rules
// Normal blackjack rules, except aces are always worth 11 points. See Sample Run below.

// PART C Required Methods
// [X] public Blackjack(): This should instantiate any instance variables you have, especially your Deck.
// public void play(Scanner scanner): The method to be called to actually play a game. This is where you implement the flow of the Gameplay. The output should clearly communicate what is happening - cards dealt, comparisons made, etc.
// [X] public static int calcPoints(Card[] hand): This helper method takes an array of Cards and returns the amount of points that hand is worth. Post condition: the parameter should remain unaltered.
// [X] public static String determineResult(Card[] userHand, Card[] dealerHand): Returns a String in one of the following formats: "User Wins", "User Loses", or "User Pushes". Does not alter parameters.
// [X] public static boolean isBust(Card[] hand): returns true if the hand is a Bust, false otherwise. Does not alter parameters.
// [X] public static boolean isBlackjack(Card[] hand): returns true if the hand is a Blackjack, false otherwise. Remember, it is only a blackjack in the opening hand (2 card hand). Does not alter parameters.
// [X] public static boolean shouldDealerKeepHitting(Card[] hand): return true if the dealer should keep hitting (score of hand is 16 or less), false otherwise. Does not alter parameters.
// You may include any other private methods and instance variables you think applicable. You should have nothing else that is public other than what is listed above.

// Part C Other Requirements
// User experience (UX) must be very clear. You might, for the sake of clarity, have extra pauses in gameplay so the player does not get lost.
// Must print the outcome of the game: Blackjack, Win, Lose, or Push
// Regularly print the state of the user hand, the state of the dealer hand, and the state of the deck.
// Your game should account for bad input. Bad input should not break the game.
// Finish your main method Make a Scanner, and call Blackjack's play method with it.
// Must not shuffle the deck between games. Only shuffle when we would deal a card when the deck is empty.