package com.example.cards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
//import com.example.cards.adaptadores.personAdapter;
import com.example.cards.adaptadores.adaptaPersona;
import com.example.cards.models.Persona;
import com.example.cards.tools.VolleyS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lp=findViewById(R.id.rv);

        JsonArrayRequest jar = new JsonArrayRequest(
                Request.Method.GET,
                "http://nuevo.rnrsiilge-org.mx/lista",
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Type Personalist = new TypeToken<List<Persona>>() {}.getType();
                        List<Persona>personas = new Gson().fromJson(response.toString(), Personalist);
                        lp.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        lp.setAdapter(new adaptaPersona(personas));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        VolleyS.getInstance(this).getRequestQueue().add(jar);

    }
}
