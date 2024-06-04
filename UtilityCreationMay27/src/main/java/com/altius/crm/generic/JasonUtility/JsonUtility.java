package com.altius.crm.generic.JasonUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser jparser=new JSONParser();
		Object obj=jparser.parse(new FileReader("./configAppData/commonDataJson.txt"));
		JSONObject jobj=(JSONObject)obj;
		String data=jobj.get(key).toString();
		return data;
	}

}
