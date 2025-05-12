package pack.parser;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class SoundParser implements PackParser {
	public Map<String, Sound> sounds = new HashMap<>();
	
	public SoundParser(String name, String path) {
		this(name, new Sound(null, null, List.of(path)));
	}
	
	public SoundParser(String name, Sound sound) {
		sounds.put(name, sound);
	}
	
	public static class Sound {
		public Boolean replace;
		public String subtitle;
		public List<Object> sounds;
		
		public Sound(Boolean replace, String subtitle, List<Object> sounds) {
			this.replace = replace;
			this.subtitle = subtitle;
			this.sounds = sounds;
		}
	}
}