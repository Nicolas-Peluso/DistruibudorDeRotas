package com.nicolas.rotaifood;

import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorDeRotas {

    public static boolean rotaAceita(Motorista moto, Rota r, Scanner scan) {
        String Aceita;
        StringBuilder ParceiroMensagem;
        boolean painel = true;
        do {
            ParceiroMensagem = new StringBuilder();
            System.out.println("######################################");
            System.out.println("            OFERTA DE ROTA             ");
            System.out.println("######################################");
            ParceiroMensagem.append("Parceiro ")
                    .append(moto.getNome())
                    .append(" Voce aceita essa rota?");
            System.out.println(ParceiroMensagem.toString());
            String e = r.processaRotaInfo(moto.getMoto(), moto.getKmAteloja());
            System.out.println(e);
            System.out.println("######################################");
            Aceita = scan.next();
            switch (Aceita) {
                case "sim":
                    painel = false;
                    r.setAceitaRota(true);
                    r.setParcero(moto);
                    return true;
                case "nao":
                    painel = false;
                    return false;
                default:
                    System.out.println("Resposta invalida, responda com sim/nao");
                    painel = true;
                    break;
            }
        } while (painel);

        return true;
    }

    //bubblesort, ineficiente em caso de varios parceiros
    public Motorista[] ordenaPrioridadeMotorista(Motorista[] motor) {
        for (int i = 0; i < motor.length - 1; i++) {

            if (motor[i] == null) {
                continue;
            }

            for (int j = 0; j < motor.length - 1 - i; j++) {

                if (motor[j] == null || motor[j + 1] == null) {
                    continue;
                }

                if (motor[j].getPrioridade() < motor[j + 1].getPrioridade()
                        || (motor[j].getPrioridade() == motor[j + 1].getPrioridade()
                        && motor[j].getKmAteloja() > motor[j + 1].getKmAteloja())) {
                    Motorista temp = motor[j];
                    motor[j] = motor[j + 1];
                    motor[j + 1] = temp;
                }
            }
        }
        return motor;
    }

    public void ofereceRota(ArrayList<Rota> rotasAlist, Motorista[] motor) {
        Scanner scan = new Scanner(System.in);
        Motorista[] MotoristasAptosASeguirRota = new Motorista[motor.length];

        for (Rota r : rotasAlist) {
            // para cada rota ordean a prioridade de acordo com o km passado

            for (int i = 0; i < motor.length; i++) {
                if (motor[i].getRodando()) {
                    MotoristasAptosASeguirRota[i] = null;
                    continue;
                }
                motor[i].setKmAteloja();
                MotoristasAptosASeguirRota[i] = motor[i];
            }

            MotoristasAptosASeguirRota = ordenaPrioridadeMotorista(MotoristasAptosASeguirRota);

            for (Motorista moto : MotoristasAptosASeguirRota) {
                boolean NextRota;
                if (r.getAceitarota()) {
                    break;
                }
                if (moto == null || moto.getRodando()) {
                    continue;
                }
                NextRota = rotaAceita(moto, r, scan);
                if (!NextRota) {
                    r.setAceitaRota(false);
                }
            }
        }
        System.out.println(MotoristasAptosASeguirRota);
        scan.close();
    }
}
