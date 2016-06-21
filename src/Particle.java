package File14.Hub.libs;

import cn.nukkit.level.Location;
import cn.nukkit.level.particle.AngryVillagerParticle;
import cn.nukkit.level.particle.BubbleParticle;
import cn.nukkit.level.particle.CriticalParticle;
import cn.nukkit.level.particle.DestroyBlockParticle;
import cn.nukkit.level.particle.DustParticle;
import cn.nukkit.level.particle.EnchantParticle;
import cn.nukkit.level.particle.EnchantmentTableParticle;
import cn.nukkit.level.particle.ExplodeParticle;
import cn.nukkit.level.particle.FlameParticle;
import cn.nukkit.level.particle.HappyVillagerParticle;
import cn.nukkit.level.particle.HeartParticle;
import cn.nukkit.level.particle.HugeExplodeParticle;
import cn.nukkit.level.particle.InkParticle;
import cn.nukkit.level.particle.InstantEnchantParticle;
import cn.nukkit.level.particle.InstantSpellParticle;
import cn.nukkit.level.particle.ItemBreakParticle;
import cn.nukkit.level.particle.LargeExplodeParticle;
import cn.nukkit.level.particle.LavaDripParticle;
import cn.nukkit.level.particle.LavaParticle;
import cn.nukkit.level.particle.MobSpawnParticle;
import cn.nukkit.math.Vector3;

public enum Particle
{	
	// FLOATINGTEXT(FloatingTextParticle.class),

	VILLAGER_HAPPY(HappyVillagerParticle.class),
	VILLAGER_ANGRY(AngryVillagerParticle.class),
	
	EXPLODE(ExplodeParticle.class),
	EXPLODE_HUGE(HugeExplodeParticle.class),
	EXPLODE_LARGE(LargeExplodeParticle.class),
	
	INSTANT_ENCHANT(InstantEnchantParticle.class),
	INSTANT_SPELL_ENCHANT(InstantSpellParticle.class),
	
	LAVA(LavaParticle.class),
	LAVA_DRIP(LavaDripParticle.class),
	
	BUBBLE(BubbleParticle.class),
	CRITICAL(CriticalParticle.class),
	DESTROY_BLOCK(DestroyBlockParticle.class),
	DUST(DustParticle.class),
	ENCHANTMENT(EnchantmentTableParticle.class),
	ENCHANT(EnchantParticle.class),
	FLAME(FlameParticle.class),	
	HEART(HeartParticle.class),
	INK(InkParticle.class),
	ITEM_BREAK(ItemBreakParticle.class),	
	MOB_SPAWNER(MobSpawnParticle.class);

	

	private Class<? extends cn.nukkit.level.particle.Particle> type;

	private Particle(Class<? extends cn.nukkit.level.particle.Particle> type)
	{
		this.type = type;
	}

	public void play(Location location)
	{
		if (location == null)
			location = new Location(0, 0, 0);

		try
		{
			cn.nukkit.level.particle.Particle particle = type.getDeclaredConstructor(Vector3.class)
					.newInstance(location);

			location.getLevel().addParticle(particle);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
