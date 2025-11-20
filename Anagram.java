

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
        String temp1 = preProcess(str1);
        String temp2 = preProcess(str2);

        if (temp1.length() != temp2.length()) return false;

        while (temp1.length() > 0) {
            char c = temp1.charAt(0);
            int idx = temp2.indexOf(c);
            if (idx == -1) return false;

            temp1 = temp1.substring(1);
            temp2 = temp2.substring(0, idx) + temp2.substring(idx + 1);
        }
        return true;
    }
       
    public static String preProcess(String str) {
        str = str.toLowerCase();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z')  // ONLY letters kept
                result += c;
        }
        return result;
    } 

    public static String randomAnagram(String str) {
        String temp = str;
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            int r = (int)(Math.random() * temp.length());
            newStr += temp.charAt(r);
            temp = temp.substring(0, r) + temp.substring(r + 1);
        }
        return newStr;
    }
}
