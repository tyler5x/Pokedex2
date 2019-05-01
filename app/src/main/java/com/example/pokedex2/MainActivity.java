package com.example.pokedex2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String[] pokemonNames;
    private String[] pokemonURL;
    private String[] types;
    private String[] abilities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Pokeapi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Pokeapi pokeapi = retrofit.create(Pokeapi.class);

        Call<Data> call = pokeapi.getPokemonNameAndPic();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("response", response.body().toString());
                Data data = response.body();

                pokemonNames = new String[data.getResults().size()];
                pokemonURL = new String[data.getResults().size()];

                for (int i = 0; i < data.getResults().size(); i++) {
                    pokemonNames[i] = data.getResults().get(i).getName();
                    pokemonURL[i] = data.getResults().get(i).getUrl();
                }
                for (String item : pokemonNames) {
                    Log.d("item", item);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void makeCall(String pokemonUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Pokeapi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Pokeapi pokeapi = retrofit.create(Pokeapi.class);
        Call<Data> call2 = pokeapi.getPokemonData(pokemonUrl);

        call2.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call2, Response<Data> response) {
                Log.d("response", response.body().toString());
                Data data = response.body();

                types = new String[data.getTypes().size()];
                abilities = new String[data.getAbilities().size()];

                for (int i = 0; i < data.getTypes().size(); i++) {
                    types[i] = data.getTypes().get(i).getName();
                }
                for (int i = 0; i < data.getAbilities().size(); i++) {
                    abilities[i] = data.getAbilities().get(i).getName();
                }
                for (String item : types) {
                    Log.d("item", item);
                }
                for (String item : abilities) {
                    Log.d("item", item);
                }
            }

            @Override
            public void onFailure(Call<Data> call2, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showAbility(View view) {
        System.out.println("Ability is being called");
        SearchView sv = findViewById(R.id.askNum);
        TextView textView = findViewById(R.id.caption);
        int number = 0;
        try {
            number = Integer.valueOf(sv.getQuery().toString());
            if (number == 1) {
                textView.setText("The Pokemon's ability is overgrow.");;
            } else if (number == 4) {
                textView.setText("The Pokemon's ability is blaze.");
            } else if (number == 493) {
                textView.setText("The Pokemon's ability is multitype.");
            } else if (number == 487) {
                textView.setText("The Pokemon's ability is pressure.");
            } else if (number ==149) {
                textView.setText("The Pokemon's ability is inner focus and it's hidden ability is multiscale.");
            }
        } catch (Exception e) {
            textView.setText("Please enter a valid pokemon number.");
        }
    }

    @SuppressLint("SetTextI18n")

    public void showName(View view) {
        System.out.println("Name is being called");
        SearchView sv = findViewById(R.id.askNum);
        TextView textView = findViewById(R.id.caption);
        int number = 0;
        try {
            number = Integer.valueOf(sv.getQuery().toString());
            //makeCall(pokemonURL[number]);
            if (number == 1) {
                textView.setText("bulbasaur");
            } else {
                textView.setText("The pokemon's name is " + pokemonNames[number - 2] + ".");
            }
        } catch (Exception e) {
            textView.setText("Please enter a valid pokemon number.");
        }
    }
}
