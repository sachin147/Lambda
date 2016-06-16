import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalLambda {
	public static void main(String args[]) {
		String a[] = {"1", "2"};
		String words[] = {"abcdef", "abc", "abcdefgh"};
		Integer numbers[] = {1, 2, 3, 4, 5};
		List<String> words2 = new ArrayList<String>(Arrays.asList(words));
		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(numbers));
		Arrays.sort(a,String::compareToIgnoreCase);
		long count = words2.stream().filter(w -> w.length() > 12).count();
		Stream<String> wordsnew = Stream.of("sachin","ram","viraj");
		Stream<String> arrayStream = Arrays.stream(words, 0, words.length);
		Stream<String> none = Stream.empty();
		Stream.generate(() -> "SACHIN");
		Stream.generate(Math::random);
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		wordsnew.map(w -> w.toLowerCase());
		Stream<Character> firstChars = wordsnew.map(s -> s.charAt(0));
		Stream<Stream<Character>> result = wordsnew.map(w -> characterStream(w));
		Stream<Character> letters = wordsnew.flatMap(w -> characterStream(w));
		Stream<Double> randoms = Stream.generate(Math::random).limit(100);
		Stream<Double> randomskip = Stream.generate(Math::random).skip(5);
		Stream<Character> combined = Stream.concat(characterStream("Hello"), characterStream("World"));
		Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();
		//stateful
		Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
		Stream<String> longestFirst = wordsnew.sorted(Comparator.comparing(String::length).reversed());
		
		
		Optional<String> largest = wordsnew.max(String::compareToIgnoreCase);
		if (largest.isPresent())
		System.out.println("largest: " + largest.get());
		
		
		Optional<String> startsWithQ = wordsnew.filter(s -> s.startsWith("Q")).findFirst();
		
		
		Optional<String> startsWithQparallel = wordsnew.parallel().filter(s -> s.startsWith("Q")).findAny();
		
		boolean aWordStartsWithQ = wordsnew.parallel().anyMatch(s -> s.startsWith("Q"));
		
		Stream<Integer> numberStream = nums.stream();
		
		Integer[] numsArray = numberStream.toArray(Integer[]::new);
		
		List<String> stringStreamList = wordsnew.collect(Collectors.toList());
		
		String joined = wordsnew.collect(Collectors.joining(", "));
		
		numberStream.forEach(System.out::println);
		
		/*Map<Integer, String> idToName = people.collect(Collectors.toMap(Person::getId, Person::getName));*/
		
		/*Map<Integer, Person> idToPerson = people.collect(Collectors.toMap(Person::getId, Function.identity()));*/
		
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, String> languageNames = locales.collect(
		Collectors.toMap(
		l -> l.getDisplayLanguage(),
		l -> l.getDisplayLanguage(l),
		(existingValue, newValue) -> existingValue));
		
		
		
		/*Map<String, Set<String>> countryLanguageSets = locales.collect(
				Collectors.toMap(
				l -> l.getDisplayCountry(),
				l -> Collections.singleton(l.getDisplayLanguage()),
				(a, b) -> { // Union of a and b
				Set<String> r = new HashSet<>(a);
				r.addAll(b);
				return r; }));
		*/
		
		
		
		Map<String, List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
		
		Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
		
		List<Locale> englishLocales = englishAndOtherLocales.get(true);
				
		
		Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(Locale::getCountry, toSet()));
		
		Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(Locale::getCountry, counting()));
		
		//Map<String, Integer> stateToCityPopulation = cities.collect(groupingBy(City::getState, summingInt(City::getPopulation)));
		
		//Map<String, City> stateToLargestCity = cities.collect(groupingBy(City::getState,maxBy(Comparator.comparing(City::getPopulation))));
		
		//Map<String, Optional<String>> stateToLongestCityName = cities.collect(groupingBy(City::getState,mapping(City::getName,maxBy(Comparator.comparing(String::length)))));
		
		
		//primitive stream
		IntStream zeroToNinetyNine = IntStream.range(0, 100); // Upper bound is excluded
		IntStream zeroToHundred = IntStream.rangeClosed(0, 100); // Upper bound is included
		
		
		IntStream lengths = wordsnew.mapToInt(String::length);
		
		Stream<Integer> primitiveToObjectType = IntStream.range(0, 100).boxed();
	}
	
	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()) {			
			result.add(c);
		}
		return result.stream();
	}
	
	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}
}
