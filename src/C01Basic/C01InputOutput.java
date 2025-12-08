package C01Basic;

import java.io.*;
import java.util.*;

public class C01InputOutput {
    public static void main(String[] args) throws IOException {
//        // 출력 : System.out을 통해 콘솔 출력(*콘솔: 터미널)
//        System.out.println(20); // 1️⃣ println은 줄바꿈 있는 출력, 2️⃣ 입출력은 모두 문자열로 진행
//        System.out.print("hello world 1"); // print는 줄바꿈이 없는 출력
//        System.out.print("hello world 2");

//        // 입력1️⃣ : Scanner 클래스 - 입력을 위한 클래스로서 바이트 단위 입력 처리
//        // System.in : 키보드 입력 의미 (입력방식 : 키보드, file 읽기 등)
//        // Scanner 객체변수명 = new Scanner(System.in); // Scanner 클래스를 이용하여 나만의 객체를 생성
//        Scanner myScanner = new Scanner(System.in);
//        String input = myScanner.nextLine(); // 입력받은 데이터를 한줄로 읽어서, String으로 return
//        System.out.println("사용자 입력사항 : " + input);

//        // [📝실습문제] 아래와 같이 입력값이 주어졌을 때 처리 방법 - scanner 버전
//        /*
//            abc
//            bcd
//            2
//            3
//        */

//        Scanner myScanner = new Scanner(System.in);
//        String input1 = myScanner.nextLine();
//        String input2 = myScanner.nextLine();
//        int input3 = Integer.parseInt(myScanner.nextLine()); // 입력받은 문자열을 직접 형변환 하는 방식(추천)
//        int input4 = myScanner.nextInt();

//        System.out.println("입력사항1: " + input1);
//        System.out.println("입력사항2: " + input2);
//        System.out.println("입력사항3: " + input3);
//        System.out.println("입력사항4: " + input4);

//        // 입력️️2️⃣ : BufferedReader
//        // 1️⃣ 버퍼를 활용하여 더 좋은 성능 발휘 2️⃣ InputStreamReader는 바이트 대신 문자 단위로 입력받음
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input2 = br.readLine(); // 입력받은 데이터를 한줄 씩 read
//        System.out.println(input2);
//        br.close(); // close()는 메모리 회수, 외부 입출력장치와 연계된 코드이므로 gc(가비지컬렉터)의 대상이 아님

//        // [📝실습문제] 아래와 같이 입력값이 주어졌을 때 처리 방법 - BufferedReader 버전
//        // 입력값 : abc bcd efg
//        // 1️⃣ 배열로 만들어서 출력
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        String[] arr = input.split(" ");
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//        br.close();

        // 2️⃣ : BufferedReader + StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // StringTokenizer를 통해 공백을 기준으로 문자열을 하나씩 잘라 내부에 토큰화
        StringTokenizer st = new StringTokenizer(input);
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        br.close();
    }
}
