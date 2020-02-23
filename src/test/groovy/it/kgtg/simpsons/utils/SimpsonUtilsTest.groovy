package it.kgtg.simpsons.utils

import spock.lang.Specification

import java.util.stream.Stream

class SimpsonUtilsTest extends Specification {

	def "Should create stream from iterator"() {
		given:
			Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator()

		when:
			Stream<Integer> stream = SimpsonUtils.streamOf(iterator)

		then:
			stream.count() == 5
	}

}
