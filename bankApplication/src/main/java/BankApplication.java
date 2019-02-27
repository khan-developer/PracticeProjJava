import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import fileOperation.ReadJSON;
import model.CreateAccount;
import org.json.JSONException;
import org.json.JSONObject;
import util.UtilService;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BankApplication {
private ReadJSON readJSON;
private UtilService utilService;

    public void main(String[] args) throws IOException, JSONException {
        String requestType = utilService.getRequestType(args[0]);
        switch (requestType){
            case "createAccount":
                readJSON.createAccount(args[0]);
                break;
            case "credit":
                break;
            default:
        }

        //Read the json file
        byte[] jsonData = Files.readAllBytes(Paths.get(args[0]));
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        CreateAccount createAccount = objectMapper.readValue(jsonData, CreateAccount.class);
        System.out.println("CreateAccount Object\n"+createAccount);
        System.out.println(createAccount.getFirstName());
        writeFile(createAccount.getFirstName());
    }

    public static void writeFile( String fName) throws JSONException {
        JSONObject object = new JSONObject();
        object.put("firstName",fName);
        try(FileWriter file = new FileWriter("myJson.json")) {
            file.write(object.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(object);
    }
}
