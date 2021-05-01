package com.openclassrooms.testing;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import premiertest.Calculator;

@ExtendWith(LogginExtension.class)
public class CalculatorTest {
	
	private static Instant startedAt;
	private Calculator calculatorUnderTest;
	private Logger logger ;
	public void setLogger (Logger logger) {
		this.logger=logger;
	}
	
@BeforeEach
public void  initCalculator() {
	System.out.println("Appel avant chaque Test");
	calculatorUnderTest = new Calculator();
}
 @ParameterizedTest(name= "{0}+{1} sould be equal to {2}")
 @CsvSource({"1,1,2","2,3,5","42,57,99"})
 void testAddTwoPositiveNumbers(int arg1,int arg2, int expectResult) {
	 
	 //int a =2 ;
	 //int b= 3;
	 
	 //Act
	 int somme = calculatorUnderTest.add(arg1,arg2);
	 
	 // Assertion
	 assertEquals(expectResult,somme);
 }
 
 @ParameterizedTest (name ="{0} x 0 doit etre egal a 0")
 @ValueSource(ints = {1,2,42,1011,5089})
 void testMultiplyTwoPositiveNumbers(int arg) {
	 //int a = 42;
	 //int b = 11;
	 int produit = calculatorUnderTest.multiply(arg,0);
	 assertEquals(0,produit);
 }
 
 @AfterEach
 public void undefCalculator() {
	 System.out.println("Appel apres chaque test");
	 calculatorUnderTest = null;
 }

 @BeforeAll
 static public void initStartingTime() {
	 System.out.println("Appel avant tous les tests");
	 startedAt = Instant.now();
 }
 
@AfterAll
static public void showTestDuration() {
	System.out.println("Appel apres tous les tests");
	Instant endetAt = Instant.now();
	long duration = Duration.between(startedAt, endetAt).toMillis();
	System.out.println(MessageFormat.format("Duree des tests : {0} ms", duration));
 
 
 
 
 
 
 
 
 
 
 
 }
}
