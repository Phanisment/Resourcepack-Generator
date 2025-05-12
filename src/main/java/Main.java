import pack.PackBuilder;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		new PackBuilder(new File("packs"), new File(".data/output"));
	}
}