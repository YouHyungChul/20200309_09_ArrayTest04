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
		
		
	}
	
}








