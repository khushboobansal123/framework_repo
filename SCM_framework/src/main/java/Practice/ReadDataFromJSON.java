package Practice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromJSON {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		//step 1: parse JSON Physical file in to java Object using JSONParser class
		
		JSONParser parser = new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\Asus\\OneDrive\\Desktop\\JSONData\\PracticeData.json"));
		
		//step 2: Convert java Object into JSON object using downcasting
		
		JSONObject map=(JSONObject) obj;
		
		//Step 3: get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		
		//in our selenium script we have to use toString method because map.get method returns the data in Object form so to convert it into String form
		// map.get("url").toString
		
		

	}

}
