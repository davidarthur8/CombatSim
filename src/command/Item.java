package command;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public enum Item implements Target {
    POTION("potion"),
    SWORD("sword");

    private final String name;

    private static final Map<String,Item> ENUM_MAP;

    Item (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    static {
        Map<String,Item> map = new HashMap<>();
        for (Item instance : Item.values()) {
            map.put(instance.getName().toLowerCase(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Item get (String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }
}
