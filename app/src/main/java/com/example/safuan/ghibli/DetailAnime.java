package com.example.safuan.ghibli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAnime extends AppCompatActivity {

    TextView tvJudul,  tvDescription;
    ImageView imgAnime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anime);

        tvJudul = findViewById(R.id.tv_judul);
        tvDescription = findViewById(R.id.tv_description);
        imgAnime = findViewById(R.id.img_anime_desc);


    }
}
