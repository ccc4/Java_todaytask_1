package test3;

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

public class Home3 extends JFrame{
	
	public Home3() throws Exception {
		
		// ���� �ҷ����°�
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		Object header[] = {" "};
		Object contents[][] = null;
		DefaultTableModel model = new DefaultTableModel(contents, header);
		
		
		JTable jTable = new JTable(model);
		jTable.setRowHeight(45);
		jTable.setFont(new Font(null, Font.ITALIC, 15));
		JScrollPane sp = new JScrollPane(jTable);
		contentPanel.add(sp);
		
		
		
		
		
		
		
		// ��ư���� Ʋ ����
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		// input,btn2 ����
		JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		JButton deleteBtn = new JButton("Delete");
		
		
		// ��ġ
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		
		
		
		
		// 2 ūƲ. ���� ������ ǰ������
		JPanel articlePanel = new JPanel();
//		Container c = getContentPane();
		articlePanel.setLayout(new BoxLayout(articlePanel, BoxLayout.Y_AXIS));
		articlePanel.add(inputPanel);
		articlePanel.add(contentPanel);
		
		// 1 ūƲ. ���ξ�ƼŬ�� �����ִ´�.
		add(articlePanel, BorderLayout.NORTH);
		
		// 0 �⺻Ʋ. �ʱ⼳��
		setTitle("ToDo List");
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		new Home3();
	}
}
