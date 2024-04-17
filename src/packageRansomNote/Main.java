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
  
//	Example 1:
//
//	Input: ransomNote = "a", magazine = "b"
//	Output: false
  
//	Example 2:
//
//	Input: ransomNote = "aa", magazine = "ab"
//	Output: false
  
//	Example 3:
//
//	Input: ransomNote = "aa", magazine = "aab"
//	Output: true
//			 
//
//	Constraints:
//
//	1 <= ransomNote.length, magazine.length <= 105
//	ransomNote and magazine consist of lowercase English letters.
  
  public static void main(String[] args) {

    String ransomNote = "aa", magazine = "aab";
    
    System.out.println(canConstructRansomNoteWithMagazine(ransomNote, magazine));
    
    /**
     * Output Result:
     * 
     * true
     */
    
  }

  /**
   * Returns true if <b>ransomNote</b> String can be constructed by using the
   * letters from <b>magazine</b> String and false otherwise. Each letter in
   * <b>magazine</b> can only be used once in <b>ransomNote</b>.
   * 
   * @param ransomNote the String to be evaluated. The word will be valid if it
   *                   can be constructed using the <b>magazine</b> letters
   * @param magazine   the String to check if it has all the possible letters to
   *                   construct the <b>ransomNote</b>
   * @return true if <b>ransomNote</b> String can be constructed by using the
   *         letters from <b>magazine</b> String, otherwise false
   */
  static boolean canConstructRansomNoteWithMagazine(String ransomNote, String magazine) {
    if (magazine.length() < ransomNote.length()) {
      return false; // then it is not possible to construct, as it has fewer letters.
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
