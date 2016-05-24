package to;

/**
 *
 * @author estebanfcv
 */
public class DatoMatrizTO {
    
    private double valor;
    private int renglon;
    private int columna;
    private boolean cero;
    private boolean seleccionado;
    private boolean cruzado;
    private boolean eliminado;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isCero() {
        return cero;
    }

    public void setCero(boolean cero) {
        this.cero = cero;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }


    public boolean isCruzado() {
        return cruzado;
    }

    public void setCruzado(boolean cruzado) {
        this.cruzado = cruzado;
    }


    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
    
}
