package config.item;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;

public class Pack {
	public YamlConfiguration config;
	public File file;
	
	public Pack(YamlConfiguration config, File file) {
		this.config = config;
		this.file = file;
	}
}