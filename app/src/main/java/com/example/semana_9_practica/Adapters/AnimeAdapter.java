package com.example.semana_9_practica.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana_9_practica.Entities.Anime;
import com.example.semana_9_practica.R;

import java.util.List;


public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ContactViewHolder> {

    List<Anime> Animes;
    public AnimeAdapter(List<Anime> contacts) {
        this.Animes = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {

        View itemView = vh.itemView;
        Anime Anime = Animes.get(position);
        TextView textAnime = itemView.findViewById(R.id.textAnime);
        textAnime.setText(Anime.Name);
    }

    @Override
    public int getItemCount() {
        return Animes.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}