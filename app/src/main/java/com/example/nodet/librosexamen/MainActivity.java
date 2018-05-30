package com.example.nodet.librosexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargarCatalogo(View view) {
        Intent intent = new Intent(getApplicationContext(), ListCatalogo.class);
        startActivity(intent);
    }
}
