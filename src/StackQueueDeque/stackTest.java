package StackQueueDeque;

import java.util.*; // import java.util.Stack;

public class stackTest {
    public static void main(String[] args) {
        // 데이터 타입은 클래스 혹은 레퍼 클래스. 즉 기본형 int, boolean 등은 안되고, Integer, Boolean으로.
        Stack<Integer> stackWithInt = new Stack<>();
        Stack<String> stackWithStr = new Stack<>();
        Stack<Boolean> stackWithBool = new Stack<>();

        stackWithInt.push(1); // 스택에 값 넣기
        System.out.println("cur = " + stackWithInt);
        stackWithInt.push(2);
        System.out.println("cur = " + stackWithInt);
        stackWithInt.push(3);
        System.out.println("cur = " + stackWithInt);

        System.out.println(stackWithInt.pop()); // 맨 위에 값 뽑고 그 값 반환
        System.out.println("cur = " + stackWithInt);

        System.out.println(stackWithInt.peek()); // 맨 위에 값 반환. 뽑진 않음.
        System.out.println("cur = " + stackWithInt);

        System.out.println(stackWithInt.isEmpty()); // 비어있으면 true, 아니면 false

        // search() 함수는 해당 인자가 몇 번째로 스택에서 빠져나오는지 알려줌.
        // 만약 해당 인자가 없으면 -1 return.
        // 인자가 여러개인 경우에는 가장 먼저 나오는 순서 알려줌
        stackWithInt.push(1); // 1 2 1이 있는 상황
        System.out.println(stackWithInt.search(0));
        System.out.println(stackWithInt.search(1));
        System.out.println(stackWithInt.search(2));

        // size()로 현재 스택 크기 알 수 있음
        System.out.println(stackWithInt.size());
    }
}
