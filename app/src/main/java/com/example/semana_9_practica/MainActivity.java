package com.example.semana_9_practica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.semana_9_practica.Adapters.AnimeAdapter;
import com.example.semana_9_practica.Entities.Anime;
import com.example.semana_9_practica.Services.AnimeService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static  String URL = "https://www.crunchyroll.com/es/fairy-tail";
    private  ImageView Imagen;
    List<Anime> Animes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        CargarImagenInternet();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimeService service = retrofit.create(AnimeService.class);

        Call<List<Anime>> call = service.GetAnime();
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Semana_9", "Error de aplicación");
                } else {
                    Log.i("Semana_9", "Respuesta Correcta");
                    Log.i("Semana_9", new Gson().toJson(response.body()));
                    Animes = response.body();
                    AnimeAdapter Adapter = new AnimeAdapter(Animes);
                    RecyclerView rv = findViewById(R.id.rvAnimes);
                    rv.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
                    rv.setHasFixedSize((true));
                    rv.setAdapter(Adapter);
                }
            }
            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                Log.e("Semana_9", "No hubo conectividad con el servicio web");
            }
        });

    }
    private void setUpView() {
        Imagen = findViewById(R.id.imageAnime);
    }
    private void CargarImagenInternet() {
        Picasso.get().load(URL).into(Imagen);
    }
}