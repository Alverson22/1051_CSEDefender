package data;

public enum TileType {

	Grass("grass64", true), Dirt("dirt64", false), Water("water64", false), NULL("water64", false),castle1("castle-1",false),castle2("castle-2",false),castle3("castle-3",false),castle4("castle-4",false),castle5("castle-5",false),castle6("castle-6",false),castle7("castle-7",false),castle8("castle-8",false),castle9("castle-9",false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable)
	{
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
