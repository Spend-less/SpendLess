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
    public Expense addExpense(@RequestBody Expense expense) {
        System.out.println(expense);
        return repository.save(expense);
    }

    @RequestMapping(value = "/remove/{expenseID}", method = RequestMethod.GET)
    public void remove(@PathVariable String expenseID) {
        repository.delete(expenseID);
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
