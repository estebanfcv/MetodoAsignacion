package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import to.DatoMatrizTO;

/**
 *
 * @author estebanfcv
 */
public class RenderCelda extends DefaultTableCellRenderer {

    private Map<String, DatoMatrizTO> mapa;

    public RenderCelda() {
    }

    public RenderCelda(Map<String, DatoMatrizTO> mapa) {
        this.mapa = mapa;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        DatoMatrizTO dato = mapa.get(row + "|" + column);
        Integer amount = (Integer) value;
        if (amount == 0 && dato.isMarcado()) {
            cell.setBackground(Color.GREEN);
            cell.setForeground(Color.WHITE);
        } else if (amount == 0 && dato.isTachado()) {
            cell.setBackground(Color.RED);
            cell.setForeground(Color.WHITE);
        } else {
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
        }
        return this;
    }
}
