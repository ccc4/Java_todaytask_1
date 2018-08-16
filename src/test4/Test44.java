package test4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Test44 extends JFrame{
	// ������Ʈ ����
	JFrame jFrame = new JFrame("Today Task");
	DefaultTableModel model;
	JTable table;
	
	public Test44(){
//		Train t = new Train(); // �ҷ��� train
		
		JPanel titlePanel = new JPanel();
		// title ����
		// Ÿ��Ʋ ��Ʈ ����
//		Font titlefont = new Font(null, Font.BOLD, 20);
		// Ÿ��Ʋ lable ����
		JLabel titlelabel = new JLabel("Today Task");
		// Ÿ��Ʋ lable �� ��Ʈ ���� �Է�
		titlelabel.setFont(new Font(null, Font.BOLD, 20));
		// title panel ���� �� ���� �ֱ�
		titlePanel.add(titlelabel);
		
		
		// ���� �߰��� ���� �ִ� panel
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		// ���̺� �����
		Object[][] contents = null;
		Object[] column = {" "};
		
		//Test44
		this.model = new DefaultTableModel(contents, column); // model �� ���� �ҷ��;���
		
		JTable table = new JTable(model); // �ҷ��� model �� �־ jtable �ϼ�
		
		
		// ���̺� ���� �ɼ� ����
		table.setRowHeight(45);
//		Font tablefont = new Font(null, Font.PLAIN, 15);
		table.setFont(new Font(null, Font.PLAIN, 15));
		
		JScrollPane contentjp = new JScrollPane(table);
		contentPanel.add(contentjp);
		
		
		// ���� �߰� �Է¶� �� ��ư ����
		JPanel inputTextPanel = new JPanel();
		inputTextPanel.setLayout(new BoxLayout(inputTextPanel, BoxLayout.X_AXIS));
		// �ؽ�Ʈ�ʵ� ����
		final JTextField textfield = new JTextField();
		// add ��ư ����
		JButton addBtn = new JButton("+ Add");
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[1];
				inputStr[0] = textfield.getText();
				model.addRow(inputStr);
				
				textfield.setText("");
			}
		});
		// done ��ư ����
		JButton delBtn = new JButton("- Done");
		delBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					return;
				}else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		// inputTextPanel �� �߰�
		inputTextPanel.add(textfield);
		inputTextPanel.add(addBtn);
		inputTextPanel.add(delBtn);
		

		
		// ��ü���� Ʋ
		JPanel articlePanel = new JPanel();
		articlePanel.setLayout(new BoxLayout(articlePanel, BoxLayout.Y_AXIS));
		articlePanel.add(titlePanel);
		articlePanel.add(inputTextPanel);
		articlePanel.add(contentPanel);
		
		
		jFrame.add(articlePanel, BorderLayout.NORTH);
		
		
		
		jFrame.setLocation(100, 100);
		jFrame.setSize(300, 500);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	

	private class Item implements Serializable {
		DefaultTableModel model;
		File file = new File("test4.txt");
		
		
		public Item() throws IOException, ClassNotFoundException {
			if(!file.exists()) {
				file.createNewFile();
			}
			
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			model = (DefaultTableModel) in.readObject();
			System.out.println(model);
		}
		public Item(DefaultTableModel model) {
			this.model = model;
		}

		
	}
	
	
	
	public static void main(String[] args) {
		new Test44();

	}

}