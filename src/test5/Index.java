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
	Container contentPane;
	DefaultTableModel model;
	JTable table;
	Station station;
	public Index() throws ClassNotFoundException, IOException {
		setTitle("ToDo List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		station = new Station();
		
		
		// title
		JLabel titleLabel = new JLabel("Today Task");
		titleLabel.setFont(new Font(null, Font.BOLD, 20));
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		
		
		// functions
		JPanel inputOutputPanel = new JPanel();
		inputOutputPanel.setLayout(new BoxLayout(inputOutputPanel, BoxLayout.X_AXIS));
		// create textField 
		final JTextField textField = new JTextField();
		// create addBtn
		JButton addBtn = new JButton("+ Add");
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				String inputStr[] = new String[1];
//				inputStr[0] = textField.getText();
//				model.addRow(inputStr);
//				
//				textField.setText("");
			}
		});
		// create delBtn
		JButton delBtn = new JButton("- Del");
		delBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				if(table.getSelectedRow() == -1) {
//					return;
//				}else {
//					model.removeRow(table.getSelectedRow());
//				}
			}
		});
		// inputTextPanel ¿¡ Ãß°¡
		inputOutputPanel.add(textField);
		inputOutputPanel.add(addBtn);
		inputOutputPanel.add(delBtn);
		
		
		// contents
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		this.model = station.getModel();
		JTable table = new JTable(model);
		table.setRowHeight(45);
		table.setFont(new Font(null, Font.PLAIN, 15));
		contentPanel.add(new JScrollPane(table));
		
		
		
		add(titlePanel);
		add(inputOutputPanel);
		add(contentPanel);
		
		
		setLocation(100, 100);
		setSize(300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Index();
	}
}
