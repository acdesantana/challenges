import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EightHouses_Amazon {

/*
 	Eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its adjacent cells (neighbors). 
	An integer value of 1 represents an active cell and a value of 0 represents an inactive cell. If the neighbors on both the sides of 
	a cell are either active or inactive, the cell becomes inactive on the next day; otherwise the cell becomes active. 
	
	The two cells on each end have a single adjacent cell, so assume that the unoccupied space on the opposite side is an inactive cell.
	Even after updating the cell state, consider its previous state when updating the state of others cells. The state information
	of all cells should be updated simultaneously.
	
	Write an algorithm to output the state of the cells after the given number of days.
	
			 	|A|	|B|	|C|	|D|	|E|	|F|	|G|	|H|
	
	NOTE: The elements of the list "states" contains 0s and 1s only.

	INPUT:
	The input to the function/method consists of two arguments: 
		"states", a list of integers representing the current state of cells;
		"days", an integer representing the number of days.

	OUTPUT:
	Return a list of integers representing the state of the cells after the given number of days.
	
	TESTCASE 1:
		Input: [1, 0, 0, 0, 0, 1, 0, 0], 1
		Expected Return value: 0 1 0 0 1 0 1 0
		
	TESTCASE 2:
		Input: [1, 1, 1, 0, 1, 1, 1, 1], 2
		Expected Return value: 0 0 0 0 0 1 1 0
		
 */
	
	public static void main(String[] args) {
		int ini = Instant.now().getNano();
		
		Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
		map.put(Arrays.asList(1, 0, 0, 0, 0, 1, 0, 0), 1);
		map.put(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1), 2);
		
		for(Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
			System.out.println("Input: "+ entry.getKey() +", "+ entry.getValue());
			
			List<Integer> updatedState = determineCellsStateAfterFewDays(entry.getKey(), entry.getValue());
			System.out.println("Expected Return value: "+ updatedState.toString().replace(",", "").replace("[", "").replace("]", ""));
			System.out.println();
		}
		
		int end = Instant.now().getNano() - ini; 
		System.out.println(end/1000000 +" milliseconds");System.out.println();
	}
	
	private static List<Integer> determineCellsStateAfterFewDays(List<Integer> states, Integer days) {

		Map<Integer, Integer> future = new HashMap<Integer, Integer>();
		for(int i=0; i < states.size(); i++) {
			future.put(i, states.get(i));
		}

		Integer value0, value1, value2, value3, value4, value5, value6, value7 = 0;
		for(int d=0; d < days; d++) {
			
			value0 = (0 == future.get(1))? 0 : 1; // The two cells on each end have a single adjacent cell, so assume 
													// that the unoccupied space on the opposite side is an inactive cell
			value1 = (future.get(0) == future.get(2))? 0 : 1;
			value2 = (future.get(1) == future.get(3))? 0 : 1;
			value3 = (future.get(2) == future.get(4))? 0 : 1;
			value4 = (future.get(3) == future.get(5))? 0 : 1;
			value5 = (future.get(4) == future.get(6))? 0 : 1;
			value6 = (future.get(5) == future.get(7))? 0 : 1;
			
			value7 = (future.get(6) == 0)? 0 : 1; // The two cells on each end have a single adjacent cell, so assume 
			 										// that the unoccupied space on the opposite side is an inactive cell
			future.put(0, value0);
			future.put(1, value1);
			future.put(2, value2);
			future.put(3, value3);
			future.put(4, value4);
			future.put(5, value5);
			future.put(6, value6);
			future.put(7, value7);
		}
		return new ArrayList<Integer>(future.values());
	}
	
}
