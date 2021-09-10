package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private List<Issue> items = new ArrayList<>();

    public boolean save(Issue item) {
        return items.add(item);
    }

    public List<Issue> findAll() {
        return items;
    }

    public Issue[] findById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return new Issue[]{item};
            }
        }
        return null;
    }

    public boolean removeById(int id) {
        return items.removeIf(item -> item.getId() == id);
    }

    public boolean removeAll(Collection<Issue> items) {
        return this.items.removeAll(items);
    }

    public boolean addAll(Collection<Issue> items) {
        return this.items.addAll(items);
    }


}