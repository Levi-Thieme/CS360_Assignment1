package views;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.teamdev.jxmaps.Marker;

public class CollectionSiteRenderer extends JLabel implements ListCellRenderer<Marker>{
	
	public CollectionSiteRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Marker> list, Marker value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		setText(value.getTitle());
		
		if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
		
		return this;
	}

}
