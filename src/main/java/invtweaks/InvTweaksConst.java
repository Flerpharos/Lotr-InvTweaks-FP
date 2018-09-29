package invtweaks;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class InvTweaksConst {

    // Mod version
    public static final String MOD_VERSION = "1.58-FP";

    // Mod tree version
    // Change only when the tree evolves significantly enough to need to override all configs
    public static final String TREE_VERSION = "1.7.1";

    public static final String INVTWEAKS_CHANNEL = "InventoryTweaks FP";

    // Network Protocol version
    public static final byte PROTOCOL_VERSION = 1;
    public static final byte PACKET_LOGIN = 0x00;
    public static final byte PACKET_CLICK = 0x01;
    public static final byte PACKET_SORTCOMPLETE = 0x02;

    // Timing constants
    public static final int RULESET_SWAP_DELAY = 1000;
    public static final int AUTO_REFILL_DELAY = 200;
    public static final int POLLING_DELAY = 3;
    public static final int POLLING_TIMEOUT = 1500;
    public static final int CHEST_ALGORITHM_SWAP_MAX_INTERVAL = 2000;
    public static final int TOOLTIP_DELAY = 800;

    // File constants
    public static final File MINECRAFT_DIR = Minecraft.getMinecraft().mcDataDir;
    public static final File MINECRAFT_CONFIG_DIR = new File(MINECRAFT_DIR, "config/");
    public static final File CONFIG_PROPS_FILE = new File(MINECRAFT_CONFIG_DIR, "InvTweaks.cfg");
    public static final File CONFIG_RULES_FILE = new File(MINECRAFT_CONFIG_DIR, "InvTweaksRules.txt");
    public static final File CONFIG_TREE_FILE = new File(MINECRAFT_CONFIG_DIR, "InvTweaksTree.txt");
    public static final File OLD_CONFIG_TREE_FILE = new File(MINECRAFT_CONFIG_DIR, "InvTweaksTree.xml");
    public static final File OLDER_CONFIG_RULES_FILE = new File(MINECRAFT_DIR, "InvTweaksRules.txt");
    public static final File OLDER_CONFIG_TREE_FILE = new File(MINECRAFT_DIR, "InvTweaksTree.txt");

    public static final String INVTWEAKS_RESOURCE_DOMAIN = "inventorytweaks";
    public static final ResourceLocation DEFAULT_CONFIG_FILE = new ResourceLocation(INVTWEAKS_RESOURCE_DOMAIN,
                                                                                    "DefaultConfig.dat");
    public static final ResourceLocation DEFAULT_CONFIG_TREE_FILE = new ResourceLocation(INVTWEAKS_RESOURCE_DOMAIN,
                                                                                         "ItemTree.xml");

    public static final String HELP_URL = "http://inventory-tweaks.readthedocs.org";

    // Global mod constants
    public static final String INGAME_LOG_PREFIX = "InvTweaks-FP: ";
    public static final Level DEFAULT_LOG_LEVEL = Level.WARN;
    public static final Level DEBUG = Level.INFO;
    public static final int JIMEOWAN_ID = 54696386; // Used in GUIs

    // Minecraft constants
    public static final int INVENTORY_SIZE = 36;
    public static final int INVENTORY_ROW_SIZE = 9;
    public static final int CHEST_ROW_SIZE = INVENTORY_ROW_SIZE;
    public static final int DISPENSER_ROW_SIZE = 3;
    public static final int INVENTORY_HOTBAR_SIZE = INVENTORY_ROW_SIZE;
    public static final int DAMAGE_WILDCARD = OreDictionary.WILDCARD_VALUE;

    /**
     * Returns the Minecraft folder ensuring: - It is an absolute path - It ends with a folder separator
     */
    public static String getMinecraftDir() {
        File dataDir = Minecraft.getMinecraft().mcDataDir;
        try {
            return dataDir.getCanonicalPath();
        } catch(IOException ex) {
            return dataDir.getAbsolutePath();
        }
    }

}
