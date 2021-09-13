package ru.netology.domain;

import java.util.Set;

public class Issue implements Comparable<Issue> {
    private int id;
    private String name;
    private String author;
    private String label;
    private String assignee;
    private boolean open;
    private int openTime;

    public Issue() {
    }

    public Issue(int id, String name, String author, String label,
                 String assignee, boolean open, int openTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.open = open;
        this.openTime = openTime;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLabel() {
        return label;
    }

    public void SetLabel(String label) {
        this.label = label;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    @Override
    public int compareTo(Issue o) {
        return openTime - o.openTime;
    }

//    @Override
//    public int compare(Issue o1, Issue o2) {
//        return o1.getTravelTime() - o2.getTravelTime();
//    }
}

