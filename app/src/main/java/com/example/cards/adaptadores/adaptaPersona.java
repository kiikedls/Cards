package com.example.cards.adaptadores;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cards.R;
import com.example.cards.models.Persona;

import java.util.List;

public class adaptaPersona extends RecyclerView.Adapter<adaptaPersona.ViewHolder> {
    private List<Persona> Listp;

    public adaptaPersona(List<Persona> personas) {
        this.Listp=personas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartas, viewGroup, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(Listp.get(i).NombreCompleto());
        viewHolder.age.setText(Listp.get(i).getEdad().toString());
        viewHolder.num.setText(Listp.get(i).getTelefono());
    }

    @Override
    public int getItemCount() {
        return Listp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, num;

        public ViewHolder(View v) {
            super(v);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            num = itemView.findViewById(R.id.tel);
        }
    }
}
