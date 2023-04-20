import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
   
	private static MorseCodeTree tree = new MorseCodeTree(); 

	public MorseCodeConverter()
	{
		
	}
    
	 /**
     * Returns string of with all the data in the tree in LNR order with a space in between them
     * Uses the toArrayList method in MorseCodeTree
     * @return the data in the tree in LNR order separated by a space.
     */
    public static String printTree() 
    {
        String data = "";

        ArrayList<String>list;
        list = tree.toArrayList();

        for(String letter : list) 
        {

            data += letter;
        }
        
        return data.trim();
    }
	
	/**
	 * Converts Morse code into English
	 * @param text
	 * @return the English translation
	 */
    public static String convertToEnglish(String text) {

    	 String[] words;
         String[] letters;

         String result = "";
         words = text.split("/");

         for(int i = 0;i < words.length;i++) 
         {
             words[i] = words[i].trim();
             letters = words[i].split(" ");

             for(int j = 0;j<letters.length;j++) 
             {
                 result += tree.fetch(letters[j]);
             }
             result += " ";
         }
         return result.trim();
    
    }
    
    /**
     * Converts a file of Morse code into English each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
     * @param file name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(File file) throws FileNotFoundException 
    {
        Scanner keyboard = new Scanner(file);
        String result = "";

        while(keyboard.hasNext()) 
        {
            result += convertToEnglish(keyboard.nextLine());
        }
        return result;
    }
	
}