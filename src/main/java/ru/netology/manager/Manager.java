package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

public class Manager {
    private IssueRepository repository;
//    private Collection<Issue> items = new ArrayList<>();

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

    public Collection<Issue> filterByAuthor(String author) {
        Collection<Issue> items = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            String expectedAuthor = item.getAuthor();
            if (expectedAuthor.equals(author)) {
                Collection<Issue> tmp = new ArrayList<>(items.size() + 1);
//                System.arraycopy(items, 0, tmp, 0, items.size());
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
                Collection<Issue> tmp = new ArrayList<>(items.size() + 1);
//                System.arraycopy(items, 0, tmp, 0, items.size());
                items.add(item);
            }
        }
        return (List<Issue>) items;

    }

    public List<Issue> filterByAssignee(String assignee ) {
        Collection<Issue> items = new ArrayList<>();
        for (Issue item : repository.findAll()) {
            String expectedAssignee = item.getAssignee();
            if (expectedAssignee.equals(assignee)) {
                Collection<Issue> tmp = new ArrayList<>(items.size() + 1);
//                System.arraycopy(items, 0, tmp, 0, items.size());
                items.add(item);
            }
        }
        return (List<Issue>) items;

    }


}
