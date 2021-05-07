package microsoftFromGithubKdn251;

public class AddDigits {
	/* https://github.com/kdn251/interviews/blob/master/company/microsoft/AddDigits.java
	
	Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

	For example:
	Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

	Follow up:
	Could you do it without any loop/recursion in O(1) runtime?
	
	class AddDigits {
	    public int addDigits(int num) {
	        while(num >= 10) {
	            int temp = 0;
	            while(num > 0) {
	                temp += num % 10;
	                num /= 10;
	            }
	            num = temp;
	        }
	        
	        return num;
	    }
	}
	
	*/
	
	public static void main(String[] args) {
		Integer[] nums = {11, 38, 104, 129, 100009, 999999999};
		
		for(Integer num : nums) {
			char[] n = num.toString().toCharArray();
			Integer sum = 0;
			
			while(n.length > 1) {	
				sum = Integer.valueOf(String.valueOf(n[0]));
				for(int i=1; i < n.length; i++) {
					sum = sum + Integer.valueOf(String.valueOf(n[i]));
				}
				n = sum.toString().toCharArray();
			}
			System.out.println("The sum of digits in "+num+" is "+ sum);
		}
		
	}
}
