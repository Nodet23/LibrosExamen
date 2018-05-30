package com.example.nodet.librosexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListCatalogo extends AppCompatActivity {

    ListView listView;
    APIRest apiRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_catalogo);


        listView = findViewById(R.id.ListCatalogo);



        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(APIRest.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiRest = retrofit.create(APIRest.class);

        Call<List<LibroCat>> getCat = apiRest.getCatalogo();

        getCat.enqueue(new Callback<List<LibroCat>>() {
            @Override
            public void onResponse(Call<List<LibroCat>> call, Response<List<LibroCat>> response) {
                if (!response.isSuccessful()){
                    Log.i("TAG", "Error1 " + response.code());
                }else {


                    final List<LibroCat> ListaLibros = response.body();

                    Log.d("BRUNO", ListaLibros.get(0).toString());
                    Log.d("BRUNO", ListaLibros.get(1).toString());
                    Log.d("BRUNO", ListaLibros.get(2).toString());

                    ArrayList<String> arrayTitulos = new ArrayList<String>();
                    ArrayList<String> arrayAutores = new ArrayList<String>();
                    ArrayList<String> arrayURLs = new ArrayList<String>();
                    final ArrayList<String> arrayIds = new ArrayList<String>();

                    for (int x = 0; x<ListaLibros.size(); x++){
                        arrayTitulos.add(ListaLibros.get(x).getTittle());
                        arrayAutores.add(ListaLibros.get(x).getAuthor());
                        arrayURLs.add(ListaLibros.get(x).getImage());
                        arrayIds.add(ListaLibros.get(x).get_id());
                    }

                    CustomListAdapter adapter = new CustomListAdapter(ListCatalogo.this, arrayTitulos, arrayAutores, arrayURLs, arrayIds);
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            Call<LibroDet> getCat = apiRest.getLibro(arrayIds.get(position));
                            getCat.enqueue(new Callback<LibroDet>() {
                                @Override
                                public void onResponse(Call<LibroDet> call, Response<LibroDet> response) {
                                    if (!response.isSuccessful()){
                                        Log.i("TAG", "Error1 " + response.code());
                                    }else {


                                        final LibroDet libroDet = response.body();
                                        System.out.println(libroDet.toString());
                                        Intent intent = new Intent(getApplicationContext(), ListLibroDet.class);
                                        Gson gson = new Gson();
                                        Type type = new TypeToken<LibroDet>() {}.getType();
                                        String json = gson.toJson(libroDet, type);
                                        intent.putExtra("datos", json);
                                        startActivity(intent);

                                    }
                                }


                                @Override
                                public void onFailure(Call<LibroDet> call, Throwable t) {
                                    Log.e("TAG", "Error 2: " + t.getMessage());
                                }
                            });
                        }
                    });

                }
            }


            @Override
            public void onFailure(Call<List<LibroCat>> call, Throwable t) {
                Log.e("TAG", "Error 2: " + t.getMessage());
            }
        });


    }
}
