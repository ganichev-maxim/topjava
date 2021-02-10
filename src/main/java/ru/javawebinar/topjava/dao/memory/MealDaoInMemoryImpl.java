package ru.javawebinar.topjava.dao.memory;

import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealDaoInMemoryImpl implements MealDao {
    AtomicLong idGenerator = new AtomicLong(0);
    private Map<Long, Meal> meals = new ConcurrentHashMap<>();

    @Override
    public void save(Meal meal) {
        meal.setId(idGenerator.incrementAndGet());
        meals.put(meal.getId(), meal);
    }

    @Override
    public void update(Meal meal) {
        Meal inMemory = meals.get(meal.getId());
        if (inMemory == null) {
            throw new IllegalArgumentException();
        }
        meals.put(meal.getId(), meal);
    }

    @Override
    public Meal get(Long id) {
        return meals.get(id);
    }

    @Override
    public void delete(Long id) {
        meals.remove(id);
    }
}
