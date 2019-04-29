package com.example.pokedex2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface Pokeapi {
    String URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon")
    Call<Data> getPokemonNameAndPic();
}
