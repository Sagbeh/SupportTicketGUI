package com.Sam;

import java.util.Date;

public class Ticket {

    private int priority;
    private String reporter; //Stores person or department who reported issue
    private String description;
    private Date dateReported;
    private Date resDate;
    private String fix;

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Date getDateReported() {
        return dateReported;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }

    public static int getTicketIdCounter() {
        return ticketIdCounter;
    }

    public static void setTicketIdCounter(int ticketIdCounter) {
        Ticket.ticketIdCounter = ticketIdCounter;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getFix() {
        return fix;

    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //TODO Problem 1: explain the role of ticketIdCounter and ticketID

    //STATIC Counter - one variable, shared by all Ticket objects.
    //If any Ticket object modifies this counter, all Ticket objects will have the modified value
    //Make it private - only Ticket objects should have access
    private static int ticketIdCounter = 1;

    //The ID for each ticket - an instance variable. Each Ticket will have it's own ticketID variable
    protected int ticketID;

    // TODO problem 6: tickets need to store the resolution date and a string describing the resolution
    // Either add them to this class or create another class called ResolvedTicket - which
    // do you think is the better approach?

    public Ticket(String desc, int p, String rep, Date date, Date resDate, String fix) {
        this.description = desc;
        this.priority = p;
        this.reporter = rep;
        this.dateReported = date;
        this.resDate = resDate;
        this.fix = fix;
        this.ticketID = ticketIdCounter;
        ticketIdCounter++;
    }

    protected int getPriority() {
        return priority;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String toString(){
        return("[" + "ID: " + this.ticketID + "]" + "["+ " Issue: " + this.description + "]" + "[" + " Priority: " + this.priority + "]"+ "[" + " Reported by: "
                + this.reporter + "]"+ "[" + " Reported on: " + this.dateReported + "]"+ "[" + " Resolved on: " + this.resDate + "]"+ "["+ " Resolution: " + this.fix + "]");
    }
}

