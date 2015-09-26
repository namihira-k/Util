/**
 * Copyright 2014 Kosuke Namihira All Rights Reserved.
 */

package jp.namihira.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

import org.junit.Test;

/**
 * class for just test.
 */
public class SimpleTest {

    /**
     * for test lambda
     */
    @Test
    public void test_no_lambda_list_grouping(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        // action
        final Map<String, List<String>> result = new HashMap<>();
        for (String name : names) {
            final String initial = String.valueOf(name.charAt(0));
            List<String> list = result.get(initial);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(name);
            result.put(initial, list);
        }

        // check
        assertEquals(2, result.keySet().size());
        assertEquals(1, result.get("n").size());
        assertEquals(2, result.get("j").size());
        assertTrue(result.get("n").contains("namihira"));
        assertTrue(result.get("j").contains("john"));
        assertTrue(result.get("j").contains("james"));
    }


    /**
     * for test lambda
     */
    @Test
    public void test_lambda_list_grouping(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        // action
        final Map<String, List<String>> result = names.stream()
                                                      .collect(Collectors.groupingBy(
                                                                              n -> String.valueOf(n.charAt(0)),
                                                                              Collectors.toList()
                                                                          )
                                                        );

        // check
        assertEquals(2, result.keySet().size());
        assertEquals(1, result.get("n").size());
        assertEquals(2, result.get("j").size());
        assertTrue(result.get("n").contains("namihira"));
        assertTrue(result.get("j").contains("john"));
        assertTrue(result.get("j").contains("james"));
    }

    /**
     * for test lambda
     */
    @Test
    public void test_no_lambda_list_sort(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        // action
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        final List<Person> persons = new ArrayList<>();
        for (String name : names) {
            final Person p = new Person();
            p.setName(name);
            persons.add(p);
        }

        // check
        assertEquals(names.size(), persons.size());
        assertEquals("james", persons.get(0).getName());
        assertEquals("john", persons.get(1).getName());
        assertEquals("namihira", persons.get(2).getName());
    }


    /**
     * for test lambda
     */
    @Test
    public void test_lambda_list_sort(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        // action
        final List<Person> persons = names.stream()
                                          .sorted(String::compareTo)
                                          //.sorted((n1, n2) -> n1.compareTo(n2))
                                          .sequential()
                                          .map(n -> {
                                                  final Person p = new Person();
                                                  p.setName(n);
                                                  return p;
                                                })
                                          .collect(Collectors.toList());

        // check
        assertEquals(names.size(), persons.size());
        assertEquals("james", persons.get(0).getName());
        assertEquals("john", persons.get(1).getName());
        assertEquals("namihira", persons.get(2).getName());
    }

    /**
     * for test lambda
     */
    @Test
    public void test_no_lambda_list_method_ref(){
        // setup
        final Set<String> names = new HashSet<>(Arrays.asList("namihira", "john", "james"));
        final List<Person> persons = names.stream()
                                          .sequential()
                                          .map(n -> {
                                                  final Person p = new Person();
                                                  p.setName(n);
                                                  return p;
                                              })
                                          .collect(Collectors.toList());


        // action
        final Set<String> result = new HashSet<>();
        for (Person p : persons) {
            result.add(p.getName());
        }

        // check
        assertEquals(names, result);
    }

    /**
     * for test lambda
     */
    @Test
    public void test_lambda_list_method_ref(){
        // setup
        final Set<String> names = new HashSet<>(Arrays.asList("namihira", "john", "james"));
        final List<Person> persons = names.stream()
                                          .sequential()
                                          .map(n -> {
                                                  final Person p = new Person();
                                                  p.setName(n);
                                                  return p;
                                              })
                                          .collect(Collectors.toList());


        // action
        final Set<String> result = persons.stream()
                                          .map(Person::getName)
                                          .collect(Collectors.toSet());

        // check
        assertEquals(names, result);
    }


    /**
     * for test lambda
     */
    @Test
    public void test_no_lambda_list_filter(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        //action
        final List<Person> persons = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("j")) {
                final Person p = new Person();
                p.setName(name);
                persons.add(p);
            }
        }

        //check
        assertEquals(names.size() - 1, persons.size());
        assertEquals(names.get(1), persons.get(0).getName());
        assertEquals(names.get(2), persons.get(1).getName());
    }

    /**
     * for test lambda
     */
    @Test
    public void test_lambda_list_filter(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        // action
        final List<Person> persons = names.stream()
                                          .sequential()
                                          .filter(n -> n.startsWith("j"))
                                          .map(n -> {
                                                  final Person p = new Person();
                                                  p.setName(n);
                                                  return p;
                                                })
                                          .collect(Collectors.toList());

        // check
        assertEquals(names.size() - 1, persons.size());
        assertEquals(names.get(1), persons.get(0).getName());
        assertEquals(names.get(2), persons.get(1).getName());
    }


    /**
     * for test lambda
     */
    @Test
    public void test_no_lambda_list(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        //action
        final List<Person> persons = new ArrayList<>();
        for (String name : names) {
            final Person p = new Person();
            p.setName(name);
            persons.add(p);
        }

        //check
        assertEquals(names.get(0), persons.get(0).getName());
        assertEquals(names.get(1), persons.get(1).getName());
        assertEquals(names.get(2), persons.get(2).getName());
    }


    /**
     * for test lambda
     */
    @Test
    public void test_lambda_list(){
        // setup
        final List<String> names = Arrays.asList("namihira", "john", "james");

        // action
        final List<Person> persons = names.stream()
                                          .sequential()
                                          .map(n -> {
                                                  final Person p = new Person();
                                                  p.setName(n);
                                                  return p;
                                                })
                                          .collect(Collectors.toList());

        // check
        assertEquals(names.size(), persons.size());
        assertEquals(names.get(0), persons.get(0).getName());
        assertEquals(names.get(1), persons.get(1).getName());
        assertEquals(names.get(2), persons.get(2).getName());
    }

    @Setter
    @Getter
    private class Person{
        private String name;
    }


    /**
     * for test lambda
     */
    @Test
    public void testLambda(){
        //prepare
        String[] strs = new String[]{"a", "ccc", "bb"};

        //action
        Arrays.sort(strs, (first, second) -> Integer.compare(first.length(), second.length()));

        //check
        assertEquals("a", strs[0]);
        assertEquals("bb", strs[1]);
        assertEquals("ccc", strs[2]);
    }

	/**
	 * for test Arrays.sorts
	 */
	@Test
	public void testArraysSort(){
		//prepare
		String[] strs = new String[]{"a", "ccc", "bb"};

		//action
		Arrays.sort(strs, new LengthComparator());

		//check
		assertEquals("a", strs[0]);
		assertEquals("bb", strs[1]);
		assertEquals("ccc", strs[2]);
	}

	class LengthComparator implements Comparator<String> {
		public int compare(String first, String second) {
			return Integer.compare(first.length(), second.length());
		}
	}

}
