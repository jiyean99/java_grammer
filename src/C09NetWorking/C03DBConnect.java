package C09NetWorking;

import java.sql.*;

public class C03DBConnect {
    public static void main(String[] args) throws SQLException {
        // MySQL 드라이버 별도 설치 필요
        // - mysql-connector-java.jar 다운로드 후 IntelliJ 라이브러리 추가

        // Java-DB 연결 핵심 기술
        // DB는 문자열로 응답 → Java에서 쉽게 처리하기 위한 기술
        // 1) JDBC (가장 기본, JPA/MyBatis의 근간)
        // 2) MyBatis (SQL 매퍼)
        // 3) JPA (객체-관계 매핑)
        // ※ JPA 사용 시에도 URL에 jdbc 프로토콜 작성

        // MariaDB 서버 연결 설정
        // HTTP가 아닌 DB 직접 연결 → jdbc:mysql:// 또는 jdbc:mariadb://
        // useSSL=false: SSL 보안 비활성화 (개발 환경용)
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false"; // jdbc:mariadb: 패턴 사용 시, MariaDB 최적화 기능 필요
        String userName = "root";
        String password = "test1234";
        Connection myConnection = DriverManager.getConnection(url, userName, password); // checked Exception 터짐
        System.out.println(myConnection);

        // Statement 객체에 쿼리를 담아 DB에 전송(전달)
        Statement st = myConnection.createStatement();
        ResultSet resultSet = st.executeQuery("select * from post");
        // ResultSet 자료구조는 iterator와 유사한 면이 있음(cursor라는 개념이 존재하며, cursor는 next 할 때마다 라인이 내려가고 null이 있으면 순회 종료)
        // next를 통해 데이터를 한 행씩 read (시작은 컬럼에 있음)
        while (resultSet.next()) {
            // 컬럼명 라벨링을 가지고 가져오는 것(split 필요 X) -
            System.out.println("id : " + resultSet.getInt("id"));
            System.out.println("title : " + resultSet.getString("title"));
            System.out.println("contents : " + resultSet.getString("contents"));
            System.out.println("========================");
        }


    }
}
