package day0704;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

///오류떴음 확인하기
public class SwingEvent_07 extends JFrame {

	Container cp;
	JButton btn1,btn2;
	
	public SwingEvent_07(String title) {
		super(title);
	      cp=this.getContentPane(); //배경색 바꾸려면 cp를 바꿔줘야함
	      this.setBounds(200,100,300,400);
	      cp.setBackground(new Color(225,225,200));
	      setDesign();
	      setVisible(true);

	}
	public void setDesign() {
		
		this.setLayout(new FlowLayout());
		
		//버튼1 생성,이벤트
		btn1=new JButton("배경색을 핫핑크로 변경");
		this.add(btn1);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setBackground(Color.magenta);
				
			}
		});
		
	
		
		//버튼2 생성,이벤트
		btn2=new JButton("배경색을 토마토색으로 변경");
		this.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setBackground(Color.orange);
				
			}

		
	});
	}
	public static void main(String[] args) {
		new SwingEvent_07("스윙이벤트_7");
	}

}
