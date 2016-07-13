package fr.nukkit.api;

public enum GameMode
{
	SURVIVAL(0),
	CREATIVE(1),
	ADVENTURE(2),
	SPECTATOR(3);
	
	private int id;

	private GameMode(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
