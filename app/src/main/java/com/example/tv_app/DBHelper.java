package com.example.tv_app;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "programas.db";
    private static final int VERSAO_BANCO = 2;
    private Context context;
    private SQLiteDatabase dbInstancia = null;

    DBHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE programas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, horario TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS programas");
        onCreate(db);
    }

    public void abrirDB() throws SQLException {
        if(this.dbInstancia == null){
            this.dbInstancia = this.getWritableDatabase();
        }
    }

    public void fecharDB() throws SQLException{
        if(this.dbInstancia != null){
            if(this.dbInstancia.isOpen()){
                this.dbInstancia.close();
            }
        }
    }

    public void insertPrograma(Programa programa) throws SQLException{
        abrirDB();
        dbInstancia.insert("programas", null, programa.getContentValues());
        Toast.makeText(context, programa.getNome() + " cadastrado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public ArrayList<Programa> getDBProgramas(){
        ArrayList<Programa> programas = new ArrayList<Programa>();
        SQLiteDatabase banco = getReadableDatabase();
        Cursor query = banco.rawQuery("SELECT nome, horario FROM programas ORDER BY nome", null);
        query.moveToFirst();
        while (!query.isAfterLast()){
            Log.d(query.getString(1), "query");
            Programa programa = new Programa(query.getString(0), query.getString(1));
            programas.add(programa);
            query.moveToNext();
        }
        banco.close();
        query.close();
        return programas;
    }

}
