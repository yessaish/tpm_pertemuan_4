package com.yessa.tugas4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Heroes> heroes;

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HeroesAdapter.ViewHolder holder, final int position) {
        holder.tvName.setText(getHeroes().get(position).getHeroName());
        holder.tvDetail.setText(getHeroes().get(position).getHeroDetail());

        Glide.with(context).load(getHeroes().get(position).getHeroImage()).into(holder.ivHero);

        holder.tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,IsiActivity.class);

                String isi = getHeroes().get(position).getHeroDetail();
                intent.putExtra("isi",isi);

                String nama = getHeroes().get(position).getHeroName();
                intent.putExtra("nama",nama);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHero;
        TextView tvName, tvDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHero = itemView.findViewById(R.id.itemHero_iv_foto);
            tvName = itemView.findViewById(R.id.itemHero_tv_nama);
            tvDetail = itemView.findViewById(R.id.itemHero_tv_deskripsi);
        }
    }
}
