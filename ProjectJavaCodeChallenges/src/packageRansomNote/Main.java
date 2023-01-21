package packageRansomNote;

import java.util.HashMap;

public class Main {

//	Challenge:
//	
//	Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters 
//	from magazine and false otherwise.
//
//	Each letter in magazine can only be used once in ransomNote.
//
	
//			Example 1:
//
//			Input: ransomNote = "a", magazine = "b"
//			Output: false
	
//			Example 2:
//
//			Input: ransomNote = "aa", magazine = "ab"
//			Output: false
	
//			Example 3:
//
//			Input: ransomNote = "aa", magazine = "aab"
//			Output: true
//			 
//
//			Constraints:
//
//			1 <= ransomNote.length, magazine.length <= 105
//			ransomNote and magazine consist of lowercase English letters.
	
	public static void main(String[] args) {

		String ransomNote = "aa", magazine = "aab";
		
		System.out.println(canConstruct(ransomNote, magazine));
		
		/* Output Result:
		 * 
		 * true
		 * 
		 */
		
	}

	static boolean canConstruct(String ransomNote, String magazine) {
        if ( magazine.length() < ransomNote.length() ) {
            return false; // then it cannot have the same values, as it has fewer letters. 
        }

        HashMap<Character, Integer> magazineLetters = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            int countLetters = magazineLetters.getOrDefault(m, 0);
            magazineLetters.put(m, ++countLetters);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char m = ransomNote.charAt(i);

            int countLetters = magazineLetters.getOrDefault(m, 0);
            if (countLetters == 0) {
                return false;
            }
            magazineLetters.put(m, --countLetters);
        }
        return true;
    }
	
}
