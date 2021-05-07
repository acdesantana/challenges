package microsoftFromGithubKdn251;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralMatrix {
	/* https://github.com/kdn251/interviews/blob/master/company/microsoft/SpiralMatrix.java
		Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
		
		Example 1:
		Input:
		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ]
		]
		Output: [1,2,3,6,9,8,7,4,5]
		
		Example 2:
		Input:
		[
		  [1, 2, 3, 4],
		  [5, 6, 7, 8],
		  [9,10,11,12]
		]
		Output: [1,2,3,4,8,12,11,10,9,5,6,7]
	*/
	

	public static void main(String[] args) {
		
		int[][] matrix = {{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
		
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int columnStart = 0;
		int columnEnd = matrix[0].length - 1;
				
		List<Integer> spiral = new ArrayList<Integer>();
		
		int totalColumns = matrix[0].length;
		int totalRows = matrix.length;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int row=0, col=0; col < totalColumns; row+=0, col++) {
			
			System.out.println(row+" "+col);
			System.out.println(matrix[row][col]);
			
			map.put(row, matrix[row][col]);
			
			if( col == totalColumns) {
				row +=1;
				col = 0;
			}
		}
		
		
		
		/*while(rowStart <= rowEnd && columnStart <= columnEnd) {
			
//			System.out.println(matrix[rowStart][columnStart]);
			
			//line 0 walk thru columns
			for(int col=0; col < matrix[0].length; col++) {
				System.out.println(col);
				spiral.add(matrix[0][col]);
				System.out.println(spiral);
			}
			
			
			rowStart += columnEnd;
			columnStart += columnEnd;
		}*/
		
		

	}

}
