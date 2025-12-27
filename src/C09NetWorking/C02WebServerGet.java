package C09NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class C02WebServerGet {
    public static void main(String[] args) throws IOException {
        // [📝실습예제]
        // 요구사항 - socket에서 사용자의 요청에 따른 동적 코딩(분기)
        // 사용자 : 크롬을 통해 http://localhost:8080?id=1 GET 요청(Request)
        // 서버 : "hello world java" + id 문자열 응답(Response)

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");
        while (true){
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //http 문서들이 하나씩 출력되고, 이 때 사용자의 요청정보를 읽을 수 있게 되는것

            String line = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (line != null && !line.isEmpty()){
                // 사용자의 요청정보가 담긴 http문서를 읽는 테스트용 코드
                /*
                System.out.println(line);
                line = br.readLine();
                */

                // GET /?id=1 HTTP/1.1 -> 여기서 id값을 추출하기 위해 먼저 sb에 문서를 담는 코드
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            // id값을 추려내는 과정
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1]; // 여기까지 /?id=1
            String id = "";
            if(infos.contains("?")){
                id = infos.split("=")[1];
            }
            System.out.println(id);

            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java " + id;
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();

        }

    }
}
