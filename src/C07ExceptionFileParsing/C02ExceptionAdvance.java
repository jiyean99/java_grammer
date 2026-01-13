package C07ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class C02ExceptionAdvance {
    public static void main(String[] args) {
        /// * ************ 회원가입 시뮬레이션 ************ *///
        // 의도된 예외 강제 발생⭐ : 특정 시점에 프로그램을 강제 중지시키기 위한 목적
        Scanner sc = new Scanner(System.in);
        System.out.println("이메일을 입력해주세요.");
        String email = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요.");
        String password = sc.nextLine();
        try {
            register(email, password);
        } catch (IllegalArgumentException e) {
            System.out.println("회원가입 도중 에러가 발생하였습니다.");
            System.out.println(e.getMessage());
            return; // main 메서드 전체를 종료하여 이후 코드 실행 방지
        }

        /// * ************ checked Exception의 처리 방법 ************ *///
        // 방법(1). throws를 통해 checked 예외처리를 위임받고, main에서도 throws(시스템에 위임하여 예외처리를 하지 않는 것)
        /*
        // main메서드 부분에 throws IOException 작성
        String text1 = fileRead("src/C07ExceptionFileParsing/test.txt");
        System.out.println(text1);
        */

        // 방법(2). throws를 통해 checked 예외처리를 위임받고, 호출하는 쪽에서 예외 처리
        /*
        try {
            String text2 = fileRead("src/C07ExceptionFileParsing/test.txt");
            System.out.println(text2);
        } catch (IOException e) {
            // 사용자에게 메세지 전달(가정)
            System.out.println("파일 처리 과정에서 에러가 발생하였습니다.");
            e.printStackTrace();
        }
        */

        // 방법(3). checked예외를 try/catch한 후 unchecked 예외 강제 발생(DB롤백 목적)⭐
        try {
            String text2 = fileRead("src/C07ExceptionFileParsing/test.txt");
            System.out.println(text2);
        } catch (RuntimeException e) {
            System.out.println("파일 처리 과정에서 에러가 발생하였습니다.");
            e.printStackTrace();
        }
    }

    /// * ************ throw, throws ************ *///
    // - throw new
    //    - 개발자가 명시적으로 예외를 발생시키는 데 사용
    //    - 특정 조건(if문 내부 등)에서 사용되어 코드 실행을 명시적으로 중지
    //    - 사용이유: 트랜잭션 롤백, 사용자에게 명확한 메시지 전달, 상태코드 전달
    //    - 예시)
    //      if (stockQuantity < 0) {
    //        throw new IllegalArgumentException("재고가 부족합니다.");
    //      }
    //    - 예외클래스("문구")의 문구는 logging, debugging, REST API에서 중요

    // - throws
    //    - 메서드 선언부에 위치하여 발생할 수 있는 예외를 명시
    //    - 예외처리를 호출하는 측에 위임(checked exception은 필수)
    //    - 예시)
    //      public void setUserAge(int age) throws IllegalArgumentException {}

    /// * ************ 주요 예외사항 ************ *///
    // - Exception: 모든 예외의 조상 클래스⭐ (java.lang.Exception)
    // - Checked Exception (외부시스템 인터랙션, 예외처리/throws 강제)
    //   - FileNotFoundException(파일 처리), IOException(입출력 등 네트워크 통신), SQLException(DB 처리)
    //   - Spring에서 rollback 안됨 → try/catch 후 "RuntimeException" 발생 필요(모든 Unchecked Exception의 조상⭐)
    // - Unchecked Exception (RuntimeException의 하위, 대부분의 예외)
    //   - ArithmeticException(0으로 나누기)
    //   - NullPointerException(null 객체 접근)
    //   - IndexOutOfBoundsException(배열 인덱스 오류)
    //   - IllegalArgumentException(부적합 인자)
    //   - NumberFormatException(문자→숫자 변환 실패)
    //   - NoSuchElementException(요소 없음, Spring EntityNotFoundException)

    static boolean register(String email, String password) {
        boolean check = false;
        if (password.length() >= 10) {
            check = true;
        } else {
            // 예외를 강제 발생시킴으로써 해당 시점에서 메서드 강제 종료
            // 예외는 기본적으로 메서드를 호출한쪽으로 전파 -> 코드실행 중단, DB 저장 방지
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
        System.out.println("DB에 저장되는 코드(가정)");
        return check;
    }

/*
    // TODO 방법 1,2 사용 코드
    static String fileRead(String path) throws IOException {
        Path filePath = Paths.get(path);
        String text = Files.readString(filePath);
        return text;
    }
*/

    static String fileRead(String path) {
        Path filePath = Paths.get(path);
        String text = null;
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e); // checked→unchecked 변환 (DB 롤백 목적)
        }
        return text;
    }

    // 실전 패턴: Service에서 예외 발생 → Controller에서 try/catch로 사용자 메시지 출력
}
