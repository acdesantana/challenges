package microsoftFromGithubKdn251;

public class ReverseWordsInAString {
	/*
		Given an input string, reverse the string word by word.
		For example,
		Given s = "the sky is blue",
		return "blue is sky the".
	*/
	
	public static void main(String[] args) {
		String[] words = {"the sky is blue", "Given an input string reverse the string word by word"};
		
		for(String s : words) {
			String[] arr = s.trim().split(" "); // the, sky, is, blue 
			int len = arr.length;
			
			StringBuilder reverse = new StringBuilder();
			
			for(int i=1; i <= len; i++) {
				int idx = len-i;
				reverse.append(arr[idx]).append(" ");
			}
			System.out.println(reverse.toString());
		}
	}
	
}
