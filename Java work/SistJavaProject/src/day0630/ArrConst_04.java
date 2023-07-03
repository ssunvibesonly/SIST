package day0630;

abstract class Game{ ///에러남 이유 찾아보기
	
	abstract void play();
	abstract void stop();
}



/////////////////////////////////
class SungHyun extends Game{

	@Override
	void play() {
		System.out.println("성현이가 게임을 합니다.");
		
	}

	@Override
	void stop() {
		System.out.println("성현이가 게임을 종료합니다.");
		
	}
	
	
}
////////////////////////////////
class SoonYeong extends Game{

	@Override
	void play() {
		System.out.println("순영이가 게임을 합니다.");
		
	}

	@Override
	void stop() {
		System.out.println("순영이가 게임을 종료합니다.");
		
	}
	
	
}
/////////////////////////////////
class SunBum extends Game{

	@Override
	void play() {
		System.out.println("선범이가 게임을 합니다.");
		
	}

	@Override
	void stop() {
		System.out.println("선범이가 게임을 종료합니다.");
		
	}
	
	
}
////////////////////////////////////
public class ArrConst_04 {

	public static void main(String[] args) {

		//배열 선언
		Game[] game=new Game[3];
		
		//각각의 sub로 생성
		game[0]=new SungHyun();
		game[1]=new SoonYeong();
		game[2]=new SunBum();
		
		//for(증가)
		for(int i=0;i<game.length;i++)
		{	game[i].play();
		
		
		}
		//for(감소)
		for(int i=game.length-1;i>=0;i--)
		{
			game[i].stop();
		}
		
			

	}

}