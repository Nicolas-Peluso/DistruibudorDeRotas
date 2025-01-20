package com.nicolas.rotaifood;

public class Rota {

    public double getKmAteCliente() {
        return kmAteCliente;
    }

    private double kmAteCliente;
    private double KmTotal;
    private double tempo;
    private double valor;
    private double velocidadeVeiculo; //informaçao do motorista
    private int[] tempoFormatado = new int[2];
    private double valorPadrao = 1.62;
    private boolean aceitaRota;
    private Motorista parceiro;
    private String Restaurante;
    private double ValorMinimoRota = 6.50;

    Rota(double kmC, String _Restaurante) {
        this.kmAteCliente = kmC;
        this.Restaurante = _Restaurante;
    }
//refatrorar esse metodo calculaTempo

    public int[] CalculaTempo(boolean IsMoto, double kmDoMotoAteLojaParceira) {
        this.KmTotal = kmDoMotoAteLojaParceira + this.getKmAteCliente();
        if (IsMoto) {
            this.velocidadeVeiculo = 50;
        } else {
            this.velocidadeVeiculo = 20;
        }

        this.tempo = (this.KmTotal / this.velocidadeVeiculo) * 60 + 9;//+9 tempo de preparo do pedido no restaurante

        if (this.tempo > 60) {
            tempoFormatado[1] = (int) Math.floor(this.tempo % 60);
            this.tempo = Math.floor(this.tempo / 60);
            tempoFormatado[0] = (int) this.tempo;
        } else {
            this.tempoFormatado[1] = (int) Math.floor(this.tempo);
        }
        return this.tempoFormatado;
    }

    public String processaRotaInfo(boolean e, double kmDoMotoAteLojaParceira) {
        StringBuilder InfoRota = new StringBuilder();
        this.CalculaTempo(e, kmDoMotoAteLojaParceira); //recebe se o parecero que a Rota esta sendo oferecida ta de moto
        InfoRota.append("Restaurante Parceiro: ")
                .append(this.Restaurante)
                .append(System.lineSeparator())
                .append("Valor da rota: ")
                .append(this.CalculaValor())
                .append("R$")
                .append(System.lineSeparator())
                .append("Km ate a Loja Parceira: ")
                .append(kmDoMotoAteLojaParceira).append("km")
                .append(System.lineSeparator())
                .append("Km da loja ate o cliente: ")
                .append(this.getKmAteCliente()).append("km")
                .append(System.lineSeparator())
                .append("Km total da rota: ")
                .append(this.getTotalKm())
                .append("km")
                .append(System.lineSeparator())
                .append("Tempo estimado de rota: ")
                .append(this.tempoFormatado[0])
                .append("H")
                .append(':')
                .append(this.tempoFormatado[1])
                .append("M");
        return InfoRota.toString();
    }

    public boolean setParcero(Motorista e) {
        if (this.getAceitarota()) {
            this.parceiro = e;
            this.parceiro.setRodando();
            return true;
        }
        return false;
    }

    public double CalculaValor() {
        this.valor = this.KmTotal * valorPadrao;
        if (this.valor < ValorMinimoRota) {
            this.valor = ValorMinimoRota; // valor minimo por rota
            return this.valor;
        }
        return Math.round(this.valor);
    }

    public double getTotalKm() {
        if (this.KmTotal < 0) {
            return 0.0;
        }
        return this.KmTotal;
    }

    public void setAceitaRota(boolean _aceita) {
        this.aceitaRota = _aceita;
    }

    public boolean getAceitarota() {
        return this.aceitaRota;
    }

}
