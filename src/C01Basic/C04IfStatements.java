package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C04IfStatements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        /* ************ if문 ************ */
//        // 도어락키 예제
//        // 요구사항 : answer = '1234';이며,
//        // 입력받은값과 비밀번호가 일치하면 "문이 열렸습니다", 일치하지 않으면 "비밀번호가 틀렸습니다"를 출력하도록 작성해라
//        String answer = "1234";
//        String answerInput = br.readLine();
//        if (answerInput.equals(answer)) {
//            System.out.println("문이 열렸습니다.");
//        } else {
//            System.out.println("비밀번호가 틀렸습니다.");
//        }
//
//        // 교통카드 예제
//        // 요구사항: 사용자가 가지고있는 돈을 int로 입력받은 후,
//        // 10000원 이상일 시 "택시를 타시오", 10000원 미만 3000원 이상이면 "버스를 타시오", 3000원 이상이면 "걸어가시오"출력
//        System.out.println("현재 가지고 있는 돈은 얼마인가요?");
//        int cardInput = Integer.parseInt(br.readLine());
//
//        // if, else if 구문에서 조건식은 택1. 즉, 한 조건에 해당하면 실행 후 구문밖으로 빠져나감.
//        if (cardInput >= 10000) {
//            System.out.println("택시를 타시오.");
//        } else if (cardInput >= 3000) {
//            System.out.println("버스를 타시오.");
//        } else {
//            System.out.println("걸어가시오.");
//        }

//        // if문을 독립적으로 관리하고 싶은 경우, 정확한 범위지정을 통해 모든 if문이 중복되어 실행되지 않도록 해야함
//        if (cardInput >= 10000) {
//            System.out.println("택시를 타시오.");
//        }
//        if (cardInput >= 3000 && cardInput < 10000) {
//            System.out.println("버스를 타시오.");
//        }
//        if(cardInput < 3000) {
//            System.out.println("걸어가시오.");
//        }

//        /* ************ 삼항연산자 : 결과값 = 조건식?반환값1:반환값2 ************ */
//        // 도어락키 예제(삼항연산자)
//        String answer = "1234";
//        String answerInput = br.readLine();
//        String result = answerInput.equals(answer) ? "문이 열렸습니다." : "비밀번호가 틀렸습니다.";
//        System.out.println(result);

        /* ************ switch문 : if, else if 등 여러 조건식이 있을 때 조건식을 가독성 있게 표현한 구문 ************ */
        // 고객센터 예제
        // callNumInput과 case는 equal 관계이고, 구문마다 반드시 break를 넣어줘야 함.
        // default는 그 외의 의미로서 else와 같은 의미
        int callNumInput = Integer.parseInt(br.readLine());
        switch (callNumInput){
            case 1:
                System.out.println("대출 업무 입니다.");
                break;
            case 2:
                System.out.println("예금 업무 입니다.");
                break;
            case 3:
                System.out.println("적금 업무 입니다.");
                break;
            default:
                System.out.println("번호를 잘못 입력하셨습니다.");
                break;
        }
    }
}
