/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.UkuranHewanModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import response.GetUkuranHewan;
import response.PostUpdateDelete;
import response.SearchUkuranHewan;

/**
 *
 * @author Smith
 */
public class ApiUkuranHewan extends ApiClient{
    Type ukuranHewanListType = new TypeToken<ArrayList<UkuranHewanModel>>(){}.getType();
    GetUkuranHewan ResponseResultGet = new GetUkuranHewan();
    PostUpdateDelete ResponseResultPUD = new PostUpdateDelete();
    SearchUkuranHewan ResponseSearch = new SearchUkuranHewan();
    List<UkuranHewanModel> ListUkuranHewan = new ArrayList<>();
    

    public ApiUkuranHewan() throws IOException {}
    
    public void createConnection(String path) throws MalformedURLException, IOException{
        urlcon = new URL(URL + path);
        con = (HttpURLConnection) urlcon.openConnection();
    }
    
    public GetUkuranHewan getDataUkuranHewan() throws MalformedURLException, IOException, JSONException{
        try{
            String path = "UkuranHewan";
            createConnection(path);//Build HTTP connection
            
            // add request HTTP method (optional, default is GET, method available: GET, POST, PUT, DELETE, OPTION)
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/json"); 
            con.setRequestProperty("Accept", "application/json"); 

            System.out.println("\nSending 'GET' request to URL : " + URL+path);

            //get response from request
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));;
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();

            //print response result in String
            System.out.println(response.toString());

            //Read JSON response
            RequestResponse = new JSONObject(response.toString());
            ResponseListData = RequestResponse.getJSONArray("message");
            String jsondata = ResponseListData.toString();

            //Create response with GetUkuranHewan class
            ResponseResultGet.setError(RequestResponse.getBoolean("error"));
            
            //parse JSON Response to list of ukuran hewan object
            ResponseResultGet.setListUkuranHewan(gson.fromJson(jsondata, ukuranHewanListType));
            
            ListUkuranHewan = ResponseResultGet.getListUkuranHewan();
            
            return ResponseResultGet;
        }catch(UnknownHostException e){
            System.out.println("Network Connection Problem");
            ResponseResultGet = new GetUkuranHewan(true, null);
            return ResponseResultGet;
        }
    }
    
    public PostUpdateDelete insertDataUkuranHewan(String nama, String created_by) throws MalformedURLException, IOException, JSONException{
        try{
            String path = "UkuranHewan";
            
	    Map params = new LinkedHashMap<>();
	    params.put("nama", nama);
	    params.put("created_by", created_by);
	    StringBuilder postData = new StringBuilder();
            for (Iterator it = params.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String, String> param = (Map.Entry<String, String>) it.next();
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
	    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	    
            createConnection(path);
	    con.setRequestMethod("POST");
	    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //con.setRequestProperty("Content-Type", "application/json"); 
            con.setRequestProperty("Accept", "application/json"); 
	    con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	    con.setDoOutput(true);
	    con.getOutputStream().write(postDataBytes);
            
            System.out.println("\nSending 'POST' request to URL : " + URL+path);

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));;
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();

            //print response result in String
            System.out.println(response.toString());

            //Read JSON response
            RequestResponse = new JSONObject(response.toString());

            //Create response with PostUpdateDelete class
            ResponseResultPUD.setError(RequestResponse.getBoolean("error"));
            ResponseResultPUD.setMessage(RequestResponse.optString("message"));
            
            return ResponseResultPUD;
        }catch(UnknownHostException e){
            System.out.println("Network Connection Problem");
            ResponseResultPUD = new PostUpdateDelete(true, null);
            return ResponseResultPUD;
        }
    }
    
    public SearchUkuranHewan searchDataUkuranHewan(String id) throws MalformedURLException, IOException, JSONException{
        try{
            String path = "UkuranHewan/search/"+id;
            createConnection(path);//Build HTTP connection
            
            // add request HTTP method (optional, default is GET, method available: GET, POST, PUT, DELETE, OPTION)
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/json"); 
            con.setRequestProperty("Accept", "application/json"); 

            System.out.println("\nSending 'GET' request to URL : " + URL+path);

            //get response from request
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));;
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();

            //print response result in String
            System.out.println(response.toString());

            //Read JSON response
            RequestResponse = new JSONObject(response.toString());
            ResponseData = RequestResponse.getJSONObject("message");
            String jsondata = ResponseData.toString();

            //Create response with GetUkuranHewan class
            //set error in search response
            ResponseSearch.setError(RequestResponse.getBoolean("error"));
            //parse JSON Response message to ukuran hewan object
            ResponseSearch.setUkuranHewan(gson.fromJson(jsondata, UkuranHewanModel.class));
            
            return ResponseSearch;
        }catch(UnknownHostException e){
            System.out.println("Network Connection Problem");
            ResponseSearch = new SearchUkuranHewan(true, null);
            return ResponseSearch;
        }
    }
}
