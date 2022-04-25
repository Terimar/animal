package com.solvd.laba;


import com.solvd.laba.animals.*;
import com.solvd.laba.exceptions.LimitAviaryException;
import com.solvd.laba.interfaces.functional.IArrive;
import com.solvd.laba.interfaces.functional.ILeave;
import com.solvd.laba.interfaces.functional.ITitle;
import com.solvd.laba.utils.LinkedList;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.solvd.laba.animals.Animal.animalSort;
import static com.solvd.laba.animals.Giraffe.ageSort;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Food meat = new Food("Meat", 3);
        Food herbal = new Food("Herbal", 2);

        Worker worker = new Worker("Alex", "Smith", "worker");
        Worker worker2 = new Worker("Max", "Brown", "worker");
        Worker worker3 = new Worker("John", "Williams", "worker");
        Worker worker4 = new Worker("Piter", "Evans", "worker");
        LinkedList<Worker> linkedWorkers = new LinkedList<>();
        linkedWorkers.addLast(worker);
        linkedWorkers.addFirst(worker2);
        linkedWorkers.addLast(worker3);
        linkedWorkers.addLast(worker4);
        linkedWorkers.remove(worker3);
        LOGGER.info(linkedWorkers.get(worker));

        ITitle<Worker> titleWorker = ()->{
            Scanner in = new Scanner(System.in);
            LOGGER.info("Enter a name: ");
            String firstName = in.nextLine();
            return new Worker(firstName);
        };
        Worker worker5 = titleWorker.get();
        LOGGER.info("Name worker5: " + worker5.getFirstName());

        IArrive ar = s -> LOGGER.info(s);
        ar.arrive("An employee has arrived");

        ILeave l = s -> LOGGER.info(s);
        l.leave("The employee left");

        Animal lion = new Lion(1, "carnivore", 5, 63.4f);
        Animal lion2 = new Lion(2, "carnivore", 5, 63.4f);
        LOGGER.info(lion);
        Animal zebra = new Zebra(3, "herbivore", 3, 54.7f);
        LOGGER.info(zebra);
        Animal tiger = new Tiger(4, "carnivore", 4, 66.5f);
        LOGGER.info(tiger);

        List<Animal> animals = Stream.of(lion, zebra, tiger).collect(Collectors.toList());

        animalSort(animals,
                an -> an.getType().equals("carnivore") && an.getAge() > 1,
                an -> LOGGER.info(an.toString()));

        Animal firstCarnivore = animals.stream()
                .filter(an -> "carnivore".equals(an.getType()))
                .findFirst()
                .orElse(null);

        Map<String, Animal> firstPartOfAnimals = new HashMap<>();
        firstPartOfAnimals.put("AlexLion", lion);
        firstPartOfAnimals.put("BobLion", lion2);
        firstPartOfAnimals.put("BigCat", tiger);
        firstPartOfAnimals.put("KsushaZebra", zebra);
        Animal alex = firstPartOfAnimals.get("AlexLion");

        Aviary aviary1 = new Aviary(1, lion);
        Aviary aviary2 = new Aviary(2, zebra);
        Aviary aviary3 = new Aviary(3);
        Aviary aviary4 = new Aviary(4, tiger);
        Aviary aviary5 = new Aviary(5, lion2);

        Set<Aviary> aviaries = Set.of(aviary1, aviary2, aviary3, aviary4, aviary5);

        Zoo zoo = new Zoo("Zooland", 10);

        String z = Stream.of("Z", "o" ,"o", "L", "a", "n", "d").collect(Collectors.joining());
        LOGGER.info(z);

        Set<Aviary> freeAviaries = new HashSet<>();
        for (Aviary aviary : aviaries) {
            if (aviary.getAnimal() == null) {
                freeAviaries.add(aviary);
            }
        }

        try {
            zoo.setAviaryList(aviaries);
        } catch (LimitAviaryException e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("you have " + freeAviaries.size() + " free aviaries");

        lion.say();
        zebra.say();

        lion.eat(meat);
        lion.eat(herbal);
        zebra.eat(meat);
        zebra.eat(herbal);

        aviary3.setAnimal(lion);
        aviary1.setAnimal(zebra);
        LOGGER.info("Lion lives in third aviary, zebra in first");
        LOGGER.info("Lets make it vice versa");
        changeAviaries(aviary1, aviary2);

        LOGGER.info(lion.hashCode());
        LOGGER.info(tiger.hashCode());
        LOGGER.info(zebra.hashCode());

        boolean isTwoLionAreTheSame = lion.equals(lion2);
        boolean isLionAndZebraAreTheSame = lion.equals(zebra);

        LOGGER.info("They say that in our zoo the same lion gets a double portion of food, " +
                "this is " + isTwoLionAreTheSame);
        LOGGER.info("and they also say that we don’t have a zebra, but we just painted a lion, " +
                "this is " + isLionAndZebraAreTheSame);

        Giraffe giraffe = new Giraffe(5, "herbivore", 5, 52.7f);
        // if age of giraffe will be less than 2 years then AgeWrongException will be caught
        Giraffe giraffeYoung = new Giraffe(6, "herbivore", 1, 15.9f);
        // if age of giraffe will be more than 50 years then AgeWrongException will be thrown
        // (because they life period is usually less then 35-40 years)
        Giraffe giraffeOld = new Giraffe(7, "herbivore", 51, 62.5f);

        List<Giraffe> allGiraffes = new ArrayList<>();
        allGiraffes.add(giraffe);
        allGiraffes.add(giraffeYoung);
        allGiraffes.add(giraffeOld);
        Stream<Giraffe> streamG = allGiraffes.stream();
        streamG.filter(g -> g.getAge() == 5).forEach(g -> LOGGER.info(g.getId()));

        ageSort(allGiraffes,
                gi -> gi.getAge() > 1,
                gi -> LOGGER.info(gi.getId()));

        Map<String, Animal> giraffeMap = new HashMap<>();
        int i = 1;
        String key = "giraffe";
        for (Giraffe item : allGiraffes) {
            giraffeMap.put(key + i, item);
            i++;
        }

        Map<String, Animal> allAnimals = new HashMap<>();
        allAnimals.putAll(firstPartOfAnimals);
        allAnimals.putAll(giraffeMap);

        for (Giraffe g : allGiraffes) {
            g.move();
        }

        countUniqueWords();

        Class<Zoo> zooClass = Zoo.class;
        Field[] declaredFields = zooClass.getDeclaredFields();
        for (Field field : declaredFields) {
            LOGGER.info(field);
        }

        Class<Zoo> zoClass = Zoo.class;
        Method[] declaredMethods = zoClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            LOGGER.info(method);
        }

        Class<Food> foodClass = Food.class;
        LOGGER.info("Constructors: " + Arrays.toString(foodClass.getConstructors()));
    }

    public static void changeAviaries(Aviary a, Aviary b) {
        Animal tempAnimal = a.getAnimal();
        a.setAnimal(b.getAnimal());
        b.setAnimal(tempAnimal);
    }

    public static void countUniqueWords() {
        try {
            File f = new File("src/main/resources/caribou.txt");
            String fileText = FileUtils.readFileToString(f, StandardCharsets.UTF_8)
                    .toLowerCase(Locale.ROOT)
                    .replaceAll("[^\\da-zA-Za ]", "");
            String[] words = fileText.split(" ");
            Set<String> wordsSet = new HashSet<>(List.of(words));
            List<String> uniqueWordsCount = new ArrayList<>();
            for (String str : wordsSet) {
                uniqueWordsCount.add(str + " " + StringUtils.countMatches(fileText, str));
            }
            FileUtils.writeLines(new File("src/main/resources/uniqueWords.txt"), uniqueWordsCount);
            LOGGER.info("The result is entered in the 'uniqueWords' file");
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}