import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER = "//(.)\n";
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        validate(input);

        String delimiter = getDelimiter(input);
        return calculate(input, delimiter);
    }

    private static boolean isCustomDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        return m.find();
    }

    private static void validate(String input) {
        if (isCustomDelimiter(input) == false && input.startsWith("//")) {
            throw new RuntimeException();
        }
    }

    private static void checkNegative(int num) {
        if(num < 0) {
            throw new RuntimeException();
        }
    }

    private static String getDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static String[] getCandidates(String input, String delimiter) {
        if(isCustomDelimiter(input)) {
            input = input.replaceAll(CUSTOM_DELIMITER, "");
        }
        String[] split = input.split(delimiter);
        return split;
    }

    private static int calculate(String input, String delimiter) {
        int sum = 0;
        String[] candidates = getCandidates(input, delimiter);
        for(int i=0; i<candidates.length; i++) {
            int number = Integer.parseInt(candidates[i]);
            checkNegative(number);
            sum += number;
        }
        return sum;
    }
}
