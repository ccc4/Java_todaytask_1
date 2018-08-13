package test1;

//import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.DefaultTableModel;

public class T1 {
	public static void main(String[] args) {
		
		Object header[] = {" "};
		Object contents[][] = null;
		DefaultTableModel model = new DefaultTableModel(contents, header);
		
		String[] inputStr = new String[1];
		
		inputStr[0] = "Hello";
//		model.addRow(inputStr);
		LinkedList<String> a = new LinkedList<>();
		a.add(inputStr[0]);
		
//		System.out.println(a.get(0));
		inputStr[0] = "Hes";
//		model.addRow(inputStr);
		a.add(inputStr[0]);
		inputStr[0] = "Hsdf";
//		model.addRow(inputStr);
		a.add(inputStr[0]);
		
		inputStr[0] = a.get(1);
		model.addRow(inputStr);
		System.out.println(model.getValueAt(0, 0));
		
		
		
		for(int i=0;i<3;i++) {
//			System.out.println(model.getValueAt(i, 0));
			System.out.println(a.get(i));
			
		}
//		for(int i=0;i<3;i++) {
//			
//			
//		}
		
		
	}
}
