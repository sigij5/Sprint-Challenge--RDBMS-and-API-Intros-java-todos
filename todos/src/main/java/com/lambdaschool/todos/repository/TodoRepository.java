package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.views.UserNameCountTodos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todos, Long> {

    @Query(value = "SELECT u.username as usernamerpt, count(todoid) as counttodos\n" +
            "FROM users u LEFT JOIN todos t\n" +
            "ON u.userid = t.userid\n" +
            "GROUP BY u.username\n" +
            "HAVING count(todoid)>0", nativeQuery = true)
    List<UserNameCountTodos> findTodoCounts();
}
