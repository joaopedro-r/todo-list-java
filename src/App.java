import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import models.Event;
import models.GrauPrioridade;
import models.Task;
import models.ToDo;

public class App {
    static SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static List<ToDo> toDoList = new ArrayList<ToDo>();
    static Scanner scanner = new Scanner(System.in);

    public static void createTodoList(int type){ //0 - task, 1 - event
        
        Map<Integer,String> typeCreateString = Map.of(
            0, "da tarefa",
            1, "do evento"
        );

        System.out.print("\n\nDigite o título " + typeCreateString.get(type) + ": ");
        String title = scanner.nextLine();

        System.out.print("Digite a descrição " + typeCreateString.get(type) + ": ");
        String description = scanner.nextLine();

        System.out.print("Digite a data " + typeCreateString.get(type) + ": ");
        String dateToDoEntry = scanner.nextLine();
        Date dateToDo = null;
        try{
            dateToDo = dateFormat.parse(dateToDoEntry);  
        }catch(Exception e){
            System.out.println("Data inválida");
        }  
        
        if (type == 0) {
            Map<Integer,String> grausPrioridade = GrauPrioridade.getGrausPrioridade();
            System.out.println("Digite o grau de prioridade da tarefa");                   
            for (Map.Entry<Integer,String> entry : grausPrioridade.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.print("Escolha: ");
            int grauPrioridadeId = scanner.nextInt();
            GrauPrioridade grauPrioridade = new GrauPrioridade(grauPrioridadeId);
            Task task = new Task(title, description, dateToDo, grauPrioridade); 
            toDoList.add(task);
        } else {
            System.out.print("Digite a data de término do evento: ");
            String dateEndEntry = scanner.nextLine();
            Date dateEnd = null;
            try{
                dateEnd = dateFormat.parse(dateEndEntry);
            }catch(Exception e){
                System.out.println("Data inválida");
            }

            System.out.print("Digite o local do evento: ");
            String local = scanner.nextLine();

            Event event = new Event(title, description, dateToDo, local, dateEnd);
            toDoList.add(event);
        }
         
    }
    public static void main(String[] args) {
        
        int option = 0;
        System.out.println("Bem vindo ao TodoList\n");
        while(option != -1){
            System.out.println("MENU");
            System.out.println("1- para adicionar uma tarefa");
            System.out.println("2- para adicionar um evento");
            System.out.println("3- para listar as tarefas");
            System.out.println("4- para listar os eventos");
            System.out.println("5- para listar as tarefas e eventos");
            System.out.println("-1-  para sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case -1:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    createTodoList(0); // 0 - task
                    break;
                case 2:
                    createTodoList(1); // 1 - event
                    break;
                case 3:
                    System.out.println("Tarefas\n");
                    for (ToDo toDo : toDoList) { 
                        if (toDo instanceof Task) {
                            toDo.generatePrint(false);
                            System.out.println("\n\n");                     
                        }                                        
                    }
                    break;
                
                case 4:
                    System.out.println("Eventos\n");
                    for (ToDo toDo : toDoList) { 
                        if (toDo instanceof Event) {
                            toDo.generatePrint(false);
                            System.out.println("\n\n");                     
                        }                                        
                    }
                    break;
                
                case 5:
                    System.out.println("Tarefas e Eventos\n");
                    for (ToDo toDo : toDoList) {
                        if (toDo instanceof Event) {
                            System.out.println("Tipo: Tarefa");
                        } else {
                            System.out.println("Tipo: Tarefa");
                        }
                        toDo.generatePrint(true);
                        System.out.println("\n\n");                     
                    }
                    break;
                                      
            }
                    
        }

        scanner.close();
    }
}
