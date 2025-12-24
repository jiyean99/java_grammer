package C07ExceptionFileParsing;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
// import com.sun.java.accessibility.util.AccessibilityListenerList; // 불필요한 import 제거

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C05HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
        /// * ************ JSON ************ *///
        // JSON은 현대 프로그래밍에서 가장 많이 사용되는 데이터 교환 포맷
        // Map과 유사한 key:value 형식: { "name": "John", "age": 30 }
        // JSON Parsing(역직렬화): JSON 문자열 → Java 객체 변환
        // JSON 직렬화: Java 객체 → JSON 문자열 변환
        // Jackson 라이브러리(ObjectMapper) 사용 (Maven Repository에서 Jackson Databind/Core/Annotations 다운로드)

        // [📝실습문제] 외부에서 json 데이터를 받아, java의 객체로 변환
        // [https://jsonplaceholder.typicode.com/posts](https://jsonplaceholder.typicode.com/posts)
        // 외부 API 요청을 하기 위한 라이브러리 (HttpClient, RestTemplate, RestClient)
        // - API 요청 : 외부에 데이터를 요청하는 행위
        // - HttpClient : Java 내장 클래스
        // - RestTemplate, RestClient : 스프링에서 가장 많이 사용하는 클래스
        // - 사실 보통은 프론트에서 java로 데이터를 요청하는 경우가 많고, java에서 쓰는 경우는 빈번하지 X(구글, 카카오 로그인 등에선 쓰이긴 함)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET().build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        // cf) 왜 String이 아니고 Http 머시기 이런 이상한 객체로 받는가?
        // 사실 요청을 했을 때 응답을 받으면 그 응답은 json이 아니고 문서다.
        // 문서에는 서론부분인 header와 본론부분인 body가 있고, 이 문서 스펙을 "http 문서"라고 함(통신규약=http 프로토콜) -> 웹은 전부 http 문서 포맷으로 되어있음
        // body에 json, xml, text 등의 데이터가 끼워져들어있다, (header에는 메타데이터)
        String data = httpResponse.body(); // 그래서 body에서 꺼내서 쓰면 됨

        // java에서 JSON 파싱: readValue()로 바로 class 변환
        ObjectMapper op = new ObjectMapper();
        Post p1 = op.readValue(data, Post.class);
        System.out.println(p1);
        System.out.println();
        System.out.println("=============== 객체 실습 코드 끝 ===============");
        System.out.println();

        // TODO 리스트형식의 객체로 변환 후 출력 (readTree + JsonNode tree방식)
        HttpClient client2 = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET().build();
        HttpResponse<String> httpResponse2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
        String data2 = httpResponse2.body();
        ObjectMapper op2 = new ObjectMapper();
        JsonNode jsonNodes2 = op2.readTree(data2);
        List<Post> posts = new ArrayList<>();
        for (JsonNode j : jsonNodes2){
            Post p = op2.readValue(j.toString(), Post.class);
            posts.add(p);
        }
        System.out.println(posts);
        System.out.println();
        System.out.println("=============== 리스트 객체 실습 코드 끝 ===============");
        System.out.println();
    }
}

class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long userId, Long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
