package com.example.pokedex2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Pokeapi {
    String URL = "https://pokeapi.co/api/v2/";
    //String pokemonNumber = "1";

    @GET("pokemon/?limit=949&offset=1")
    Call<Data> getPokemonNameAndPic();

    @GET
    Call<Data> getPokemonData(@Url String url);
}
