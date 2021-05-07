import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*  AvenueCode  */
public class FindNoRepeatedLetter_AvenueCode {

	/*
		Given any input string, the challenge should return the first occurence of no repeated letter.
		If none, should return "_" .
	
		Examples: "ababcdab", "asdfgasdfghasd"
	*/
	public static void main(String[] args){
		 //respostas: "h", "c", "_", "o"
		String[] inputs = {"asdfgasdfghasd", "ababcdab", "asdfgasdfgasd", "07uu7202o"};
		
		for (String input : inputs) {
			
			String withoutLambda = checkFirstNotRepeatedCharWithoutLambda(input);
			Character withLambda = checkFirstNotRepeatedCharWithLambda(input);
			
			System.out.println("Final result without lambda: "+ withoutLambda);
			System.out.println("Final result with lambda: "+ withLambda);
		}
	}


	private static String checkFirstNotRepeatedCharWithoutLambda(String input){
		String result = "_";
		
		char[] chars = input.toCharArray();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0; i < chars.length; i++){
			if(charMap.containsKey(chars[i])){
				int charValue = charMap.get(chars[i]);
				charMap.put( chars[i], (charValue+1) );
			}else{
				charMap.put(chars[i], 0);
			}
		}
		
		String notRepeated = "";
		for(Map.Entry<Character, Integer> set : charMap.entrySet()){
			if(0 == set.getValue()){
				notRepeated = String.valueOf(set.getKey());
				break; 
			}
		}
		
		if(!notRepeated.isEmpty()){ 
			result =  notRepeated;
		}
		
		return result;
	}
	
	private static Character checkFirstNotRepeatedCharWithLambda(String input){

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		List<Character> list = input.chars()
					.mapToObj(m -> (char)m)
					.collect(Collectors.toList());

		
		list.forEach(item -> {
			if(charMap.containsKey(item)) {
				int charValue = charMap.get(item);
				charMap.put(item, charValue+1);
			}else {
				charMap.put(item, 0);
			}
		});
		
//		System.out.println("--------------------");
//		System.out.println(charMap);
		
		Optional<Character> optional = charMap.entrySet().stream()
				.filter(y ->  0 == y.getValue())
				.map(y -> y.getKey())
				.findFirst();
				
		return optional.orElse('_');
	}
}
