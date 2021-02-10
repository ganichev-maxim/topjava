package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

public interface MealDao {
    void save(Meal meal);
    void update(Meal meal);
    Meal get(Long id);
    void delete(Long id);
}
