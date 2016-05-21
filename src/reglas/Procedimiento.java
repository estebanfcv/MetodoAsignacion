package reglas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
import to.DatoMatrizTO;
import util.RenderCelda;

/**
 *
 * @author estebanfcv
 */
public class Procedimiento {

    private Map<String, DatoMatrizTO> mapaMatriz;
    private JTable tablaOriginal;
    private JTable tablaResultado;
    private JTextArea txtResultados;
    private Integer[][] matriz;
    private int numero;
    private Map<Integer, String> renglonesTachados;
    private Map<Integer, String> columnasTachadas;
    private Map<Integer, String> renglonesLinea;
    private Map<Integer, String> columnasLinea;
    private int contador;
    private StringBuilder builder;
    private static final String FORMATO = "%3d   ";

    public Procedimiento(JTable tablaOriginal, JTable tablaResultado, JTextArea txtResultados) {
        this.tablaOriginal = tablaOriginal;
        this.tablaResultado = tablaResultado;
        this.txtResultados = txtResultados;
        contador = 1;
        builder = new StringBuilder(Instrucciones.TITULO);
        builder.append(Instrucciones.SUBTITULO_1).append(contador).append(Instrucciones.SUBTITULO_2);
        numero = tablaOriginal.getRowCount();
        matriz = new Integer[numero][numero];
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[renglon][columna] = (Integer) tablaOriginal.getValueAt(renglon, columna);

            }
        }
        builder.append(Instrucciones.MATRIZ_ORIGINAL);
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                builder.append(String.format(FORMATO, matriz[renglon][columna]));
            }
            builder.append("\n\n");
        }
        pasoUno();
        pasoDos();
        pasoTres();
        pasoCuatro();
        pasoCinco();
        pintarMatriz();
        escribirResuldados();
    }

    private void pasoUno() {
        //Restar el valor más pequeño de cada uno de los valores de la columna y de si mismo.
        builder.append(Instrucciones.PASO_1);
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
            builder.append("Columna: ").append((columna+1)).append(" valor más pequeño: ").append(valorPequeño).append("\n");
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                matriz[renglon][columna] = matriz[renglon][columna] - valorPequeño;
            }
        }
        imprimirDatos("\n", true, false);
    }

    private void pasoDos() {
        // Restar el valor más pequeño de cada renglón de los demás valores de ese renglón y de si mismo.
        builder.append(Instrucciones.PASO_2);
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
            builder.append("Renglón: ").append((renglon+1)).append(" valor más pequeño: ").append(valorPequeño).append("\n");
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[renglon][columna] = matriz[renglon][columna] - valorPequeño;
            }
        }
        imprimirDatos("\n", true, false);
    }

    private void pasoTres() {
        builder.append(Instrucciones.PASO_3);
        //   deben escogerse los 0’s que sean únicos tanto en renglón como en columna y marcarlos
        mapaMatriz = new LinkedHashMap<>();
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                String llave = renglon + "|" + columna;
                DatoMatrizTO datoMatriz = new DatoMatrizTO();
                datoMatriz.setValor(matriz[renglon][columna]);
                datoMatriz.setRenglon(renglon);
                datoMatriz.setColumna(columna);
                datoMatriz.setCero(datoMatriz.getValor() == 0);
                mapaMatriz.put(llave, datoMatriz);
            }
        }
        int ceros;

        // a) deben elegirse los 0’s que sean únicos en renglón y marcarlos, los 0’s restantes de la columna se eliminan
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            ceros = 0;
            for (int columna = 0; columna < matriz.length; columna++) {
                DatoMatrizTO dmto = mapaMatriz.get(renglon + "|" + columna);
                if (!dmto.isEliminado() && !dmto.isSeleccionado() && dmto.isCero()) {
                    ceros++;
                }
            }
            if (ceros == 1) {
                int coordenadaY = -1;
                for (int columna = 0; columna < matriz.length; columna++) {
                    DatoMatrizTO dmto = mapaMatriz.get(renglon + "|" + columna);
                    if (!dmto.isEliminado() && !dmto.isSeleccionado() && dmto.isCero()) {
                        coordenadaY = columna;
                        mapaMatriz.get(renglon + "|" + columna).setSeleccionado(true);
                        mapaMatriz.get(renglon + "|" + columna).setEliminado(false);
                        break;
                    }
                }
                for (int coordenadaX = 0; coordenadaX < matriz.length; coordenadaX++) {
                    DatoMatrizTO dmto = mapaMatriz.get(coordenadaX + "|" + coordenadaY);
                    if (coordenadaX != renglon && !dmto.isEliminado() && dmto.isCero()) {
                        mapaMatriz.get(coordenadaX + "|" + coordenadaY).setEliminado(true);
                        mapaMatriz.get(coordenadaX + "|" + coordenadaY).setSeleccionado(false);
                    }
                }
            }
        }

        imprimirDatos(Instrucciones.IMPRIMIR_DATOS_A, false, true);

        // b) deben seleccionarse los 0’s que sean únicos en columna y marcarlos, los restantes 0’s del renglón se eliminan
        for (int columna = 0; columna < matriz.length; columna++) {
            ceros = 0;
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                DatoMatrizTO dmto = mapaMatriz.get(renglon + "|" + columna);
                if (!dmto.isEliminado() && !dmto.isSeleccionado() && dmto.isCero()) {
                    ceros++;
                }
            }
            if (ceros == 1) {
                int coordenadaX = -1;
                for (int renglon = 0; renglon < matriz.length; renglon++) {
                    DatoMatrizTO dmto = mapaMatriz.get(renglon + "|" + columna);
                    if (!dmto.isEliminado() && !dmto.isSeleccionado() && dmto.isCero()) {
                        coordenadaX = renglon;
                        mapaMatriz.get(renglon + "|" + columna).setSeleccionado(true);
                        mapaMatriz.get(renglon + "|" + columna).setEliminado(false);
                        break;
                    }
                }
                for (int coordenadaY = 0; coordenadaY < matriz.length; coordenadaY++) {
                    DatoMatrizTO dmto = mapaMatriz.get(coordenadaX + "|" + coordenadaY);
                    if (coordenadaY != columna && !dmto.isSeleccionado() && dmto.isCero()) {
                        mapaMatriz.get(coordenadaX + "|" + coordenadaY).setEliminado(true);
                        mapaMatriz.get(coordenadaX + "|" + coordenadaY).setSeleccionado(false);
                    }
                }
            }
        }
        imprimirDatos(Instrucciones.IMPRIMIR_DATOS_B, false, true);
    }

    private void pasoCuatro() {
        builder.append(Instrucciones.PASO_4);
        inicializarMapas();
        boolean cerosMarcados;
        List<DatoMatrizTO> listaRenglon;
        //a) deben marcarse el renglon o renglones que tengan exclusivamente uno o varios 0’s eliminados o tachados
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            listaRenglon = new ArrayList<>();
            cerosMarcados = false;
            //a.1 verificar que el renglón contenga 0's
            for (int columna = 0; columna < matriz.length; columna++) {
                if (mapaMatriz.get(renglon + "|" + columna).isCero()) {
                    listaRenglon.add(mapaMatriz.get(renglon + "|" + columna));
                }
            }
            // a.2 ver el tipo de 0's que tiene (tachado, marcado)
            if (!listaRenglon.isEmpty()) {
                for (DatoMatrizTO dm : listaRenglon) {
                    if (dm.isSeleccionado()) {
                        cerosMarcados = true;
                        break;
                    }
                }
                if (!cerosMarcados) {
                    if (renglonesTachados.get(renglon) == null) {
                        renglonesTachados.put(renglon, "a");
                    }
                }
            }
        }

        imprimirTachadosLineas(Instrucciones.IMPRIMIR_TACHADOS_A, "a");
        //b) marcardo el renglón o renglones del punto a) se revisan dichos renglones y
        //donde esté el 0 eliminado o tachado identifica columnas y se marcan
        for (Integer renglon : renglonesTachados.keySet()) {
            for (int columna = 0; columna < matriz.length; columna++) {
                if (mapaMatriz.get(renglon + "|" + columna).isEliminado()) {
                    if (columnasTachadas.get(columna) == null) {
                        columnasTachadas.put(columna, "b");
                    }
                }
            }
        }
        imprimirTachadosLineas(Instrucciones.IMPRIMIR_TACHADOS_B, "b");
        //c) marcada la columna o columnas se revisan y en la posición donde se ubique el 0 seleccionado, 
        //hay que identificar el o los renglones y se marcan
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (Integer columna : columnasTachadas.keySet()) {
                if (mapaMatriz.get(renglon + "|" + columna).isCero() && mapaMatriz.get(renglon + "|" + columna).isSeleccionado()) {
                    if (renglonesTachados.get(renglon) == null) {
                        renglonesTachados.put(renglon, "c");
                    }
                }
            }
        }
        imprimirTachadosLineas(Instrucciones.IMPRIMIR_TACHADOS_C, "c");
        //d) finalmente, las líneas deben trazarse en el o los renglones no marcados y columnas marcadas.
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            if (renglonesTachados.get(renglon) == null) {
                renglonesLinea.put(renglon, "d");
            }
        }

        for (int columna = 0; columna < matriz.length; columna++) {
            if (columnasTachadas.get(columna) != null) {
                columnasLinea.put(columna, "d");
            }
        }

        // establecer cruce
        for (Integer renglon : renglonesLinea.keySet()) {
            for (Integer columna : columnasLinea.keySet()) {
                mapaMatriz.get(renglon + "|" + columna).setCruzado(true);
            }
        }
        imprimirTachadosLineas(Instrucciones.IMPRIMIR_TACHADOS_D, "d");

    }

    private void pasoCinco() {
        //despues de trazar el número mínimo de líneas se hace la prueba de optimalidad, 
        //si el número de lineas es igual a “n” que representa el número de renglones o columnas,
        //la solución es la óptima.
        builder.append(Instrucciones.PASO_5);
        if (contador >= 100) {
            generarResultado();
            pintarMatriz();
//            JOptionPane.showMessageDialog(tablaResultado, "Solución parcial","",JOptionPane.WARNING_MESSAGE);
            builder.append(Instrucciones.SOLUCION_PARCIAL);
            return;
        }

        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                DatoMatrizTO dm = mapaMatriz.get(renglon + "|" + columna);
                if (dm.isCero() && !dm.isEliminado() && !dm.isSeleccionado()) {
                    mapaMatriz.get(renglon + "|" + columna).setSeleccionado(true);
                }
            }
        }

        int numeroSeleccionados = 0;
        for (DatoMatrizTO value : mapaMatriz.values()) {
            if (value.isSeleccionado()) {
                numeroSeleccionados++;
            }
        }

        if (numeroSeleccionados == numero) {
//            JOptionPane.showMessageDialog(tablaResultado, "SOLUCIÓN TOTAL","",JOptionPane.INFORMATION_MESSAGE);
            builder.append(Instrucciones.SOLUCION_TOTAL);
            imprimirDatos(Instrucciones.MATRIZ_FINAL, false, true);
            generarResultado();
            return;
        }
        DatoMatrizTO dm = new DatoMatrizTO();
        if (numeroSeleccionados != numero) {
            builder.append(Instrucciones.PASO_51);
            //seleccionar el valor más pequeño el cual no debe estar cruzado por ninguna línea,
            int valorPequeño = 0;
            boolean firstTime = true;
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                if (renglonesLinea.get(renglon) != null) {
                    continue;
                }
                for (int columna = 0; columna < matriz.length; columna++) {
                    if (columnasLinea.get(columna) != null) {
                        continue;
                    }
                    if (firstTime) {
                        firstTime = false;
                        valorPequeño = matriz[renglon][columna];
                        dm = mapaMatriz.get(renglon + "|" + columna);
                    } else if (matriz[renglon][columna] < valorPequeño) {
                        valorPequeño = matriz[renglon][columna];
                        dm = mapaMatriz.get(renglon + "|" + columna);
                    }
                }

            }
            //este valor debe restarse de todos los valores que no están cruzados por ninguna linea,
            imprimirRenglonesColumnasTachadas(Instrucciones.R_C_TACHADAS_A, dm);
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                if (renglonesLinea.get(renglon) != null) {
                    continue;
                }
                for (int columna = 0; columna < matriz.length; columna++) {
                    if (columnasLinea.get(columna) != null) {
                        continue;
                    }
                    matriz[renglon][columna] = matriz[renglon][columna] - valorPequeño;
                }
            }
            dm.setValor(dm.getValor() - valorPequeño);
            //despues hay que sumar esta cantidad a todos los valores situados en la intersección de lineas, 
            //donde los valores cruzados por una linea horizontal o vertical permanecen inalterados 
            imprimirRenglonesColumnasTachadas(Instrucciones.R_C_TACHADAS_B, dm);
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                for (int columna = 0; columna < matriz.length; columna++) {
                    if (mapaMatriz.get(renglon + "|" + columna).isCruzado()) {
                        matriz[renglon][columna] = matriz[renglon][columna] + valorPequeño;
                        mapaMatriz.get(renglon + "|" + columna).setValor(mapaMatriz.get(renglon + "|" + columna).getValor() + valorPequeño);
                    }
                }
            }
            imprimirRenglonesColumnasTachadas(Instrucciones.R_C_TACHADAS_C, dm);
        }
        contador++;
        builder.append(Instrucciones.SUBTITULO_1).append(contador).append(Instrucciones.SUBTITULO_2);
        repetirProceso();
    }
    
    private void repetirProceso(){
        pasoTres();
        pasoCuatro();
        pasoCinco();
        generarResultado();
    }

    private void escribirResuldados() {
        StringBuilder sb = new StringBuilder();
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                if (mapaMatriz.get(renglon + "|" + columna).isSeleccionado()) {
                    sb.append("Renglón: ").append(renglon + 1);
                    sb.append(" Columna: ").append((columna + 1));
                    sb.append(" El valor óptimo es: ").append(tablaResultado.getValueAt(renglon, columna));
                    sb.append("\n");
                }
            }
            txtResultados.setText(sb.toString());
        }
    }

    private void generarResultado() {
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                if (mapaMatriz.get(renglon + "|" + columna).isSeleccionado()) {
                    tablaResultado.setValueAt(tablaOriginal.getValueAt(renglon, columna), renglon, columna);
                } else {
                    tablaResultado.setValueAt(matriz[renglon][columna], renglon, columna);
                }
            }
        }
    }

    private void imprimirDatos(String comentario, boolean isMatriz, boolean mostrarSimbologia) {
        builder.append(comentario).append("\n");
        builder.append(mostrarSimbologia ? (Instrucciones.SIMBOLOGIA_CEROS) : "").append("\n");
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                if (isMatriz) {
                    builder.append(String.format(FORMATO, matriz[renglon][columna]));
                } else {
                    String valorTemp;
                    DatoMatrizTO dm = mapaMatriz.get(renglon + "|" + columna);
                    if (!dm.isCero()) {
                        builder.append(String.format(FORMATO, matriz[renglon][columna]));
                    } else if (dm.isSeleccionado()) {
                        valorTemp = "[" + dm.getValor() + "]";
                        builder.append("   ").append(valorTemp);
                    } else if (dm.isEliminado()) {
                        valorTemp = "*" + dm.getValor() + "*";
                        builder.append("   ").append(valorTemp);
                    } else {
                        builder.append(String.format(FORMATO, matriz[renglon][columna]));
                    }
                }
            }
            builder.append("\n");
        }
        builder.append("\n");
    }

    private void imprimirTachadosLineas(String comentario, String letra) {
        builder.append(comentario).append("\n");
        switch (letra) {
            case "a":
                for (Integer rt : renglonesTachados.keySet()) {
                    builder.append("(").append(renglonesTachados.get(rt)).append(") Renglón ").append((rt + 1)).append(" (").append(renglonesTachados.get(rt)).append(")").append("\n");
                }
                builder.append("\n");
                break;
            case "b":
                for (Integer ct : columnasTachadas.keySet()) {
                    builder.append("(").append(columnasTachadas.get(ct)).append(") Columna ").append((ct + 1)).append(" (").append(columnasTachadas.get(ct)).append(")").append("\n");
                }
                builder.append("\n");
                break;
            case "c":
                for (Integer rt : renglonesTachados.keySet()) {
                    builder.append("(").append(renglonesTachados.get(rt)).append(") Renglón ").append((rt + 1)).append(" (").append(renglonesTachados.get(rt)).append(")").append("\n");
                }
                builder.append("\n");
                break;
            default:
                for (Integer rl : renglonesLinea.keySet()) {
                    builder.append("(").append(renglonesLinea.get(rl)).append(") Renglón línea ").append((rl + 1)).append(" (").append(renglonesLinea.get(rl)).append(")").append("\n");
                }
                builder.append("\n");
                for (Integer cl : columnasLinea.keySet()) {
                    builder.append("(").append(columnasLinea.get(cl)).append(") Columna línea ").append((cl + 1)).append(" (").append(columnasLinea.get(cl)).append(")").append("\n");
                }
                builder.append("\n");
        }
        builder.append("\n");
    }

    private void imprimirRenglonesColumnasTachadas(String comentario, DatoMatrizTO datoMatriz) {
        builder.append(comentario).append("\n");
        builder.append(Instrucciones.SIMBOLOGIA_NUMEROS).append("\n");
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                String valorTemp;
                DatoMatrizTO dm = mapaMatriz.get(renglon + "|" + columna);
                if (dm.isCruzado()) {
                    valorTemp = "+" + dm.getValor() + "+";
                    builder.append("   ").append(valorTemp);
                } else if (datoMatriz.getRenglon() == renglon && datoMatriz.getColumna() == columna) {
                    valorTemp = ">" + dm.getValor() + "<";
                    builder.append("   ").append(valorTemp);
                } else if (renglonesLinea.get(renglon) != null || columnasLinea.get(columna) != null) {
                    valorTemp = "-" + dm.getValor() + "-";
                    builder.append("   ").append(valorTemp);
                } else {
                    builder.append(String.format(FORMATO, matriz[renglon][columna]));
                }
            }
            builder.append("\n");
        }
        builder.append("\n");
    }

    public String imprimirMatriz() {
        StringBuilder sb = new StringBuilder();
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                sb.append(String.format(FORMATO, matriz[renglon][columna]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void pintarMatriz() {
        TableCellRenderer renderer = new RenderCelda(mapaMatriz);
        tablaResultado.setDefaultRenderer(Object.class, renderer);
    }

    private void inicializarMapas() {
        renglonesTachados = new LinkedHashMap<>();
        columnasTachadas = new LinkedHashMap<>();
        renglonesLinea = new LinkedHashMap<>();
        columnasLinea = new LinkedHashMap<>();
    }

    public String getPasos() {
        return builder.toString();
    }
}
