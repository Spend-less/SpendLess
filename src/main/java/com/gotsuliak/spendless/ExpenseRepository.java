package com.gotsuliak.spendless;

import com.gotsuliak.spendless.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
