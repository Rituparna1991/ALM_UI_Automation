package com.alm.automation.genericutils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.google.gson.Gson;

public class JSONFileUtils {
	String className;

	public JSONFileUtils(String className) {
		this.className = className;
	}

	public String getJsonValue(String data) {
		String dirPath = SleepUtils.getCurrentDirPath();
		String resultData = null;
		try {
			Gson gson = new Gson();
			Reader reader = Files.newBufferedReader(Paths.get(dirPath + "\\TestDataFiles\\" + className + ".json"));
			Map<?, ?> map = gson.fromJson(reader, Map.class);
			for (Map.Entry<?, ?> entry : map.entrySet()) {
				if (entry.getKey().toString().equalsIgnoreCase(data)) {
					resultData = entry.getValue().toString();
				}
			}
		} catch (IOException e) {
		}
		return resultData;
	}

	public static void main(String[] args) throws IOException {
		// JSONFileUtils.readJSONFile("testusername");

	}
}
