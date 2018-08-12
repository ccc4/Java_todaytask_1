package test1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	JFrame jFrame = new JFrame("Test");
	public Main() {
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		
		// input,btn2 제작
		final JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String getText = textField.getText();
				try {
					new saveClass(getText);
					textField.setText("");
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		JButton deleteBtn = new JButton("Delete");
		// 설치
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		// 2 큰틀. 여러 컨텐츠 품고있음
		JPanel articlePanel = new JPanel();
		articlePanel.setLayout(new BoxLayout(articlePanel, BoxLayout.Y_AXIS));
		articlePanel.add(inputPanel);
		
		
		// 1 큰틀. 메인아티클을 갖고있는다.
		jFrame.add(articlePanel, BorderLayout.NORTH);
		
		jFrame.setLocation(100, 100);
		jFrame.setSize(300, 300);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
