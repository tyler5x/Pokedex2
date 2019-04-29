package com.example.pokedex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private String[] pokemonNames;
    private String[] types;
    private String[] abilities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final ListView listView = (ListView) findViewById(R.id.listView);

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
                //types = new String[data.getResults().size()];
                //abilities = new String[data.getResults().size()];

                for (int i = 0; i < data.getResults().size(); i++) {
                    pokemonNames[i] = data.getResults().get(i).getName();
                    //abilities[i] = data.getResults().get(i).getAbility();
                    //types[i] = data.getResults().get(i).getType();
                }
                for (String item : pokemonNames) {
                    Log.d("item", item);
                }
                /*
                for (String item : abilities) {
                    Log.d("item", item);
                }
                for (String item : types) {
                    Log.d("item", item);
                }
                //TextView textView = findViewById(R.id.caption);
                //textView.setText(pokemonNames[0]);
                /*
                listView.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                pokemonNames

                        )


                );
                */
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
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
            textView.setText(pokemonNames[number]);
        } catch (Exception e) {
            textView.setText("Please enter a number");
        }
        //textView.setText(pokemonNames[number]);
    }

    public void showType(View view) {
        System.out.println("Type is being called");
        TextView textView = findViewById(R.id.caption);
        textView.setText("This is the type");
    }

}
