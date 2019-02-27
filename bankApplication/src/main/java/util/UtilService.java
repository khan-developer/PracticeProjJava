package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class UtilService {

    public String getRequestType(String filePath){
        String requestType="";
        JSONParser parser = new JSONParser();
        {
            try {
              Object obj = parser.parse(new FileReader(filePath));
              JSONObject jsonObject = (JSONObject) obj;
              requestType = (String) jsonObject.get("requestType");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return requestType;
    }

}
