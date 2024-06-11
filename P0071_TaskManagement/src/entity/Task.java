/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author a
 */
public class Task {
    private int id;
    private String name;
    private int typeId;
    private  String date; 
    private double from;
    private double to; 
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String name, int typeId, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String taskName(){
        String taskName = "";
        switch(typeId){
            case 1:
                taskName = "Code";
                break;
            case 2:
                taskName = "Test";
                break;
            case 3:
                taskName = "Design";
                break;
            case 4:
                taskName = "Review";
                break;
        }
        return taskName;
    }

    @Override
    public String toString() {
        return String.format("%d%20s%20s%20s%20f%20s%20s", id, name, taskName(), date, to-from, assignee, reviewer);
    }
    
    
}
