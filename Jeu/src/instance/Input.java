package instance;

import java.util.Scanner;

public class Input {
	/**permet de recuperer la saisie des players
	 * @param sc
	 * @return
	 */
	public static int readInt(Scanner sc) {
		String input = sc.nextLine();
		int result = -1;
		try {
			result=Integer.parseInt(input);
			
		}catch (NumberFormatException e) {
			
		}
		return result;
	}

}
