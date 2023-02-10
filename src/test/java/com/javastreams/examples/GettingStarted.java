package com.javastreams.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.javastreams.beans.Person;
import com.javastreams.mockdata.MockData;

public class GettingStarted {

	@Test
	public void imperativeApproach() throws IOException {
		//1 FInd people aged less or equal 18
		//2 Then change implementation to find firs 10 people
		List<Person> people = MockData.getPeople();
		List<Person> youngPeople = new ArrayList<>();

		int stopCounter = 10;
		for (Person person : people) {
			if (person.getAge() <= 10) {
				if (stopCounter-- == 0) {
					break;
				}
				youngPeople.add(person);

			}
		}
		youngPeople.stream().forEach(System.out::println);

	}

	@Test
	public void declaritiveApproach() throws IOException {
		List<Person> people = MockData.getPeople();
		List<Person> youngPeople = people.stream()
				.filter(person -> person.getAge() <= 10)
				.limit(10)
				.collect(Collectors.toList());
		youngPeople.forEach(System.out::println);
	}
}
