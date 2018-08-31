package test6;

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


public class MainFrame extends JFrame {
	Container contentPane;
	JTable table;
	JTextField textField;
	
	Station station;
	DefaultTableModel model;
	
	public MainFrame() {
		super("Today Task");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		
		
		// title
		JLabel titleLabel = new JLabel("Today Task");
		titleLabel.setFont(new Font(null, Font.BOLD, 20));
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		
		
		// contents
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		Object[][] contents = null;
		Object[] column = {"번호", "할 일"};
		model = new DefaultTableModel(contents, column) { // 셀 더블클릭 수정불가 오버라이딩
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.setRowHeight(30);
		table.setFont(new Font(null, Font.PLAIN, 15));
		table.getColumn("번호").setPreferredWidth(10);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
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
		this.add(titlePanel);
		this.add(inputOutputPanel);
		this.add(contentPanel);
		
		station = new Station();
		getList();
		
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new MainFrame();
	}
	
	private void getList() {
		model.setNumRows(0);
		String[] input = new String[2];
		for(int i=0;i<station.items.size();i++) {
			input[0] = String.valueOf(i+1);
			input[1] = station.items.get(i);
			model.addRow(input);
		}
	}
	
	class addBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String item = textField.getText().trim();
			textField.setText("");
			if(item.length() == 0) return;
			station.addItem(item);
			getList();
		}

	}

	class delBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
	
}
