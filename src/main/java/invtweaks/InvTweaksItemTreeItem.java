package invtweaks;

import invtweaks.api.IItemTreeItem;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Representation of an item in the item tree.
 *
 * @author Jimeo Wan
 */
public class InvTweaksItemTreeItem implements IItemTreeItem {

    private String name;
    private String id;
    private int damage;
    private int order;

    /**
     * @param name   The item name
     * @param id     The item ID
     * @param damage The item variant or InvTweaksConst.DAMAGE_WILDCARD
     * @param order  The item order while sorting
     */
    public InvTweaksItemTreeItem(String name, String id, int damage, int order) {
        this.name = name;
        this.id = InvTweaksObfuscation.getNamespacedID(id);
        this.damage = damage;
        this.order = order;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getOrder() {
        return order;
    }

    /**
     * Warning: the item equality is not reflective. They are equal if "o" matches the item constraints (the opposite
     * can be false).
     */
    public boolean equals(Object o) {
        if(o == null || !(o instanceof IItemTreeItem)) {
            return false;
        }
        IItemTreeItem item = (IItemTreeItem) o;
        return ObjectUtils.equals(id, item.getId()) && (damage == InvTweaksConst.DAMAGE_WILDCARD || damage == item.getDamage());
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(IItemTreeItem item) {
        return item.getOrder() - getOrder();
    }

}
