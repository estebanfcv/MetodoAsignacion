package to;

/**
 *
 * @author estebanfcv
 */
public class DatoMatrizTO {
    
    // sera un to que incluya el valor, isCero, marcado, tachado, intercectado
    
    private int valor;
    private int renglon;
    private int columna;
    private boolean cero;
    private boolean marcado;
    private boolean interceptado;
    private boolean tachado;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isCero() {
        return cero;
    }

    public void setCero(boolean cero) {
        this.cero = cero;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public boolean isInterceptado() {
        return interceptado;
    }

    public void setInterceptado(boolean interceptado) {
        this.interceptado = interceptado;
    }

    public boolean isTachado() {
        return tachado;
    }

    public void setTachado(boolean tachado) {
        this.tachado = tachado;
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
