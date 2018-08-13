package todaytask_mk1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TodayTask extends JFrame{
	// 컴포넌트 생성
	JFrame jFrame = new JFrame("Today Task");
	
	
	public TodayTask(){
		
		JPanel titlePanel = new JPanel();
		// title 설정
		// 타이틀 폰트 설정
//		Font titlefont = new Font(null, Font.BOLD, 20);
		// 타이틀 lable 생성
		JLabel titlelabel = new JLabel("Today Task");
		// 타이틀 lable 에 폰트 설정 입력
		titlelabel.setFont(new Font(null, Font.BOLD, 20));
		// title panel 생성 및 글자 넣기
		titlePanel.add(titlelabel);
		
		
		// 할일 추가한 내용 넣는 panel
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		// 테이블 만들기
		Object[][] contents = null;
		Object[] column = {" "};
		DefaultTableModel model = new DefaultTableModel(contents, column);
		JTable table = new JTable(model);
		// 테이블 세부 옵션 조정
		table.setRowHeight(45);
//		Font tablefont = new Font(null, Font.PLAIN, 15);
		table.setFont(new Font(null, Font.PLAIN, 15));
		
		JScrollPane contentjp = new JScrollPane(table);
		contentPanel.add(contentjp);
		
		
		// 할일 추가 입력란 및 버튼 생성
		JPanel inputTextPanel = new JPanel();
		inputTextPanel.setLayout(new BoxLayout(inputTextPanel, BoxLayout.X_AXIS));
		// 텍스트필드 생성
		final JTextField textfield = new JTextField();
		// add 버튼 생성
		JButton addBtn = new JButton("+ Add");
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[1];
				inputStr[0] = textfield.getText();
				model.addRow(inputStr);
				
				textfield.setText("");
			}
		});
		// done 버튼 생성
		JButton deleteBtn = new JButton("- Done");
		deleteBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					return;
				}else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		// inputTextPanel 에 추가
		inputTextPanel.add(textfield);
		inputTextPanel.add(addBtn);
		inputTextPanel.add(deleteBtn);
		

		
		// 전체적인 틀
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
	
	
	
	public static void main(String[] args) {
		new TodayTask();

	}

}