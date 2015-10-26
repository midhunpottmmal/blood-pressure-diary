package epicgraph.com.process;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import epicgraph.com.objects.ListData;
import epicgraph.com.sevicehanler.DatabaseOpenHelper;

/**
 * Created by Midhun on 10-09-2015.
 */
public class GetDataProcess {



   public ArrayList<ListData> getData(SQLiteDatabase mDB){

    //   String result = restService();

       return resultToList(mDB);
    }


    private ArrayList<ListData> resultToList( SQLiteDatabase mDB) {


        ArrayList<ListData> resultData =new ArrayList<ListData>();

        Cursor c = readArtists(mDB);

            c.moveToLast();
            if (c.isLast()) {
                //c.moveToPrevious();
                do {

                    resultData.add(new ListData(c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5),
                            c.getString(6), c.getString(7)));



                 } while (c.moveToPrevious()) ;

            }


        return resultData;
    }
    String restService(){
        String url = "http://192.168.2.102:3000/tickets";
        HttpResponse httpResponse = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet =new HttpGet(url);
        //httpPost.setHeader("Content-Type", "application/json");

        System.out.println("http get created");
        try {
            httpResponse = httpClient.execute(httpGet);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(httpResponse.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cursor readArtists(SQLiteDatabase mDB) {
        return mDB.query(DatabaseOpenHelper.TABLE_NAME,
                DatabaseOpenHelper.columns, null, new String[] {}, null, null,
                null);
    }
}
