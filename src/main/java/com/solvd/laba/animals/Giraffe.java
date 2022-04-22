package com.solvd.laba.animals;

import com.solvd.laba.exceptions.AgeWrongException;
import com.solvd.laba.interfaces.IMove;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Giraffe extends Animal implements IMove {

    private static final Logger LOGGER = LogManager.getLogger(Giraffe.class);

    public Giraffe() {
    }

    public Giraffe(int id, String type, int age, float weight){
        super(id, type, age, weight);
    }

    @Override
    public void say() {
        LOGGER.info("I am " + super.getType() + " and I will eat only herbal");
    }

    public void move() {
        try {
            if (getAge() < 2 || getAge() > 50) {
                throw new AgeWrongException("I can't walk");
            }
            LOGGER.info("I can walk on my own");
        } catch (AgeWrongException e) {
            LOGGER.error("I can't walk");
        }
    }

    public static void ageSort(List<Giraffe> allGiraffes, Predicate<Giraffe> predicate, Consumer<Giraffe> consumer) {
        for(Giraffe gi : allGiraffes) {
            if (predicate.test(gi)) {
                consumer.accept(gi);
            }
        }
    }
}