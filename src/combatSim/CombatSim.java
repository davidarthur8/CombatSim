package combatSim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray)parser.parse(new FileReader("C:\\Users\\david\\eclipse-workspace\\CombatSim\\src\\dndSource\\Spells.json"));		
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				String jsonStr = (String) jsonArray.get(i).toString();
				Spell spell = objectMapper.readValue(jsonStr, Spell.class);
				wizard.addSpells(spell);
			}
			for (Spell spell: wizard.getSpells()) {
				System.out.println(spell.getSpellName());
				System.out.println(spell.getSpellDamage());
				System.out.println(spell.getSpellDamage()*(wizard.rollDice(20)));
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
