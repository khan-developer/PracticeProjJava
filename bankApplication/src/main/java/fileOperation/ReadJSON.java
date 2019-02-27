package fileOperation;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.DBOperations;
import model.CreateAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSON {
    private DBOperations dbOperations;
    public void createAccount(String filePath){
        //Read the json file
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
            ObjectMapper objectMapper = new ObjectMapper();
            //convert json string to object
            CreateAccount createAccount = objectMapper.readValue(jsonData, CreateAccount.class);
            System.out.println("CreateAccount Object\n"+createAccount);
            //dbOperations
            //YYYY-MM-DD HH:MM:SS
            String mySqlDateTime = getMySqlDateTime();
            String accountHolderCode = "FR912561550846091638";
            dbOperations.createAccountHolder(accountHolderCode,mySqlDateTime);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getMySqlDateTime() {
        String currentDateTime ="";
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return currentDateTime = sdf.format(dt);
    }
}
