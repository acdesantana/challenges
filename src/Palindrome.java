import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {

	public static void main(String[] args) {

		String[] inputs = { "pinga", " ovo", "mussum    ", "roma me tem amor", "rener", "estrela",
				"socorram-me! subi no onibus em Marrocos" };

		compareUsingArrayIndexes(inputs);
		compareUsingStringCharAt(inputs);
		compareUsingReverseOrderWithoutLambda(inputs);
		compareUsingReverseOrderWithLambda(inputs);
	}
	
	// Stands for 32 milliseconds!!
	private static void compareUsingArrayIndexes(String[] inputs) {
		long ini = System.nanoTime();
		System.out.println(" -> Only one array. Which word is a palindrome?");
		
		for (String input : inputs) {
			char[] list = input.replace("-", "").replace("!", "").replace(" ", "").toLowerCase().toCharArray();
			
			boolean isPalindrome = true;
			for (int i = 0, n = list.length; i < list.length / 2; i++) {
				if ((list[i] != list[n - (i + 1)])) {
					isPalindrome = false;
					break;
				}
			}
			System.out.println(input.trim() + "? "+ isPalindrome);
		}
		
		long end = System.nanoTime() - ini;
		System.out.println(end/1000000 +" milliseconds");System.out.println();
	}
	
	// Stands for 731 microseconds ~ 0.731 milliseconds!!
	private static void compareUsingStringCharAt(String[] inputs) {
		long ini = System.nanoTime();
		System.out.println(" -> String.CharAt(i). Which word is a palindrome?");
		
		for (String input : inputs) {
			
			String word = input.replace("-", "").replace("!", "").replace(" ", "").toLowerCase();
			
			boolean isPalindrome = true;
			for(int left=0, right=word.length()-1; left < word.length(); left++, right--) {
				if(word.charAt(left) != word.charAt(right)) {
					isPalindrome = false;
					break;
				}
			}
			System.out.println(input.trim() + "? "+ isPalindrome);
		}
		
		long end = System.nanoTime() - ini;
		System.out.println(end/1000 +" microseconds");System.out.println();
	}
	
	// Stands for 675 microseconds ~ 0.675 milliseconds!!
	private static void compareUsingReverseOrderWithoutLambda(String[] inputs) {
		long ini = System.nanoTime();
		System.out.println(" -> ReverseOrder without lambda. Which word is a palindrome?");
		
		for (String input : inputs) {	
			char[] list = input.replace("-", "").replace("!", "").replace(" ", "").toLowerCase().toCharArray();
			
			char[] reverse = new char[list.length];
			
			for(int j=0; j< list.length; j++) {
				reverse[j] = list[j];
			}
			
			boolean isPalindrome = true;
			
			int right = reverse.length-1;
			for(int left=0; left < list.length; left++) {
				if(list[left] != reverse[right]) {
					isPalindrome = false;
					break;
				}
				right--;
			}
			System.out.println(input.trim() + "? "+ isPalindrome);
		}
		long end = System.nanoTime() - ini;
		System.out.println(end/1000 +" microseconds");System.out.println();
	}
	
	// Stands for 14 milliseconds!!
	private static void compareUsingReverseOrderWithLambda(String[] inputs) {
		long ini = System.nanoTime();
		System.out.println(" -> ReverseOrder with lambda. Which word is a palindrome?");
		
		for (String input : inputs) {	
			List<Character> list = input.replace("-", "").replace("!", "").replace(" ", "").toLowerCase()
										.chars()
										.mapToObj(x -> (char)x)
										.collect(Collectors.toList());
			
			List<Character> clone = list.stream().collect(Collectors.toList());
			Collections.reverse(clone);
			
			System.out.println(input.trim() + "? "+ list.equals(clone));
		}
		
		long end = System.nanoTime() - ini;
		System.out.println(end/1000000 +" milliseconds");System.out.println();
	}

}
