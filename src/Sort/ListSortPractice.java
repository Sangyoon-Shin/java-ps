package Sort;

import java.util.*;

public class ListSortPractice {

    public static void main(String[] args) {
        // 하나씩 주석 풀고 돌려봐
        // p1_sortPairs();
        // p2_sortTriples();
        // p3_sortStudentsObject();
        // p4_sortStringsByCustomRule();
        p5_sortMeetingsAndPick();
        // p6_sortByComputedKey();
    }

    // ----------------------------
    // P1) int[] (pair) 리스트 정렬
    // 규칙: x 오름차순, x 같으면 y 내림차순
    // 기대 출력:
    // [1, 9]
    // [2, 7]
    // [2, 5]
    // [2, 1]
    // [3, 3]
    // ----------------------------
    static void p1_sortPairs() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{2, 5});
        list.add(new int[]{1, 9});
        list.add(new int[]{2, 1});
        list.add(new int[]{3, 3});
        list.add(new int[]{2, 7});

        // TODO: list.sort(...) 작성
        // 힌트: a[0], a[1] 사용
        list.sort((a, b) -> {
           if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
           return Integer.compare(b[1], a[1]);
        });

        printListPairs(list);
    }

    // ----------------------------
    // P2) int[] (triple) 리스트 정렬
    // 원소 의미: {score, time, id}
    // 규칙: score 내림, time 오름, id 오름
    // 기대 출력:
    // [100, 9, 1]
    // [100, 9, 3]
    // [100, 10, 2]
    // [80, 5, 2]
    // [80, 5, 9]
    // ----------------------------
    static void p2_sortTriples() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{100, 10, 2});
        list.add(new int[]{100,  9, 3});
        list.add(new int[]{100,  9, 1});
        list.add(new int[]{ 80,  5, 9});
        list.add(new int[]{ 80,  5, 2});

        // TODO: list.sort(...) 작성
        list.sort((a, b) -> {
           if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
           else if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
           return Integer.compare(a[2], b[2]);
        });

        printListTriples(list);
    }

    // ----------------------------
    // P3) 객체 리스트 정렬
    // 규칙: grade 내림, name 사전순 오름, age 오름
    // 기대 출력:
    // park(g=3,age=20)
    // kim(g=3,age=21)
    // choi(g=2,age=19)
    // lee(g=2,age=22)
    // ----------------------------
    static class Student {
        String name;
        int grade;
        int age;
        Student(String name, int grade, int age) {
            this.name = name;
            this.grade = grade;
            this.age = age;
        }
        public String toString() {
            return name + "(g=" + grade + ",age=" + age + ")";
        }
    }

    static void p3_sortStudentsObject() {
        ArrayList<Student> list = new ArrayList<>(List.of(
                new Student("kim", 3, 21),
                new Student("lee", 2, 22),
                new Student("park", 3, 20),
                new Student("choi", 2, 19)
        ));

        // TODO: list.sort(...) 작성
        list.sort((a, b) -> {
           if (a.grade != b.grade) return Integer.compare(b.grade, a.grade);
           else if (!a.name.equals(b.name)) return a.name.compareTo(b.name);
           return Integer.compare(a.age, b.age);
        });

        System.out.println(list);
    }

    // ----------------------------
    // P4) 문자열 리스트 “커스텀” 정렬
    // 규칙: 길이 오름차순, 길이 같으면 사전순 내림차순
    // 기대 출력:
    // [b, a, ba, ab, abc, aaa]
    // ----------------------------
    static void p4_sortStringsByCustomRule() {
        ArrayList<String> list = new ArrayList<>(List.of("ab", "a", "abc", "b", "ba", "aaa"));

        // TODO: list.sort(...) 작성
        list.sort((a, b) -> {
           if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
           return b.compareTo(a);
        });

        System.out.println(list);
    }

    // ----------------------------
    // P5) 회의실 배정 느낌 (정렬 + 선택)
    // 원소: {start, end}
    // 1) 정렬 규칙: end 오름, end 같으면 start 오름
    // 2) 정렬된 순서대로 "겹치지 않게" 최대 몇 개 선택 가능한지 출력
    //
    // 입력: (1,4), (2,3), (3,5), (0,6), (5,7), (8,9), (5,9)
    // 정답(최대 선택 개수): 4  (예: (2,3),(3,5),(5,7),(8,9))
    // ----------------------------
    static void p5_sortMeetingsAndPick() {
        ArrayList<int[]> meetings = new ArrayList<>();
        meetings.add(new int[]{1, 4});
        meetings.add(new int[]{2, 3});
        meetings.add(new int[]{3, 5});
        meetings.add(new int[]{0, 6});
        meetings.add(new int[]{5, 7});
        meetings.add(new int[]{8, 9});
        meetings.add(new int[]{5, 9});

        // TODO1: meetings.sort(...) 작성 (end asc, tie start asc)
        meetings.sort((a, b) -> {
           if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
           return Integer.compare(a[0], b[0]);
        });

        // TODO2: 그리디로 최대 개수 선택
        // 힌트: 마지막으로 선택한 회의의 end를 저장하고,
        // start >= lastEnd 이면 선택
        int cnt = 1;
        int end = meetings.get(0)[1];
        for (int i = 1; i < meetings.size(); i++){
            if (meetings.get(i)[0] >= end){
                cnt++;
                end = meetings.get(i)[1];
            }
        }
        System.out.println(cnt);
        // 출력: 선택 개수만 출력
    }

    // ----------------------------
    // P6) “계산된 키”로 정렬
    // 원소: {a, b}
    // 규칙: |a-b| 오름차순, 같으면 a 오름차순
    // 기대 출력(원소 순서):
    // (5,5) diff=0
    // (3,4) diff=1
    // (10,8) diff=2
    // (1,7) diff=6
    // ----------------------------
    static void p6_sortByComputedKey() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 7});
        list.add(new int[]{10, 8});
        list.add(new int[]{3, 4});
        list.add(new int[]{5, 5});

        // TODO: list.sort(...) 작성 (diff asc, tie a asc)

        for (int[] x : list) {
            System.out.println("(" + x[0] + "," + x[1] + ") diff=" + Math.abs(x[0] - x[1]));
        }
    }

    // ----------------------------
    // 출력 도우미
    // ----------------------------
    static void printListPairs(ArrayList<int[]> list) {
        for (int[] x : list) System.out.println(Arrays.toString(x));
    }

    static void printListTriples(ArrayList<int[]> list) {
        for (int[] x : list) System.out.println(Arrays.toString(x));
    }
}