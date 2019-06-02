package com.example.tv_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPrograma extends ArrayAdapter<Programa> {

    private final Context context;
    private final ArrayList<Programa> listaProgramas;

    public AdapterPrograma(Context context, ArrayList<Programa> listaProgramas) {
        super(context, R.layout.linha, listaProgramas);
        this.context = context;
        this.listaProgramas= listaProgramas;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = inflater.inflate(R.layout.linha, parent, false);
        TextView nome = (TextView) linha.findViewById(R.id.nome);
        TextView horario = (TextView) linha.findViewById(R.id.horario);
        nome.setText(listaProgramas.get(position).getNome());
        horario.setText("R$ " + listaProgramas.get(position).getHorario());
        return linha;
    }
}
