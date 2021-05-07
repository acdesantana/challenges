package microsoftFromGithubKdn251;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

/*	https://github.com/kdn251/interviews/blob/master/company/microsoft/FirstUniqueCharacterInAString.java
	 
	Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	
	Examples:
	
	s = "leetcode"
	return 0.
	
	s = "loveleetcode",
	return 2.
	Note: You may assume the string contain only lowercase letters.
*/
	
	public static void main(String[] args) {
		
		String s = "lleetcode";
	
		Map<Character, Integer> characters = new HashMap<Character, Integer>();
		for(int i=0; i < s.length(); i++) {
			char current = s.charAt(i);
			
			if(characters.containsKey(current)) {
				characters.put(current, -1);
			}else {
				characters.put(current, i);
			}
		}
		System.out.println(characters);
		int min = Integer.MAX_VALUE;
        for(char c : characters.keySet()) {
            if(characters.get(c) > -1 && characters.get(c) < min) {
            	System.out.println(min);
                min = characters.get(c);
            }
        }
        
        int index = min == Integer.MAX_VALUE ? -1 : min;
		System.out.println("The index is "+ index);
	}

}
