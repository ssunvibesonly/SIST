package day0704;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingRandom_11 extends JFrame implements ActionListener {

	Container cp;
	JLabel[] lblName=new JLabel[9]; //3행 3열 이므로
	String[] str= {"블루베리","수박","요거트","메론","물","딸기","바나나","사과","코코넛"}; //내가 먹고싶은거
	JButton btn;
	
	public SwingRandom_11(String title) {
		super(title);
	      cp=this.getContentPane(); //배경색 바꾸려면 cp를 바꿔줘야함
	      this.setBounds(200,100,500,550);
	      cp.setBackground(new Color(255,255,200));
	      setDesign();
	      setVisible(true);
	}
	public void setDesign() {
		
		//패널을 프레임의 센터에 추가
		JPanel pCenter=new JPanel(new GridLayout(3,3));
		this.add(pCenter,BorderLayout.CENTER);
		
		//라벨을 패널에 추가
		for(int i=0;i<lblName.length;i++) {
			lblName[i]=new JLabel(str[i],JLabel.CENTER);
			
			int r=(int)(Math.random()*256); //0~255
			int g=(int)(Math.random()*256); //0~255
			int b=(int)(Math.random()*256); //0~255
			
			lblName[i].setBackground(new Color(r,g,b));
			
			//panel에 라벨 추가
			pCenter.add(lblName[i]);
			lblName[i].setOpaque(true); //투명도 
		}
		
		//버튼
		btn=new JButton("라벨색상변경");
		this.add(btn, BorderLayout.SOUTH);
		btn.addActionListener(this);
		
		
		
	}

	public static void main(String[] args) {
		new SwingRandom_11("랜덤색상 구하기");
	
	}
	//액션
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();

		for(int i=0;i<lblName.length;i++) {
			
			int r=(int)(Math.random()*256); //0~255
			int g=(int)(Math.random()*256); //0~255
			int b=(int)(Math.random()*256); //0~255
			
			lblName[i].setBackground(new Color(r,g,b));
		}
		
	}

}
