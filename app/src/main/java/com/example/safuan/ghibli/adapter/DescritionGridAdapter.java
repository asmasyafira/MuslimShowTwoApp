package com.example.safuan.ghibli.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.safuan.ghibli.R;
import com.example.safuan.ghibli.model.ghibli;

import java.util.ArrayList;

public class DescritionGridAdapter extends RecyclerView.Adapter<DescritionGridAdapter.DescViewHolder> {
    private Context context;
    private ArrayList<ghibli> ghibliArrayLis;

    public DescritionGridAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<ghibli> getGhibliArrayLis() {
        return ghibliArrayLis;
    }

    public void setGhibliArrayLis(ArrayList<ghibli> ghibliArrayLis) {
        this.ghibliArrayLis = ghibliArrayLis;
    }

    @NonNull
    @Override
    public DescViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int a) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_description_anime,viewGroup,false);
        return new DescViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DescViewHolder descViewHolder, int i) {
        Glide.with(context)
                .load(getGhibliArrayLis().get(i).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(descViewHolder.imgPhoto);

        descViewHolder.tvName.setText(getGhibliArrayLis().get(i).getName());
    }

    @Override
    public int getItemCount() {
        return getGhibliArrayLis().size();
    }

    public class DescViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

        public DescViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_desc_grid);
            tvName = itemView.findViewById(R.id.tv_item_desc_grid);

        }

    }
}
