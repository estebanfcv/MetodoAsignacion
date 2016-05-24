package util;

import java.util.Collection;

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

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String debugImprimirContenidoObjecto(Object o) {
        if (null == o) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("Objeto clase: ").append(o.getClass().getName()).append(" - ").append(o.toString()).append('\n');
        try {
            for (java.lang.reflect.Field f : o.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                sb = sb.append(f.getName()).append(" - ").append(f.get(o)).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String debugImprimirContenidoListaObjeto(Collection<? extends Object> lista) {
        if (null == lista) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("Collection clase: ").append(lista.getClass().getName()).append(" - ").append(lista.toString()).append('\n');
        try {
            for (Object o : lista) {
                sb = sb.append("Objeto clase: ").append(o.getClass().getName()).append(" - ").append(o.toString()).append('\n');
                for (java.lang.reflect.Field f : o.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    sb = sb.append(f.getName()).append(" - ").append(f.get(o)).append('\n');
                }
                sb = sb.append("=============================\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
