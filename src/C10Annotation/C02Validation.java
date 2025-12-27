package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Validation {
    public static void main(String[] args) throws IllegalAccessException {
        ///* ************ Annotation 어노테이션 : 리플렉션 기술을 근간으로 사용됨 ************ *///
        // - 자바에서 메타데이터(metadata)를 제공하기 위한 문법 요소
        // - 일반적으로, 어노테이션은 런타임 시점에서 동작
        // - 어노테이션의 주요 기능:
        // 1) 컴파일러에게 정보 제공: @Override (메서드 오버라이딩 검사)
        // 2) 런타임 시 특정 행동 유발: @Autowired (의존성 자동 주입)
        // - 동작 원리: 리플렉션 기술로 런타임에 처리
        // - 사용법: @interface로 정의 → 클래스/필드/메서드에 부착

        List<Member> memberList = new ArrayList<>();
        // 회원가입 프로그램
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("회원가입 서비스입니다.");
            System.out.println("이름을 입력해주세요");
            String name = sc.nextLine();
            System.out.println("이메일을 입력해주세요");
            String email = sc.nextLine();
            // TODO Member 클래스 내부에 특정 변수들의 제약조건들을 설정하고싶은 상황(검증이 반복적으로 수행되기도 함)
            //  ex) notEmpty 등 선언적으로 작성하고싶음
            Member member = new Member(name, email);
            // 추후 스프링에서는 아래와 같은 <validate 메서드> + <직접 만든 어노테이션>이 모두 합해져있는 이미 만들어진 <어노테이션>을 사용함
            validate(member);
            memberList.add(member);
        }
    }

    // 2. 기능 생성
    // 특정 변수에 NotEmpty 어노테이션 설정이 있을 경우, 값이 비어있는지를 검사하는 메서드
    // 리플렉션 기술을 통해 런타임 시점에 private 변수라 할지라도 객체안의 필드값을 꺼내 확인할 수 있음
    /* 📍 검증 로직: 리플렉션 + 어노테이션 활용
     * 1. 객체의 모든 필드 탐색
     * 2. @NotEmpty 어노테이션 존재 여부 확인
     * 3. private 필드 접근 허용 → 값 검증 → 예외 발생
     */
    static void validate(Object object) throws IllegalAccessException {
        Field[] fieldList = object.getClass().getDeclaredFields();
        for (Field f : fieldList) {
            if (f.isAnnotationPresent(NotEmpty.class)) {
                f.setAccessible(true); // 우선 접근 가능하도록 변경
                String value = (String) f.get(object);
                if (value == null || value.isEmpty()) {
                    NotEmpty ne = f.getAnnotation(NotEmpty.class);
                    throw new IllegalAccessException(ne.message());
                }
            }
        }
    }
}

class Member {
    private String name;
    @NotEmpty
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

}

// 1. 인터페이스 클래스(어노테이션) 생성
// 어노테이션은 선언적 표시이고, 어떠한 기능도 수행하지 않음
// 따라서 아래 NotEmpty 어노테이션 클래스는 어떤 기능도 없지만, 특정 필드값이 비어있으면 안된다는 선언적 표시만 수행함
// 리플렉션은 기본적으로 런타임에 동작하므로, 어노테이션을 사용할 때에 기본적으로 런타임 동작을 설정함
// 런타임 <-> 컴파일타임( 문법적 오류등이 발생하는 등 프로그램 실행 후 발생하는 오류다. 따라서 어노테이션은 런타임시점에 발생해야하는 것)

/* 📍 커스텀 어노테이션 정의
 * @interface NotEmpty { ... } → 어노테이션 클래스 생성
 * ✅ @Retention: 동작 시점 지정
 *  - RUNTIME: 런타임에 리플렉션으로 접근 가능 (기본)
 *  - SOURCE: 컴파일러용 (코드에 남지 않음)
 *  - CLASS: 바이트코드에 저장 (런타임 접근 불가)
 * ✅ @Target: 사용 가능 위치 지정 (생략 시 모든 곳 가능)
 *  - ElementType.FIELD, METHOD, TYPE 등
 */
@Retention(RetentionPolicy.RUNTIME)
@interface NotEmpty {
    // 어노테이션 클래스의 속성은 일반적으로 메서드 형태로 정의
    String message() default "this field cannot be empty!!😡🤬";
}