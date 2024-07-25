
/**
 *
 * @Gunnar Creach
 */
import java.util.Scanner;
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int[] smithVotes = new int[3];
        int[] carterVotes = new int[3];

        System.out.println("Enter your votes for each candidate by precinct");

        // Input votes for each precinct
        for (int i = 0; i < 3; i++) {
            System.out.println("Precinct " + (i + 1) + " votes:");
            System.out.print("Mr. Smith votes: ");
            smithVotes[i] = scanner.nextInt();
            System.out.print("Carter Pewterschmidt votes: ");
            carterVotes[i] = scanner.nextInt();
            System.out.println();
        }

        // Calculate and display total votes
        int totalSmithVotes = findTotalVotes(smithVotes);
        int totalCarterVotes = findTotalVotes(carterVotes);

        System.out.println("The votes for each candidate are:");
        System.out.println("Mr. Smith: " + totalSmithVotes);
        System.out.println("Carter Pewterschmidt: " + totalCarterVotes);
        System.out.println();

        displayWinner(totalSmithVotes, totalCarterVotes);
        System.out.println();

        // Allow recounts
        System.out.print("Do you have any recounts? 1 for Yes, 2 for No: ");
        int recount = scanner.nextInt();
        while (recount == 1) {
            System.out.println();
            System.out.println("Select the appropriate candidate number below.");
            System.out.println("1. Mr. Smith");
            System.out.println("2. Carter Pewterschmidt");
            System.out.print("Candidate number: ");
            int candidate = scanner.nextInt();
            System.out.println();

            System.out.println("Please select a precinct to change");
            System.out.println("1. Precinct 1");
            System.out.println("2. Precinct 2");
            System.out.println("3. Precinct 3");
            System.out.print("Precinct number: ");
            int precinct = scanner.nextInt();
            System.out.println();

            System.out.print("Please enter the number of votes: ");
            int newVotes = scanner.nextInt();
            System.out.println();

            if (candidate == 1) {
                smithVotes[precinct - 1] = newVotes;
            } else {
                carterVotes[precinct - 1] = newVotes;
            }

            // Recalculate and display total votes
            totalSmithVotes = findTotalVotes(smithVotes);
            totalCarterVotes = findTotalVotes(carterVotes);

            System.out.println("The votes for each candidate are:");
            System.out.println("Mr. Smith: " + totalSmithVotes);
            System.out.println("Carter Pewterschmidt: " + totalCarterVotes);
            System.out.println();

            displayWinner(totalSmithVotes, totalCarterVotes);

            System.out.print("Do you have any recounts? 1 for Yes, 2 for No: ");
            recount = scanner.nextInt();
            System.out.println();
        }

        System.out.println("The votes for each candidate are:");
        System.out.println("Mr. Smith: " + totalSmithVotes);
        System.out.println("Carter Pewterschmidt: " + totalCarterVotes);
        System.out.println();

        displayWinner(totalSmithVotes, totalCarterVotes);

        scanner.close();
    }

    public static int findTotalVotes(int[] votes) {
        int total = 0;
        for (int vote : votes) {
            total += vote;
        }
        return total;
    }

    public static void displayWinner(int firstCandidate, int secondCandidate) {
        if (firstCandidate > secondCandidate) {
            System.out.println("Mr. Smith with " + firstCandidate + " votes is the winner!r");
        } else if (secondCandidate > firstCandidate) {
            System.out.println("Carter Pewterschmidt with " + secondCandidate + " votes is the winner!");
        } else {
            System.out.println("It is a tie!");
        }
    }
}

    }

}
