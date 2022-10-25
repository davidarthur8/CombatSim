package combatSim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import character.Character;
import character.Spell;
public class CombatSim {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		Character wizard = new Character("Gandalf", "Wizard");
		Character warlock = new Character("Atreus", "Warlock");
		Character rogue = new Character("Vax", "Rogue");

		ArrayList<Character> playerCharacter = Character.getPlayerCharacters();

		for (int i = 0; i < playerCharacter.size(); i++) {
			System.out.println(playerCharacter.get(i));
		}
		
		//Generate Spell list from json file
		Spell spell = new Spell();
		spell.createSpellList();
		for(Spell spell1 : Spell.getSpellList()) {
			System.out.println(spell1.getSpellName());
		}
		
		wizard.addSpells(Spell.getSpellList(1));
		
		System.out.println(wizard.getSpellList(0).getSpellName());

	}

}
