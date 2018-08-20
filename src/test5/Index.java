package test5;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Index extends JFrame {
	Station station;
	DefaultTableModel model;
	Container contentPane;
	JTable table;
	JTextField textField;
	
	
	public Index() throws ClassNotFoundException, IOException {
		setTitle("Today Task");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		station = new Station();
		
		
		// title
		JLabel titleLabel = new JLabel("Today Task");
		titleLabel.setFont(new Font(null, Font.BOLD, 20));
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		
		
		// contents
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		model = station.getModel();
		table = new JTable(model);
		table.setRowHeight(30);
		table.setFont(new Font(null, Font.PLAIN, 15));
		contentPanel.add(new JScrollPane(table));
				
		
		// functions
		JPanel inputOutputPanel = new JPanel();
		inputOutputPanel.setLayout(new BoxLayout(inputOutputPanel, BoxLayout.X_AXIS));
		// create textField 
//		JTextField textField = new JTextField();
		textField = new JTextField();
		textField.addActionListener(new addBtnListener());
		// create addBtn
		JButton addBtn = new JButton("+ Add");
		addBtn.addActionListener(new addBtnListener());
		// create delBtn
		JButton delBtn = new JButton("- Del");
		delBtn.addActionListener(new delBtnListener());
		
		// inputTextPanel 에 추가
		inputOutputPanel.add(textField);
		inputOutputPanel.add(addBtn);
		inputOutputPanel.add(delBtn);
		
		
		textField.requestFocus();
		add(titlePanel);
		add(inputOutputPanel);
		add(contentPanel);
		
		setSize(300, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Index();
	}
	
	class addBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String text = textField.getText();
				if(text.trim().length() == 0) {
					System.out.println("텍스트를 입력해주세요.");
					return;
				} else {
					station.addContent(text);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("addBtn error");
			}
			
			textField.setText("");
			textField.requestFocus();
//			model = station.getModel(); // 안써도 되네
		}
		
	}
	
	class delBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int getRow = table.getSelectedRow();
			if(getRow == -1) {
				System.out.println("선택된 목록이 없습니다.");
				return;
			} else {
				try {
					station.delContent(table.getSelectedRow());
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("delBtn error");
				}
			}
			
		}
		
	}
	
}
