
public class StringsForSum {
		
	public static void main(String[] args) {
		String[] strs = {"1 + 1", 
							"1 + 1 - 1", 
								"1 - 1 - 1 + 3", 
									"1 + 1 + 1 + 1 + 1 - 3", 
										"1 + 1 + 1 + 1 + 1 + 3"};
		
		for(String s : strs) {
		
			String[] terms = s.trim().split(" ");
			
			Integer sum = Integer.valueOf(terms[0]);
	
			int i=2;
			while(i < terms.length) {
				String sign = terms[i-1];
				if (sign.equals("+")){
					sum = sum + Integer.valueOf(terms[i]);
				
				}else if (sign.equals("-")){
					sum = sum - Integer.valueOf(terms[i]);
				}
				i = i+2;
			}
			System.out.println("Sum = "+ sum);
		}
	}

}
