package com.nicolas.rotaifood;
import java.text.DecimalFormat;

public class Motorista {

    private boolean IsMoto;
    private String nome;
    private int score;
    private String ModeloMoto;
    private int Prioridade;
    private boolean Rodando;
    private double kmAteloja;

    Motorista(boolean _moto, String _nome, int _score, String _modelo) {
        this.nome = _nome;
        this.IsMoto = _moto;
        this.score = _score;
        this.ModeloMoto = _modelo;
        this.setPrioridade();
    }

    public void setKmAteloja() {
        double e = 1 + Math.random() * 20;
        double temp = Math.floor(e);
        this.kmAteloja = temp;
    }

    public double getKmAteloja() {
        return kmAteloja;
    }

    public String getNome() {
        return nome;
    }

    public boolean getMoto() {
        return this.IsMoto;
    }

    //prioridade se tem moto e score alto prioridade 1// se for bike ou moto com score baixo prioridade 0
    public void setPrioridade() {
        if (this.score > 3 || this.score <= 0) {
            this.Prioridade = -1;
        }
        if (this.score == 3 && this.getMoto()) {
            this.Prioridade = 3;
        } else if (this.score == 2 && this.getMoto()) {
            this.Prioridade = 2;
        } else if (this.score == 1 && this.getMoto()) {
            this.Prioridade = 2;
        } else {
            this.Prioridade = 1;
        }
    }

    public boolean getRodando() {
        return this.Rodando;
    }

    public boolean setRodando() {
        this.Rodando = !this.Rodando;
        return this.Rodando;
    }

    public int getPrioridade() {
        return this.Prioridade;
    }

    public int getScore() {
        return this.score;
    }
}
