package character;

import java.util.ArrayList;

public class Monster extends Character {

	private ArrayList<Monster> monsterList = new ArrayList<Monster>();

	public Monster(String name) {
		this.setName(name);
	}

}
