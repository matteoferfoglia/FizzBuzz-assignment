package dssc.assignment.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Convert {

    @Test
    void number_1_to_string_1() {   //We want to convert number 1 to string 1
        // Arrange  :   set up classes and instances to use in our test
        FizzBuzz fizzBuzz = new FizzBuzz() ;

        // Act      :   here we invoke some behaviour of the instances for testing
        String numberAsString = fizzBuzz.convert(1) ;

        // Assert
        Assertions.assertEquals("1", numberAsString);   //first arg: what we expect
    }

    @Test
    void number_1_to_string_1_bis() {   //Same test, less verbose:
        FizzBuzz fizzBuzz = new FizzBuzz() ;

        Assertions.assertEquals("1", fizzBuzz.convert(1));   //first arg: what we expect
    }
}
