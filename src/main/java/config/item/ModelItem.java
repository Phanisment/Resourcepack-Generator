package config.item;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.Material;

public class ModelItem {
	private ConfigurationSection config;
	private Pack pack;
	private String id;
	
	public Material base;
	public String model;
	public int model_data;
	
	public ModelItem(Pack pack, ConfigurationSection config, String id) {
		this.config = config;
		this.pack = pack;
		this.id = id;
		try {
			this.base = Material.valueOf(config.getString("base", "STICK").toUpperCase());
			this.model = config.getString("model");
			this.model_data = config.getInt("model_data", 0);
		} catch (Exception e) {
		}
	}
	
	// Getter
	public Pack getPack() {
		return this.pack;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Material getBase() {
		return this.base;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getModelData() {
		return this.model_data;
	}
	
	// Setter
	public void setBase(Material value) {
		this.config.set("base", value);
		this.base = value;
		save();
	}
	
	public void setModel(String value) {
		this.config.set("model", value);
		this.model = value;
		save();
	}
	
	public void setModelData(int value) {
		this.config.set("model_data", value);
		this.model_data = value;
		save();
	}
	
	private void save() {
		try {
			this.pack.config.save(this.pack.file);
		} catch (Exception e) {
			System.out.println("Failed to save config for model " + this.id + ": " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "ModelItem{id=" + id + ";base=" + base + ";model=" + model + ";model_data=" + model_data + "}";
	}
}