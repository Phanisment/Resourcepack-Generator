package pack.parser;

public class MetaParser implements PackParser {
	public Pack pack;
	public MetaParser(String description, int version) {
		this.pack = new Pack(description, version);
	}
	public static class Pack {
		String description;
		int pack_format;
		Pack(String description, int pack_format) {
			this.description = description;
			this.pack_format = pack_format;
		}
	}
}