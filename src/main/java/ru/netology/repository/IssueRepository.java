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

    public List<Issue> findById(int id) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : items) {
            if (item.getId() == id) {
                result.add(item);
            }
        }
        return result;
    }


    public boolean getStatus(int id) {
        boolean status = false;
        for (Issue item : items) {
            if (item.getId() == id) {
                status = item.isOpen();
                return status;
            }
        }
        return status;
    }

    public boolean setStatus(int id, boolean status) {
        boolean statusD = status;
        for (Issue item : items) {
            if (item.getId() == id) {
                item.setOpen(status);
                return statusD;
            }
        }
        return statusD;
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
