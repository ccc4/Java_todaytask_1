package test1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Home {

	public Home() throws Exception {
		JFrame jFrame = new JFrame("Test");
		
		
		
		// ��ư���� Ʋ ����
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		// input,btn2 ����
		JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getText = textField.getText();
				SaveClass savec = null;
				try {
					savec = new SaveClass();
				} catch (ClassNotFoundException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					savec.saver(getText);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textField.setText("");
				textField.requestFocus();
				
			}
		});
		JButton deleteBtn = new JButton("Delete");
		// ��ġ
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		// ���� �ҷ����°�
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		Object header[] = {" "};
		Object contents[][] = null;
		DefaultTableModel model = new DefaultTableModel(contents, header);
//		LinkedList<String> loader = saveClass.loader();
//		for(int i=0;i<loader.size();i++) {
//			
//		}
		
		JTable jTable = new JTable(model);
		JScrollPane sp = new JScrollPane(jTable);
		contentPanel.add(sp);
		
		
		
		
		// 2 ūƲ. ���� ������ ǰ������
		JPanel articlePanel = new JPanel();
		articlePanel.setLayout(new BoxLayout(articlePanel, BoxLayout.Y_AXIS));
		articlePanel.add(inputPanel);
		articlePanel.add(contentPanel);
		
		// 1 ūƲ. ���ξ�ƼŬ�� �����ִ´�.
		jFrame.add(articlePanel, BorderLayout.NORTH);
		
		// 0 �⺻Ʋ. �ʱ⼳��
		jFrame.setLocation(100, 100);
		jFrame.setSize(300, 300);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Home();
	}
}
