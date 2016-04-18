package com.songokute.androidutil.restutil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Admin on 4/18/2016.
 */
public class RESTUtils {
    /**
     * Method: GET
     * Query Param: No
     * Header: No
     *
     * @param urlStr
     * @return
     */
    public static JSONObject getJSONObject(String urlStr) throws Exception {
        JSONObject ret = null;
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
            buffer.close();
            ret = new JSONObject(sb.toString());
        } catch (JSONException ex) {
            ret = null;
            throw new Exception("Return data is not a valid json object");
        }
        return ret;
    }

    /**
     * Method: GET
     * Query Param: No
     * Header: No
     *
     * @param urlStr
     * @return
     */
    public static JSONArray getJSONArray(String urlStr) throws Exception{
        JSONArray ret = null;
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
            buffer.close();
            ret = new JSONArray(sb.toString());
        } catch (JSONException ex) {
            throw new Exception("Return data is not a valid json array");
        }
        return ret;
    }
}
