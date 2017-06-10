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
        
        int processos[] = new int[5];

        processos[0] = 5;
        processos[1] = 10;
        processos[2] = 3;
        processos[3] = 4;
        processos[4] = 7;            
        
        int tempoEspera = 0;
        int turnAround = 0;               
        
        String opcao = "sjf";
        
        switch (opcao){
            
            case "fifo":
                //FIFO: somando os tempos de cpu
                for(int i=0; i<5; i++){

                    if(i==0){
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos[i] + ":");
                        tempoEspera = 0;
                        turnAround = processos[i];
                        System.out.println("Tempo de espera = " + tempoEspera);
                        System.out.println("Tempo de TurnAround = " +  turnAround);
                        System.out.println();
                    }
                    else{
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos[i] + ":");
                        System.out.println("Tempo de Espera = " + (tempoEspera = tempoEspera + processos[i-1]));
                        System.out.println("Tempo de TournAroud = " + (turnAround = turnAround + processos[i]));
                        System.out.println();
                    }        
                }
                break;
                    
            case "sjf":
                //SJF, calculando tempos
                System.out.println("SJF");
                       
                int processosInicial[] = processos;
                int aux = 0;
        
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if (processos[i] < processos[j])
                        {
                            aux = processos[i];
                            processos[i] = processos[j];
                            processos[j] = aux;
                        }
                    }
                }

                for (int i = 0; i < 5; i++) {                                    
                    
                    if(i==0){
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos[i] + ":");
                        tempoEspera = 0;
                        turnAround = processos[i];
                        System.out.println("Tempo de espera = " + tempoEspera);
                        System.out.println("Tempo de TurnAround = " +  turnAround);
                        System.out.println();
                    }
                    else{
                        System.out.println("Processo " + (i+1) + " tempo de CPU = " + processos[i] + ":");
                        System.out.println("Tempo de Espera = " + (tempoEspera = tempoEspera + processos[i-1]));
                        System.out.println("Tempo de TournAroud = " + (turnAround = turnAround + processos[i]));
                        System.out.println();
                    } 
                }
                
            break;
                
            default:
                System.out.println("Você não escolheu nenhuma opção!");
        }
        
        
    }
}
