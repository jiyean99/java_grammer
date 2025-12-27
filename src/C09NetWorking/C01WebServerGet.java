package C09NetWorking;

import javax.naming.ldap.SortKey;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {
        // [📝실습예제]
        // 요구사항
        // 사용자 : 크롬을 통해 http://서버url GET 요청(Request) - http 요청 문서 조립 필요(이 때 GET요청은 body 내용이 없음)
        // 서버 : "hello world java" 문자열 응답(Response) - http 응답 문서 조립 필요
        // cf) POST 요청 예시 : 회원가입 등(사용자의 요청문서에도 body 내용이 있고 사용자의 입력(이름, 이메일, PW 등)을 받아야 함 - Post man 툴을 통해서도 가능함)

        //📍 HTTP 문서 구조 (Request/Response 공통)
        // 1. Start Line (필수) : HTTP/1.1 200 OK
        //       - HTTP/1.1: 프로토콜 버전
        //       - 200: 성공 상태코드
        //       - OK: 상태코드 설명 (인간 읽기용)
        // 2. Header (선택) : Content-Type, Content-Length 등
        // 3. Empty Line (\r\n) : Header와 Body 구분
        // 4. Body (GET은 빈칸) : 응답 데이터

        //📍 포트 : 프로그램을 구분짓는 단위
        // - PC의 위치를 구분짓는 단위는 IP(주소)이고, 그 IP 내에 프로그램을 구분짓는 개념이 포트
        //📍 소켓(socket) : 서버와 사용자가 통신을 하기위한 네트워크 통신의 끝점을 나타내는 개념
        // - ServerSocket: 클라이언트 연결 대기용 서버 소켓 (가상 개념)
        ServerSocket serverSocket = new ServerSocket(8080); // 시스템과의 통신 -> 예외가 예상되는 작업(throws 필요)
        System.out.println("서버 시작");
        while (true){
            //📍 accept(): 클라이언트 연결 수락 대기
            // - 브라우저 접속 시 실행 → socket에 클라이언트 IP/요청 데이터 저장
            // - 이 때 소켓 객체에는 사용자가 보내온 http 요청 문서 및 사용자 정보(IP 등)가 있음
            Socket socket = serverSocket.accept();

            // localhost(127.0.0.1) : 나의 IP를 지칭, IP주소를 DNS에 등록하여야하나 내 IP의 경우 localhost로 호출 가능
            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java";

            //📍 getOutputStream().write(): 클라이언트로 바이트(서버의 응답 메시지) 전송
            //📍 String → byte[] 변환 (UTF-8 문자 인코딩)
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8)); // 사용자 정보 기반으로 응답을 주며 이 때 문자열을 바이트로 변환(문자체계도 넣어줌-UTF 8)

            // flush : 일반적으로 변경사항을 확정(버퍼 강제 전송)
            socket.getOutputStream().flush();

            // close : 메모리의 낭비를 막기위함(소켓 닫기-메모리 정리)
            socket.close();

        }

    }
}
