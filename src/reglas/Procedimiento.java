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
    private Map<Integer, Integer> renglonesTachados;
    private Map<Integer, Integer> columnasTachadas;
    private Map<Integer, Integer> renglonesLinea;
    private Map<Integer, Integer> columnasLinea;
    private int contador;
    private StringBuilder builder;

    public Procedimiento(JTable tablaOriginal, JTable tablaResultado, JTextArea txtResultados) {
        this.tablaOriginal = tablaOriginal;
        this.tablaResultado = tablaResultado;
        this.txtResultados = txtResultados;
        contador = 1;
        builder = new StringBuilder("======================================Procedimiento======================================\n\n");
        builder.append("\n\n======================================Corrida: ").append(contador).append("======================================\n\n");
        numero = tablaOriginal.getRowCount();
        matriz = new Integer[numero][numero];
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[renglon][columna] = (Integer) tablaOriginal.getValueAt(renglon, columna);

            }
        }
        builder.append("Matriz Original\n\n");
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                builder.append(String.format("%3d   ", matriz[renglon][columna]));
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
        imprimirDatos("PASO 1: \n" + "Restar el valor más pequeño de cada uno de los valores de la columna y de si mismo.\n", true, false);
    }

    private void pasoDos() {
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
        imprimirDatos("PASO 2: \n" + "Restar el valor más pequeño de cada renglón de los demás valores de ese renglón y de si mismo.\n", true, false);
    }

    private void pasoTres() {
        builder.append("PASO 3: \n").append("Deben escogerse los 0’s que sean únicos tanto en renglón como en columna y marcarlos\n");
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

        imprimirDatos("a) Deben elegirse los 0’s que sean únicos en renglón y marcarlos, los 0’s restantes de la columna se eliminan.\n", false, true);

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
        imprimirDatos("b) Deben seleccionarse los 0’s que sean únicos en columna y marcarlos, los restantes 0’s del renglón se eliminan\n", false, true);
    }

    private void pasoCuatro() {
        builder.append("PASO 4:\n").append("Verificar la optimalidad trazando el mímino número de líneas que pueden pasar a través de todos los 0’s.\n");
        renglonesTachados = new LinkedHashMap<>();
        columnasTachadas = new LinkedHashMap<>();
        renglonesLinea = new LinkedHashMap<>();
        columnasLinea = new LinkedHashMap<>();
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
                    renglonesTachados.put(renglon, renglon);
                }
            }
        }

        imprimirTachadosLineas("a) Deben marcarse el renglón o renglones que tengan exclusivamente uno o varios 0’s eliminados o tachados.\n", "a");
        //b) marcardo el renglón o renglones del punto a) se revisan dichos renglones y
        //donde esté el 0 eliminado o tachado identifica columnas y se marcan
        for (Integer renglon : renglonesTachados.keySet()) {
            for (int columna = 0; columna < matriz.length; columna++) {
                if (mapaMatriz.get(renglon + "|" + columna).isEliminado()) {
                    columnasTachadas.put(columna, columna);
                }
            }
        }
        imprimirTachadosLineas("b) Marcardo el renglón o renglones del punto a) se revisan dichos renglones y "
                + "donde esté el 0 eliminado o tachado identifica columnas y se marcan\n", "b");
        //c) marcada la columna o columnas se revisan y en la posición donde se ubique el 0 seleccionado, 
        //hay que identificar el o los renglones y se marcan
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (Integer columna : columnasTachadas.keySet()) {
                if (mapaMatriz.get(renglon + "|" + columna).isCero() && mapaMatriz.get(renglon + "|" + columna).isSeleccionado()) {
                    renglonesTachados.put(renglon, renglon);
                }
            }
        }
        imprimirTachadosLineas("c) Marcada la columna o columnas se revisan y en la posición donde se ubique el 0 seleccionado, "
                + "donde esté el 0 eliminado o tachado identifica columnas y se marcan\n", "c");
        //d) finalmente, las líneas deben trazarse en el o los renglones no marcados y columnas marcadas.
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            if (renglonesTachados.get(renglon) == null) {
                renglonesLinea.put(renglon, renglon);
            }
        }

        for (int columna = 0; columna < matriz.length; columna++) {
            if (columnasTachadas.get(columna) != null) {
                columnasLinea.put(columna, columna);
            }
        }

        // establecer cruce
        for (Integer renglon : renglonesLinea.keySet()) {
            for (Integer columna : columnasLinea.keySet()) {
                mapaMatriz.get(renglon + "|" + columna).setCruzado(true);
            }
        }
        imprimirTachadosLineas("d) Finalmente, las líneas deben trazarse en el o los renglones NO MARCADOS y columnas MARCADAS.\n", "d");

    }

    private void pasoCinco() {
        //despues de trazar el número mínimo de líneas se hace la prueba de optimalidad, 
        //si el número de lineas es igual a “n” que representa el número de renglones o columnas,
        //la solución es la óptima.
        builder.append("PASO 5:\n").append("Prueba de optimalidad:\n"
                + "Si el número de líneas es igual a “n” que representa el número de renglones o columnas, la solución es la óptima\n");
        if (contador >= 100) {
            generarResultado();
            pintarMatriz();
//            JOptionPane.showMessageDialog(tablaResultado, "Solución parcial","",JOptionPane.WARNING_MESSAGE);
            builder.append("\n======================================SOLUCIÓN PARCIAL======================================\n");
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
            builder.append("\n======================================SOLUCIÓN TOTAL======================================\n");
            imprimirDatos("Matriz Final\n", false, true);
            generarResultado();
            return;
        }
        DatoMatrizTO dm = new DatoMatrizTO();
        if (numeroSeleccionados != numero) {
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
            //despues hay que sumar esta cantidad a todos los valores situados en la intersección de lineas, 
            imprimirRenglonesColumnasTachadas("Si el número de líneas es diferente a “n”:\n"
                    + "a) Seleccionar el valor más pequeño el cual no debe estar cruzado por ninguna línea.\n"
                    + "b) Este valor debe restarse de todos los valores que no están cruzados por ninguna línea.\n", dm);
            for (int renglon = 0; renglon < matriz.length; renglon++) {
                for (int columna = 0; columna < matriz.length; columna++) {
                    if (mapaMatriz.get(renglon + "|" + columna).isCruzado()) {
                        matriz[renglon][columna] = matriz[renglon][columna] + valorPequeño;
                    }
                }
            }
            imprimirRenglonesColumnasTachadas("c) después hay que sumar esta cantidad a todos los valores situados en la intersección de líneas\n", dm);
        }
        contador++;
        builder.append("\n\n======================================Corrida: ").append(contador).append("======================================\n\n");
        //donde los valores cruzados por una linea horizontal o vertical permanecen inalterados 
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
        String simbologia;
        simbologia = mostrarSimbologia ? ("\nDonde:\n"
                + "\n[0] cero seleccionado\n"
                + "*0* cero eliminado\n") : "";
        builder.append(simbologia).append("\n");
        for (int renglon = 0; renglon < matriz.length; renglon++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                if (isMatriz) {
                    builder.append(String.format("%3d   ", matriz[renglon][columna]));
                } else {
                    String valorTemp;
                    DatoMatrizTO dm = mapaMatriz.get(renglon + "|" + columna);
                    if (!dm.isCero()) {
                        builder.append(String.format("%3d   ", matriz[renglon][columna]));
                    } else if (dm.isSeleccionado()) {
                        valorTemp = "[" + dm.getValor() + "]";
                        builder.append("   ").append(valorTemp);
                    } else if (dm.isEliminado()) {
                        valorTemp = "*" + dm.getValor() + "*";
                        builder.append("   ").append(valorTemp);
                    } else {
                        builder.append(String.format("%3d   ", matriz[renglon][columna]));
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
                    builder.append("(").append(letra).append(") Renglón ").append((rt + 1)).append(" (").append(letra).append(")").append("\n");
                }
                builder.append("\n");
                break;
            case "b":
                for (Integer ct : columnasTachadas.keySet()) {
                    builder.append("(").append(letra).append(") Columna ").append((ct + 1)).append(" (").append(letra).append(")").append("\n");
                }
                builder.append("\n");
                break;
            case "c":
                for (Integer rt : renglonesTachados.keySet()) {
                    builder.append("(").append(letra).append(") Renglón ").append((rt + 1)).append(" (").append(letra).append(")").append("\n");
                }
                builder.append("\n");
                break;
            default:
                for (Integer rl : renglonesLinea.keySet()) {
                    builder.append("(").append(letra).append(") Renglón línea ").append((rl + 1)).append(" (").append(letra).append(")").append("\n");
                }
                builder.append("\n");
                for (Integer cl : columnasLinea.keySet()) {
                    builder.append("(").append(letra).append(") Columna línea ").append((cl + 1)).append(" (").append(letra).append(")").append("\n");
                }
                builder.append("\n");
        }
        builder.append("\n");
    }

    private void imprimirRenglonesColumnasTachadas(String comentario, DatoMatrizTO datoMatriz) {
        builder.append(comentario).append("\n");
        String simbologia;
        simbologia = "\nDonde:\n"
                + "\n-#- Número en línea\n"
                + "+#+ Número en cruce\n"
                + ">1< Número menor\n";
        builder.append(simbologia).append("\n");
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
                    builder.append(String.format("%3d   ", matriz[renglon][columna]));
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
                sb.append(String.format("%3d   ", matriz[renglon][columna]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void pintarMatriz() {
        TableCellRenderer renderer = new RenderCelda(mapaMatriz);
        tablaResultado.setDefaultRenderer(Object.class, renderer);
    }

    public String getPasos() {
        return builder.toString();
    }
}
