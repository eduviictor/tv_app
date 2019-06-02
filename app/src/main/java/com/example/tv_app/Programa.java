package com.example.tv_app;

import android.content.ContentValues;

public class Programa {
    private String nome;
    private String horario;

    public Programa(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put("nome", this.nome);
        cv.put("horario", this.horario);
        return cv;
    }
}
