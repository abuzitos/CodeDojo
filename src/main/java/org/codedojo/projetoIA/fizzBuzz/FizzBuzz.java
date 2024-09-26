package org.codedojo.projetoIA.fizzBuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            StringBuilder output = new StringBuilder();

            if (i % 3 == 0) {
                output.append("Fizz");
            }
            if (i % 5 == 0) {
                output.append("Buzz");
            }
            if (i % 7 == 0) {
                output.append("Whizz");
            }
            if (i % 11 == 0) {
                output.append("Bang");
            }
            if (output.length() == 0) {
                output.append(i);
            }

            System.out.println(output);

            if (output.toString().equals("FizzBuzzWhizzBang")) {
                break;
            }

            i++;
        }
    }
}