package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import data.Tile;
import data.TileGrid;
import data.TileType;

public class Leveler {
	public static void SaveMap(String mapName, TileGrid grid){
		String mapData = "";
		System.out.println(grid.getTilesWide());
		for(int i=0;i<grid.getTilesWide();i++){
			for(int j=0;j<grid.getTilesHigh();j++){
				mapData += getTileID(grid.getTile(i,j)); 
				System.out.println(mapData);
			}
		}
		
		try {
			File file = new File(mapName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(mapData);
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static TileGrid LoadMap(String mapName){
		TileGrid grid = new TileGrid();
		try{
			BufferedReader br = new BufferedReader(new FileReader(mapName));
			String data = br.readLine();
			for(int i = 0 ; i<grid.getTilesWide() ; i++){
				for(int j = 0 ; j<grid.getTilesHigh();j++){
					grid.setTile(i,j,getTileType(data.substring(i * grid.getTilesHigh() + j, i * grid.getTilesHigh() + j + 1)));
					
				}
			}
			br.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return grid;
	}
	
	public static TileType getTileType(String ID){
		TileType type = TileType.NULL;
		switch(ID){
		case "0":
			type = TileType.Grass;
			break;
		case "1":
			type = TileType.Dirt;
			break;
		case "2":
			type = TileType.Water;
			break;
		case "3":
			type = TileType.castle1;
			break;
		case "4":
			type = TileType.castle2;
			break;
		case "5":
			type = TileType.castle3;
			break;
		case "6":
			type = TileType.castle4;
			break;
		case "7":
			type = TileType.castle5;
			break;
		case "8":
			type = TileType.castle6;
			break;
		case "9":
			type = TileType.castle7;
			break;
		case "a":
			type = TileType.castle8;
			break;
		case "b":
			type = TileType.castle9;
			break;
		case "c":
			type = TileType.NULL;
			break;
		}
		return type;
	}
	
	public static String getTileID(Tile t){
		String ID = "E";
		switch(t.getType()){
		case Grass:
			ID = "0";
			break;
		case Dirt:
			ID = "1";
			break;
		case Water:
			ID = "2";
			break;
		case castle1:
			ID = "3";
			break;
		case castle2:
			ID = "4";
			break;
		case castle3:
			ID = "5";
			break;
		case castle4:
			ID = "6";
			break;
		case castle5:
			ID = "7";
			break;
		case castle6:
			ID = "8";
			break;
		case castle7:
			ID = "9";
			break;
		case castle8:
			ID = "a";
			break;
		case castle9:
			ID = "b";
			break;
		case NULL:
			ID = "c";
			break;
		}
		return ID;
	} 
}
