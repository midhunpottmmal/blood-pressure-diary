package epicgraph.com.process;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import epicgraph.com.objects.ListData;
import epicgraph.com.objects.SendData;

/**
 * Created by Midhun on 10-09-2015.
 */
public class AddDataProcess {


    public void SaveData(List data){
        restService(data);
        Log.v("myApp", "no network");

    }

    private  void restService(List data){
        String url = "http://192.168.2.106:3000/tickets";
        HttpResponse httpResponse = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost =new HttpPost(url);
        //httpPost.setHeader("Content-Type", "application/json");
        try {
            System.out.println(new UrlEncodedFormEntity(data).getContent());
            httpPost.setEntity(new UrlEncodedFormEntity(data));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("http get created");
        try {
            httpResponse = httpClient.execute(httpPost);
            System.out.println(httpResponse.getEntity().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertToJson(SendData data) {

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("Systolic",data.getSystolic());
            jsonObj.put("diastolic",data.getDiastolic());
            jsonObj.put("pulse",data.getPulse());
            jsonObj.put("weight",data.getPulse());
            jsonObj.put("site",data.getSite());
            jsonObj.put("date",data.getDate());
            jsonObj.put("note",data.getNote());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObj.toString();

    }


    }




