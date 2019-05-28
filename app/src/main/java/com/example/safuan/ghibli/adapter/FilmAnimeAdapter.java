package com.example.safuan.ghibli.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.safuan.ghibli.DetailAnime;
import com.example.safuan.ghibli.R;
import com.example.safuan.ghibli.model.ghibli;
import com.example.safuan.ghibli.resource.GhibliData;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class FilmAnimeAdapter extends RecyclerView.Adapter<FilmAnimeAdapter.FilmViewHolder> {
    private Context context;
    private ArrayList<ghibli> ghibliArrayList;


    public FilmAnimeAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<ghibli> getGhibliArrayList() {
        return ghibliArrayList;
    }

    public void setGhibliArrayList(ArrayList<ghibli> list) {
        this.ghibliArrayList = list;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int a) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_film,viewGroup,false);
        return new FilmViewHolder(view);


    }


    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder filmViewHolder, int i) {
        ghibli ghibli1 = getGhibliArrayList().get(i);

        Glide.with(context).load(ghibli1.getPhoto()).apply(new RequestOptions().override(130,150))
                .into(filmViewHolder.imgFilm);

        filmViewHolder.tvFilm.setText(ghibli1.getName());
        filmViewHolder.tvDesc.setText(ghibli1.getDescription());

    }



    @Override
    public int getItemCount() {
        return getGhibliArrayList().size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {

        TextView tvFilm,tvDesc;
        ImageView imgFilm;
        Button btnOpen;

        public FilmViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvFilm = itemView.findViewById(R.id.tv_name_film);
            imgFilm = itemView.findViewById(R.id.img_card_anime);
            tvDesc = itemView.findViewById(R.id.tv_name_desc);
            btnOpen = itemView.findViewById(R.id.btn_open_card);


            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(v.getContext(), DetailAnime.class);
                    context.startActivity(a);
                }
            });
        }
    }
}
