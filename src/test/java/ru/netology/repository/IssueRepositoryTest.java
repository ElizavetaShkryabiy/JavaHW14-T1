package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private Issue error1 = new Issue(1, "errorIn1", "Vasya Pupkin",
            "systemError", "Ivan Pupkin", true, 12);
    private Issue error2 = new Issue(2, "errorIn2", "Anya Pupkina",
           "systemError", "Andrey Pupkin", false, 34);
    private Issue error3 = new Issue(3, "errorIn3", "Katya Pupkina",
            "systemError", "Sanya Pupkin", false, 10);
    private Issue error4 = new Issue(4, "errorIn4", "Kirill Pupkin",
           "systemError", "Lev Pupkin", true, 80);
    private Issue error5 = new Issue(5, "errorIn5", "Ilya Pupkin",
            "systemError", "Lyoha Pupkin", true, 5);


    @Test
    public void shouldSaveOneItem() {
        repository.save(error1);
    }

    @Test
    public void shouldSaveAllItems() {
        Collection<Issue> items = new ArrayList<>();
        items.add(error1);
        items.add(error2);
        items.add(error3);
        items.add(error4);
        items.add(error5);
        repository.addAll(items);

    }

    @Test
    public void shouldRemoveById() {

        repository.addAll(List.of(error1, error2, error3, error4, error5));
        repository.removeById(3);

    }

    @Test
    public void shouldRemoveAll() {
        Collection<Issue> items = new ArrayList<>();
        items.add(error1);
        items.add(error2);
        items.add(error3);
        items.add(error4);
        items.add(error5);
        repository.addAll(items);
        repository.removeAll(items);
    }

    @Test
    public void shouldFindById() {
        repository.addAll(List.of(error1, error2, error3, error4, error5));
        Issue[] expected = new Issue[]{error2};
        Issue[] actual = repository.findById(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNotExistingId() {
        repository.addAll(List.of(error1, error2, error3, error4, error5));
        Issue[] expected = null;
        Issue[] actual = repository.findById(7);
        assertArrayEquals(expected, actual);
    }


}
