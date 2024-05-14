package contact.main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import contact.lib.DBConnection;
import contact.lib.ConService;
import contact.lib.ConVO;

public class Main {
	public static void main(String[] args) {
		int num = 0;
		boolean go = true;
		
		Scanner scan = new Scanner(System.in);
		ConService conService = new ConService();
		
		while(go) {
			System.out.println("---------------------------------------------------");
			System.out.println("                     연락처 관리");
			System.out.println("---------------------------------------------------");
			System.out.println("1. 조회	2. 삽입	3. 수정	4. 삭제	5. 관계 추가   6. 종료");
			System.out.print("메뉴를 입력하세요 : ");
			num = scan.nextInt();
			switch(num) {
			case 1:
				conService.select();
				continue;
			case 2:
				conService.insert();
				System.out.println("추가 완료");
				continue;
			case 3:
				conService.update();
				System.out.println("수정 완료");
				continue;
			case 4:
				conService.delete();
				System.out.println("삭제 완료");
				continue;
			case 5:
				conService.addRelation();
				System.out.println("관계 추가 완료");
				continue;
			case 6:
				conService.end();
				System.out.println("프로그램 종료");
				go=false;
			}
		}
	}
}
