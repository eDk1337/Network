package com.example.a2ramae45.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSongActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);

        Button addSongButton = (Button)findViewById(R.id.addSongButton);
        addSongButton.setOnClickListener(this);

    }




    public void onClick(View view) {

        EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        String title = titleEditText.getText().toString();

        EditText artistEditText = (EditText)findViewById(R.id.artistEditText);
        String artist = artistEditText.getText().toString();

        EditText yearEditText = (EditText)findViewById(R.id.yearEditText);
        String year = yearEditText.getText().toString();


    }

}
