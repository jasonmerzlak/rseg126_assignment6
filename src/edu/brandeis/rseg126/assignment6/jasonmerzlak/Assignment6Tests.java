package edu.brandeis.rseg126.assignment6.jasonmerzlak.test;

import edu.brandeis.rseg126.assignment6.jasonmerzlak.Assignment6;

import java.util.stream.Stream;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Assignment6Tests
 * Just a series of quick tests to ensure accuracy.
 * 
 * 
 */
public class Assignment6Tests {
    @Test
    public void testNumber1() {        
        assertEquals(Assignment6.prime_sieve(1).count(), 0); 
    }

    @Test
    public void testNumber2() {
        assertEquals(Assignment6.prime_sieve(2).count(), 1);
    }
}
