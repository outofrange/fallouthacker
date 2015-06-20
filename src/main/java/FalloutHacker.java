import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Markus Möslinger
 */
public class FalloutHacker {
    private final Set<String> words;

    public FalloutHacker(List<String> words) {
        this.words = words.stream().map(String::toLowerCase).collect(Collectors.toSet());
    }

    public Set<String> leftWords() {
        return words;
    }

    public void guessed(String guess, int common) {
        words.remove(guess);
        removeNotMatchingWords(guess, common);
    }

    private int charsAtCorrectPlace(String possibleMatch, String guessed) {
        int common = 0;

        for (int i = 0; i < possibleMatch.length(); i++) {
            if (possibleMatch.charAt(i) == guessed.charAt(i)) {
                common++;
            }
        }

        return common;
    }

    private void removeNotMatchingWords(String guess, int actualCommon) {
        Iterator<String> it = words.iterator();

        while (it.hasNext()) {
            final String word = it.next();

            final int charsInCommon = charsAtCorrectPlace(word, guess);
            if (charsInCommon != actualCommon) {
                it.remove();
            }
        }
    }
}
