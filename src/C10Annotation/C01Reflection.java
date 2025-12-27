package C10Annotation;

import java.lang.reflect.Field;
import java.nio.file.Files;

// Annotation이 Reflection하는 대표적인 기술임
public class C01Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ///* ************ Reflection 리플렉션 ************ *///
        // Java 프로그램이 런타임에 클래스, 메서드, 필드 등의 정보를 검사하고 수정할 수 있도록 하는 기능
        // 주요 기능:
        // 1) 클래스 정보를 런타임에 얻을 수 있음 (클래스의 이름, 메서드, 필드 등)
        // 2) 런타임에 메서드를 호출할 수 있음
        // 3) 런타임에 필드에 접근하고 수정할 수 있음
        // 4) 런타임에 객체를 생성할 수 있음
        // 아래의 예시는 실전성은 아예 없음(추후 스프링에서 객체 자동생성 활용). 그냥 리플랙션의 개념만 알고있으면 됨


        Person p1 = new Person();
        System.out.println(p1); // 당연히 깡통임(초기값만 세팅되어있음) {name='null', age=0}

        // 아래와 같은 방식을 통해 private 변수(name변수 등)에 직접 접근
        Field nameField = Person.class.getDeclaredField("name");
        Field ageField = Person.class.getDeclaredField("age");
        nameField.setAccessible(true); // private이라 할 지라도 접근 가능하도록 세팅 변경 가능
        ageField.setAccessible(true);
        nameField.set(p1, "jiyean");
        ageField.set(p1, 27);
        System.out.println(p1); // {name='jiyean', age=27}

        ///* ************ Annotation 어노테이션 ************ *///
        // 리플렉션 기술이 전반적으로 사용됨
    }
}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}