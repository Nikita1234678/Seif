import java.util.Arrays;
import java.util.Objects;

public class Utilites {

    public static String TurnArrayToString(Number[] currentTurn) {

        StringBuilder result = new StringBuilder();

        for (Number turnDigit : currentTurn) {
            result.append(turnDigit);
        }

        return result.toString();
    }

    public static int getRightCounter(Number[] digits, Number[] _secret) {
        int right = 0;

        for (Number digit : digits) {
            if (Arrays.asList(_secret).contains(digit)) {
                right++;
            }
        }

        return right;
    }

    public static int getInPlaceCount(Number[] digits, Number[] _secret ) {
        int inPlace = 0;
        for (int counter = 0; counter < 4; counter++) {
            if (Objects.equals(_secret[counter], digits[counter])) {
                inPlace++;
            }
        }
       return  inPlace;
    }
}