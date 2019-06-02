package com.example.tv_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Programa extends AppCompatActivity {

    private EditText nome_programa;
    private EditText horario_programa;
    private Button submit;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__programa);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setTitle("Adicionar Programa");

        nome_programa = findViewById(R.id.nome_programa);
        horario_programa = findViewById(R.id.horario_programa);
        submit = findViewById(R.id.submit);
        db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Programa programa = new Programa(nome_programa.getText().toString(), horario_programa.getText().toString());
                try{
                    db.insertPrograma(programa);
                    finish();
                }catch (Exception e){
                    Toast.makeText(Add_Programa.this, "Erro na gravação!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
