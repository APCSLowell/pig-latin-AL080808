import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
   public int findFirstVowel(String sWord)
// precondition: sWord is a valid String of length greater than 0.
// postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
	for (int i = 0; i < sWord.length(); i++) {
		char ch = Character.toLowerCase(sWord.charAt(i)); // Handles uppercase
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return i; // Return position of the first vowel
		}
	}
	return -1; // Return -1 if no vowel found
}
public String pigLatin(String sWord)
// precondition: sWord is a valid String of length greater than 0
// postcondition: returns the pig latin equivalent of sWord
{
	if (findFirstVowel(sWord) == -1) {
		// Rule 1: No vowels in the word
		return sWord + "ay";
	} else if (findFirstVowel(sWord) == 0) {
		// Rule 2: Word starts with a vowel
		return sWord + "way";
	} else if (sWord.toLowerCase().startsWith("qu")) {
		// Rule 4: Word starts with "qu"
		return sWord.substring(2) + "quay";
	} else {
		// Rule 3: Word starts with a consonant
		int firstVowel = findFirstVowel(sWord);
		return sWord.substring(firstVowel) + sWord.substring(0, firstVowel) + "ay";
	}
}
