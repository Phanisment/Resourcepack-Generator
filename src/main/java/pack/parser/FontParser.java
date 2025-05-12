package pack.parser;

import org.bukkit.configuration.ConfigurationSection;

import config.item.Pack;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FontParser implements PackParser {
	List<Font> providers;
	public FontParser(List<Font> providers) {
		this.providers = providers;
	}
	
	public static class Font {
		public transient Pack pack;
		public transient ConfigurationSection config;
		public transient String namespace;
		
		public String type;
		public String file;
		public Integer height;
		public Integer ascent;
		public List<Character> chars;
		public Map<String, Integer> advances;
		
		public Font(Pack pack, ConfigurationSection config, String namespace) {
			this.pack = pack;
			this.config = config;
			this.namespace = namespace;
			
			try {
				this.type = config.getString("type", "bitmap");
				this.file = config.getString("file");
				if (config.contains("height")) this.height = config.getInt("height");
				if (config.contains("ascent")) this.ascent = config.getInt("ascent");
				this.chars = (List<Character>)config.getList("chars", new ArrayList<>());
				if (config.contains("advances")) {
					this.advances = new HashMap<>();
					for (String c : config.getConfigurationSection("advances").getKeys(false)) {
						int asc = config.getInt("advances." + c);
						advances.put(c, asc);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}