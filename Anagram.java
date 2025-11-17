

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
    String tempStr1 = preProcess(str1);
    String tempStr2 = preProcess(str2);

    int i = 0;
    while (i < tempStr1.length()) {
        int j = 0;
        boolean found = false;

        while (j < tempStr2.length()) {
            if (tempStr1.charAt(i) == tempStr2.charAt(j)) {
                // remove matched characters
                tempStr1 = tempStr1.substring(0, i) + tempStr1.substring(i + 1);
                tempStr2 = tempStr2.substring(0, j) + tempStr2.substring(j + 1);
                found = true;
                break; 
            }
            j++;
        }

        if (!found) {
            return false; 
        }
    }

    return tempStr1.length() == 0 && tempStr2.length() == 0;
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		int i = 0;
		while(i < str.length())
		{
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z'){
				i++;
			}else{
				str = str.substring(0, i) + str.substring(i+1);
			}
		}
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr ="";
		String tempStr = str;
		for (int i = 0; i < str.length(); i++) {
			int random = (int)(Math.random()*tempStr.length());
			newStr += tempStr.charAt(random);
			tempStr = tempStr.substring(0,random) + tempStr.substring(random+1);
		}
		return newStr;
	}
}
