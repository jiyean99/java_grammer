package C02MethodClass;

import java.util.Scanner;

public class C02MethodPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        if(isPrime(input)){
            System.out.println("입력하신 숫자는 소수입니다.");
        } else {
            System.out.println("입력하신 숫자는 소수가 아닙니다.");
        }
    }
    // 소수 판별기 메서드(isPrime) 생성
    // 요구사항 : 접근 제어자(public), 클래스메서드, 반환타입 boolean, 입력값 int
    public static boolean isPrime(int num){
        if (num <= 1){
            // 메서드에서 return을 만나면 메서드는 즉시 종료된다(강제종료)
            return false;
        }
        for (int i = 2; i*i <= num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // void의 경우 본래 return이 없는 메서드인데, return을 넣을 수 도 있음 -> 메서드 강제 종료를 목적으로 사용
    public static void voidMethod(){
        if (true){
            // void 메서드에서 return은 메서드 강제 종료 목적으로 사용됨
            return;
        }
        System.out.println("hello world");
    }
}