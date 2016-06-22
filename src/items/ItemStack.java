package fr.nukkit.api.items;

import cn.nukkit.Player;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;

public class ItemStack
{
	private Item item;
	private Material material;

	public ItemStack(Material material)
	{
		this.item = new Item(material.getId(), material.getMeta());
		this.material = material;
	}

	public ItemStack setDisplayName(String displayName)
	{
		item.setCustomName(displayName.replace("&", "§"));

		return this;
	}

	public ItemStack setAmount(int amount)
	{
		if (amount > 64)
			amount = 64;

		item.setCount(amount);

		return this;
	}

	public ItemStack setMeta(int meta)
	{
		item.setDamage(meta);

		return this;
	}

	public ItemStack addEnchantement(Enchantment enchantment, int level)
	{
		cn.nukkit.item.enchantment.Enchantment en = cn.nukkit.item.enchantment.Enchantment
				.get(enchantment.getId());
		en.setLevel(level, false);

		item.addEnchantment(en);

		return this;
	}

	public void giveTo(Player player)
	{
		player.getInventory().addItem(item);
	}

	public void giveTo(Player player, int slot)
	{
		player.getInventory().setItem(slot, item);
	}
	
	public void addTo(Inventory inventory)
	{
		inventory.addItem(item);
	}

	public void addTo(Inventory inventory, int slot)
	{
		inventory.setItem(slot, item);
	}

	public Item getItem()
	{
		return item;
	}

	public Material getMaterial()
	{
		return material;
	}

	public int getId()
	{
		return item.getId();
	}

	public int getAmount()
	{
		return item.getCount();
	}

	public int getMeta()
	{
		return item.getDamage();
	}
}
