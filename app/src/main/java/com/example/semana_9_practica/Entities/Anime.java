package com.example.semana_9_practica.Entities;

public class Anime {
    public int id;
    public String Name;

    public Anime() {
    }

    public Anime(String Name) {
        this.Name = Name;
    }

    public Anime(int id, String Name) {
        this.id = id;
        this.Name = Name;
    }
}

