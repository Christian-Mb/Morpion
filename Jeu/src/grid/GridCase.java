package grid;

import player.Player;

/**
 * @author Christian Mada-Mbari
 *
 */
public class GridCase {
	private int id;
	private Choice element;

	/**constructeur 1
	 * @param id
	 */
	public GridCase(int id) {
		super();
		this.id = id;
		this.element = null;
	}

	/**constructeur 2
	 * @param id
	 * @param element
	 */
	public GridCase(int id, Choice element) {
		super();
		this.id = id;
		this.element = element;
	}
	
	/** pour verifier si le tableau ne cotient pas de caractère
	 * @return
	 */
	public boolean isEmpty() {

		if (this.element == null)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		if (this.element != null)
			return this.element.toString();
		else
			return Integer.toString(this.id);
	}

	
	/**permet de recuperer le charac de chaque player
	 * @return
	 */
	public Player getTokenOwner() {
		if (this.element != null)
			return this.element.getOwner();
		else
			return null;

	}

	/**setter
	 * @param element
	 */
	public void setElement(Choice element) {
		this.element = element;
	}

	

}
