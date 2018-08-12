package todaytask_mk1;

import javax.swing.table.DefaultTableModel;

public class Mover_Test_1 {
	DefaultTableModel model = null;
	
	public Mover_Test_1(Object[][] contents, Object[] column) {
		model = new DefaultTableModel(contents, column);
	}
	
}
