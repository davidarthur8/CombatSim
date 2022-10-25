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

public class Skill {
	private int proficiency;
	private String modifier;
	private String name;
	private int bonus;
	private static ArrayList<Skill> skillList = new ArrayList<Skill>();

	public Skill(int proficiency, String modifier, String name, int bonus) {
		
	}
	
	public Skill() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getProficiency() {
		return proficiency;
	}

	public void setProficiency(int proficiency) {
		this.proficiency = proficiency;
	}
	
	public static ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public static void setSkillList(ArrayList<Skill> skillList) {
		Skill.skillList = skillList;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	public void createSkillList() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser
				.parse(new FileReader("C:\\Users\\david\\eclipse-workspace\\CombatSim\\src\\dndSource\\Skills.json"));

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				String jsonStr = (String) jsonArray.get(i).toString();
				Skill skill = objectMapper.readValue(jsonStr, Skill.class);
				skillList.add(skill);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
