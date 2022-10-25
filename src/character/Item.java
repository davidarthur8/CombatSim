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

public class Item {
	private String itemName;
	private String itemDesc;
	private float itemCost;
	private int itemDamage;
	private int itemEffect;
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Item() {
		
	}
	
	public Item(String itemName) {

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public float getItemCost() {
		return itemCost;
	}

	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}

	public int getItemDamage() {
		return itemDamage;
	}

	public void setItemDamage(int itemDamage) {
		this.itemDamage = itemDamage;
	}

	public int getItemEffect() {
		return itemEffect;
	}

	public void setItemEffect(int itemEffect) {
		this.itemEffect = itemEffect;
	}

	public static ArrayList<Item> getItemList() {
		return itemList;
	}

	public static void setItemList(ArrayList<Item> itemList) {
		Item.itemList = itemList;
	}
	
	public void createItemList() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser
				.parse(new FileReader("C:\\Users\\david\\eclipse-workspace\\CombatSim\\src\\dndSource\\Items.json"));

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				String jsonStr = (String) jsonArray.get(i).toString();
				Item item = objectMapper.readValue(jsonStr, Item.class);
				itemList.add(item);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
