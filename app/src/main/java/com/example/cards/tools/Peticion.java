package com.example.cards.tools;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.cards.models.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class Peticion {
    private List<Persona> lp;
    private Context c;


    public Peticion(Context c) {
        this.c = c;
    }

    public List<Persona> getLp() {
        JsonArrayRequest jar = new JsonArrayRequest(
                Request.Method.GET,
                "http://nuevo.rnrsiilge-org.mx/lista",
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Type Personalist = new TypeToken<List<Persona>>() {}.getType();
                        lp = new Gson().fromJson(response.toString(), Personalist);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        VolleyS.getInstance(c).getRequestQueue().add(jar);
        return lp;
    }
}
