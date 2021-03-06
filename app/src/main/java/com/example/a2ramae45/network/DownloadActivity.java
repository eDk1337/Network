package com.example.a2ramae45.network;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;
import android.widget.TextView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.app.AlertDialog;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class DownloadActivity extends Activity implements View.OnClickListener{

    class MyTask extends AsyncTask<String,Void,String>
    {
        public String doInBackground(String... params)
        {

            String url = params[0];
            String artist = params[1];
            HttpURLConnection conn = null;
            try
            {
                URL urlObj = new URL(url + "?artist=" +artist +"&format=json");
                conn = (HttpURLConnection) urlObj.openConnection();
                InputStream in = conn.getInputStream();
                if(conn.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String result = "", line;
                    while ((line = br.readLine()) != null)
                        result += line;


                    JSONArray jsonArray = new JSONArray(result);
                    String output = "";
                    for (int i=0; i<jsonArray.length(); i++) {
                        JSONObject songObj = jsonArray.getJSONObject(i);
                        String songTitle = songObj.getString("song");
                        String artistName = songObj.getString("artist");
                        String year = songObj.getString("year");

                        String pretty = "Song Title: " + songTitle;
                        pretty += ", Artist: " + artistName;
                        pretty += ", Year: " + year;

                        output += pretty;
                    }
                    return output;
                }
                else
                    return "HTTP ERROR: " + conn.getResponseCode();


            }
            catch(IOException e)
            {
                return e.toString();
            } catch (JSONException e) {
                return e.toString();

            } finally
            {
                if(conn!=null)
                    conn.disconnect();
            }

        }
        @Override
        public void onPostExecute(String result)
        {
            TextView displaySongText = (TextView)findViewById(R.id.displaySongText);
            displaySongText.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Button go = (Button)findViewById(R.id.btn1);
        go.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        TextView urlTextView = (TextView)findViewById(R.id.urlEditText);
        String url = urlTextView.getText().toString();

        EditText artistEditText = (EditText)findViewById(R.id.artistEditText);
        String artist = artistEditText.getText().toString();

        new MyTask().execute(url, artist);

    }



}
