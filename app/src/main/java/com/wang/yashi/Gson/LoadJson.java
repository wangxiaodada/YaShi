package com.wang.yashi.Gson;

import android.content.Context;

import com.wang.yashi.fragment.ShouYeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LoadJson {
    private Context mContext;
    public LoadJson(Context ctx) {
        mContext = ctx;
    }


    public String loadJSONFromAsset(String fileName){
        String json = null;
        try{
            InputStream inputStream = mContext.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    public List<Navigator> getNavigator(String fileName){
        List<Navigator> result = new ArrayList<>();
        String json = loadJSONFromAsset(fileName);
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("jsonArray");
            for (int i = 0; i < jsonArray.length(); i++){
                Navigator navigator = new Navigator();
                JSONObject item = jsonArray.getJSONObject(i);
                navigator.setUrl(item.getString("url"));
                navigator.setTitle(item.getString("title"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}