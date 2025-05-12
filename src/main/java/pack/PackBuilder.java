package pack;

import pack.generation.*;
import pack.NamespaceMeta;

import java.io.File;

public class PackBuilder {
	public static File input;
	public static File output;
	
	private static ConfigurationProcessor configuration_processor;
	private static ModelProcessor model_processor;
	
	public PackBuilder(File input, File output) {
		this.input = input;
		this.output = output;
		
		// Read Data
		File[] files = input.listFiles();
		for (File nmsc : files) {
			String name = nmsc.getName();
			if (!name.equals("minecraft")) {
				boolean is_zip = false;
				if (name.endsWith(".zip")) is_zip = true;
				NamespaceMeta meta = new NamespaceMeta(name, nmsc, is_zip);
				configuration_processor = new ConfigurationProcessor(this, meta);
				model_processor = new ModelProcessor(this, meta);
			} else {
				
			}
		}
	}
	
	// Generate Data
	public void generate() {
		
	}
	
	public static ConfigurationProcessor getConfigReader() {
		return configuration_processor;
	}
	
	public static ModelProcessor getModelReader() {
		return model_processor;
	}
	
	public File getInput() {
		return input;
	}
	
	public File getOutput() {
		return output;
	}
}