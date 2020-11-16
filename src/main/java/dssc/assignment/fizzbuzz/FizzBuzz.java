package dssc.assignment.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * See README file.
 * Furthermore, this program does a comparison between "old style" and
 * "Java stream" programming.
 */
public class FizzBuzz {

    public static void main(String... args) {
        //int[] N_testValues = {1,2,3,4,5,6,7,8,9,10,15,20,50,100,105,
        //        200,500,1000,10000,20000,50000,100000,150000,200000,250000};
        int[] N_testValues = {100,105};
        boolean print = true ;
        for(int N : N_testValues)
            fizzBuzz(N,print);
    }

    public static void fizzBuzz(int N, boolean print){
        long startTime, endTime, durationOld, durationStream ;

        //"Classic" way (imperative)
        startTime = System.nanoTime(); //just for timing and comparing
        fizzBuzz_old(N, print);
        endTime = System.nanoTime();   //just for timing and comparing
        durationOld = endTime - startTime ;


        //Alternative (stream):
        startTime = System.nanoTime(); //just for timing and comparing
        fizzBuzz_stream(N, print);
        endTime = System.nanoTime();   //just for timing and comparing
        durationStream = endTime - startTime ;


        //Print comparison: "old style" vs "Stream"
        System.out.println("\nCOMPARISON: (N=" + N + ")"
                + "\n\t\"Old style\":\t" + durationOld/1000000.0 + " ms"
                + "\n\t\"Stream\":\t" + durationStream/1000000.0 + " ms");
    }

    public static void fizzBuzz_old(int N, boolean print){
        String str_ris = "";
        for (int i=1; i<=N ; i++) {
            String str_out = "";
            boolean f3 = i%3==0,
                    f5 = i%5==0,
                    f7 = i%7==0;
            if(f3)
                str_out += "Fizz";
            if(f5)
                str_out += "Buzz";
            if(f7)
                str_out += "Bang";
            if(str_out.equals(""))
                str_out += i ;

            str_ris += str_out + "\n";
        }
        if(print)   System.out.println(str_ris);
    }

    public static void fizzBuzz_stream(int N, boolean print){
        int[] multiples = {3,5,7};
        String[] fizzBuzzBang = {"Fizz","Buzz","Bang"};
        String s = IntStream.rangeClosed(1,N)
                .parallel()
                .mapToObj(i -> {
                    String str = IntStream.range(0,multiples.length)
                            .filter(j -> i % multiples[j] == 0)
                            .mapToObj(j -> fizzBuzzBang[j])
                            .collect(Collectors.joining());
                    return (str.isEmpty()?String.valueOf(i):str)+"\n";
                })
                .collect(Collectors.joining());
        if(print)   System.out.println(s);
    }

}
