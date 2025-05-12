package pack.generation;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Material;

import pack.PackBuilder;
import pack.NamespaceMeta;
import pack.parser.ModelParser;
import config.item.ModelItem;
import config.item.Pack;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ConfigurationProcessor extends PackGen {
	protected static Map<Material, Map<String, Integer>> model_data = new HashMap<>();
	protected static Map<String, ModelItem> model_item = new HashMap<>();
	
	public ConfigurationProcessor(PackBuilder builder, NamespaceMeta meta) {
		super(builder, meta);
		
		File config_file = new File(meta.file, "configs.yml");
		File config_folder = new File(meta.file, "configs");
		if (config_file.exists()) {
			if (config_folder.exists()) return;
			YamlConfiguration config = YamlConfiguration.loadConfiguration(config_file);
			for (String id : config.getKeys(false)) {
				ModelItem item_data = new ModelItem(new Pack(config, config_file), config.getConfigurationSection(id), meta.name + ":" + id);
				if (item_data != null) {
					model_data.putIfAbsent(item_data.base, new HashMap<>());
					Map<String, Integer> items = model_data.get(item_data.base);
					model_item.put(meta.name + ":" + id, item_data);
					if (item_data.model_data < 1) {
						int n_model_data = this.find(items);
						items.put(meta.name + ":" + id, n_model_data);
						model_data.put(item_data.base, items);
					} else {
						items.put(meta.name + ":" + id, item_data.model_data);
						model_data.put(item_data.base, items);
					}
				}
			}
		}
		if (config_folder.exists()) {
			if (config_file.exists()) return;
		}
	}
	
	protected int find(Map<String, Integer> item) {
		int id = 1;
		List<Integer> used = new ArrayList<>(item.values());
		while (used.contains(id)) {
			id++;
		}
		return id;
	}
	
	public static Map<Material, Map<String, Integer>> getListItemBase() {
		return model_data;
	}
	
	public static Map<String, ModelItem> getItemConfig() {
		return model_item;
	}
	
	public ModelItem getModelItem(String id) {
		return model_item.get(id);
	}
}