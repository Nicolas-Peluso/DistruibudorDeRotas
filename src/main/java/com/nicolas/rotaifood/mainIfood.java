package com.nicolas.rotaifood;
import java.util.ArrayList;

public class mainIfood {
    public static void main(String[] args) {
        GerenciadorDeRotas gerRotas = new GerenciadorDeRotas();
        Motorista parceiro1 = new Motorista(true, "Nicolas", 1, "fan-160");
        Motorista parceiro2 = new Motorista(true, "Andre", 3, "fazer-250");
        Motorista parceiro3 = new Motorista(false, "Anderson", 2, "");
        Motorista parceiro4 = new Motorista(true, "Pedro", 1, "fan-160");
        Motorista parceiro5 = new Motorista(true, "Jose", 3, "ducati");
        Motorista parceiro6 = new Motorista(false, "Maicon", 3, "");
        Motorista[] motors = {parceiro5, parceiro1, parceiro2, parceiro4, parceiro6, parceiro3};// parceiro sempre sera um valor fixo

        //ordenação de prioridade de Rota bubblesort se eu tivesse 1600 entregadores isso nao seria performatico
        ArrayList<Rota> rotasAlist = new ArrayList<>(); //tem que ser modular pois pode ter n rotas
        Rota mcdonalds = new Rota(2.3, "Mc donalds");
        Rota bombeff = new Rota(5.3, "Bom Beef Burger");
        Rota PorteiraGrill = new Rota(3.2, "Porteira grill");
        Rota juPasteis = new Rota(1.5, "ju Pasteis");

        rotasAlist.add(bombeff);
        rotasAlist.add(mcdonalds);
        rotasAlist.add(PorteiraGrill);
        rotasAlist.add(juPasteis);

        gerRotas.ofereceRota(rotasAlist, motors);
    }
}
