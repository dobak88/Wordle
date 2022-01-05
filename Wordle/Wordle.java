          /*
          Dylan Rossi
          Wordle you can play all the time
          1.5.22
          */
import java.util.*;
import java.io.*;

public class Wordle{
     public static void main(String[] args){

          Scanner input = new Scanner(System.in);
          char [] solve = new char[5];
          int total = 0;
          String answer = findWord();
          for (int i = 0; i < 5; i++){
               solve[i] = answer.charAt(i);
          }

          /* Print answer word
          for (int i = 0; i < 5; i++){
               System.out.println(solve[i]);
          }
          */
          /*Finds the word to be solved, breaks down into characters*/
               System.out.println("Enter a 5 letter word. If the letter is in the correct spot, print 1." +
               "\nIf the letter is in the word but not the right spot, print 2." +
               "\nIf the letter is not in the word, print 0." +
               "\nYOU HAVE FIVE CHANCES!\n");

               String userInput = new String();
               userInput = input.next();
               char [] userChar = new char[5];
               for (int i = 0; i < 5; i++) {
                  userChar[i] = userInput.charAt(i);
              }

               for (int i = 0; i < 5; i++){
                    if (userChar[i] == solve[i]){
                         System.out.print("1 ");
                         total++;
                    }
                    else if (userChar[i] == solve[0] || userChar[i] == solve[1] ||
                         userChar[i] == solve[2] || userChar[i] == solve[3] || userChar[i] == solve[4]){
                         System.out.print("2 ");
                    }
                    else
                         {System.out.print("0 ");
                    }
               }

          if (total == 5){System.out.println("\nCONGRATULATIONS! The word was " + answer);return;}

          System.out.println();
          if (total != 5){
               total = 0;
               userInput = new String();
               userInput = input.next();
               userChar = new char[5];
               for (int i = 0; i < 5; i++) {
                  userChar[i] = userInput.charAt(i);
              }

               for (int i = 0; i < 5; i++){
                    if (userChar[i] == solve[i]){
                         System.out.print("1 ");
                         total++;
                    }
                    else if (userChar[i] == solve[0] || userChar[i] == solve[1] ||
                         userChar[i] == solve[2] || userChar[i] == solve[3] || userChar[i] == solve[4]){
                         System.out.print("2 ");
                    }
                    else
                         {System.out.print("0 ");
                    }
               }
          }

          if (total == 5){System.out.println("\nCONGRATULATIONS! The word was " + answer);return;}

          System.out.println();
          if (total != 5){
               total = 0;
               userInput = new String();
               userInput = input.next();
               userChar = new char[5];
               for (int i = 0; i < 5; i++) {
                  userChar[i] = userInput.charAt(i);
              }

               for (int i = 0; i < 5; i++){
                    if (userChar[i] == solve[i]){
                         System.out.print("1 ");
                         total++;
                    }
                    else if (userChar[i] == solve[0] || userChar[i] == solve[1] ||
                         userChar[i] == solve[2] || userChar[i] == solve[3] || userChar[i] == solve[4]){
                         System.out.print("2 ");
                    }
                    else
                         {System.out.print("0 ");
                    }
               }
          }
          if (total == 5){System.out.println("\nCONGRATULATIONS! The word was " + answer);return;}
          System.out.println();
          if (total != 5){
               total = 0;
               userInput = new String();
               userInput = input.next();
               userChar = new char[5];
               for (int i = 0; i < 5; i++) {
                  userChar[i] = userInput.charAt(i);
              }

               for (int i = 0; i < 5; i++){
                    if (userChar[i] == solve[i]){
                         System.out.print("1 ");
                         total++;
                    }
                    else if (userChar[i] == solve[0] || userChar[i] == solve[1] ||
                         userChar[i] == solve[2] || userChar[i] == solve[3] || userChar[i] == solve[4]){
                         System.out.print("2 ");
                    }
                    else
                         {System.out.print("0 ");
                    }
               }
          }
          if (total == 5){System.out.println("\nCONGRATULATIONS! The word was " + answer);return;}
          System.out.println();
          if (total != 5){
               total = 0;
               userInput = new String();
               userInput = input.next();
               userChar = new char[5];
               for (int i = 0; i < 5; i++) {
                  userChar[i] = userInput.charAt(i);
              }

               for (int i = 0; i < 5; i++){
                    if (userChar[i] == solve[i]){
                         System.out.print("1 ");
                         total++;
                    }
                    else if (userChar[i] == solve[0] || userChar[i] == solve[1] ||
                         userChar[i] == solve[2] || userChar[i] == solve[3] || userChar[i] == solve[4]){
                         System.out.print("2 ");
                    }
                    else
                         {System.out.print("0 ");
                    }
               }
          }
          System.out.println();
     if (total == 5){System.out.println("\nCONGRATULATIONS! The word was " + answer);return;}
     else {System.out.println("\nYOU LOSE! The word was " + answer);return;}
     }




/*       Function to find the word to be solved. NOT MY CODE, FOUND ONLINE*/
     public static String findWord(){
          try{
               BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
               String line = reader.readLine();
               List<String> words = new ArrayList<String>();
               while(line != null) {
                  String[] wordsLine = line.split(" ");
                  for(String word : wordsLine) {
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
/*     The above finds a word from the list and prints it out */
     }
}
