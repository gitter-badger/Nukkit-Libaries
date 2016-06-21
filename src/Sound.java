package fr.nukkit.api;

import cn.nukkit.level.Location;
import cn.nukkit.level.sound.AnvilBreakSound;
import cn.nukkit.level.sound.AnvilFallSound;
import cn.nukkit.level.sound.AnvilUseSound;
import cn.nukkit.level.sound.BatSound;
import cn.nukkit.level.sound.BlazeShootSound;
import cn.nukkit.level.sound.ButtonClickSound;
import cn.nukkit.level.sound.ClickSound;
import cn.nukkit.level.sound.DoorBumpSound;
import cn.nukkit.level.sound.DoorCrashSound;
import cn.nukkit.level.sound.DoorSound;
import cn.nukkit.level.sound.EndermanTeleportSound;
import cn.nukkit.level.sound.FizzSound;
import cn.nukkit.level.sound.GenericSound;
import cn.nukkit.level.sound.GhastShootSound;
import cn.nukkit.level.sound.GhastSound;
import cn.nukkit.level.sound.LaunchSound;
import cn.nukkit.level.sound.LeverSound;
import cn.nukkit.level.sound.NoteBoxSound;
import cn.nukkit.level.sound.PopSound;
import cn.nukkit.level.sound.TNTPrimeSound;
import cn.nukkit.level.sound.ZombieHealSound;
import cn.nukkit.level.sound.ZombieInfectSound;
import cn.nukkit.math.Vector3;

public enum Sound
{
	BLOCK_ANVIL_BREAK(AnvilBreakSound.class),
	BLOCK_ANVIL_FALL(AnvilFallSound.class),
	BLOCK_ANVIL_USE(AnvilUseSound.class),
	BLOCK_DOOR_BUMP(DoorBumpSound.class),
	BLOCK_DOOR_BROKEN(DoorCrashSound.class),
	BLOCK_DOOR(DoorSound.class),
	BLOCK_LAVA_FIZZ(FizzSound.class),
	BLOCK_LEVER_PULL(LeverSound.class),

	NOTE_PIANO(NoteBoxSound.class),
	NOTE_BASS_DRUM(NoteBoxSound.class),
	NOTE_CLICK(NoteBoxSound.class),
	NOTE_TABOUR(NoteBoxSound.class),
	NOTE_BASS(NoteBoxSound.class),

	ENTITY_BAT_FLY(BatSound.class),
	ENTITY_TNT_PRIME(TNTPrimeSound.class),
	ENTITY_GHAST_SHOOT(GhastShootSound.class),
	ENTITY_BLAZE_SHOOT(BlazeShootSound.class),
	ENTITY_ENDERMAN_TELEPORT(EndermanTeleportSound.class),
	ENTITY_GHAST(GhastSound.class),
	ENTITY_FIREWORK_LAUNCH(LaunchSound.class),
	ENTITY_CHICKEN_EGG_POP(PopSound.class),
	ENTITY_ZOMBIE_HEAL(ZombieHealSound.class),
	ENTITY_ZOMBIE_INFECT(ZombieInfectSound.class),

	UI_BUTTOM_CLICK(ButtonClickSound.class),
	UI_CLICK(ClickSound.class);

	private Class<? extends GenericSound> type;

	private Sound(Class<? extends cn.nukkit.level.sound.GenericSound> type)
	{
		this.type = type;
	}

	public void play(Location location)
	{
		if (location == null)
			location = new Location(0, 0, 0);

		try
		{
			cn.nukkit.level.sound.Sound sound = type.getDeclaredConstructor(Vector3.class).newInstance(location);

			location.getLevel().addSound(sound);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Class<? extends GenericSound> getType()
	{
		return type;
	}

}