package pack;
import java.io.File;
public class NamespaceMeta {
	public String name;
	public File file;
	public boolean isZip;
	
	public NamespaceMeta(String name, File file, boolean isZip) {
		this.name = name;
		this.file = file;
		this.isZip = isZip;
	}
}