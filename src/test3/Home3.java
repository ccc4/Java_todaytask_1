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
		
		// 내용 불러오는곳
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
		
		
		
		
		
		
		
		// 버튼넣을 틀 제작
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		// input,btn2 제작
		JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		JButton deleteBtn = new JButton("Delete");
		
		
		// 설치
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		
		
		
		
		// 2 큰틀. 여러 컨텐츠 품고있음
		JPanel articlePanel = new JPanel();
//		Container c = getContentPane();
		articlePanel.setLayout(new BoxLayout(articlePanel, BoxLayout.Y_AXIS));
		articlePanel.add(inputPanel);
		articlePanel.add(contentPanel);
		
		// 1 큰틀. 메인아티클을 갖고있는다.
		add(articlePanel, BorderLayout.NORTH);
		
		// 0 기본틀. 초기설정
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
