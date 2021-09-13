package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    IssueRepository productRepository = new IssueRepository();
    Manager manager = new Manager(productRepository);
    private Issue error1 = new Issue(1, "errorIn1", "Vasya Pupkin",
            "systemError1", "Ivan Pupkin", true, 12);
    private Issue error2 = new Issue(2, "errorIn2", "Anya Pupkina",
            "systemError2", "Andrey Pupkin", false, 34);
    private Issue error3 = new Issue(3, "errorIn3", "Vasya Pupkin",
            "systemError1", "Sanya Pupkin", false, 10);
    private Issue error4 = new Issue(4, "errorIn4", "Kirill Pupkin",
            "systemError5", "Lev Pupkin", true, 80);
    private Issue error5 = new Issue(5, "errorIn5", "Ilya Pupkin",
            "systemError1", "Lyoha Pupkin", true, 5);

    @BeforeEach
    public void setUp() {
        manager.add(error1);
        manager.add(error2);
        manager.add(error3);
        manager.add(error4);
        manager.add(error5);
    }

    @Test
    public void shouldAddItemsInRepository() {
        List<Issue> actual = manager.findAll();
        List<Issue> expected = new ArrayList<>(List.of(error1, error2, error3, error4, error5));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStatus() {
        boolean actual = manager.getStatus(1);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFilteredByAuthor() {

        List<Issue> actual = new ArrayList<>(manager.filterByAuthor("Vasya Pupkin"));
        List<Issue> expected = new ArrayList<>(List.of(error1, error3));
        assertEquals(expected, actual);

    }

    @Test
    public void shouldBeFilteredByLabel() {
        List<Issue> actual = manager.filterByLabel("systemError1");
        List<Issue> expected = new ArrayList<>(List.of(error1, error3, error5));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFilteredByAssignee() {
        List<Issue> actual = manager.filterByAssignee("Lev Pupkin");
        List<Issue> expected = new ArrayList<>(List.of(error4));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFilteredByOpen() {
        Collection<Issue> actual = manager.filterByOpen(false);
        List<Issue> expected = new ArrayList<>(List.of(error2, error3));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListsOfOpened() {

        Collection<Issue> actual = manager.returnOpened();
        Collection<Issue> expected = new ArrayList<>(List.of(error1, error4, error5));
        ;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListsOfClosed() {

        Collection<Issue> actual = manager.returnClosed();
        Collection<Issue> expected = new ArrayList<>(List.of(error2, error3));
        ;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeStatusToOpen() {
        boolean actual = manager.changeStatus(2);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByOpenTime() {
        List<Issue> actual = manager.sortedByOpenTime();
        List<Issue> expected = new ArrayList<>(List.of(error5, error3, error1, error2, error4));
        assertEquals(expected, actual);
    }

}
