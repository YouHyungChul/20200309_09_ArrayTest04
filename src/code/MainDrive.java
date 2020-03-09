package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
		int[] userLottoArr = new int[6];
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0 ; i < userLottoArr.length ; i++) {
			
			while (true) {
				System.out.print((i+1) + "번째 숫자 입력 : ");
				int tempInput = scan.nextInt();
				
				boolean isRangeOk = false;
				
				if (1 <= tempInput && tempInput <= 45) {
					isRangeOk = true;
				}
				else {
					isRangeOk = false;
					System.out.println("1~45의 숫자만 입력 가능합니다.");
				}
				
				boolean isDuplOk = true;
				
				for (int num : userLottoArr) {
					
					if (num == tempInput) {
						isDuplOk = false;
						System.out.println("이미 입력한 숫자입니다.");
						break;
						
					}
					
				}
				
				if (isRangeOk && isDuplOk) {
 					userLottoArr[i] = tempInput;
					break;
				}
			}
			
		}
		
		for (int i=0 ; i < userLottoArr.length ; i++) {
			
			for (int j=0 ; j < userLottoArr.length-1 ; j++) {
				
				if (userLottoArr[j] > userLottoArr[j+1]) {
					
					int backUp = userLottoArr[j];
					userLottoArr[j] = userLottoArr[j+1];
					userLottoArr[j+1] = backUp;
				}
			}
		}
		
		for (int num : userLottoArr) {
			System.out.println(num);
		}
		
//		내가 입력한번호가 몇등인지 비교.
		
//		이번주 당첨번호를 배열로. 5, 18, 20, 23, 30, 34
		
		int[] thisWeekLotto = {5, 18, 20, 23, 30, 34};
//		보너스번호는 21이다. 변수 저장
		int bonusNum = 21;
		
//		몇등인지 판단.
//		1등? 내가 입력한 숫자와 / 당첨번호의 숫자중 같은 갯수가 6개면.
//		2등? 차후에
//		3등? 같은 갯수가 5개면.
//		4등? 4개
//		5등? 3개
//		그 이하면? 꽝
		
//		몇개를 맞췄는지 저장할 변수.
		int correctCount = 0;
		
//		내 로또 번호를 하나씩 꺼내보는 for
		for (int i=0 ; i < userLottoArr.length ; i++) {
			
//			당첨번호 하나씩 꺼내보는 for
			for (int j=0 ; j < thisWeekLotto.length ; j++) {
				
//				내 번호 / 당첨번호 비교. 같은가? 
				if (userLottoArr[i] == thisWeekLotto[j]) {
//					같다면? "맞춘 갯수"가 하나 증가.
					correctCount++;
				}
				
			}
			
			
		}
		
		
		if (correctCount == 6) {
			System.out.println("1등!");
		}
		else if (correctCount == 5) {
			
//			내가 보너스 번호를 맞췄는가? 맞추면 2등 아니면 3등.
//			맞췄는가?  true / false => boolean변수로 결과 저장
			boolean isCorrectBonus = false;
			
//			보너스번호를 맞춘다 => 보너스번호가 내가입력한 배열안에 들어있는가?
//			같은 값이 하나라도 있는가?
			
			for (int i=0; i < userLottoArr.length ; i++) {
//				내 입력번호와, 보너스번호가 같다면
				if (userLottoArr[i] == bonusNum) {
					
					isCorrectBonus = true;
				}
			}
			
//			무조건 3등 출력 => 보너스번호 여부에 따라 2등, 3등 구별 출력.
			if (isCorrectBonus) {
				System.out.println("2등!");
			}
			else {
				System.out.println("3등!");				
			}
			
		}
		else if (correctCount == 4) {
			System.out.println("4등!");
		}
		else if (correctCount == 3) {
			System.out.println("5등!");
		}
		else {
			System.out.println("꽝 ㅜㅠ");
		}
		
		
		
		
	}
	
}








