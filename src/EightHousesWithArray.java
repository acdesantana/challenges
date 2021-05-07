import java.util.Arrays;
import java.util.Scanner;

public class EightHousesWithArray {

	private static int ZERO = 0;
	private static int ONE = 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in).useDelimiter(", ");
		sc.skip("\\[");
		sc.skip("\\]");

		long ini = System.currentTimeMillis();

		int[] states = new int[10];
		states[0] = 0;
		states[9] = 0;
		int j = 1;
		while (sc.hasNext() && j < 9) {
			states[j] = sc.nextInt();
			j++;
		}
		int days = sc.nextInt();
		sc.close();

		int[] statesUpdated = new int[10];
		statesUpdated[0] = 0;
		statesUpdated[9] = 0;
		// System.out.println(" states         "+ Arrays.toString(Arrays.copyOfRange(states,1,9)));

		for (int i = 0; i < days; i++) {
			statesUpdated[1] = (states[0] == states[2]) ? ZERO : ONE;
			statesUpdated[3] = (states[2] == states[4]) ? ZERO : ONE;
			statesUpdated[8] = (states[9] == states[7]) ? ZERO : ONE;
			statesUpdated[6] = (states[7] == states[5]) ? ZERO : ONE;

			statesUpdated[2] = (states[1] == states[3]) ? ZERO : ONE;
			statesUpdated[7] = (states[8] == states[6]) ? ZERO : ONE;

			statesUpdated[4] = (states[3] == states[5]) ? ZERO : ONE;
			statesUpdated[5] = (states[6] == states[4]) ? ZERO : ONE;

			states = Arrays.copyOf(statesUpdated, statesUpdated.length);
		}

		long end = System.currentTimeMillis() - ini;
		System.out.println("In: "+end+ "ms.");
		System.out.println(" statesUpdated  " + Arrays.toString(Arrays.copyOfRange(statesUpdated, 1, 9))
				.replaceAll("\\[|\\]", "").replaceAll(",", ""));

	}

}
