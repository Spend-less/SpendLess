package com.gotsuliak.spendless.controller;

import com.gotsuliak.spendless.ExpenseRepository;
import com.gotsuliak.spendless.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String addExpense(@RequestBody Expense expense) {
        repository.save(expense);
        return "success";
    }

    @RequestMapping(value = "/remove/{expenseID}", method = RequestMethod.GET)
    public String remove(@PathVariable String expenseID) {
        repository.delete(expenseID);
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Expense> getExpenses() {
        System.out.println("I'm here");
        List<Expense> expenses = repository.findAll();
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
        return expenses;
    }

    @RequestMapping(value = "/{expenseID}", method = RequestMethod.GET)
    public Expense getExpense(@PathVariable String expenseID) {
        System.out.println("expense: " + expenseID);
        return repository.findOne(expenseID);
    }

    @RequestMapping(value = "/edit/{expenseID}", method = RequestMethod.POST)
    public Expense edit(@PathVariable String expenseID, @RequestBody Expense expense) {
        expense.setId(expenseID);
        return repository.save(expense);
    }

}
