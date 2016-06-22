# Nukkit-Libaries
Lot's of Nukkit Libaries for Bukkit lovers

## Sound use:

	Sound.BLOCK_ANVIL_BREAK.play(location);

## Particle use:

	Particle.VILLAGER_HAPPY.play(location);

## ItemStack use:

	ItemStack compass = new ItemStack(Material.COMPASS, 0);
	compass.setDisplayName("&b&lGameType Selector &7(Right Click)");
	compass.setAmount(1);
	compass.setMeta(0);
	compass.addEnchantement(Enchantment.BASIC_SILKTOUCH, 1);
	compass.giveTo(player, 1);	
	