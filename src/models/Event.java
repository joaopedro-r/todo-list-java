package models;

import java.util.Date;


public class Event extends ToDo {
    private String local;
    private Date dateEnd;

    public Event(String title, String description, Date dateToDo, String local, Date dateEnd) {
        super(title, description, dateToDo);
        this.local = local;
        this.dateEnd = dateEnd;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    
    @Override
    public void generatePrint (boolean showType) {
        System.out.println("=-".repeat(40));
        if (showType){
            System.out.println("Tipo: Evento");
        }  
        System.out.println("Evento: " + this.getTitle());
        System.out.println("Descrição: " + this.getDescription());
        System.out.println("Data: " + this.getDateToDo());      
        System.out.println("Local: " + this.getLocal());
        System.out.println("Data de término: " + this.getDateEnd());
        System.out.println("\n\nData de criação: " + this.getDateCreated());
        System.out.println("=-".repeat(40));
    }
    
}
