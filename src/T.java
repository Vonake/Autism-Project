import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class T {

    public String[] WORDS = { "among", "amongst", "analog", "apologise", "behaviour", "catalogue", "centre", "cheque",
            "cheque's", "chequed", "cheques", "chequing", "colour", "colour's", "colours", "defence", "favour",
            "favourite", "flavour", };

    // Random word
    public static final Random random = new Random();

    // Maximum Errors To Allow
    public static final int MAX_ERRORS = 8;

    // word to find
    private String wordToFind = "";

    // word found stored in a char array to be displayed to user
    private char[] wordFound;
    private int nbErrors;

    // letters already entered by the user
    private ArrayList<String> letters = new ArrayList<>();

    // method returning Random next word to find
    private String nextWordToFind() {
        return WORDS[random.nextInt(WORDS.length)];
    }

    // method for starting a new game
    public void newGame() {
        nbErrors = 0;
        letters.clear();
        wordToFind = nextWordToFind();

        // word found initialization
        wordFound = new char[wordToFind.length()];

        for (int i = 0; i < wordFound.length; i++) {
            wordFound[i] = '_';
        }
    }

    // this method returns true if word is found by player

    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    // Method updating the word found after user entered a new character

    private void enter(String c) {
        // we update only when c has not ben entered
        if (!letters.contains(c)) {
            // check if word to find contains c
            if (wordToFind.contains(c)) {
                // if so, we replace _ by the character c
                int index = wordToFind.indexOf(c);

                while(index >= 0){
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                // c not in the word error
                nbErrors ++;
            }

            //c is now a character added
            letters.add(c);
        }
    }

    //method returning the state of the word found by the user until by now
    private String wordFoundContent(){
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < wordFound.length; i++) {
            b.append(wordFound[i]);

            if(i < wordFound.length -1){
                b.append(" ");
            }
        }

        return b.toString();
    }

    // play method for our gamer
    public void play(){
        Scanner input = new Scanner(System.in);

        //we play while nbErrors is less than MAX_ERRORs OR user has found the word
        while(nbErrors < MAX_ERRORS){
            System.out.println("\nEnter a character : ");

            //get input
            String str = input.next();

            //we keep just the first letter

            if(str.length() > 1){
                str = str.substring(0, 1);
            }

            // update word found
            enter(str);

            System.out.println("\n"+wordFoundContent());

            // check if word found

            if(wordFound()){
                System.out.println("\n You Win!");
                break;
            }
            else{
                System.out.println("\n Tries Left : "+ (MAX_ERRORS - nbErrors) );
            }

        }

        if (nbErrors == MAX_ERRORS) {
            System.out.println("You Lose !");
            System.out.println("Word to find was : "+wordToFind);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n+++++++++++++++\nWelcome to HangGame\n+++++++++++++++\n");
        T t = new T();
        t.newGame();
        t.play();
    }

}