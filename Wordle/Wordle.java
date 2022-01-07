          /*
          Dylan R.
          Wordle for Terminal
          words.txt file from https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt
          findWord() function from https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt
          */
import java.util.*;
import java.io.*;

public class Wordle {
     public static void main(String[] args) {

          final int LENGTH = 5;
          final int MAX_TRIES = 6;

          Scanner input = new Scanner(System.in);

          String userInput = new String();

          char [] solve = new char[LENGTH];
          char [] userChar = new char[LENGTH];

          char userChoice = 'y';

          int numOfTries = 0;
          int total = 0;
          int wins = 0;
          int losses = 0;
          //int points = 0;

          do{
               numOfTries = 0;
               //Clear terminal screen
               System.out.print("\033[H\033[2J");
               System.out.flush();

               String answer = findWord();

               for (int i = 0; i < LENGTH; i++) {
                    solve[i] = answer.charAt(i);
               }

               System.out.println("\n\t\t\t\t*WORDLE*\n\n\t\t  *Try to guess the 5-letter word*\n\nEnter your own 5-letter word.\n" +
                    "If your letter is in the correct spot as the answer, you will see '1'.\nIf your letter is " +
                    "in the answer word but not in the right spot, you will see '2'.\nIf your letter is not in " +
                    "the answer word, you will see '0'.\n\nYou have six chances to guess the correct word:\n");

               do {
                    System.out.print(numOfTries+1 + ".\t");
                    total = 0;
                    userInput = input.next();

                    for (int i = 0; i < LENGTH; i++) {
                       userChar[i] = userInput.charAt(i);
                    }

                    System.out.print("  \t");
                    for (int i = 0; i < LENGTH; i++) {
                         if (userChar[i] == solve[i]) {
                              System.out.print("1");
                              total++;
                         }
                         else if (userChar[i] == solve[0] || userChar[i] == solve[1] || userChar[i] ==
                                   solve[2] ||userChar[i] == solve[3] || userChar[i] == solve[4]) {
                              System.out.print("2");
                         }
                         else {
                              System.out.print("0");
                         }
                    }
                    System.out.println();
                    numOfTries++;
                    if (total == LENGTH) {
                         System.out.println("\nCONGRATULATIONS! The word was " + answer);
                         wins++;
                    }
               } while (total != LENGTH && numOfTries < MAX_TRIES);

               System.out.println();
               if (total != LENGTH) {
                    System.out.println("\nYOU LOSE! The word was " + answer);
                    losses++;
               }
               System.out.println("Wins: " + wins + " || Losses: " + losses + "\n");
               System.out.print("Play again? (y/n): ");
               userChoice = input.next().charAt(0);
          } while (userChoice != 'n');
     }
//       Function to find the word to be solved:
     public static String findWord() {
          try {
               BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
               String line = reader.readLine();
               List<String> words = new ArrayList<String>();
               while (line != null) {
                  String[] wordsLine = line.split(" ");
                  for (String word : wordsLine) {
                      words.add(word);
                  }
                  line = reader.readLine();
               }
          Random rand = new Random(System.currentTimeMillis());
          String randomWord = words.get(rand.nextInt(words.size()));
          //System.out.println(randomWord);                           //displays answer word
               return randomWord;
          } catch (Exception e) {
          // Handle this
               return "0";
          }
     }
}
