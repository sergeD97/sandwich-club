package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try{

            JSONObject sandWichJson = new JSONObject(json);
            JSONObject sandWichNameJson = sandWichJson.getJSONObject("name");
            sandwich.setMainName(sandWichNameJson.getString("mainName"));
            sandwich.setPlaceOfOrigin(sandWichJson.getString("placeOfOrigin"));
            sandwich.setDescription(sandWichJson.getString("description"));
            sandwich.setImage(sandWichJson.getString("image"));
            sandwich.setIngredients(parseListStringJson(sandWichJson.getJSONArray("ingredients")));
            sandwich.setAlsoKnownAs(parseListStringJson(sandWichNameJson.getJSONArray("alsoKnownAs")));
            return sandwich;
        }catch(JSONException jse){
            return null;
        }



    }

    private static List<String> parseListStringJson(JSONArray jsonList){

        try{

            List<String> stringList = new ArrayList<>();
            int lenght = jsonList.length();
            for(int i = 0; i < lenght; i++){
                stringList.add(jsonList.getString(i));
            }
            return stringList;
        }catch (JSONException jse){
            return null;
        }

    }
}
