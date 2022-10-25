package character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Spell {
	private String spellName;
	private String spellDesc;
	private int spellCost;
	private int spellDamage;
	private String classSpell;


	private static ArrayList<Spell> spellList = new ArrayList<Spell>();

	public Spell(String spellName) {
		this.spellName = spellName;
	}

	public Spell() {

	}

	public Spell(String spellName, String spellDesc, int spellCost, int spellDamage, String classSpell) {
		this.spellName = spellName;
		this.spellDesc = spellDesc;
		this.spellCost = spellCost;
		this.spellDamage = spellDamage;
		this.classSpell = classSpell;
	}

	public String getSpellName() {
		return spellName;
	}
	
	public String getClassSpell() {
		return classSpell;
	}

	public void setClassSpell(String classSpell) {
		this.classSpell = classSpell;
	}
	
	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}

	public String getSpellDesc() {
		return spellDesc;
	}

	public void setSpellDesc(String spellDesc) {
		this.spellDesc = spellDesc;
	}

	public float getSpellCost() {
		return spellCost;
	}

	public void setSpellCost(int spellCost) {
		this.spellCost = spellCost;
	}

	public int getSpellDamage() {
		return spellDamage;
	}

	public void setSpellDamage(int spellDamage) {
		this.spellDamage = spellDamage;
	}

	public static ArrayList<Spell> getSpellList() {
		return spellList;
	}
	public static Spell getSpellList(int position) {
		return spellList.get(position);
	}

	public static void setSpellList(ArrayList<Spell> spellList) {
		Spell.spellList = spellList;
	}

	public void createSpellList() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser
				.parse(new FileReader("C:\\Users\\david\\eclipse-workspace\\CombatSim\\src\\dndSource\\Spells.json"));

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				String jsonStr = (String) jsonArray.get(i).toString();
				Spell spell = objectMapper.readValue(jsonStr, Spell.class);
				spellList.add(spell);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
