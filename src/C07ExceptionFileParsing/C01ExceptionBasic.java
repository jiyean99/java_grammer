package C07ExceptionFileParsing;

import java.util.Scanner;

public class C01ExceptionBasic {
    public static void main(String[] args) {
        /// * ************ 예외처리 개요 ************ *///
        // - 에러 = 시스템 에러
        //    - 주로, 스택오버플로우 또는 물리적 부족 같은 시스템 장애
        //    - java.lang.Error에서 에러사항 정의
        //    - 일반적으로 에러를 대비한 코드를 작성하지는 않음
        // - 예외 = 코드상의 에러
        //    - 주로 애플리케이션의 로직에서 발생할 수 있는 오류
        //    - 잘못된 사용자 입력, 네트워크 문제, 파일 읽기 오류 등
        //    - Checked Exception와 Unchecked Exception로 구분

        /// * ************ 예외처리 정의 및 목적, 기본 문법 ************ *///
        // - 예외처리란 발생할 수 있는 오류와 상황을 미리 예측하여 예외 발생시에 적절한 처리를 해주는 작업
        // - 예외처리 목적:
        //   1) 사용자에게 적절한 에러 메시지 전달(가장중요) - USER에게 화면, 개발자간 상태코드+message 전달 ⭐
        //   2) logging, debugging 목적(로그를 잘 뒤져서 디버깅)
        //   3) 프로그램 강제종료 방지(오히려 일부러 발생시키는게 더 중요)
        // - 기본 문법 : try / catch / finally 문
        //    - try
        //        - 실행되는 코드
        //    - catch
        //        - try 블록에서 발생한 예외의 처리를 담당 (예상되는 예외 클래스를 분기)
        //    - finally
        //        - try 블록에서 예외가 발생여부와 상관없이 무조건 실행

        /// * ************ 예외처리를 하지 않은 원본 ************ *///
//        System.out.println("나눗셈 프로그램입니다.");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("분자를 입력해주세요.");
//        int head = Integer.parseInt(sc.nextLine());
//        System.out.println("분모를 입력해주세요.");
//        int tail = Integer.parseInt(sc.nextLine());
//        int result = head / tail;
//        System.out.println("두 수를 나눈 값은 = " + result);
        // 위 코드에서 분모에 0이 들어오면 에러가 발생한다. -> ArithmeticException: / by zero(*result구문에서 발생한 에러로, 꼬리표처럼 달고다니게 됨)
        // 문제점 : 1.에러발생 후 코드 실행 중단 / 2.사용자에게 메시지 X / 3.자세한 로그X


        /// * ************ 예외처리 실행 ************ *///
        // 예외처리 기본 : 예외가 발생할 것으로 예상되는 코드를 try로 감싼다.
        // 예외처리 목적:
        // 1) 사용자에게 적절한 에러 메시지 전달(가장중요) - http프로토콜을 이해하면 더 이해가 쉬울 것
        // 2) 예외 발생 시 디버깅을 위한 로그 기록
        // 3) (프로그램 강제종료 막기)
        // Exception:
        // - 모든 예외 클래스의 조상 클래스
        // - 구체적인 예외 클래스가 catch부에 있다면 해당 부분으로 우선 분기처리된다.

        System.out.println("나눗셈 프로그램입니다.");
        Scanner sc = new Scanner(System.in);
        System.out.println("분자를 입력해주세요.");
        try {
            int head = Integer.parseInt(sc.nextLine());
            System.out.println("분모를 입력해주세요.");
            int tail = Integer.parseInt(sc.nextLine());
            int result = head / tail;
            System.out.println("두 수를 나눈 값은 = " + result);
        } catch (ArithmeticException error) { // catch를 통해 예상되는 예외 클래스를 분기처리한다.
            // 1. 사용자에게 메시지 전달(가정)
            System.out.println("0으로 나누면 안됩니다.");
            // 2. 시스템에 디버깅을 위한 로그 자세히 기록
            error.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("문자를 입력하면 안됩니다.");
            e.printStackTrace();
        } catch (Exception e) { // Exception: 모든 에러 클래스의 조상, 이 때 항상 구체적인 에러가 먼저 잡히게 됨
            System.out.println("예상치 못한 에러가 발생했습니다.");
            e.printStackTrace();
        } finally {
            System.out.println("예외가 발생하든 발생하지 않든 무조건 실행되는 구문");
        }

        // 예외처리를 하지 않을 경우 프로그램은 강제종료되고, 예외처리를 할 경우 프로그램은 예외가 발생하더라도 지속됨
        System.out.println("예외발생 후 예외처리 진행 되었다면 실행되는 코드 테스트");

    }
}
