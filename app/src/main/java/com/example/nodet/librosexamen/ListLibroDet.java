package com.example.nodet.librosexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.List;

public class ListLibroDet extends AppCompatActivity {

    TextView autor;
    TextView titulo;
    TextView descripcion;
    TextView publisher;
    TextView date;
    ImageView imagen;
    TextView rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_libro_det);

        autor = findViewById(R.id.autor);
        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);
        publisher = findViewById(R.id.publisher);
        date = findViewById(R.id.date);
        imagen = findViewById(R.id.imagen);
        rating = findViewById(R.id.rating);



        Intent data = getIntent();
        Gson gson = new Gson();
        String stringLocation = data.getStringExtra("datos");
            Type type = new TypeToken<LibroDet>() {
            }.getType();
            LibroDet libro = gson.fromJson(stringLocation, type);

        System.out.println(libro.toString());
        autor.setText(libro.getAuthor());
        titulo.setText(libro.getTitle());
        descripcion.setText(libro.getDescription());
        publisher.setText(libro.getPublisher());
        date.setText(libro.getDate());
        rating.setText(Integer.toString(libro.getRating()));
        //imagen
    }
}
