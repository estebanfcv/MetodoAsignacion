package reglas;

/**
 *
 * @author estebanfcv
 */
public class Instrucciones {

    public static final String SIMBOLOGIA_CEROS = "\nDonde:\n\n[0] cero seleccionado.\n *0* cero eliminado.\n";
    public static final String SIMBOLOGIA_NUMEROS = "\nDonde:\n" + "\n-#- Número en línea.\n +#+ Número en cruce.\n>#< Número menor.\n";
    public static final String TITULO = "======================================Procedimiento======================================\n\n";
    public static final String SUBTITULO_1 = "\n\n======================================Corrida: ";
    public static final String SUBTITULO_2 = "======================================\n\n";
    public static final String MATRIZ_ORIGINAL = "Matriz Original\n\n";
    public static final String MATRIZ_FINAL = "Matriz Final\n";
    public static final String PASO_1 = "PASO 1: \nRestar el valor más pequeño de cada uno de los valores de la columna y de si mismo.\n\n";
    public static final String PASO_2 = "PASO 2: \nRestar el valor más pequeño de cada renglón de los demás valores de ese renglón y de si mismo.\n\n";
    public static final String PASO_3 = "PASO 3: \nDeben escogerse los 0’s que sean únicos tanto en renglón como en columna y marcarlos.\n";
    public static final String PASO_4 = "PASO 4:\n"
            + "Verificar la optimalidad trazando el mímino número de líneas que pueden pasar a través de todos los 0’s.\n";
    public static final String PASO_5 = "PASO 5:\nPrueba de optimalidad:\n"
            + "Si el número de líneas es igual a “n” que representa el número de renglones o columnas, la solución es la óptima.\n";
    public static final String PASO_51 = "Si el número de líneas es diferente a “n”:\n";
    public static final String IMPRIMIR_DATOS_A = "a) Deben elegirse los 0’s que sean únicos en renglón y marcarlos,"
            + " los 0’s restantes de la columna se eliminan.\n";
    public static final String IMPRIMIR_DATOS_B = "b) Deben seleccionarse los 0’s que sean únicos en columna y marcarlos,"
            + " los restantes 0’s del renglón se eliminan.\n";
    public static final String IMPRIMIR_TACHADOS_A = "a) "
            + "Deben marcarse el renglón o renglones que tengan exclusivamente uno o varios 0’s eliminados o tachados.\n";
    public static final String IMPRIMIR_TACHADOS_B = "b) Marcardo el renglón o renglones del punto a) :\n "
            + "Se revisan dichos renglones y donde esté el 0 eliminado o tachado identifica columnas y se marcan.\n";
    public static final String IMPRIMIR_TACHADOS_C = "c) Marcada la columna o columnas se revisan y en la posición donde se ubique el 0 seleccionado,"
            + "donde esté el 0 eliminado o tachado identifica columnas y se marcan.\n";
    public static final String IMPRIMIR_TACHADOS_D = "d) Finalmente,"
            + " las líneas deben trazarse en el o los renglones NO MARCADOS y columnas MARCADAS.\n";
    public static final String SOLUCION_TOTAL_RESULTADO = "\n==============================SOLUCIÓN TOTAL==============================\n";
    public static final String SOLUCION_PARCIAL = "\n======================================SOLUCIÓN PARCIAL======================================\n";
    public static final String SOLUCION_TOTAL= "\n======================================SOLUCIÓN TOTAL======================================\n";
    public static final String SIN_SOLUCION="\n================================SIN SOLUCIÓN================================\n";
    public static final String R_C_TACHADAS_A = "a) Seleccionar el valor más pequeño el cual no debe estar cruzado por ninguna línea.\n";
    public static final String R_C_TACHADAS_B = "b) Este valor debe restarse de todos los valores que no están cruzados por ninguna línea.\n";
    public static final String R_C_TACHADAS_C = "c) después hay que sumar esta cantidad a todos los valores situados en la intersección de líneas.\n";
    public static final String REVISAR_PROCEDIMIENTO= "\nRevisar el procedimiento para más información.";

}
