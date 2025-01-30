import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {

    public void tester() {
        String[] lines = new String[8]; 
        try {
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("there are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(pigLatin(lines[i]));
        }
    }

    public int findFirstVowel(String sWord) {
        for (int i = 0; i < sWord.length(); i++) {
            char ch = Character.toLowerCase(sWord.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return i; 
            }
        }
        return -1; 
    }

    public String pigLatin(String sWord) {
        if (sWord == null || sWord.isEmpty()) return ""; 

        sWord = sWord.toLowerCase(); 

        if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay";
        }

        int firstVowel = findFirstVowel(sWord);

        if (firstVowel == -1) {
            return sWord + "ay";
        } else if (firstVowel == 0) {
            return sWord + "way";
        } else {
            return sWord.substring(firstVowel) + sWord.substring(0, firstVowel) + "ay";
        }
    }

    public static void main(String[] args) {
        PigLatin pl = new PigLatin();
        pl.tester();
    }
}
