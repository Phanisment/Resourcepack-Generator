package pack.parser;

import java.util.List;

public class AnimParser implements PackParser {
	public Animation animation;
	
	public AnimParser(Integer frametime) {
		this.animation = new Animation(null, null, frametime, null, null);
	}
	
	public AnimParser(Animation animation) {
		this.animation = animation;
	}
	
	public static class Animation {
		public Integer width;
		public Integer height;
		public Integer frametime;
		public Boolean interpolate;
		public List<Object> frames;
		
		public Animation(Integer width, Integer height, Integer frametime, Boolean interpolate, List<Object> frames) {
			this.width = width;
			this.height = height;
			this.frametime = frametime;
			this.interpolate = interpolate;
			this.frames = frames;
		}
	}
}