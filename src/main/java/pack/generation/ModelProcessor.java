package pack.generation;

import pack.PackBuilder;
import pack.NamespaceMeta;
import config.item.ModelItem;
import util.FileUtil;

import java.util.Map;
import java.io.File;

public class ModelProcessor extends PackGen {
	public ModelProcessor(PackBuilder builder, NamespaceMeta meta) {
		super(builder, meta);
		Map<String, ModelItem> items = builder.getConfigReader().getItemConfig();
		for (String id : items.keySet()) {
			ModelItem model_item = items.get(id);
			File model_file = new File(meta.file, "models/" + FileUtil.surfix(model_item.model, "json"));
			if (model_file.exists()) {
				System.out.println(model_file.toPath());
			}
		}
	}
}