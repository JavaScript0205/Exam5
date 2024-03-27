package jsonApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Students {
    public static void main(String[] args) {
        String path = "src/main/java/jsonApi/students.json";

        try {
            Reader reader = new FileReader(path);
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            int totalAge = 0;
            int count = 0;
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject student = jsonArray.get(i).getAsJsonObject();
                totalAge += student.get("age").getAsInt();
                count++;
            }

            double averageAge = (double) totalAge / count;
            System.out.println("O'rtacha yosh: " + averageAge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
