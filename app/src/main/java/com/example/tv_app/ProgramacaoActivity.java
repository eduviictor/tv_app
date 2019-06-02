package com.example.tv_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ProgramacaoActivity extends Fragment {

    private DBHelper db;
    private Context context = getActivity();
    FragmentActivity act;

    public ProgramacaoActivity() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_programacao, container, false);
        act = getActivity();
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(act, Add_Programa.class);
                startActivity(i);
            }
        });

        db = new DBHelper(context);
//        ArrayList<Programa> produtos = db.getDBProgramas();
//        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(R.id.listView, produtos);
        AdapterPrograma adapter = new AdapterPrograma(context, db.getDBProgramas());
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        return view;
    }

}
