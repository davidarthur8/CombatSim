package character;

public class SpellSlots {
	private int firstLevel;
	private int secondLevel;
	private int thirdLevel;
	private int fourthLevel;
	private int fifthLevel;
	private int sixthLevel;
	private int seventhLevel;
	private int eigthLevel;
	private int ninthLevel;
		
	public SpellSlots(String chosenClass, int level) {
		setSpellSlots(chosenClass, level);
	}
	
	public void setSpellSlots(String chosenClass, int level) {
		switch (chosenClass) {
		case "Wizard", "Bard", "Druid", "Sorcerer", "Cleric":
			setPrimarySpellcaster(level);
			break;
		case "Paladin", "Ranger":
			setSecondarySpellcaster(level);
			break;
		case "Warlock":
			setWarlockSpell(level);
		default:
			break;
		}
	}
	
	private void setSecondarySpellcaster(int level) {
		switch (level) {
		case 1 -> firstLevel = 0;
		case 2 -> firstLevel = 2;
		case 3, 4 -> firstLevel = 3;
		case 5, 6 -> {
			firstLevel = 4;
			secondLevel = 2;
		}
		case 7, 8 -> {
			firstLevel = 4;
			secondLevel = 3;
		}
		case 9, 10 -> {
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 2;
		}
		case 11, 12 -> {
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
		}
		case 13, 14 -> {
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 1;
		}
		case 15, 16 -> {
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 2;
		}
		case 17, 18 -> {
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 1;
		}
		case 19, 20 -> {
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 2;
		}
		default -> {
		}
		}

	}

	private void setWarlockSpell(int level) {
		switch (level) {
		case 1:
			firstLevel = 1;
			break;
		case 2:
			firstLevel = 2;
			break;
		case 3, 4:
			secondLevel = 2;
			break;
		case 5, 6:
			thirdLevel = 2;
			break;
		case 7, 8:
			fourthLevel = 2;
			break;
		case 9, 10:
			fifthLevel = 2;
			break;
		case 11, 12, 13, 14, 15, 16:
			fifthLevel = 3;
			break;
		case 17, 18, 19, 20:
			fifthLevel = 4;
			break;
		default:
			break;
		}
	}

	private void setPrimarySpellcaster(int level) {
		switch (level) {
		case 1:
			firstLevel = 2;
			break;
		case 2:
			firstLevel = 3;
			break;
		case 3:
			firstLevel = 4;
			secondLevel = 2;
			break;
		case 4:
			firstLevel = 4;
			secondLevel = 3;
			break;
		case 5:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 2;
			break;
		case 6:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			break;
		case 7:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 1;
			break;
		case 8:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 2;
			break;
		case 9:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 1;
			break;
		case 10:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 2;
			break;
		case 11, 12:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 2;
			sixthLevel = 1;
			break;
		case 13, 14:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 2;
			sixthLevel = 1;
			seventhLevel = 1;
			break;
		case 15, 16:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 2;
			sixthLevel = 1;
			seventhLevel = 1;
			eigthLevel = 1;
			break;
		case 17:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 2;
			sixthLevel = 1;
			seventhLevel = 1;
			eigthLevel = 1;
			ninthLevel = 1;
			break;
		case 18:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 3;
			sixthLevel = 1;
			seventhLevel = 1;
			eigthLevel = 1;
			ninthLevel = 1;
			break;
		case 19:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 3;
			sixthLevel = 2;
			seventhLevel = 1;
			eigthLevel = 1;
			ninthLevel = 1;
			break;
		case 20:
			firstLevel = 4;
			secondLevel = 3;
			thirdLevel = 3;
			fourthLevel = 3;
			fifthLevel = 3;
			sixthLevel = 2;
			seventhLevel = 2;
			eigthLevel = 1;
			ninthLevel = 1;
			break;
		default:
			break;
		}
	}

	public int getFirstLevel() {
		return firstLevel;
	}

	public int getSecondLevel() {
		return secondLevel;
	}

	public int getThirdLevel() {
		return thirdLevel;
	}

	public int getFourthLevel() {
		return fourthLevel;
	}

	public int getFifthLevel() {
		return fifthLevel;
	}

	public int getSixthLevel() {
		return sixthLevel;
	}

	public int getSeventhLevel() {
		return seventhLevel;
	}

	public int getEigthLevel() {
		return eigthLevel;
	}

	public int getNinthLevel() {
		return ninthLevel;
	}
	
}
