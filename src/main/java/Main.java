import java.util.*;

/**
 * @author Markus Möslinger
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter words\n");

        List<String> initialWords = new ArrayList<>();

        String line = in.nextLine();
        while (!line.trim().equals("")) {
            initialWords.add(line);
            line = in.nextLine();
        }

        FalloutHacker hacker = new FalloutHacker(initialWords);

        do {
            StringJoiner joiner = new StringJoiner(", ");

            hacker.leftWords().forEach(joiner::add);
            System.out.println("Try one of those: " + joiner.toString());

            System.out.println("What have you tried?");
            String trie = in.nextLine().toLowerCase();
            System.out.println("How much in common? ");
            line = in.nextLine();
            hacker.guessed(trie, Integer.valueOf(line));
        } while (!line.trim().equals(""));
    }
}
