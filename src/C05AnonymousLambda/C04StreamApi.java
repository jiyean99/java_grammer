package C05AnonymousLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C04StreamApi {
    public static void main(String[] args) throws IOException {
        // 전통적인 방식의 데이터 접근 방법 : 메모리 주소로 접근
        // 해당 방식(원본에 접근하지 말자)을 지양하자는 트렌드가 생겨남 -> 함수형 프로그래밍
        int[] arr = {20, 10, 4, 12};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("전통적방식(" + i + ") : " + arr[i]);
        }
        // 향상된 for문 역시 원본에 접근하는것이 아닌 사본에 접근하는 방식임
        /*
        for (int a : arr){
            System.out.println(a);
        }
        */

        System.out.println("=============================== stream API Part ===============================");

        /// * ************ 함수형 프로그래밍 방식 ************ *///
        // - 설명 : 데이터와 객체 중심이 아닌, 입력에 따른 출력만 존재하는 코딩 스타일
        //   * 입력: 원본에서 꺼내는 행위
        //   * 출력: 물리적 출력 + 연산 행위 모두 포함
        // - Stream API: Java 함수형 프로그래밍 지원 라이브러리
        //   * forEach: 스트림 요소 하나씩 소모하며 동작 수행
        //   * Arrays.stream(arr): 원본 → 사본 생성
        //   * 람다표현식(화살표함수) 사용
        // - 핵심: 입력(원본꺼내기) → 출력(연산/출력) 사상만 존재
        //   * 원본 보존, 순수 함수형 처리
        Arrays.stream(arr).forEach(a -> System.out.println(a));

        /// * ************ 주요 메서드 (생성 -> 중개연산 -> 소모연산)************ *///
        //📍 .stream() : 스트림의 생성
        // ex) List 자료의 스트림 생성
        List<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("c++");
        Stream<String> stream1 = myList.stream();
        // ex) String 배열 자료의 스트림 생성
        String[] strArr = {"java", "python", "c++"};
        Stream<String> stream2 = Arrays.stream(strArr);
        // ex) int 배열 자료의 스트림 생성
        // 원시자료형을 위한 Stream 객체가 별도로 존재
        int[] intArr = {10, 10, 20, 30, 40, 50};
        IntStream stream3 = Arrays.stream(intArr);

        //📍 stream의 중개 연산(변환) : filter, map, sorted, distinct, mapToInt
        // - filter : 특정 기준으로 대상을 필터링하여 새로운 스트림을 반환하는 중개연산
        IntStream filterStream = Arrays.stream(intArr).filter(a -> a >= 30); // 30이상의 원본들을 필터링
        // - map : 기존의 스트림을 조작하여 새로운 스트림을 반환
        IntStream mapStream = Arrays.stream(intArr).map(a -> a * a); // 제곱으로 만듦
        // - distinct : 중복제거
        IntStream distinctStream = Arrays.stream(intArr).distinct();
        // - sorted : 정렬
        IntStream sortedStream = Arrays.stream(intArr).sorted();
        // - mapToInt : IntStream 형태로 변환해주는 map
        Stream<String> stringStream = Arrays.stream(strArr);
        IntStream mapToIntStream = stringStream.mapToInt(a -> a.length());
        // cf) 문자열 조작은 가능하다
        Stream<String> stringMapStream = Arrays.stream(strArr).map(a -> a + " hello");
        System.out.println("test === " + Arrays.toString(stringMapStream.toArray()));


        //📍 stream의 소모 : forEach(출력), sum(합계), count, max, min, reduce(누적연산), findFirst(스트림의 첫번째 값 리턴)
        // - sum : 스트림의 요소를 하나씩 소모하여 총합을 구하는 메서드
        int filterSum = filterStream.sum();
        System.out.println("30이상 필터링 후 sum : " + filterSum);
        int mapSum = mapStream.sum();
        System.out.println("제곱으로 조작 후 sum : " + mapSum);
        int distinctSum = distinctStream.sum();
        System.out.println("중복 제거 후 sum : " + distinctSum);
        // - toArray : 배열로 만들어주는 메서드
        int[] sortedArr = sortedStream.toArray();
        System.out.println("정렬 후 배열화 : " + Arrays.toString(sortedArr));
        int mapToIntSum = mapToIntStream.sum();
        System.out.println("Stream string 타입 int로 변환 후 sum : " + mapToIntSum);
        // - forEach : 출력
        Arrays.stream(intArr).forEach(a -> System.out.println("forEach : " + a));
        // - count : 보통 필터링하고 count 하는 경우가 많음(length만으로도 가능하기 때문에)
        long count = Arrays.stream(intArr).count();
        System.out.println("count : " + count);
        // - min/max : 최대/최소
        //📍 optional 객체 : 값이 있을수도 있고, 없을수도 있음을 명시한 객체
        int max = Arrays.stream(intArr).max().getAsInt();
        int min = Arrays.stream(intArr).min().getAsInt();
        System.out.println("max : " + max + ", min : " + min);
        // - reduce: 누적연산 -> reduce(초기값, 연산식)
        int reduceSum = Arrays.stream(intArr).reduce(0, (a, b) -> a + b);
        System.out.println("초기값 0, a+b 누적합 : " + reduceSum);
        int reduceMuliply = Arrays.stream(intArr).reduce(1, (a, b) -> a * b);
        System.out.println("초기값 1, a*b 누적곱 : " + reduceMuliply);
        String strSum = Arrays.stream(strArr).reduce("", (a, b) -> a + b); // 그냥 stringBuilder 쓰셈
        System.out.println("문자열 누적합 : " + strSum);
        // - findFirst : 첫번째 요소 반환
        String firstStr = Arrays.stream(strArr).filter(a -> a.length() >= 5).findFirst().get();
        System.out.println("길이 5자 이상의 데이터 필터링 후 첫번째 요소 반환 : " + firstStr);

        // cf) map에서의 활용 예제
        Map<String, Integer> myMap = new TreeMap<>();
        myMap.put("hello", 10);
        myMap.put("java", 20);
        String firstKeyValue = myMap.keySet().stream().findFirst().get();
        System.out.println("TreeMap에서 첫번째 key값 출력 : " + firstKeyValue);

        //📍 배열로 변환 시 주의사항(제네릭 타입 소거)
        // - 제네릭의 타입 소거: 자바 런타임 시점에 <String> 등 제네릭 타입이 제거되는 현상
        // - toArray() 호출 시 타입 정보 손실 → Object[] 반환 (컴파일 에러)

        // 예시: 5글자 이상의 값만 필터링해서 String 배열로 변환
        String[] stArr = {"hello", "java", "world"};

        // 컴파일 에러 발생
        // Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray()
        // → Stream<String> → Object[] 반환 (제네릭 소거로 타입 불명확)

        // 왜 int[]에서는 에러가 안 날까?
        // - int[] → Arrays.stream() → IntStream 반환 (원시타입 특화 스트림)
        // - IntStream.toArray() → int[] 직접 반환 (타입 보존)

        // String 경우
        // Stream<String> → 제네릭 소거 → Object[] 반환

        // 해결법
        // String[] answer = Arrays.stream(stArr)
        //     .filter(a -> a.length() >= 5)
        //     .toArray(String[]::new);  // 생성자 참조로 타입 명시

        String[] answer = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(a -> new String[a]); // a 안에는 배열의 길이가 담김
        String[] answer2 = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(String[]::new); // new는 생성자를 호출하는 키워드므로 메서드명이 됨
        System.out.println("string의 필터링 후 배열 변환 : " + Arrays.toString(answer));

        //📍 메소드 참조 : 매개변수를 제거한 형식
        // - 형식 : 클래스명::메서드명
        // - 조건 : 하나의 메서드(실행문)만을 호출하는 경우 사용 가능
        Arrays.stream(stArr).forEach(a -> System.out.println(a)); // 메서드명: println, 클래스명: System.out
        Arrays.stream(stArr).forEach(System.out::println);


        // [📝실습예제]
        // 요구사항 : (1) ~ (3)
        int[] arrEle = {1, 2, 3, 4, 5, 6};

        // (1) arr에서 홀수만 담은 배열을 생성 후 배열 출력
        int[] oddArr = Arrays.stream(arrEle).filter(a -> a % 2 != 0).toArray();
        System.out.println(Arrays.toString(oddArr));

        // (2) arr에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열 출력
        int[] oddSquareArr = Arrays.stream(arrEle).filter(a -> a % 2 != 0).map(a -> a * a).toArray();
        System.out.println(Arrays.toString(oddSquareArr));

        // (3) arr에서 홀수만 걸러 제곱값을 구하고, 해당 숫자값을 오름차순한 순서로 배열 출력
        int[] oddMultiSortArr = Arrays.stream(arrEle).filter(a -> a % 2 != 0).map(a -> a * a).sorted().toArray();
        System.out.println(Arrays.toString(oddMultiSortArr));

        // [📝실습예제]
        // 요구사항 : Student 객체에의 아래 조건으로 출력 (1)~(3)
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("kim", 20));
        studentsList.add(new Student("choi", 30));
        studentsList.add(new Student("lee", 35));
        studentsList.add(new Student("park", 22));

        // (1) 모든 객체의 평균나이(average 함수)
        double avgAge = studentsList.stream().mapToInt(a -> a.getAge()).average().getAsDouble();
        System.out.println(avgAge);

        // (2) 정렬을 통해 가장 나이가 어린 사람 찾기(sorted + findFirst)
        Student mostYoungUser = studentsList.stream().sorted((Comparator<Student>) (o1, o2) -> o1.getAge() - o2.getAge()).findFirst().get();
        System.out.println(mostYoungUser);

        // (3) 30대인 사람들의 이름만 모아 새로운 String 배열에 담기(filter + map)
        String[] age30UserList = studentsList.stream().filter(a -> a.getAge() >= 30).map(a -> a.getName()).toArray(a -> new String[a]);
        System.out.println(Arrays.toString(age30UserList));


        System.out.println("=============================== Optional Part ===============================");

        /// * ************ Optional 객체 ************ *///
        // - 특정 객체에 값이 없을지도 모른다는 것을 명시적으로 표현한 객체 (값이 없다 = null)
        // - java의 고질적인 문제 중 null처리가 힘들다는 문제가 있음
        // - 참조자료형의 변수만 담을 수 있음
        // - 기본 자료형의 경우 OptionalInt, OptionalDouble 등으로 선언
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String st1 = br.readLine();
        /*
        if (st1 == null) {
            System.out.println("값이 없습니다.");
        } else {
            System.out.println(st1.length());
        }
        */
        /*
        Optional<String> opt1 = Optional.ofNullable(st1); // opt1은 값이 있을수도 있고, 없을수도 있다고 명시적으로 알려준것
        if (opt1.isPresent()) {
            System.out.println("Optional을 통한 null 확인 : " + opt1.get().length());
        } else {
            System.out.println("Optional을 통한 null 확인 : 값이 없습니다.");
        }
        */

        /// * ************ Optional 객체 생성 방법(3가지) ************ *///
        // - empty : 비어있는 optional 객체 생성
        // - ofNullable : 값이 있거나 비어있는 optional 객체 생성
        // - of : 값이 있는 optional 객체 생성
        Optional<String> opt1 = Optional.empty(); // get하면 에러 발생
        Optional<String> opt2_1 = Optional.ofNullable(null); // get하면 에러 발생
        Optional<String> opt2_2 = Optional.ofNullable("hello"); // get하면 string이 꺼내짐
        Optional<String> opt3 = Optional.of("hello"); // get하면 에러 발생


        /// * ************ Optional 객체 처리 방법(4가지) ************ *///
        // - isPresent : 값이 있으면 get하여 return. 정석사용.
        // - orElse : 값이 있으면 있는 값 return, 없으면 지정한 값 return.
        // - orElseGet : 값이 있으면 있는 값 return, 없으면 람다함수 실행.
        // - orElseThrow : 값이 있으면 있는 값 return, 없으면 지정한 예외(에러) 강제 발생. 가장 많이 사용.

        // isPresent
        if (opt1.isPresent()) {
            System.out.println("opt1의 isPresent를 통한 처리 : " + opt1.get());
        } else {
            //System.out.println("isPresent를 통한 처리 : " + opt1.get()); // 에러(예외) 발생 NoSuchElementException
            System.out.println("값이 없습니다.");
        }

        // orElse
        System.out.println(opt2_1.orElse("값이 없습니다."));
        System.out.println(opt2_2.orElse("값이 없습니다."));

        // orElseGet
        System.out.println(opt2_1.orElseGet(() -> new String("값이 없습니다.")));

        // orElseThrow
        //System.out.println(opt2_1.get()); // NoSuchElementException: No value present 발생, 해당 에러는 의도치 않은 에러(지양해야할 에러)
        //System.out.println(opt2_1.orElseThrow(() -> new RuntimeException("값이 없습니다."))); // RuntimeException: 값이 없습니다.
        System.out.println(opt2_2.orElseThrow(() -> new RuntimeException("값이 없습니다.")));

        // 의문점
        // - 에러나면 안되지 않냐? 왜 에러를 터트려?
        //  의도된 코드 중단이 필요하기 때문에
        // - 어짜피 에러라면 뭐하러 에러를 직접 지정해서 터트리냐?(에러의 의도성)
        //  사용자에게 적절한 문구와 적절한 예외를 터트리기 위해서

        //  웹 개발에서 값을 입력하는 사용자에게 적절한 메세지를 전달 목적과 의도된 코드 중단을 목표로 강제로 예외(에러) 발생시키는 경우는 매우 일반적이다.

        // [📝실습예제]
        // 요구사항 : 평균 나이 구하기(위에 정의한 studentsList 확인)
        // optional 객체 처리방법(1)
        OptionalDouble optionalAvg = studentsList.stream().mapToInt(a -> a.getAge()).average();
        double value1 = 0;
        if (optionalAvg.isPresent()) {
            value1 = optionalAvg.getAsDouble();
            System.out.println(value1);
        } else {
            System.out.println("값이 없습니다.");
        }
        // optional 객체 처리방법(2) - 더 많이 쓰는 방식
        double value2 = studentsList.stream().mapToInt(a -> a.getAge()).average().orElseThrow(() -> new NoSuchElementException("값이 없습니다."));
        System.out.println(value2);

        // [📝실습예제]
        // 사용자에게 input을 받아(동적) 상세 조회
        System.out.println("조회하고자 하는 student의 index 번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        /* 잘못된 방식
        Student s1 = studentsList.get(num); // 예외처리가 없다면 IndexOutOfBoundsException 에러 발생 위험O
        System.out.println(s1);
        */
        /*
        Student s1 = null;
        if (studentsList.size() <= num || num < 0) {
            System.out.println("잘못 입력하셨습니다.");
        } else {
            s1 = studentsList.get(num);
        }
        System.out.println("이름은 " + s1.getName() + ", 나이는 " + s1.getAge()); // NullPointerException 에러 발생
        */
        Optional<Student> s1;
        if (studentsList.size() <= num || num < 0) {
            s1 = Optional.empty();
        } else {
            s1 = Optional.of(studentsList.get(num));
        }
        System.out.println(s1.orElseThrow(() -> new NoSuchElementException("없는 회원입니다.")));

    }
}

