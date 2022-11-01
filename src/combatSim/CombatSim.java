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
import character.Item;
import character.Skill;
import character.Spell;
public class CombatSim {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		Character wizard = new Character.Builder("Gandalf", "Wizard").build();
		Character warlock = new Character.Builder("Atreus", "Warlock").build();
		Character rogue = new Character.Builder("Vax", "Rogue").build();
		
		ArrayList<Character> playerCharacter = Character.getPlayerCharacters();

		//Generate Spell list from json file
		Spell spell = new Spell();
		spell.createSpellList();
		for(Spell spell1 : Spell.getSpellList()) {
			System.out.println(spell1.getSpellName());
		}
		
		//Generate Skill list from json file
		Skill skill = new Skill();
		skill.createSkillList();
		for(Skill skill1 : Skill.getSkillList()) {
			System.out.println(skill1.getName());
		}
		
		//Generate item list from json file
		Item item = new Item();
		item.createItemList();
		for(Item item1 : Item.getItemList()) {
			System.out.println(item1.getItemName());
		}

	}

}
