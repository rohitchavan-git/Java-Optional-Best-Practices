package com.rohit;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Main {

    private static final String MH = "MH";
    private static final String ROHIT = "ROHIT";

    public static void main(String[] args) {


        Person person = new Person("rohit","chavan",new Address("MH","OBAD",413501));

        boolean personLiveInMH = Optional.of(person)
                .flatMap(person1 -> Optional.ofNullable(person1.getAddress()))
                .map(Address::getState)
                .filter(MH::equals).isPresent();

        String getCity = Optional.of(person)
                .flatMap(person1 -> Optional.ofNullable(person1.getAddress()))
                .map(Address::getCity)
                .orElse("city not given");

        List<Person> personList = new ArrayList<>();

        List<Person> allPersonLiveInMH = personList.stream()
                .filter(person1 -> Optional.ofNullable(person1.getAddress())
                        .map(Address::getState).filter(MH::equals).isPresent())
                .collect(toList());


        List<String> allCityName = personList.stream()
                .map(person1 -> Optional.ofNullable(person1)
                        .flatMap(person2 -> Optional.ofNullable(person2.getAddress()))
                        .map(Address::getCity))
                .flatMap(Optional::stream)
                .collect(toList());

        List<String> allAlternativeCityName = personList.stream()
                .map(person1 -> Optional.ofNullable(person1)
                        .flatMap(person2 -> Optional.ofNullable(person2.getAddress()))
                        .map(Address::getCity))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());


        boolean rohitInThisList = Optional.of(personList)
                .stream()
                .flatMap(List::stream)
                .map(Person::getFname)
                .anyMatch(ROHIT::equals);


        List<Integer> oneToTen = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<List<Integer>> listOfistOfInteger = oneToTen.stream()
                .map(number -> List.of(number - 1, number + 1))
                .collect(toList());

        List<Integer> listOfInteger = oneToTen.stream()
                .map(number -> List.of(number - 1, number + 1))
                .flatMap(List::stream)
                .distinct()
                .toList();

    }

    private static void mapOfValuePresent() {
        Map<String, Integer> firstMap = Map.of("A", 100, "B", 96, "C", 101);
        Map<String, Integer> secondMap = Map.of("D", 100, "E", 98, "C1", 108);


        Map<String, Integer> helperMap = new HashMap<>(firstMap);
        helperMap.putAll(secondMap);


        Map<Integer, Long> matchCount = helperMap.entrySet()
                .stream()
                .collect(groupingBy(Map.Entry::getValue, counting()));


        Optional<List<String>> first = firstMap.entrySet()
                .stream()
                .map(oneMap -> getStrings(secondMap, oneMap))
                .findFirst();
    }

    private static List<String> getStrings(Map<String, Integer> secondMap, Map.Entry<String, Integer> oneMap) {

        Optional<String> first = secondMap.entrySet().stream()
                .filter(second -> second.getValue().equals(oneMap.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        if (first.isPresent()) {
            return List.of(oneMap.getKey(), first.get());
        }
        return null;
    }

    public static Optional<Object> optionalExample1(String Name){

        /**
         *
         * Example :
         * Optional<BigDecimal> firstNumber=Optional.of(10);
         * Optional<BigDecimal> firstNumber=Optional.of(12);
         * After addition:
         * Optional<BigDecimal> result= Optional.of(22);
         * If both present add them
         * If one of them is empty take it as zero and them them with other
         * If both are empty return empty
         */


        Optional<BigDecimal> firstNumber= Optional.of(new BigDecimal(10));
        Optional<BigDecimal> secondNumber=Optional.of(new BigDecimal(20));

        if ( !firstNumber.isPresent() && !secondNumber.isPresent() ){
            return Optional.empty();
        }
        return Optional.of(firstNumber.orElse(BigDecimal.ZERO)
                .add(secondNumber.orElse(BigDecimal.ZERO)));
    }



}