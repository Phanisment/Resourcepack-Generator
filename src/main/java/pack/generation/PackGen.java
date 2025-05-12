package pack.generation;

import pack.PackBuilder;
import pack.NamespaceMeta;

public class PackGen {
	private PackBuilder builder;
	private NamespaceMeta meta;
	
	public PackGen(PackBuilder builder, NamespaceMeta meta) {
		this.builder = builder;
		this.meta = meta;
	}
	
	public PackBuilder getBuilder() {
		return this.builder;
	}
	
	public NamespaceMeta getMeta() {
		return this.meta;
	}
}