package day0630;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon_07 extends JFrame {//J프레임에 있는 스윙메서드를 모두 상속받는다.
	
	public SwingGibon_07(String title) {
		super(title);
		
		//시작위치, 너비, 높이
		this.setBounds(500, 100, 500, 500);
		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배경색 -> 컨테이너가 위에 씌여져 있으므로 컨텐트팬을 불러와서 색칠해줘야한다.
		//this.setBackground(Color.magenta);
		//this.setBackground(new Color(190,242,200));
		this.getContentPane().setBackground(Color.pink);;//제이프레임 안에 있는 컨테이너를 가져와야 배경색이 변한다
		
		
		//프레임 보이게
		this.setVisible(true);
		
		
	}

	public static void main(String[] args) {

		new SwingGibon_07("스윙기본");
		
	}

}
