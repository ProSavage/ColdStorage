package org.ctp.coldstorage.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.ctp.coldstorage.ColdStorage;
import org.ctp.coldstorage.database.tables.StorageTable;
import org.ctp.coldstorage.database.tables.Table;

public class Storage {
	
	private int amount;
	private Player player;
	private Material material;
	private String unique;
	
	public Storage(Player player, String unique, Material material, int amount) {
		setPlayer(player);
		setUnique(unique);
		setMaterial(material);
		setAmount(amount);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}
	
	public static Storage getStorage(Player player, String id) {
		Table table = ColdStorage.getDb().getTable(StorageTable.class);
		StorageTable storageTable = null;
		if(table instanceof StorageTable) {
			storageTable = (StorageTable) table;
		} else {
			return null;
		}
		return storageTable.getStorage(player, id);
	}
	
	public void updateStorage() {
		Table table = ColdStorage.getDb().getTable(StorageTable.class);
		StorageTable storageTable = null;
		if(table instanceof StorageTable) {
			storageTable = (StorageTable) table;
		} else {
			return;
		}
		storageTable.setPlayerStorage(this);
	}

}