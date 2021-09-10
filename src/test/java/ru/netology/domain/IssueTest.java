package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

class IssueTest {


    @Test
    public void shouldSetId() {
        Issue product = new Issue();
        product.setId(1);
    }
    @Test
    public void shouldGetId() {
        Issue product = new Issue();
        product.setId(1);
        product.getId();
    }

    @Test
    public void shouldSetName() {
        Issue product = new Issue();
        product.setName("100");
    }
    @Test
    public void shouldGetName() {
        Issue product = new Issue();
        product.setName("100");
        product.getName();
    }

    @Test
    public void shouldSetAuthor() {
        Issue product = new Issue();
        product.setAuthor("100");
    }
    @Test
    public void shouldGetAutor() {
        Issue product = new Issue();
        product.setAuthor("100");
        product.getAuthor();
    }

    @Test
    public void shouldSetLabel() {
        Issue product = new Issue();
        product.setLabel("Name");
    }
    @Test
    public void shouldGetLabel() {
        Issue product = new Issue();
        product.setLabel("Name");
        product.getLabel();
    }

    @Test
    public void shouldSetAssignee() {
        Issue product = new Issue();
        product.setAssignee("Name");
    }

    @Test
    public void shouldGetAssignee() {
        Issue product = new Issue();
        product.setAssignee("Name");
        product.getAssignee();
    }

    @Test
    public void shouldSetOpen() {
        Issue product = new Issue();
        product.setOpen(false);
    }

    @Test
    public void shouldGetOpen() {
        Issue product = new Issue();
        product.setOpen(false);
        product.isOpen();

    }

    @Test
    public void shouldSetOpenTime() {
        Issue product = new Issue();
        product.setOpenTime(10);
    }

    @Test
    public void shouldGetOpenTime() {
        Issue product = new Issue();
        product.setOpenTime(10);
        product.getOpenTime();
    }


}
