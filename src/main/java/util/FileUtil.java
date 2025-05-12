package util;

import java.io.File;

public class FileUtil {
	public static String surfix(String value, String surfix) {
		if (!value.endsWith("." + surfix)) return value + "." + surfix;
		return value;
	}
	
	public static void delete(File file) {
		if (file.isDirectory()) {
			File[] children = file.listFiles();
			if (children != null) {
				for (File child : children) {
					delete(child);
				}
			}
		}
		file.delete();
	}
}