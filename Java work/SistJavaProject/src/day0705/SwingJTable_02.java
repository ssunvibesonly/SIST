package day0705;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SwingJTable_02 extends JFrame {

	Container cp;
	JTable table; 
	JLabel lblTitle;
	JLabel lblOut;
	
	public SwingJTable_02(String title) {
		
		super(title);
	      cp=this.getContentPane(); //배경색 바꾸려면 cp를 바꿔줘야함
	      this.setBounds(200,100,500,400);
	      cp.setBackground(new Color(255,255,200));
	      setDesign();
	      setVisible(true);
		
	}
	
	public void setDesign() {
		
		String[][]data= {{"김영준","서울","010-222-4444"},
				{"최성현","경기","010-111-2222"},
				{"장미란","인천","010-333-8555"},
				{"박세리","제주","010-456-7777"}};
		String [] title= {"이름","주소","연락처"};
		
		lblTitle=new JLabel("JTable연습",JLabel.CENTER);
		lblOut=new JLabel("결과 출력...",JLabel.CENTER);
		
		table=new JTable(data,title);
		JScrollPane pane=new JScrollPane(table); // 표로 만들때 JScrollPane
		
		//테이블에 마우스 이벤트 추가
		table.addMouseListener(new TableEvent());
		
		this.add("North",lblTitle);
		this.add("Center",pane);
		this.add("South",lblOut);
				
		
	}
	
	//테이블 클릭시 발생하는 마우스 이벤트
	class TableEvent extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			
			//System.out.println("테이블 클릭!!");
			//선택한 행번호 얻기
			int rowNum=table.getSelectedRow();
			
			String str="이름: "+table.getValueAt(rowNum, 0)
						+",주소: "+table.getValueAt(rowNum, 1)
						+",연락처: "+table.getValueAt(rowNum, 2);
			
			lblOut.setText(str);
		}
		
	}
	
	public static void main(String[] args) {
		new SwingJTable_02("");

	}

}
