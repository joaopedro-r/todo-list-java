package models;

import java.util.Date;



public class Task extends ToDo {
    
    GrauPrioridade grauPrioridade;  
    public Task(String title, String description, Date dateToDo, GrauPrioridade grauPrioridade) {
        super(title, description, dateToDo);
        this.grauPrioridade = grauPrioridade;
    }

    @Override
    public void generatePrint (boolean showType) {
        System.out.println("=-".repeat(40));
        if (showType){
            System.out.println("Tipo: Tarefa");
        }   
        System.out.println("Tarefa: " + this.getTitle());
        System.out.println("Descrição: " + this.getDescription());
        System.out.println("Data: " + this.getDateToDo());
        System.out.println("Grau de prioridade: " + this.grauPrioridade.getGrauPrioridade());
        System.out.println("\n\nData de criação: " + this.getDateCreated());
        System.out.println("=-".repeat(40));
    }
    
    
    
}
