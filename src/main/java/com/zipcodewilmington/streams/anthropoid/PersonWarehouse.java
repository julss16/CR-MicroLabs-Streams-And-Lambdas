package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonWarehouse implements Iterable<Person> {
    private final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private final List<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public List<String> getNames() {

        List<String> names= new ArrayList<>();
        String name;

        for(int i=0; i <people.size(); i++){
            name= people.get(i).getName();
            names.add(name);

        }return names;
    }

    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public Stream<Person> getUniquelyNamedPeople() {

        Set<String> set= new HashSet<>(people.size());

        List<Person> persons= people.stream().filter(person -> set.add(person.getName())).collect(Collectors.toList());

            return persons.stream();
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {

        Stream<Person> start= people.stream().filter(person -> person.getName().startsWith(character.toString()));

        return start;
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public Stream<Person> getFirstNUniquelyNamedPeople(int n) {

        return getUniquelyNamedPeople().limit(n).collect(Collectors.toList()).stream();
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public Map<Long, String> getIdToNameMap() {

        Map<Long, String> ids = new HashMap<>();
        Long id;
        String name;
        for(Person person: people){
            id= person.getPersonalId();
            name= person.getName();
            ids.put(id, name);
        }

        return ids;
    }


    /**
     * @return Stream of Stream of Aliases
     */ // TODO
    public Stream<Stream<String>> getNestedAliases() {
        return null;
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public Stream<String> getAllAliases() {
        return null;
    }

    // DO NOT MODIFY
    public Boolean contains(Person p) {
        return people.contains(p);
    }

    // DO NOT MODIFY
    public void clear() {
        people.clear();
    }

    // DO NOT MODIFY
    public int size() {
        return people.size();
    }

    @Override // DO NOT MODIFY
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
