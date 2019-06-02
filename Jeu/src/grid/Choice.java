package grid;

import player.Player;

public class Choice {

	private char charac;
	private Player owner;

	/**constructeur 
	 * @param charac
	 * @param player
	 */
	public Choice(char charac,Player player) {
		super();
		this.charac = charac;
		this.owner= player;
	}

	/* permet d'afficher les caractères de type Choice
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Character.toString(this.charac);
	}

		
	/**permet de recuperer le player en fonction de son Choice
	 * @return
	 */
	public Player getOwner() {
		return this.owner;
	}

}
