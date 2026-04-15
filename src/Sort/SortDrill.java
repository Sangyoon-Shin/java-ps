package Sort;

import java.util.*;

public class SortDrill {

    public static void main(String[] args) {
        // 문제별로 하나씩 주석 풀어서 실행해봐
        // q1_intArrayAscDesc();
        // q2_stringLexVsLength();
        // q3_2dArrayKeys();
        // q4_stableTieBreak();
        // q5_customObject();
        // q6_largestNumberRule();
        // q7_intervalSort();
        // q8_multiKeyMixedDirections();
        // q9_groupThenSort();
        q10_priorityQueueTopK();
    }

    // 출력 편의
    static void printIntArr(int[] a) { System.out.println(Arrays.toString(a)); }
    static void printStrArr(String[] a) { System.out.println(Arrays.toString(a)); }
    static void print2d(int[][] a) { System.out.println(Arrays.deepToString(a)); }

    // ----------------------------
    // Q1. int[] 오름/내림 + 주의점
    // ----------------------------
    static void q1_intArrayAscDesc() {
        int[] arr = {5, 1, 10, -3, 10, 2};
        Arrays.sort(arr); // 오름차순
        printIntArr(arr);

        // TODO: 내림차순으로 출력해보기 (방법 2개 중 택1)
        // 1) Integer[]로 변환 후 Comparator 사용
        Integer[] arrInt = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++){
            arrInt[i] = arr[i];
        }
        Arrays.sort(arrInt, (a, b) -> Integer.compare(b, a));
        for (int i = 0; i < arr.length; i++){
            System.out.print(arrInt[i] + " ");
        }
        System.out.println();
        // 2) 오름차순 후 reverse 출력(또는 reverse 배열 만들기)
        int[] newarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            newarr[arr.length - 1 - i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(newarr[i] + " ");
        }
    }

    // ----------------------------
    // Q2. String 사전순 vs 길이순
    // ----------------------------
    static void q2_stringLexVsLength() {
        String[] a = {"ab", "a", "abc", "b", "ba", "aa"};

        // TODO1: 사전순 오름차순
        Arrays.sort(a, (s1, s2) -> s1.compareTo(s2));
        System.out.println("lex asc: " + Arrays.toString(a));


        // TODO2: 길이 오름차순, 길이 같으면 사전순 오름차순
        Arrays.sort(a, (s1, s2) -> {
            if (s1.length() != s2.length()) return Integer.compare(s1.length(), s2.length());
            else return s1.compareTo(s2); // 사전 오름차순
        });
        System.out.println("len asc, tie lex asc: " + Arrays.toString(a));
    }

    // ----------------------------
    // Q3. int[][] 2중키 정렬 (너가 자주 묻던 것)
    // ----------------------------
    static void q3_2dArrayKeys() {
        int[][] arr = {
                {5, 3},
                {5, 1},
                {2, 9},
                {7, 4},
                {7, 2}
        };

        // TODO: [0] 내림차순 우선, [0] 같으면 [1] 오름차순
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            else return Integer.compare(a[1], b[1]);
        });
        print2d(arr);
        // 기대: [[7, 2], [7, 4], [5, 1], [5, 3], [2, 9]]
    }

    // ----------------------------
    // Q4. 동점 처리(타이브레이커) 3키
    // ----------------------------
    static void q4_stableTieBreak() {
        int[][] players = {
                {100, 10, 2},  // score, time, id
                {100,  9, 3},
                {100,  9, 1},
                { 80,  5, 9},
                { 80,  5, 2}
        };

        // TODO: score 내림, time 오름, id 오름
        Arrays.sort(players, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[2], b[2]);
        });
        print2d(players);
        // 기대: [[100, 9, 1], [100, 9, 3], [100, 10, 2], [80, 5, 2], [80, 5, 9]]
    }

    // ----------------------------
    // Q5. 객체 정렬 (필드 기준)
    // ----------------------------
    static class Node {
        String name;
        int age;
        int score;
        Node(String name, int age, int score) { this.name = name; this.age = age; this.score = score; }
        public String toString() { return name + "(age=" + age + ",score=" + score + ")"; }
    }

    static void q5_customObject() {
        ArrayList<Node> list = new ArrayList<>(List.of(
                new Node("kim", 20, 90),
                new Node("lee", 20, 95),
                new Node("park", 19, 95),
                new Node("choi", 19, 80)
        ));

        // TODO: score 내림, age 오름, name 사전순 오름
        list.sort((a, b) ->{
            if (a.score != b.score) return Integer.compare(b.score, a.score);
            if (a.age != b.age) return Integer.compare(a.age, b.age);
            return a.name.compareTo(b.name);
        });
        System.out.println(list);
        // 기대: park(19,95), lee(20,95), kim(20,90), choi(19,80)  (표현은 toString상 다름)
    }

    // ----------------------------
    // Q6. "가장 큰 수" 정렬 규칙 실습
    // ----------------------------
    static void q6_largestNumberRule() {
        int[] numbers = {3, 30, 34, 5, 9};

        // TODO: 문자열로 바꾸고 (s2+s1).compareTo(s1+s2) 기준으로 정렬 후 붙이기
        String[] numToStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            numToStr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numToStr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numToStr.length; i++){
            sb.append(numToStr[i]);
        }
        System.out.println(sb);
        // 기대: "9534330"
    }

    // ----------------------------
    // Q7. 구간(Interval) 정렬 (start 오름, end 내림)
    // ----------------------------
    static void q7_intervalSort() {
        int[][] intervals = {
                {1, 4},
                {1, 3},
                {2, 2},
                {0, 10},
                {0, 3}
        };

        // TODO: start 오름, start 같으면 end 내림
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        print2d(intervals);
        // 기대: [[0, 10], [0, 3], [1, 4], [1, 3], [2, 2]]
    }

    // ----------------------------
    // Q8. 혼합키 4개: [0] 내림, [1] 오름, [2] 내림, [3] 오름
    // ----------------------------
    static void q8_multiKeyMixedDirections() {
        int[][] arr = {
                {5, 1, 7, 2},
                {5, 1, 9, 1},
                {5, 0, 1, 9},
                {4, 9, 9, 9}
        };

        // TODO: [0] desc, [1] asc, [2] desc, [3] asc
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[2] != b[2]) return Integer.compare(b[2], a[2]);
            return Integer.compare(a[3], b[3]);
        });
        print2d(arr);
        // 기대:
        // [5,0,1,9]
        // [5,1,9,1]
        // [5,1,7,2]
        // [4,9,9,9]
    }

    // ----------------------------
    // Q9. 그룹핑 후 정렬 (베스트앨범 핵심 패턴)
    // ----------------------------
    static void q9_groupThenSort() {
        String[] genres = {"classic","pop","classic","classic","pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // TODO:
        // 1) genreTotal(Map) 만들기
        HashMap<String, Integer> genreTotal = new HashMap<>();

        // 2) songsByGenre(Map<genre, List<int[]{idx,plays}>>) 만들기
        HashMap<String, ArrayList<int[]>> songsByGenre = new HashMap<>();

        for (int i = 0; i < plays.length; i++){
            String g = genres[i];
            int p = plays[i];
            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            songsByGenre.putIfAbsent(g, new ArrayList<>());
            songsByGenre.get(g).add(new int[] {i, p});
        }

        // 3) genreOrder를 total desc로 정렬
        ArrayList<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> Integer.compare(genreTotal.get(b), genreTotal.get(a)));

        // 4) 각 장르 list를 plays desc, idx asc로 정렬 후 상위 2개 idx를 결과 리스트에 add
        ArrayList<Integer> pick = new ArrayList<>();
        for (String g : genreOrder){
            ArrayList<int[]> list = songsByGenre.get(g);

            list.sort((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            });

            pick.add(list.get(0)[0]);
            if (list.size() > 1){
                pick.add(list.get(1)[0]);
            }
        }

        for (int i = 0; i < pick.size(); i++){
            System.out.print(pick.get(i) + " ");
        }

        // 기대 결과 idx: [4, 1, 3, 0]
    }

    // ----------------------------
    // Q10. Top-K: PriorityQueue로 "상위 k개" 뽑기
    // ----------------------------
    static void q10_priorityQueueTopK() {
        int[] a = {10, 3, 5, 7, 2, 9, 8};
        int k = 3;

        // TODO: 가장 큰 값 3개를 뽑아 출력 (내림차순)
        // 힌트: PriorityQueue를 "최대힙"처럼 쓰려면 Comparator.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < a.length; i++){
            pq.add(a[i]);
        }

        for (int i = 0; i < 3; i++){
            System.out.print(pq.remove() + " ");
        }
        // 기대: 10 9 8
    }
}