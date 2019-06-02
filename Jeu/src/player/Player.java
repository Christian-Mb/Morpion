package player;

import grid.Choice;

public class Player {
	private int id;
	private String name;
	
	private Choice choix;

	public Player(int id, String name, char c) {
		super();
		this.id = id;
		this.name = name;
		this.choix = new Choice(c,this);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Choice getChoice() {
		return this.choix;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Player) {
			Player player = (Player)other;
			return player.id== this.id;
		}
		else 
			return false;
		
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	};
	

	
}
