package com.test.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.oneOf;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.object.HasToString.hasToString;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace;
import static org.hamcrest.text.StringContainsInOrder.stringContainsInOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/* strings
		equalToIgnoringCase							assertThat("foo", equalToIgnoringCase("Foo"));
		equalToIgnoringWhiteSpace					assertThat("foo ", equalToIgnoringCase("  foo"));
		equalTo										assertThat(a, equalTo("foo"));
		startsWith									assertThat("calligraphy", startsWith("call"));
		endsWith									assertThat("calligraphy", startsWith("graphy"));
		emptyString									assertThat("", emptyString());
		emptyOrNullString							assertThat(str, emptyOrNullString()); // str = ""; or str = null;
		containsString								assertThat("calligraphy", containsString("call"));
		stringContainsInOrder						assertThat("calligraphy", stringContainsInOrder(Arrays.asList("call", "graph")));

	integer
		greaterThan									assertThat(2, greaterThan(0));
		greaterThanOrEqualTo						assertThat(5, greaterThanOrEqualTo(5));
		lessThan									assertThat(-2, lessThan(0));
		lessThanOrEqualTo							assertThat(4, lessThanOrEqualTo(5));
		isAPositiveInteger							assertThat(3, isAPositiveInteger());
		
	float, double
		closeTo										assertThat(1.2, closeTo(1, 0.5));
		
		
	objects
		is											assertThat(str1, is(str2)); // str1 = "foo", str2="foo"
		not											assertThat(str1, not(str2)); // str1 = "foo", str2="foos"
		hasProperty									assertThat(person, hasProperty("name"));
													assertThat(person, hasProperty("address", equalTo("New York")));
		hasToString									assertThat(person, hasToString(str));													
		samePropertyValuesAs						assertThat(person1, samePropertyValuesAs(person2)); // 
														//Person person1 = new Person("Baeldung", "New York");
														//Person person2 = new Person("Baeldung", "New York");
		typeCompatibleWith							assertThat(Cat.class, typeCompatibleWith(Animal.class)); // public class Cat extends Animal
		sameInstance								assertThat(cat, sameInstance(cat));
		instanceOf									assertThat(cat, instanceOf(Cat.class));
		notNullValue								assertThat("foo", notNullValue());
		allOf										assertThat(str, allOf(startsWith(start), endsWith(end)));
														//String str = "calligraphy";
														//String start = "call";
														//String end = "phy";
		anyOf										assertThat(str, anyOf(startsWith(start), containsString(end)));
		
	list
		hasSize										assertThat(hamcrestMatchers, hasSize(4)); 
													// List<String> hamcrestMatchers = Arrays.asList("collections", "beans", "text", "number");
		containsInAnyOrder							assertThat(hamcrestMatchers, containsInAnyOrder("beans", "text", "collections", "number"));
		contains									assertThat(hamcrestMatchers, contains("collections", "beans", "text", "number"));
		empty										assertThat(emptyList, empty()); //List<String> emptyList = new ArrayList<>();
		everyItem									assertThat(list, everyItem(greaterThan(baseCase))); 
													//List<Integer> list = Arrays.asList(1, 2, 3);
													//int baseCase = 0;
		
	array
		arrayWithSize								assertThat(hamcrestMatchers, arrayWithSize(4));
													String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		
		hasItemInArray								assertThat(hamcrestMatchers, hasItemInArray("text"));
		in											assertThat("beans", in(hamcrestMatchers));
		arrayContaining								assertThat(hamcrestMatchers, arrayContaining("collections", "beans", "text", "number"));
		arrayContainingInAnyOrder					assertThat(hamcrestMatchers, arrayContaining("beans", "collections", "number", "text"));
		oneOf										assertThat("text", oneOf(hamcrestMatchers));
		
	map
		hasKey										assertThat(map, hasKey("blogname"));
													//Map<String, String> map = new HashMap<>();
													//map.put("blogname", "baeldung");
		hasValue									assertThat(map, hasValue("baeldung"));
		hasEntry									assertThat(map, hasEntry("blogname","baeldung"));
		
		
*/
public class HamcrestMatcherTest {
	@Test
	public void given2Strings_whenEqual_thenCorrect() {
		String a = "foo";
		String b = "FOO";
		assertThat(a, equalToIgnoringCase(b));
		
		String c = "foo ";
		assertThat(a, equalToIgnoringWhiteSpace(c));
		
		assertThat(a, equalTo("foo"));
	}

	@Test
	public void givenAString_whenStartsWithAnotherGivenString_thenCorrect() {
		String str1 = "calligraphy";
		String str2 = "call";
		assertThat(str1, startsWith(str2));
	}

	@Test
	public void givenAString_whenEndsWithAnotherGivenString_thenCorrect() {
		String str1 = "calligraphy";
		String str2 = "phy";
		assertThat(str1, endsWith(str2));
	}
	
	@Test
	public void givenString_whenEmpty_thenCorrect() {
		String str = "";
		assertThat(str, emptyString());
	}

	@Test
	public void givenString_whenEmptyOrNull_thenCorrect() {
		String str = null;
		assertThat(str, emptyOrNullString());
		
		str = "";
		assertThat(str, emptyOrNullString());
	}

	@Test
	public void givenAStrings_whenContainsAnotherGivenString_thenCorrect() {
		String str1 = "calligraphy";
		String str2 = "alli";
		assertThat(str1, containsString(str2));
	}
	
	@Test
	public void givenString_whenContainsGivenSubstring_thenCorrect() {
		String str = "calligraphy";
		assertThat(str, stringContainsInOrder(Arrays.asList("all", "raph")));
	}
	
