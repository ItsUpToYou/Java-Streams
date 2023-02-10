package com.javastreams.examples;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.javastreams.beans.Car;
import com.javastreams.beans.Person;
import com.javastreams.beans.PersonDTO;
import com.javastreams.mockdata.MockData;

public class TransformationMapAndReduce {
	@Test
	void yourFirstTransformationWithMap() throws IOException {
		List<Person> people = MockData.getPeople();

		Function<Person, PersonDTO> personPersonDTOFunction = person ->
				new PersonDTO(
						person.getId(),
						person.getFirstName(),
						person.getAge());

		List<PersonDTO> dtos = people.stream()
				.filter(person -> person.getAge() > 20)
				.map(PersonDTO::map)
				.collect(Collectors.toList());

		dtos.forEach(System.out::println);

	}

	@Test
	void mapToDoubleAndFindAverageCarPrice() throws IOException {
		List<Car> cars = MockData.getCars();
		double avg = cars.stream()
				.mapToDouble(Car::getPrice)
				.average()
				.orElse(0);
		System.out.println(avg);
	}

	@Test
	public void reduce() {
		int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
		int sum = Arrays.stream(integers).reduce(0, Integer::sum);
		int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
		System.out.println(sum);
		System.out.println(sub);
	}

}
