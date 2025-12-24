package C07ExceptionFileParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class C03File {
    public static void main(String[] args) throws IOException {
        /// * ************ 파일 입출력 - Stream ************ *///
        // 스트림(stream)이란 실제의 입력이나 출력이 표현된 데이터의 이상화된 흐름을 의미
        // 스트림은 운영체제에 의해 생성되는 가상의 연결 고리를 의미하며, 시스템간 데이터 전송에 있어 중간 매개자 역할

        /// * ************ 키보드를 통한 입출력 ************ *///
        // InputStreamReader는 문자체계를 받겠다, System.in는 키보드를 통해 받겠다 라는 뜻
        // BufferedReader의 역할은 키보드에 입력하면 하나하나 전달하기에 성능이 떨어지기 때문에 모아주는 역할
        // 버퍼클래스의 역할: 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        /// * ************ 파일 입출력(1) : IO 패키지 ************ *///
        // java 스트림의 종류
        // byte기반 스트림: 바이너리 파일, 이미지, 오디오 파일 등의 바이트 데이터를 처리
        // character기반 스트림: 텍스트 파일과 같은 문자열 데이터를 처리 (FileReader, FileWriter)
        // IO패키지: Blocking방식 (thread는 데이터를 읽을 때까지 blocked), buffer사용하려면 별도의 BufferedReader 사용
        BufferedReader br2 = new BufferedReader(new FileReader("src/C07ExceptionFileParsing/test.txt"));
        String line = br2.readLine();
        while (line != null) {
            System.out.println(line);
            line = br2.readLine();
        }

        /// * ************ 파일 입출력(2) : NIO 패키지 ************ *///
        // NIO(New Input Output): NonBlocking방식 (동시작업 가능), 버퍼기반이 기본
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test.txt");
        // readString : 문자열 전체를 통째로 read
        String st1 = Files.readString(filePath);
        System.out.println(st1);

        // readAllLines : 문자열을 라인별로 split 하여 list 형태로 저장
        List<String> strList = Files.readAllLines(filePath);
        System.out.println(strList);

        // 파일에 문자열 쓰기
        Path filePath1 = Paths.get("src/C07ExceptionFileParsing/test.txt");
//        Files.write(filePath1, "홍길동0".getBytes(), StandardOpenOption.CREATE_NEW); // 새로 만들기
//        Files.write(filePath1, "홍길동1\n홍길동2".getBytes(), StandardOpenOption.WRITE); // 덮어쓰기
        Files.write(filePath1, "\n홍길동3".getBytes(), StandardOpenOption.APPEND); // 추가모드

        // IO와 NIO의 성능/특성 비교
        // IO: 스레드 블로킹(스레드 세이프)
        // NIO: 스레드 논블로킹(동시작업 가능)
        // 작업 성능을 높이기 위한 키워드: 블로킹, 논블로킹, 동기, 비동기 등
    }
}
