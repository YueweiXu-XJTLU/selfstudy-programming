package S2_FlowControl;

public class P42_S2_NestedLoop {
    public static void main(String[] args) {
        //Nested Loop 循环嵌套
        //it is allowed to use while-loop/do-while-loop inside the for-loop, vice versa

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(i + "-" + j);
            }
            System.out.println("--------------------");
        }

        //print:
        //     ****
        //
        //     ****
        //
        //     ****
        //
        for (int i = 0; i < 3; i++) { //number of rows
            System.out.print("     ");
            for (int j = 0; j < 4; j++) { //number of columns
                System.out.print("*");
            }
            System.out.println ("\n");
        }

        //print:
        //*
        //**
        //***
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        //sum of prime numbers from 1~100:
        int sum5 = 0; //create the variable to store the sum
        boolean nIsPrimeNumber = true; //every number is a prime number by default, only need to pick up numbers that are not prime below
        for (int n = 2; n < 100; n++) { //adjust n from 2 to 100 (1 is not a prime number by definition)
            for (int i = 2; i < n; i++) { //for a certain n, calculate n % every number less than itself and greater than 2
                if ((n % i) == 0){
                    nIsPrimeNumber = false; //if there is some i that n%i=0, then n is not a prime number
                }
            }

            if (nIsPrimeNumber == true) { //!!!if n is a prime number, then plus it to sum5
                sum5  += n;
            }

            nIsPrimeNumber = true; //reset the nIsPrimeNumber to true for next circle of calculation for next n
        }
        System.out.println(sum5);

    }
}
