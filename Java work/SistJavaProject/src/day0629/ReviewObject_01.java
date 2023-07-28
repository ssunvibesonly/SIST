package day0629;

class MyTv{
	
	private String channel;//채널
	private String volume;//볼륨
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	

}

//////////////////////////////////
public class ReviewObject_01 {
	
	public static void main(String[] args) {
		
		System.out.println("**TV 시청 목록**");
		//클래스가 기존에 있으면 생성자만 호출 없으면 클래스 생성-> 생성자 호출 ex.배열
		MyTv tv1=new MyTv();
		tv1.setChannel("ebs");
		tv1.setVolume("15");
		System.out.println(tv1.getChannel()+"채널을 시청합니다.");
		System.out.println(tv1.getVolume()+"데시벨 입니다.");
		
		System.out.println("---------------------------------");
		
		MyTv tv2=new MyTv();
		tv2.setChannel("tvn");
		tv2.setVolume("22");
		System.out.println("채널"+tv2.getChannel());
		System.out.println("볼륨"+tv2.getVolume());
		
		System.out.println("---------------------------------");
		
		MyTv [] tv3=new MyTv[2];// MyTv[]까지가 설계도 이름, 배열에 대한 이름 할당
		
		for(int i=0;i<tv3.length;i++) {
			tv3[i]=new MyTv();
			
		}
		
		tv3[0].setChannel("KBS");
		tv3[0].setVolume("5");
		tv3[1].setChannel("SBS");
		tv3[1].setVolume("30");
		
		for(int i=0;i<tv3.length;i++) {
			System.out.println("채널:"+tv3[i].getChannel()+" 볼륨: "+tv3[i].getVolume());
		
			
		
			
		
		
		
		

	}

	}}
