package command;

import character.Character;

public class AttackCommand implements Command<Character, Action, Character>{
    private Character subjCharacter;
    private Action action;
    private Character objCharacter;

    public Character getSubjCharacter() {
        return subjCharacter;
    }

    public Action getAction() {
        return action;
    }

    public Character getObjCharacter() {
        return objCharacter;
    }

}
