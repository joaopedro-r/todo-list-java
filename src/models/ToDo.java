package models;

import java.util.Date;

public class ToDo  {
    private String title;
    private String description;
    private boolean isDone;
    private Date dateToDo;
    private Date dateCreated;
   
    public ToDo(String title, String description, Date dateToDo) {
        this.title = title;
        this.description = description;
        this.isDone = false;
        this.dateToDo = dateToDo;
        this.dateCreated = new Date(System.currentTimeMillis());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public Date getDateToDo() {
        return dateToDo;
    }

    public void setDateToDo(Date dateToDo) {
        this.dateToDo = dateToDo;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void generatePrint(boolean showType){
        
    }

}
