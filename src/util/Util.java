package util;

/**
 *
 * @author estebanfcv
 */
public class Util {

    private Util() {
    }

    public static boolean isNumero(String s) {
        char x;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x < 48 || x > 57) {
                return false;
            }
        }
        return true;
    }

}
