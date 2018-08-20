package test5;

import java.io.Serializable;

import javax.swing.table.DefaultTableModel;

public class Item implements Serializable {
	private DefaultTableModel model;

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	public Item() {
		Object[][] columnNames = null;
		Object[] rowCount = {" "};
		this.model = new DefaultTableModel(columnNames, rowCount);
	}
}
