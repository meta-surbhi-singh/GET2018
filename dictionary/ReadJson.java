package dictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
    
    /**
     * Parse the JSON object form JSON file.
     * @return returns JSON object.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static JSONObject readJson() throws FileNotFoundException, IOException, ParseException
    {
        JSONParser jsonParser=new JSONParser();
        Object object=jsonParser.parse(new FileReader("IntialDictionaryValues.json.txt"));
        JSONObject jsonObject=(JSONObject)object;
        return jsonObject;
    }

}
