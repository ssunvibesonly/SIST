package day0630;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingLay_09 extends JFrame implements ActionListener {

	Container cp;
	JButton btn1,btn2,btn3;

	
	public SwingLay_09(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200, 100, 300, 400);
		cp.setBackground(new Color(255,255,200));
		setDesign();
		setVisible(true);
	}
	//디자인
	public void setDesign() {
		
		//기본레이아웃 변경
		this.setLayout(new FlowLayout());
		//버튼
		btn1=new JButton("버튼 #1");
		btn2=new JButton("버튼 #2");
		btn3=new JButton("버튼 #3");
		
		//프레임에 추가
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
		//버튼속성
		btn1.setBackground(Color.pink);
		btn2.setBackground(Color.lightGray);
		btn3.setBackground(Color.ORANGE);

		//버튼에 이벤트 발생
		//이벤트 핸들러랑 이벤트 발생객체 연결
		btn1.addActionListener(this); //상속받았으니까 this
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	
	}
	
	//액션
	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob=e.getSource();//getSource() object형태이기 때문에 Object 변수=변수.getSource();
		
		//메세지를 다이얼로그 형태로 보여주기
		
		//JOptionPane.showMessageDialog(this, "버튼클릭");
		
		if(ob==btn1)
			JOptionPane.showMessageDialog(this, "첫번째 버튼클릭");
		else if(ob==btn2)
			JOptionPane.showMessageDialog(this, "두번째 버튼클릭");
		else if(ob==btn3) //명확하게 객체를 주기위해 else로 안끝내고 else if 했다
			JOptionPane.showMessageDialog(this, "세번째 버튼클릭");
		
	}
	
	
	public static void main(String[] args) {
		
		new SwingLay_09("레이아웃 이벤트");
	}
	
	

}
