package reglas;

import javax.swing.JTable;

/**
 *
 * @author estebanfcv
 */
public class Procedimiento {

    private JTable tablaOriginal;
    private JTable tablaResultado;
    private Integer[][] matriz;
    private int numero;

    public Procedimiento(JTable tablaOriginal, JTable tablaResultado) {
        this.tablaOriginal = tablaOriginal;
        this.tablaResultado = tablaResultado;
        numero = tablaOriginal.getRowCount();
        matriz = new Integer[numero][numero];
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[renglon][columna] = (Integer) tablaOriginal.getValueAt(renglon, columna);

            }
        }
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                System.out.print(matriz[renglon][columna]);
                System.out.print(" , ");
            }
            System.out.println("");
        }
        pasoUno();
        pasoDos();
        generarResultado();
    }

    private void pasoUno() {
        //Restar el valor más pequeño de cada uno de los valores de la columna y de si mismo.
        System.out.println("entro al paso Uno");
        int valorPequeño = 0;
        boolean firstTime;
        for (int columna = 0; columna < matriz.length; columna++) {
            firstTime = true;
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                if (firstTime) {
                    firstTime = false;
                    valorPequeño = matriz[renglon][columna];
                } else if (matriz[renglon][columna] < valorPequeño) {
                    valorPequeño = matriz[renglon][columna];
                }
            }
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                matriz[renglon][columna] = matriz[renglon][columna] - valorPequeño;
            }
        }
        imprimirMatriz("pasoUno");
    }

    private void pasoDos() {
        System.out.println("entro al paso Dos");
        // Restar el valor más pequeño de cada renglón de los demás valores de ese renglón y de si mismo.
        int valorPequeño = 0;
        boolean firstTime;
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            firstTime = true;
            for (int columna = 0; columna < matriz.length; columna++) {
                if (firstTime) {
                    firstTime = false;
                    valorPequeño = matriz[renglon][columna];
                } else if (matriz[renglon][columna] < valorPequeño) {
                    valorPequeño = matriz[renglon][columna];
                }
            }
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[renglon][columna] = matriz[renglon][columna] - valorPequeño;
            }
        }
        imprimirMatriz("pasoDos");
    }

    private void generarResultado() {
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                tablaResultado.setValueAt(matriz[renglon][columna], renglon, columna);
            }
        }
    }

    private void imprimirMatriz(String comentario) {
        System.out.println(comentario + "\n");
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                System.out.print(matriz[renglon][columna]);
                System.out.print(" , ");
            }
            System.out.println("");
        }
    }

}
