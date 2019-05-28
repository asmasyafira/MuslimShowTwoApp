package com.example.safuan.ghibli.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.safuan.ghibli.R;
import com.example.safuan.ghibli.adapter.DescritionGridAdapter;
import com.example.safuan.ghibli.adapter.FilmAnimeAdapter;
import com.example.safuan.ghibli.model.ghibli;
import com.example.safuan.ghibli.resource.GhibliData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<ghibli> list = new ArrayList<>();
    private String title = "Mode List";



    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_grid:
                showRecyclerGrid();
                setActionBarTitle("Description");
                break;
            case R.id.action_film:
                showRecyclerFilm();
                setActionBarTitle("Film");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvCategory = findViewById(R.id.rv_anime);
        rvCategory.setHasFixedSize(true);

        list.addAll(GhibliData.getListData());
        showRecyclerGrid();




    }





    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        DescritionGridAdapter gridAnimeAdapter = new DescritionGridAdapter(this);
        gridAnimeAdapter.setGhibliArrayLis(list);
        rvCategory.setAdapter(gridAnimeAdapter);
    }

    private void showRecyclerFilm() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this) );
        FilmAnimeAdapter filmAnimeAdapter = new FilmAnimeAdapter(this);
        filmAnimeAdapter.setGhibliArrayList(list);
        rvCategory.setAdapter(filmAnimeAdapter);
    }





}
