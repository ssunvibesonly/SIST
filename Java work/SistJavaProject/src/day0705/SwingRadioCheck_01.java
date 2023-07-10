package day0705;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SwingRadioCheck_01 extends JFrame implements ActionListener{

	Container cp;
	JRadioButton [] rb=new JRadioButton[5]; //하나만 선택하고 싶을 때
	JCheckBox[] cb=new JCheckBox[5];
	JLabel lblMessage; //라디오버튼, 체크박스 결과값 출력할 곳
	JPanel pTop,pBottom;//라디오버튼, 체크박스 올릴 패널
	Color[] colors= {Color.red,Color.pink,Color.blue,Color.green,Color.yellow};
	
	public SwingRadioCheck_01(String title) {
		super(title);
	      cp=this.getContentPane(); //배경색 바꾸려면 cp를 바꿔줘야함
	      this.setBounds(200,100,500,400);
	      cp.setBackground(new Color(255,255,200));
	      setDesign();
	      setVisible(true);
	}
	
	public void setDesign() {
		//상단 패널에 보더로 감싼 5개의 radio버튼 만들기
		String [] str1= {"빨강","핑크","파랑","초록","노랑"};
		pTop=new JPanel();
		pTop.setBorder(new TitledBorder("글자색"));
		this.add("North",pTop);
		
		
		//라디오버튼 하나만 선택되도록 그룹을 지어줌
		ButtonGroup bg=new ButtonGroup();
		
		for(int i=0;i<rb.length;i++) {
			
			rb[i]=new JRadioButton(str1[i],i==2?true:false);//라디오버튼 생성
			rb[i].addActionListener(this); //라디오 버튼의 액션 추가
			pTop.add(rb[i]);//5개의 버튼을 탑패널에 추가
			bg.add(rb[i]); //버튼그룹에 추가
			
		}
		
		ImageIcon icon=new ImageIcon("C:\\sist0615\\Swing image\\09.png");
		lblMessage=new JLabel("Have a Nice Day!!!",icon,JLabel.CENTER);
		lblMessage.setHorizontalTextPosition(JLabel.LEFT);
		lblMessage.setBorder(new LineBorder(Color.gray,2));//라인 굵기
		this.add("Center",lblMessage);
		
		
		//하단 패널에 보더로 감싼 4개의 checkbox 버튼 만들기
		pBottom=new JPanel();
		pBottom.setBorder(new TitledBorder("가능 언어"));
		this.add("South",pBottom);
		
		String [] str2={"JAVA","ORACLE","HTML","JSP"};
		
		for(int i=0;i<cb.length-1;i++) {
			cb[i]=new JCheckBox(str2[i],i==2?true:false);
			cb[i].addActionListener(this); 
			pBottom.add(cb[i]);
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		//라디오버튼 호출처리, 메세지를 컬러별로 출력
		for(int i=0;i<rb.length;i++) {
			if(ob==rb[i]) {
				
				lblMessage.setForeground(colors[i]);
				lblMessage.setFont(new Font("", Font.BOLD, 20));
				
			}
		}
		//체크박스 호출처리.. 선택한 체크를 라벨 메세지별 출력
		String lang="나의 가능 언어는 ";
		
		for(int i=0;i<cb.length-1;i++){
			if(cb[i].isSelected()){ //boolean으로 값을 반환해줘야 함
				lang+=cb[i].getText()+" ";
				
			}

			{
	
		}
		lblMessage.setText(lang);	
		
		//클래스 타입비교
		if(ob instanceof JCheckBox)
			lblMessage.setText(lang);
		else if(ob instanceof JRadioButton)
			lblMessage.setText("Have a Nice Day!!!");
		
			
		}
	}
	
	
	public static void main(String[] args) {
		new SwingRadioCheck_01("라디오 체크 연습");

	}



}
