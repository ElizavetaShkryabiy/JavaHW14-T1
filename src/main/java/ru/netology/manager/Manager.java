package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

public class Manager {
    private IssueRepository repository;


    public Manager(IssueRepository repository) {
        this.repository = repository;
    }

    public List<Issue> findAll() {
        Collection<Issue> product = repository.findAll();
        Arrays.sort(new Collection[]{product});
        return (List<Issue>) product;
    }

    public void add(Issue issue) {
        repository.save(issue);
    }

    public boolean getStatus(int id) {
        return repository.getStatus(id);
    }

    public Collection<Issue> filterByOpen(boolean open) {
        Collection<Issue> items = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            if (item.isOpen() == open) {
                items.add(item);
            }
        }
        return items;
    }

    public Collection<Issue> returnOpenYClosed() {
        Collection<Issue> itemsO = new ArrayList<>();
        Collection<Issue> itemsC = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            if (item.isOpen() == true) {
                itemsO.add(item);
            } else {
                itemsC.add(item);
            }
        }
        System.out.println("Opened:" + itemsO);
        System.out.println("Closed:" + itemsC);
        return null;
    }

    public boolean changeStatus(int id) {
        boolean item = repository.getStatus(id);
        if (item == true) {
            item = false;
        } else {
            item = true;
        }
        return item;
    }


    public Collection<Issue> filterByAuthor(String author) {
        Collection<Issue> items = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            String expectedAuthor = item.getAuthor();
            if (expectedAuthor.equals(author)) {
                items.add(item);
            }
        }
        return items;

    }

    public List<Issue> filterByLabel(String label) {
        Collection<Issue> items = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            String expectedLabel = item.getLabel();
            if (expectedLabel.equals(label)) {
                items.add(item);
            }
        }
        return (List<Issue>) items;

    }

    public List<Issue> filterByAssignee(String assignee) {
        Collection<Issue> items = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            String expectedAssignee = item.getAssignee();
            if (expectedAssignee.equals(assignee)) {
                items.add(item);
            }
        }
        return (List<Issue>) items;

    }


}
