package com.example.semana_9_practica.Services;

import com.example.semana_9_practica.Entities.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {

    @GET("/v3/caa1dfe4-f52d-4489-9ca6-4c62370416f9")
    Call<List<Anime>> GetAnime();
}
