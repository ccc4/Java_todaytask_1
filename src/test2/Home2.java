package test2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Home2 extends JFrame{
	T2_Class t2c;
	
	public Home2(T2_Class t2c) throws Exception {
		this.t2c = t2c;
		
		// 내용 불러오는곳
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		Object header[] = {" "};
		Object contents[][] = null;
		DefaultTableModel model = new DefaultTableModel(contents, header);
		
		LinkedList<String> loader = t2c.load();
		if(loader != null) {
			String[] inputStr = new String[1];
			for(int i=0;i<loader.size();i++) {
				inputStr[0] = loader.get(i);
//			System.out.println(inputStr[0]);
				model.addRow(inputStr);
			}
		}
		
		JTable jTable = new JTable(model);
		jTable.setRowHeight(45);
		jTable.setFont(new Font(null, Font.ITALIC, 15));
		JScrollPane sp = new JScrollPane(jTable);
		contentPanel.add(sp);
		
		
		
		
		
		
		
		// 버튼넣을 틀 제작
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		// input,btn2 제작
		JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String getText = textField.getText();
				t2c.input(getText);
				
				
				textField.setText("");
				textField.requestFocus();
				
			}
		});
		JButton deleteBtn = new JButton("Delete");
		
		
		// 설치
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		
		
		
		
		// 2 큰틀. 여러 컨텐츠 품고있음
//		JPanel articlePanel = new JPanel();
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.add(inputPanel);
		c.add(contentPanel);
		
		// 1 큰틀. 메인아티클을 갖고있는다.
		add(c, BorderLayout.NORTH);
		
		// 0 기본틀. 초기설정
		setTitle("ToDo List");
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws Exception {
		T2_Class t2c = new T2_Class();
		Loader loader = new Loader(t2c);
		Saver saver = new Saver(t2c);
		loader.start();
		saver.start();
		
		new Home2(t2c);
	}
}
