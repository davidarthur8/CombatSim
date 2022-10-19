package combatSim;

import java.util.ArrayList;

import character.Character;

public class CombatSim {

	public static void main(String[] args) {

		Character wizard = new Character("Gandalf", "Wizard");
		Character warlock = new Character("Atreus", "Warlock");
		Character rogue = new Character("Vax", "Rogue");

		ArrayList<Character> playerCharacter = Character.getPlayerCharacters();

		for (int i = 0; i < playerCharacter.size(); i++) {
			System.out.println(playerCharacter.get(i));
		}
	}

}
