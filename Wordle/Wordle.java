          /*
          Dylan R
          Wordle you can play all the time
          1.5.22 *updated 1.6.22*
          */
import java.util.*;
import java.io.*;

public class Wordle {
     public static void main(String[] args) {

          final int LENGTH = 5;
          final int MAX_TRIES = 6;
          Scanner input = new Scanner(System.in);
          String userInput = new String();
          int numOfTries = 0;
          char [] solve = new char[LENGTH];
          int total = 0;
          //Clear terminal screen
          System.out.print("\033[H\033[2J");
          System.out.flush();

          String answer = findWord();

          for (int i = 0; i < LENGTH; i++) {
               solve[i] = answer.charAt(i);
          }

          System.out.println("Enter a 5 letter word. If the letter is in the correct spot, print 1." +
          "\nIf the letter is in the word but not the right spot, print 2." +
          "\nIf the letter is not in the word, print 0." +
          "\n\nYOU HAVE SIX (6) CHANCES!\n");

          do {
               System.out.print(numOfTries+1 + ".\t");
               total = 0;
               userInput = new String();
               userInput = input.next();
               char [] userChar = new char[LENGTH];
               for (int i = 0; i < LENGTH; i++) {
                  userChar[i] = userInput.charAt(i);
               }
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
                    return;
               }
          } while (total != LENGTH && numOfTries < MAX_TRIES);

          System.out.println();
          if (total != LENGTH) {
               System.out.println("\nYOU LOSE! The word was " + answer);
               return;
          }
     }
/*       Function to find the word to be solved. */
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
          //System.out.println(randomWord);
               return randomWord;
          } catch (Exception e) {
          // Handle this
               return "0";
          }
     }
}
