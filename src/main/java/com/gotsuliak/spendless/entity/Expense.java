package com.gotsuliak.spendless.entity;

import java.util.Date;
import java.util.List;

public class Expense {

    private String id;
    private Date date;
    private String category;
    private List<Item> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", items=" + items +
                '}';
    }
}
