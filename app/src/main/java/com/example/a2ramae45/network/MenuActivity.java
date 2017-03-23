package com.example.a2ramae45.network;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button downloadSongButton = (Button) findViewById(R.id.downloadSongButton);
        downloadSongButton.setOnClickListener(this);

        Button addSongButton = (Button) findViewById(R.id.addSongButton);
        addSongButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.downloadSongButton) {
            startActivity(new Intent(this, DownloadActivity.class));
        }
        else if (view.getId() == R.id.addSongButton) {
            startActivity(new Intent(this, AddSongActivity.class));

    }

    }
}
