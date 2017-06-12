/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonamento2;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Escalonamento2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {             
        
        ArrayList processos = new ArrayList();

        processos.add(5);
        processos.add(10);
        processos.add(3);
        processos.add(4);        
        processos.add(7);
        processos.add(1);
        
        int tempoEspera = 0;
        int turnAround = 0;               
        
        String opcao = "sjf";
        
        switch (opcao){
            
            case "fifo":
                //FIFO: somando os tempos de cpu
                for(int i=0; i<processos.size(); i++){

                    if(i==0){
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        tempoEspera = 0;
                        turnAround = (int) processos.get(i);                        
                        System.out.println("Tempo de espera = " + tempoEspera);
                        System.out.println("Tempo de TurnAround = " +  turnAround);
                        System.out.println();
                    }
                    else{
                        tempoEspera = tempoEspera + (int) processos.get(i-1);
                        turnAround = turnAround + (int) processos.get(i);
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        System.out.println("Tempo de Espera = " + tempoEspera);
                        System.out.println("Tempo de TournAroud = " + turnAround);
                        System.out.println();
                    }        
                }
            break;
            
            case "sjf":
                //SJF, calculando tempos
                System.out.println("SJF");
                       
                ArrayList processosInicial = processos;
                int aux = 0;
        
                for (int i = 0; i < processos.size(); i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if ((int)processos.get(i) < (int)processos.get(j)){
                            aux = (int) processos.get(i);
                            processos.set(i,processos.get(j));
                            processos.set(j, aux);
                        } else {
                        }
                    }
                }
                for(int i=0; i<processos.size(); i++){

                    if(i==0){
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        tempoEspera = 0;
                        turnAround = (int) processos.get(i);                        
                        System.out.println("Tempo de espera = " + tempoEspera);
                        System.out.println("Tempo de TurnAround = " +  turnAround);
                        System.out.println();
                    }
                    else{
                        tempoEspera = tempoEspera + (int) processos.get(i-1);
                        turnAround = turnAround + (int) processos.get(i);
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        System.out.println("Tempo de Espera = " + tempoEspera);
                        System.out.println("Tempo de TournAroud = " + turnAround);
                        System.out.println();
                    }        
                }
            break;
                
            default:
                System.out.println("Você não escolheu nenhuma opção!");
        }
        
        
    }
}
