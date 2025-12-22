package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
        // Java에서는 비교를 위한 인터페이스로 대표적으로 두개가 주어진다
        // 1) Comparator 인터페이스 : 인터페이스 내 compareTo 메서드만 존재
        // 2) Comparable 인터페이스 : 인터페이스 내 compare 메서드만 존재

        /// * ************ Comparator ************ *///
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        // 자바의 대부분 정렬 함수는 매개변수로 Comparator 객체 요구함
        myList.sort(Comparator.naturalOrder()); // Comparator 객체를 리턴하는 static(클래스) 메서드임
        // o1과 o2의 숫자값을 마이너스 형식으로 코딩을 하되,
        // o1이 먼저 있으면 오름차순, o2가 먼저 있으면 내림차순 (rule이라서 외워야함)
        // 이 때 매개변수가 두개만 있으면 정렬이 되나? -> 두개의 비교만 하면 정렬이 가능하다(like 선택정렬)
        myList.sort((o1, o2) -> o1 - o2);

        List<String> myList2 = new ArrayList<>();
        myList2.add("java");
        myList2.add("python");
        myList2.add("c++");

        // 기본적인 문자열 정렬일 때에는 Comparator 커스텀을 하지 않고,
        // 복잡한 자신만의 정렬 기준을 갖고 정렬해야 할 때에는 Comparator 익명객체 생성

        Collections.sort(myList2, Comparator.reverseOrder());
        System.out.println("기본 내림차순 정렬 : " + myList2);
        // 알파벳순 오름차순
        Collections.sort(myList2, (o1, o2) -> o2.compareTo(o1));
        System.out.println("알파벳순 내림차순 정렬 : " + myList2);

        // 길이를 기준으로 한 오름차순
        Collections.sort(myList2, (o1, o2) -> o1.length() - o2.length());
        System.out.println("문자길이순 오름차순 정렬 : " + myList2);

        // 문자열의 길이로 정렬하되, 문자열의 길이가 같은 경우 알파벳 순으로 정렬
        myList2.add("HTML");
        Collections.sort(myList2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }

            }
        });
        System.out.println("문자길이순 & 알파벳순 정렬 오름차순 : " + myList2);


        // 배열, 리스트 정렬 외에 java의 그 외 정렬 자료 구조 (pq, Treeset, Treemap 등)
        Queue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length()-o2.length());

        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.length() - o2.length());

        // [📝실습예제] 리스트 안의 배열 정렬
        // 요구사항 : 리스트 안의 배열에 1번째 index를 기준으로 오름차순 정렬해라
        // [{4,5},{1,2},{5,0},{3,1}] -> [{5,0},{3,1},{1,2},{4,5}]
        List<int[]> arrList = new ArrayList<>();
        arrList.add(new int[]{4,5});
        arrList.add(new int[]{1,2});
        arrList.add(new int[]{5,0});
        arrList.add(new int[]{3,1});

        Collections.sort(arrList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int[] arr : arrList){
            System.out.println(Arrays.toString(arr));
        }

        // [📝실습예제] 내가 직접 만든 객체의 정렬
        // Student 클래스 요구사항 : 변수 name, age / 생성자 / getter / toString
        // Student 객체 요구사항 : List에 4개쯤 담기.

        List<Student> students = new ArrayList<>();
        students.add(new Student("lee", 20));
        students.add(new Student("kim", 45));
        students.add(new Student("park", 13));
        students.add(new Student("hong", 20));
        /* 객체의 나이순 정렬
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        */
        // 객체의 이름순 정렬
        // 방법(1) : Comparator를 구현한 익명객체 방식
        /*
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(students);
        */

        // 방법(2) : Comparable을 구현한 방식
        // Students 객체 안에 Comparable을 implements 하는 방식
        // 단점: 객체 자체를 sort하는 방식은 불가능함, 유연성이 떨어짐
        Collections.sort(students); // sort 실행 시 자동으로 클래스 안의 compareTo 메서드를 찾아서 호출됨


        // TODO 문제풀이
        //  백준 : 단어정렬
        //  백준 : 절대값 힙
        //  백준 : 선긋기
    }
}

// [📝실습예제] 내가 직접 만든 객체의 정렬
// Student 클래스 요구사항 : 변수 name, age / 생성자 / getter / toString
// Student 객체 요구사항 : List에 4개쯤 담기.
class Student implements Comparable<Student>{ // Comparable 사용을 위한 설계
//class Student { // Comparator 사용시 기본 설계 구조
    private String name;
    private int age;

    // 기본생성자
    public Student(){

    }
    // 생성자 오버라이딩
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    // Comparable의 compareTo에서는 this와 매개변수로 주어지는 객체와 비교
    // this가 앞에 있으면 오름차순, 매개변수 객체가 앞에 있으면 내림차순.
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
