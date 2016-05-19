package reglas;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import to.DatoMatrizTO;
import util.RenderCelda;

/**
 *
 * @author estebanfcv
 */
public class Procedimiento {

    private Map<String, DatoMatrizTO> mapa;
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
        pasoTres();
        generarResultado();
        imprimirMapa();
        pintarMatriz();
    }

    private void pasoUno() {
        //Restar el valor más pequeño de cada uno de los valores de la columna y de si mismo.
        System.out.println("entro al paso Uno\n");
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
        System.out.println("entro al paso Dos\n");
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

    private void pasoTres() {
        System.out.println("entro al paso Tres \n");
        mapa = new LinkedHashMap<>();
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                String llave = renglon + "|" + columna;
                DatoMatrizTO datoMatriz = new DatoMatrizTO();
                datoMatriz.setValor(matriz[renglon][columna]);
                datoMatriz.setRenglon(renglon);
                datoMatriz.setColumna(columna);
                datoMatriz.setCero(datoMatriz.getValor() == 0);
                mapa.put(llave, datoMatriz);
            }
        }
        int ceros;
        // Unicos en renglón y eliminar los demas ceros de la columna
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            ceros = 0;
            for (int columna = 0; columna < matriz.length; columna++) {
                DatoMatrizTO dmto = mapa.get(renglon + "|" + columna);
                if (!dmto.isTachado() && !dmto.isMarcado() && dmto.isCero()) {
                    ceros++;
                }
            }
            if (ceros == 1) {
                int coordenadaY = -1;
                for (int columna = 0; columna < matriz.length; columna++) {
                    DatoMatrizTO dmto = mapa.get(renglon + "|" + columna);
                    if (!dmto.isTachado() && !dmto.isMarcado() && dmto.isCero()) {
                        coordenadaY = columna;
                        mapa.get(renglon + "|" + columna).setMarcado(true);
                        mapa.get(renglon + "|" + columna).setTachado(false);
                        break;
                    }
                }
                for (int coordenadaX = 0; coordenadaX < matriz.length; coordenadaX++) {
                    DatoMatrizTO dmto = mapa.get(coordenadaX + "|" + coordenadaY);
                    if (coordenadaX != renglon && !dmto.isTachado() && dmto.isCero()) {
                        mapa.get(coordenadaX + "|" + coordenadaY).setTachado(true);
                        mapa.get(coordenadaX + "|" + coordenadaY).setMarcado(false);
                    }
                }
            }
        }
        // Unicos en la columna y eliminar los demás del renglón
        for (int columna = 0; columna < matriz.length; columna++) {
            ceros = 0;
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                DatoMatrizTO dmto = mapa.get(renglon + "|" + columna);
                if (!dmto.isTachado() && !dmto.isMarcado() && dmto.isCero()) {
                    ceros++;
                }
            }
            if (ceros == 1) {
                int coordenadaX = -1;
                for (int renglon = 0; renglon < matriz.length; renglon++) {
                    DatoMatrizTO dmto = mapa.get(renglon + "|" + columna);
                    if (!dmto.isTachado() && !dmto.isMarcado() && dmto.isCero()) {
                        coordenadaX = renglon;
                        mapa.get(renglon + "|" + columna).setMarcado(true);
                        mapa.get(renglon + "|" + columna).setTachado(false);
                        break;
                    }
                }
                for (int coordenadaY = 0; coordenadaY < matriz.length; coordenadaY++) {
                    DatoMatrizTO dmto = mapa.get(coordenadaX + "|" + coordenadaY);
                    if (coordenadaY != columna && !dmto.isMarcado() && dmto.isCero()) {
                        mapa.get(coordenadaX + "|" + coordenadaY).setTachado(true);
                        mapa.get(coordenadaX + "|" + coordenadaY).setMarcado(false);
                    }
                }
            }
        }

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

    private void imprimirMapa() {
        System.out.println("");
        for (String key : mapa.keySet()) {
            if (mapa.get(key).isCero()) {
                System.out.println("la llave es:::: " + key + " su contenido es::::");
                System.out.println("el valor es:::: " + mapa.get(key).getValor());
                System.out.println("el valor es cero:::: " + mapa.get(key).isCero());
                System.out.println("el valor es marcado: " + mapa.get(key).isMarcado());
                System.out.println("el valor es tachado: " + mapa.get(key).isTachado());
                System.out.println("");
            }
        }
    }

    private void pintarMatriz() {
        TableCellRenderer renderer = new RenderCelda(mapa);
        tablaResultado.setDefaultRenderer(Object.class, renderer);
    }

}
