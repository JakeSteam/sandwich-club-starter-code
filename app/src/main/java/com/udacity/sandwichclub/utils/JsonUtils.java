package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            return new Sandwich(
                    sandwichJson.getJSONObject("name").getString("mainName"),
                    jsonArrayToList(sandwichJson.getJSONObject("name").getJSONArray("alsoKnownAs")),
                    sandwichJson.getString("placeOfOrigin"),
                    sandwichJson.getString("description"),
                    sandwichJson.getString("image"),
                    jsonArrayToList(sandwichJson.getJSONArray("ingredients"))
            );
        } catch (JSONException e) {
            return null;
        }
    }

    private static List<String> jsonArrayToList(JSONArray jsonArray) throws JSONException {
        ArrayList<String> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++){
                list.add(jsonArray.getString(i));
            }
        }
        return list;
    }
}
