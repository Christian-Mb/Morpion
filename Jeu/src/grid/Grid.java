package grid;

import player.Player;

public class Grid {
	private GridCase[] Case;

	/**
	 * constructeur
	 */
	public Grid() {
		super();
		this.Case = new GridCase[9];

		for (int i = 0; i < Case.length; i++) {

			this.Case[i] = new GridCase(i+1);

		}

	}

	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder("┌───┬───┬───┐").append(System.lineSeparator());
		chaine.append("│ ").append(this.Case[0]).append(" │ ").append(this.Case[1]).append(" │ ").append(this.Case[2])
				.append(" │").append(System.lineSeparator());
		chaine.append("├───┼───┼───┤").append(System.lineSeparator());
		chaine.append("│ ").append(this.Case[3]).append(" │ ").append(this.Case[4]).append(" │ ").append(this.Case[5])
				.append(" │").append(System.lineSeparator());
		chaine.append("├───┼───┼───┤").append(System.lineSeparator());
		chaine.append("│ ").append(this.Case[6]).append(" │ ").append(this.Case[7]).append(" │ ").append(this.Case[8])
				.append(" │").append(System.lineSeparator());
		chaine.append("└───┴───┴───┘").append(System.lineSeparator());
		return chaine.toString();

	}

	/**
	 * permet de modifier la valeur du tableau à l'indice caseId par Choice c
	 * 
	 * @param caseId
	 * @param c
	 */
	public void setCaseChoice(int caseId, Choice c) {

		this.Case[caseId].setElement(c);
	}

	/**
	 * pour recuperer les winners et verifie par rapport aux diagonales si un joueur à gagner
	 * 
	 * @return
	 */
	public Player getWinner() {
		Player winner = null;
		winner = getColumnWinner();
		if (winner != null) {
			return winner;
		}

		winner = getLinesWinner();
		if (winner != null) {
			return winner;
		}

		Player player = getTokenOwnerOf(0);
		if (player != null && player.equals(getTokenOwnerOf(4))) {
			if (player.equals(getTokenOwnerOf(8))) {
				return player;
			}
		}
		player = getTokenOwnerOf(2);
		if (player != null && player.equals(getTokenOwnerOf(4))) {
			if (player.equals(getTokenOwnerOf(6))) {
				return player;
			}
		}
		return winner;
	}

	/**verifie si le tableau est rempli
	 * @return
	 */
	public boolean isFull() {

		boolean full = true;
		for (int j = 0; j < Case.length; j++) {
			if ((this.Case[j]).isEmpty()) {

				full = false;
				break;
			}
		}

		return full;
	}

	/** permet de recuperer pour chaque joueur son symbole
	 * @param id
	 * @return
	 */
	public Player getTokenOwnerOf(int id) {
		if (this.Case[id].getTokenOwner() != null)
			return this.Case[id].getTokenOwner();
		else
			return null;
	}

	/**permet d'effacer les symbole dans le tableau
	 * 
	 */
	public void clear() {
		int n = 1;
		for (int i = 0; i < Case.length; i++) {
			if (this.Case[i] == null) {
				this.Case[i] = new GridCase(n++);
			} else
				this.Case[i].setElement(null);
		}

	}

	/**verifie par rapport à la ligne si le joueur à gagner
	 * @return
	 */
	private Player getLinesWinner() {
		Player winner = null;
		for (int i = 0; i < 3; i++) {
			Player player = getTokenOwnerOf(0 + (i * 3));
			if (player == null)
				continue;
			if (player.equals(getTokenOwnerOf(1 + (i * 3)))) {
				if (player.equals(getTokenOwnerOf(2 + (i * 3)))) {
					winner = player;
					break;
				}
			}
			;
		}

		return winner;
	}

	/**verifie par rapport à la colonne si un joueur à gagner
	 * @return
	 */
	private Player getColumnWinner() {
		Player winner = null;
		for (int col = 0; col < 3; col++) {

			Player player = getTokenOwnerOf((col + 0 * 3));
			if (player == null)
				continue;
			if (player.equals(getTokenOwnerOf((col + 1 * 3)))) {
				if (player.equals(getTokenOwnerOf((col + 2 * 3)))) {
					winner = player;
					break;
				}
			}
			;
		}

		return winner;
	}

}
