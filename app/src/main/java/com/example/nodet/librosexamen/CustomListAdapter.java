package com.example.nodet.librosexamen;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> listTitulos;
    private final List<String> listAutores;
    private final List<String> imgid;
    private final List<String> listIds;



    public CustomListAdapter(Activity context, List<String> listTitulos, List<String> listAutores, List<String> imgid, List<String> listIds) {
        super(context, R.layout.row, listTitulos);

        this.context=context;
        this.listTitulos=listTitulos;
        this.listAutores=listAutores;
        this.listIds=listIds;
        this.imgid=imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.row, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.titulo);
        TextView txtAutor = (TextView) rowView.findViewById(R.id.autor);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imagen);

        txtTitle.setText(listTitulos.get(position));
        txtAutor.setText(listAutores.get(position));
        Picasso.with(getContext()).load(imgid.get(position)).into(imageView);
        return rowView;

    }
}

