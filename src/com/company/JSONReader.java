package com.company;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JSONReader
{
    public static List<String>  getusernames(int threshold){
        List<String> authors = new ArrayList<String>();
        URL url = null;
        int responsecode = 200;
        try {
            url = new URL("https://jsonmock.hackerrank.com/api/article_users/search?page=1");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            responsecode = conn.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(responsecode!=200){
            throw new RuntimeException("HttpResponseCode: " +responsecode);
        }
        else{
            int total_authors = 0;
            int total_pages = 0;
            try{
            JSONTokener tokener = new JSONTokener(url.openStream());
            JSONObject jobj = new JSONObject(tokener);
            
            total_authors = Integer.parseInt(jobj.get("total").toString());
            total_pages = Integer.parseInt(jobj.get("total_pages").toString());
            }catch(Exception e){
                e.printStackTrace();
            }

            for(int pagenumber=1;pagenumber<=total_pages;pagenumber++){

                try {
                    url = new URL("https://jsonmock.hackerrank.com/api/article_users/search?page=" + pagenumber);

                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    responsecode = conn.getResponseCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(responsecode!=200){
                    throw new RuntimeException("HttpResponseCode: " +responsecode);
                }
                else{
                    
                    try{
                        JSONTokener new_tokener = new JSONTokener(url.openStream());
                        JSONObject _jobj = new JSONObject(new_tokener);
                        JSONArray data = (JSONArray) _jobj.get("data");
                        for(int i=0;i<(int)data.length();i++){
                            JSONObject author = (JSONObject)data.get(i);
                            if(Integer.parseInt(author.get("submission_count").toString())>threshold){
                                authors.add(author.get("username").toString());
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }
        return authors;
    }
}
