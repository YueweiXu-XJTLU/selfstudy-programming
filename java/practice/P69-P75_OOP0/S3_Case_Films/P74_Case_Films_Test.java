package S6_S3_Case_Films;

import java.util.Scanner;

public class P74_Case_Films_Test {
    public static void main(String[] args) {
        Films f1 = new Films(1,"水门桥",38.9,9.8,"徐克","吴京","12万人想看");
        Films f2 = new Films(2,"出拳吧",39,7.8,"唐晓白","田雨","3.5万人想看");
        Films f3 = new Films(3,"月球陨落",42,7.9,"罗兰","贝瑞","17.9万人想看");
        Films f4 = new Films(4,"一点就到家",35,8.7,"许宏宇","刘吴然","10.8万人想看");

        Films[] films = {f1, f2, f3, f4};
        Operator operator = new Operator(films);
//        operator.printAllFilms();
//        System.out.println("-----");
//        operator.searchFilms(2);



        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==Film System==");
            System.out.println("Enter 1 to look through all film info");
            System.out.println("Enter 2 to search for a certain film");
            System.out.println("Please enter:");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    operator.printAllFilms();
                    break;
                case 2:
                    System.out.println("Please enter the film id:");
                    operator.searchFilms(sc.nextInt());
                    break;
                default:
                    System.out.println("Invalid");
                    System.out.println("\n\n");
            }
        }
    }
}
