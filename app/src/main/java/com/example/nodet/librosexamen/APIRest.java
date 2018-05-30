package com.example.nodet.librosexamen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIRest {

    public static final String BASE_URL = "http://api.dsamola.tk/";

    /*@GET("procesarOp")
    Call<String> doOp();


    @POST("addOperacion/{op}")
    Call<String> addOp(@Path("op") String operacion);

    @GET("listadoOpAlum/{alum}")
    Call<List<String>> getListaAlumno(@Path("alum") String alumno);*/

    @GET("books")
    Call<List<LibroCat>> getCatalogo();

    @GET("books/{id}")
    Call<LibroDet> getLibro(@Path("id") String id);
}