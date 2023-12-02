package collections;

import java.util.*;

public class Lottery {

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new LinkedHashSet<Integer>();
        for (int i = 0; i < 6; i++) {
            System.out.println("Enter " + (i + 1) + ". number (1-49): ");
            int number = scanner.nextInt();
            if (number < 1 || number > 49) {
                System.out.println("The number out of the range 1 - 49");
                break;
            } else {
                numbers.add(number);
            }
        }

        Set<Integer> integerSet = runLottery();

        int result = returnResult(numbers, integerSet);

        System.out.println("You have chosen: ");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.println("The lottery numbers are: ");
        for (Integer integer : integerSet) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println("Your result is: " + result);
    }

    private static Set<Integer> runLottery() {
        Set<Integer> numbers = new LinkedHashSet<>();
        for (int i = 0; i < 6; i++) {
            Random rand = new Random();
            numbers.add(rand.nextInt(49) + 1);
        }
        return numbers;
    }

    public static int returnResult(Set<Integer> usersNumbers, Set<Integer> lotteryNumbers) {

        int counter = 0;
        for (Integer lotteryNumber : lotteryNumbers) {
            if (usersNumbers.contains(lotteryNumber)) {
                counter++;
            }
        }
        return counter;
    }
}
