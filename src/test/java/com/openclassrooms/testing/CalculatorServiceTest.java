package com.openclassrooms.testing;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import model.CalculationModel;
import model.CalculationType;
import premiertest.Calculator;
import service.CalculatorService;
import service.CalculatorServiceImpl;
import service.SolutionFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.Random;



@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	
	    @Mock
	    Calculator calculator;
	    @Mock
		SolutionFormatter solutionFormatter;
	    CalculatorServiceImpl classUnderTest;
	    
	    @BeforeEach
	    public void init () {
	    	classUnderTest = new CalculatorServiceImpl(calculator,solutionFormatter);
	    }

		/*Calculator calculator = new Calculator();
		// Une instance réelle du calculateur est utilisée
		CalculatorServiceImpl classUnderTest = new CalculatorServiceImpl(calculator); */
	    
	    @Test
	    public void calculate_shouldUseCalculator_forAddition() {
	    	// GIVEN
	    	when(calculator.add(1, 2)).thenReturn(3);

	    	// WHEN
	    	final int result = classUnderTest.calculate(
	    			new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();

	    	// THEN
	    	verify(calculator).add(1, 2);
	    	assertThat(result).isEqualTo(3);
	    }
	    
	    @Test 
	    public void calculate_shouldUseCalculator_Multiplication() {
	    	//GIVEN
	    	when(calculator.multiply(2, 2)).thenReturn(4);
	    	//WHEN
	    	final int result = 
	    			classUnderTest.calculate(
	    					new CalculationModel(CalculationType.MULTIPLICATION,2,2)).getSolution();
	    	
	    	//THEN
	    	verify(calculator).multiply(2, 2);
	    	assertThat(result).isEqualTo(4);
	    }
	    
	    
	    @Test
	    public void calculate_shouldUseCalculator_forAnyAddition() {
	    	// GIVEN
	    	final Random r = new Random();
	    	when(calculator.add(any(Integer.class), any(Integer.class))).thenReturn(3);

	    	// WHEN
	    	final int result = classUnderTest.calculate(
	    			new CalculationModel(CalculationType.ADDITION,
	    			    r.nextInt(), r.nextInt())).getSolution();

	    	// THEN
	    	verify(calculator).add(any(Integer.class), any(Integer.class));
	    	assertThat(result).isEqualTo(3);
	    }
	    
	    @Test
	    public void calculate_shouldFormatSolution_forAnAddition() {
	    	// GIVEN
	    	when(calculator.add(10000, 3000)).thenReturn(13000);
	    	when(solutionFormatter.format(13000)).thenReturn("13 000");

	    	// WHEN
	    	final String formattedResult = classUnderTest
	    	    .calculate(new CalculationModel(CalculationType.ADDITION, 10000, 3000))
	    	    .getFormattedSolution();

	    	// THEN
	    	assertThat(formattedResult).isEqualTo("13 000");
	    }

	/*	@Test
		public void add_returnsTheSum_ofTwoPositiveNumbers() {
			final int result = classUnderTest.calculate(
					new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();
			assertThat(result).isEqualTo(3);
		}

		@Test
		public void add_returnsTheSum_ofTwoNegativeNumbers() {
			final int result = classUnderTest.calculate(
					new CalculationModel(CalculationType.ADDITION, -1, 2))
					.getSolution();

			assertThat(result).isEqualTo(1);
		}

		@Test
		public void add_returnsTheSum_ofZeroAndZero() {
			final int result = classUnderTest.calculate(
					new CalculationModel(CalculationType.ADDITION, 0, 0)).getSolution();
			assertThat(result).isEqualTo(0);
		}*/
	}


