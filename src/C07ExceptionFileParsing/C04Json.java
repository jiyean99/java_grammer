package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C04Json {
    public static void main(String[] args) throws IOException {
        ///* ************ 외부의 json 파일을 java의 클래스 객체로 변환 - json 파싱(역직렬화) ************ *///
        // 현재 통신개념 선행 전이기 때문에 그냥 박혀있는 파일로 파싱할 예정
        //📍 (1) 문자열 전체를 통째로 read (파일 읽기 방식)
        Path filePath = Paths.get("src/C07ExceptionFileParsing/myjosn1.json");
        String jsonString = Files.readString(filePath);
        System.out.println(jsonString);
        // 이렇게 가져오면 하나하나 다 잘라서 써야함

        //📍 (2) Jackson 라이브러리의 ObjectMapper 클래스를 통한 객체로의 파싱
        // - Jackson 라이브러리는 spring에는 기본 탑재되어있으나 java의 경우 별도로 추가해줘야함
        ObjectMapper o1 = new ObjectMapper();
        //📍 (2-1) map으로 일괄적으로 String, String 파싱하기
        Map<String, String> myMap = o1.readValue(jsonString, Map.class);
        System.out.println(myMap); //{id=1, name=hong1, classNumber=1, city=seoul}
        System.out.println(myMap.get("name")); //hong1
        // 단 map으로 파싱 시 숫자값으로 담아주지 않으므로 map을 사용하지 않을 것(타입을 분기할 수 없음)

        //📍 (2-2) 직접 만든 객체로 파싱하기 - Map
        // 실제 값 세팅은 private로 설계되어 있어 직접 접근이 불가함
        // 이 때 , java의 reflection 기술을 통해 런타임 시점에 private 변수도 직접 접근 가능
        // 단, 필드값을 유추할 수 있도록 반드시 타입이 일치하는 <getter메서드>와 <기본생성자>를 생성해야함.
        // 최종적으로는 파싱을 하고, 객체를 만드는 기술이 집합되어있는 코드임
        // Cannot deserialize value of type `long` from String "abd" -> 역직렬화 에러가 발생하는 모습 확인
        Student myStudent = o1.readValue(jsonString, Student.class);
        System.out.println(myStudent);
        System.out.println(myStudent.getId()); //1
        System.out.println(myStudent.getName()); //hong1

        //📍 (2-3) 직접 만든 객체로 파싱하기 - List 형식으로 주어지는 json 파싱 : 트리 구조의 JSON Node로 변환
        Path listFilePath = Paths.get("src/C07ExceptionFileParsing/myjson2.json");
        String jsonString1 = Files.readString(listFilePath);
        ObjectMapper o2 = new ObjectMapper();
        JsonNode jsonNodes = o2.readTree(jsonString1); // readTree : 끝도없이 이어져있는 json 데이터를 트리구조로 만들어주는 메서드(트리안에 객체들이 담기게 되는 것)
        List<Student> studentList = new ArrayList<>();
        for (JsonNode j : jsonNodes) {
            Student s1 = o2.readValue(j.toString(), Student.class);
            studentList.add(s1);
        }
        System.out.println(studentList);

        // e.g. 티오더 - 메뉴를 여러개 담아서 던질 수도 있음
        // 리스트형식의 데이터는 매우 빈번한 케이스다
        // [{"name":"왕돈까스","price": 10000,"맵기":"보통맛"},{"name":"왕돈까스","price": 10000,"맵기":"보통맛"} ... ]

        ///* ************ 객체에서 json으로 변환 : json 직렬화 ************ *///
        Student s2 = new Student(4, "jiyean", "1", "gyung-gi");
        System.out.println(s2); // 우리가 만든 toString 형식으로 생성한 객체일 뿐 외부 통신용으로 사용 못함. {id=4, name='jiyean', classNumber='1', city='gyung-gi'}
        String result = o2.writeValueAsString(s2);
        System.out.println(result); // {"id":4,"name":"jiyean","classNumber":"1","city":"gyung-gi"}


    }
}

class Student {
    private long id;
    private String name;
    private String classNumber;
    private String city;

    public Student() {

    }

    public Student(long id, String name, String classNumber, String city) {
        this.id = id;
        this.name = name;
        this.classNumber = classNumber;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getCity() {
        return city;
    }


    @Override
    public String toString() {
        return "{" +
                "id==" + id +
                ", name=='" + name + '\'' +
                ", classNumber=='" + classNumber + '\'' +
                ", city=='" + city + '\'' +
                '}';
    }
}
