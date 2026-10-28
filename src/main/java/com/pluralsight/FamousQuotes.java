import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        // 10 quotes - index 0 is quote #1
        String[] quotes = {
                "The only true wisdom is in knowing you know nothing. - Socrates",
                "A journey of a thousand miles begins with a single step. - Lao Tzu",
                "It does not matter how slowly you go as long as you do not stop. - Confucius",
                "Well done is better than well said. - Benjamin Franklin",
                "To be, or not to be: that is the question. - William Shakespeare",
                "We are what we repeatedly do. - Aristotle",
                "The secret of getting ahead is getting started. - Mark Twain",
                "Knowledge is power. - Francis Bacon",
                "I think, therefore I am. - Rene Descartes",
                "Whatever you are, be a good one. - Abraham Lincoln"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepGoing = true;

        // keep showing quotes until the user says no
        while (keepGoing) {
            System.out.println();
            System.out.println("Enter a number between 1 and " + quotes.length);
            System.out.println("or type R for a random quote.");
            System.out.print("Your choice: ");
            String input = scanner.nextLine().trim();

            try {
                if (input.equalsIgnoreCase("R")) {
                    // random quote
                    int index = random.nextInt(quotes.length);
                    System.out.println("Random quote #" + (index + 1) + ": " + quotes[index]);
                } else {
                    int choice = Integer.parseInt(input);
                    // subtract 1 because arrays start at 0
                    System.out.println("Quote #" + choice + ": " + quotes[choice - 1]);
                }
            } catch (NumberFormatException e) {
                // user didn't type a number
                System.out.println("\"" + input + "\" is not a number. Please try again.");
            } catch (ArrayIndexOutOfBoundsException e) {
                // number was outside 1-10
                System.out.println("There is no quote #" + input
                        + ". Please pick a number from 1 to " + quotes.length + ".");
            }

            System.out.print("Would you like to see another quote? (yes/no): ");
            String again = scanner.nextLine().trim();
            keepGoing = again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y");
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

}