	@Test
	public void given2Strings_whenIsEqual_thenCorrect() {
		String str1 = "text";
		String str2 = "text";
		assertThat(str1, is(str2));
	}
	
	@Test
	public void given2Strings_whenNotEqual_thenCorrect() {
		String str1 = "text";
		String str2 = "texts";
		assertThat(str1, not(str2));
	}


	

	@Test
	public void givenBean_whenToStringReturnsRequiredString_thenCorrect() {
		Person person = new Person("Barrack", "Washington");
		String str = person.toString();
		assertThat(person, hasToString(str));
	}

	@Test
	public void givenBean_whenHasValue_thenCorrect() {
		Person person = new Person("Baeldung", "New York");
		assertThat(person, hasProperty("name"));
		assertThat(person, hasProperty("address", equalTo("New York")));
	}

	@Test
	public void given2Beans_whenHavingSameValues_thenCorrect() {
		Person person1 = new Person("Baeldung", "New York");
		Person person2 = new Person("Baeldung", "New York");
		assertThat(person1, samePropertyValuesAs(person2));
	}

	@Test
	public void givenAList_whenChecksSize_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList("collections", "beans", "text", "number");
		assertThat(hamcrestMatchers, hasSize(4));
	}

	@Test
	public void givenArray_whenChecksSize_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers, arrayWithSize(4));
	}

	@Test
	public void givenAListAndValues_whenChecksListForGivenValues_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList("collections", "beans", "text", "number");
		assertThat(hamcrestMatchers, containsInAnyOrder("beans", "text", "collections", "number"));
	}

	@Test
	public void givenAListAndValues_whenChecksListForGivenValuesWithOrder_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList("collections", "beans", "text", "number");
		assertThat(hamcrestMatchers, contains("collections", "beans", "text", "number"));
	}

	@Test
	public void givenArrayAndValue_whenValueFoundInArray_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers, hasItemInArray("text"));

	}

	@Test
	public void givenValueAndArray_whenValueIsOneOfArrayElements_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat("text", oneOf(hamcrestMatchers));

	}
	
	@Test
	public void givenValueAndArray_whenValueFoundInArray_thenCorrect() {
		String[] array = new String[] { "collections", "beans", "text",	"number" };
		assertThat("beans", in(array));

	}

	@Test
	public void givenArrayAndValues_whenValuesFoundInArray_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers,
				arrayContainingInAnyOrder("beans", "collections", "number",	"text"));

	}

	@Test
	public void givenArrayAndValues_whenValuesFoundInArrayInOrder_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers, arrayContaining("collections", "beans", "text", "number"));

	}

	@Test
	public void givenCollection_whenEmpty_thenCorrect() {
		List<String> emptyList = new ArrayList<String>();
		assertThat(emptyList, empty());

	}

	@Test
	public void givenMapAndKey_whenKeyFoundInMap_thenCorrect() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("blogname", "baeldung");
		assertThat(map, hasKey("blogname"));
	}

	@Test
	public void givenMapAndEntry_whenEntryFoundInMap_thenCorrect() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("blogname", "baeldung");
		assertThat(map, hasEntry("blogname", "baeldung"));
	}

	@Test
	public void givenMapAndValue_whenValueFoundInMap_thenCorrect() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("blogname", "baeldung");
		assertThat(map, hasValue("baeldung"));
	}



	@Test
	public void given2Classes_whenOneInheritsFromOther_thenCorrect() {
		assertThat(Cat.class, typeCompatibleWith(Animal.class));
	}

	@Test
	public void given2Objects_whenSameInstance_thenCorrect() {
		Cat cat = new Cat();
		assertThat(cat, sameInstance(cat));
	}

	@Test
	public void givenAnObject_whenInstanceOfGivenClass_thenCorrect() {
		Cat cat = new Cat();
		assertThat(cat, instanceOf(Cat.class));
		assertThat(cat, instanceOf(Animal.class));
	}

	@Test
	public void givenList_whenEachElementGreaterThan0_thenCorrect() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		int baseCase = 0;
		assertThat(list, everyItem(greaterThan(baseCase)));
	}

	@Test
	public void givenString_whenNotNull_thenCorrect() {
		String str = "notnull";
		assertThat(str, notNullValue());
	}

	@Test
	public void givenString_whenMeetsAnyOfGivenConditions_thenCorrect() {
		String str = "calligraphy";
		String start = "call";
		String end = "foo";
		assertThat(str, anyOf(startsWith(start), containsString(end), emptyString()));
	}

	@Test
	public void givenString_whenMeetsAllOfGivenConditions_thenCorrect() {
		String str = "calligraphy";
		String start = "call";
		String end = "phy";
		assertThat(str, allOf(startsWith(start), endsWith(end), containsString("lig"), stringContainsInOrder("c", "gra", "hy")));
	}


	@Test
	public void givenAnInteger_whenGreaterThan0_thenCorrect() {
		int num = 1;
		assertThat(num, greaterThan(0));
	}

	@Test
	public void givenAnInteger_whenGreaterThanOrEqTo5_thenCorrect() {
		int num = 5;
		assertThat(num, greaterThanOrEqualTo(5));
	}

	@Test
	public void givenAnInteger_whenLessThan0_thenCorrect() {
		int num = -1;
		assertThat(num, lessThan(0));
	}

	@Test
	public void givenAnInteger_whenLessThanOrEqTo5_thenCorrect() {
		assertThat(-1, lessThanOrEqualTo(5));
	}

	@Test
	public void givenADouble_whenCloseTo_thenCorrect() {
		assertThat(1.2, closeTo(1, 0.5));
	}

}
