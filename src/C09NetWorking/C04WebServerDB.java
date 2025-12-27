package C09NetWorking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class C04WebServerDB {
    public static void main(String[] args) throws IOException, SQLException {
        // [📝실습예제]
        // 요구사항 - 사용자에게 id값을 받아 db 조회 수행
        // 사용자 : 크롬을 통해 http://localhost:8080?id=1 GET 요청(Request)
        // 서버 : DB에서 조회한 결과값을 문자열 형식으로 응답
        //  1) 구조화되지 않은 일반 문자열로 return
        //  2) JSON 형태로 return - 객체 생성(writeValueAsString 메서드 사용)

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ///* ************ DB 연결 세팅 ************ *///
            String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
            String userName = "root";
            String password = "test1234";
            Connection myConnection = DriverManager.getConnection(url, userName, password); // checked Exception 터짐
            Statement st = myConnection.createStatement();


            String line = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (line != null && !line.isEmpty()) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1];
            String id = "";
            if (infos.contains("?")) {
                id = infos.split("=")[1];
            }

            ///* ************ DB 요청 받기 ************ *///
            ResultSet resultSet = st.executeQuery("select * from post where id=" + "\'" + id + "\'");

            // 코드 개선을 위해 주석처리
            //String response = "HTTP/1.1 200 OK\r\n\r\n";

            Post post = null; // 옵셔널 객체로 만드는것이 더 적절함
            while (resultSet.next()) {
                ///* ************ 터미널 내 확인 ************ *///
                System.out.println("id : " + resultSet.getInt("id"));
                System.out.println("title : " + resultSet.getString("title"));
                System.out.println("contents : " + resultSet.getString("contents"));
                System.out.println("========================");

                ///* ************ 사용자에게 응답(DB) ************ *///
                // 코드 개선을 위해 주석처리
                /*
                response += ("id :" + resultSet.getInt("id"));
                response += ("\ntitle :" + resultSet.getString("title"));
                response += ("\ncontents :" + resultSet.getString("contents"));
                // 위 형식으로 제공(직렬화)이 되면 구조화되어있지 않기 때문에 FE에서 작업이 매우 힘듦 -> JSON 형식으로 구조화가 필요함 (파싱할 때도 마찬가지임)
                */

                ///* ************ JSON 형식으로 직렬화 ************ *///
                post = new Post(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getString("contents"));
            }

            ///* ************ DB 데이터 객체에 담기 ************ *///
            // 코드 개선을 위해 코드 작성 위치 변경(Headers의 Content-Type 설정 추가)
            // - application/json :
            // - charset=UTF-8 :
            ObjectMapper om = new ObjectMapper();
            String jsonPost = om.writeValueAsString(post);
            String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: application/json; charset=UTF-8\r\n\r\n" + jsonPost; // 응답을 주는 부분은 Controller에서 수행하고, null일 시에는 예외처리를 해아하므로 계층분리에 대한 이해와 함께 생각해야함

            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();

        }

    }
}

class Post {
    private long id;
    private String title;
    private String contents;

    // 기본생성자
    public Post(long id) {
    }

    // 생성자 오버라이딩
    public Post(long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}