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
        
        int tempoEspera = 0;
        int turnAround = 0;
        
        String opcao = "rr";
        int quantum = 2;
        
        switch (opcao){
            
            case "fifo":
                //FIFO: somando os tempos de cpu
                float somaTurnAroundFIFO = 0;
                
                for(int i=0; i<processos.size(); i++){

                    if(i==0){
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        tempoEspera = 0;
                        turnAround = (int) processos.get(i);                        
                        System.out.println("Tempo de espera = " + tempoEspera);
                        System.out.println("Tempo de TurnAround = " +  turnAround);
                        somaTurnAroundFIFO = somaTurnAroundFIFO + turnAround;
                        System.out.println();
                    }
                    else{
                        tempoEspera = tempoEspera + (int) processos.get(i-1);
                        turnAround = turnAround + (int) processos.get(i);
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        System.out.println("Tempo de Espera = " + tempoEspera);
                        System.out.println("Tempo de TournAroud = " + turnAround);
                        somaTurnAroundFIFO = somaTurnAroundFIFO + turnAround;
                        System.out.println();
                    }        
                }
                System.out.println("Tempo médio de TurnAround = " + somaTurnAroundFIFO/processos.size());
            break;
            
            case "sjf":
                //SJF, calculando tempos
                System.out.println("SJF");
                       
                ArrayList processosInicial = processos;
                int auxsjf = 0;
                
                for (int i = 0; i < processos.size(); i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if ((int)processos.get(i) < (int)processos.get(j)){
                            auxsjf = (int) processos.get(i);
                            processos.set(i,processos.get(j));
                            processos.set(j, auxsjf);
                        } else {
                        }
                    }
                }
                
                float somaTurnAroundSJF = 0;
                
                for(int i=0; i<processos.size(); i++){

                    if(i==0){
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        tempoEspera = 0;
                        turnAround = (int) processos.get(i);                        
                        System.out.println("Tempo de espera = " + tempoEspera);
                        System.out.println("Tempo de TurnAround = " +  turnAround);
                        somaTurnAroundSJF = somaTurnAroundSJF + turnAround;
                        System.out.println();
                    }
                    else{
                        tempoEspera = tempoEspera + (int) processos.get(i-1);
                        turnAround = turnAround + (int) processos.get(i);
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                        System.out.println("Tempo de Espera = " + tempoEspera);
                        System.out.println("Tempo de TournAroud = " + turnAround);
                        somaTurnAroundSJF = somaTurnAroundSJF + turnAround;
                        System.out.println();
                    }        
                }
                System.out.println("Tempo médio de TurnAround = " + somaTurnAroundSJF/processos.size());
            break;
            
            case "rr":
                //Round Robin: somando os tempos de cpu
                int maiorProcesso = 0;
                int auxrr = 0;
                
                for(int i=0; i<processos.size();i++){
                    if(auxrr < (int)processos.get(i)){
                        auxrr = (int)processos.get(i);
                        maiorProcesso = (int)processos.get(i);
                    }                
                }                
                
                ArrayList tempoEsperaRR = new ArrayList();
                ArrayList turnAroundRR = new ArrayList();
                
                for(int i=0; i<processos.size(); i++){
                    tempoEsperaRR.add(0);
                    turnAroundRR.add(0);
                }
                
                for(int j=0; j<maiorProcesso; j++){
                    for(int i=1; i<=quantum; i++){                                             
                        
                        tempoEsperaRR.set(j, (int) tempoEsperaRR.get(j) + (int)processos.get(j));
                        turnAroundRR.set(j, (int)turnAroundRR.get(j) + (int)processos.get(j));
                        
                        System.out.println(maiorProcesso = maiorProcesso - 2); 
                    }
                }
                
                for(int i=0; i<processos.size(); i++){
                    
                    System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos.get(i) + ":");
                    System.out.println("Tempo de espera = " + tempoEsperaRR.get(i));
                    System.out.println("Tempo de TurnAround = " +  turnAroundRR.get(i));
                    System.out.println();
                    
                }                
            break;
            
            default:
                System.out.println("Você não escolheu nenhuma opção!");
        }
        
        
    }
}
