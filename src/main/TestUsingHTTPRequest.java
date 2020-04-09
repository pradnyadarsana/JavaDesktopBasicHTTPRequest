/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DAO.ApiUkuranHewan;
import model.UkuranHewanModel;
import response.GetUkuranHewan;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import response.PostUpdateDelete;
import response.SearchUkuranHewan;

/**
 *
 * @author Smith
 */
public class TestUsingHTTPRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
        // TODO code application logic here
        ApiUkuranHewan apiukuranhewan = new ApiUkuranHewan();
        GetUkuranHewan responseGetUkuranHewan;
        PostUpdateDelete responsePUD;
        SearchUkuranHewan responseSearchUkuranHewan;
        
        //NOTE: comment yang tidak ingin anda coba
        //EXAMPLE: comment bagian retrieve dan insert jika ingin mencoba search, begitupun sebaliknya
        
        //test retrieve ukuran hewan using get method
        responseGetUkuranHewan = apiukuranhewan.getDataUkuranHewan();
        //print value of list of ukuran hewan in console
        System.out.println(responseGetUkuranHewan.isError());
        System.out.println("Isi list ukuran hewan (hanya menampilkan nama) :");
        for(int i=0;i < responseGetUkuranHewan.getListUkuranHewan().size();i++){
           System.out.println(responseGetUkuranHewan.getListUkuranHewan().get(i).getNama());
        }
        
        //test insert ukuran hewan using post method
        responsePUD = apiukuranhewan.insertDataUkuranHewan("Tiny", "admin");
        //print api response
        System.out.println(responsePUD.isError());
        System.out.println(responsePUD.getMessage());
        
        //test search ukuran hewan using get method
        responseSearchUkuranHewan = apiukuranhewan.searchDataUkuranHewan("4");
        //print api response
        System.out.println(responseSearchUkuranHewan.isError());
        System.out.println(responseSearchUkuranHewan.getUkuranHewan().getNama());
    } 
    
}
