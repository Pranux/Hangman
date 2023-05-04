import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        try
        {
            String word1 = FileManager.readFile();
            check(word);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static boolean errorCheck(char[] alphabet, char letter)
    {
        int a = 0;
        for(int i = 0; i < 26; i++)
        {
            if(letter == alphabet[i])
            {
                a++;
            }
        }
        if(letter < 65 || letter > 122 || (letter > 90 && letter < 97))
        {
            System.out.println("PLEASE ENTER LETTER FROM ENGLISH ALPHABET");
            return true;
        }
        else if(a == 0)
        {
            System.out.println("YOU ALREADY TRIED THAT LETTER");
            return true;
        }
        return false;
    }

    static void check(String word)
    {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Scanner obj = new Scanner(System.in);
        boolean gameOver = false;
        int tryNum = 0;
        char[] soFar = word.toCharArray(); // so far established word

        //there is the same amount of '-' as there is letters in a word
        System.out.println(" ");
        System.out.println("THIS IS AN EASY GAME OF HANGMAN... WITHOUT HANGMAN. IF YOU WANT TO GIVE UP, ENTER '0'. GOOD LUCK! ");
        System.out.print("So far the word is: ");
        for (int i = 0; i < word.length(); i++)
        {
            System.out.print("-");
            soFar[i] = '-';
        }

        while(!gameOver) {
            tryNum++; //number of tries
            System.out.println(" ");
            System.out.print("Left unused letters: ");

            for (int i = 0; i < 26; i++) {
                System.out.print(alphabet[i]);
                if (i != 25) {
                    System.out.print("; ");
                }
            }

            System.out.println(" ");
            System.out.print("Try number #" + tryNum);

            System.out.println(" ");
            System.out.print("Enter letter: ");
            char letter = obj.next().charAt(0);

            //if user used upper case letter, they are treated as lower case
            if ((letter >= 65 && letter <= 90)) {
                letter += 32;
            }

            //if user makes mistake, number of tries does not become bigger
            if (errorCheck(alphabet, letter)) {
                tryNum--;
            }

            //if a letter is used, it is replaced by '-' in char array 'alphabet'
            for (int i = 0; i < 26; i++) {
                if ((alphabet[i] == letter || (int) alphabet[i] == (int) letter + 32)) {
                    alphabet[i] = '-';
                }
            }


            System.out.println(" ");
            System.out.print("So far the word is: ");
            for (int j = 0; j < word.length(); j++) {
                //checks if so far established word is full word
                if (Objects.equals(letter, word.charAt(j))) {
                    soFar[j] = letter;
                }
                System.out.print(soFar[j]);
            }

            //if conditions are met game will end
            if (letter == '0' || new String(soFar).equals(word)) {
                gameOver = true;
            }
        }
        System.out.println(" ");
        System.out.println("Congrats! You guessed the word correctly. It took you " + tryNum + " tries.");
        System.out.println("Von babilon. Great song.");
        System.out.println(" ");
        System.out.println("Hello, my name is Borat");

        System.out.println("Titanic is meh.");
    }
}