package HashMap;

import java.io.*;
import java.util.*;

public class HashMapTest {
    public static void main(String[] args) throws IOException{
        HashMap<Integer, String> map = new HashMap<>();
        // HashMap<key 타입, val 타입> 맵이름 = new HashMap<>();
        // () 안에 사이즈 초기 선언 가능. ArrayList랑은 다르게 크기 늘릴때 2의 제곱으로 늘린다 정도 알아두기.
        map.put(1, "apple"); // put(key, val) => put 메서드
        // put은 해시맵에 데이터 추가. 넣으려는 key값이 이미 존재한다면 새로운 val로 업데이트됨.
        map.put(2, "banana");
        map.put(3, "grape");

        // map.remove(1); // remove(key) => remove 메서드
        // remove는 해당 키 값의 데이터를 삭제.

        // map.clear(); // clear() => clear 메서드
        // clear는 해시 맵 전체 데이터 삭제

        // System.out.println(map.get(1)); // get(key) => get 메서드
        // get은 해당되는 키 값의 value를 반환

        // entrySet() => 키, 값 둘 다 필요할 때 사용.
        // for문 사용해서 다 뽑을 수 있다.
        for (Map.Entry<Integer, String> e : map.entrySet()){
            Integer key = e.getKey();
            String val = e.getValue();
            System.out.println(key + " -> " + val);
        }

        // keySet() => 키만 필요할 때
        for (Integer key : map.keySet()){
            System.out.println(key);
            System.out.println(key + " -> " + map.get(key)); //  이렇게 키 순회하면서 값 뽑기도 가능하지만, 이럴바엔 entrySet()을 쓰자.
        }

        // values() => 값만 볼 때
        for (String val : map.values()){
            System.out.println(val);
        }

        // containsKey() => 특정 값을 갖는 키가 있는지 판단할 때 사용.
        if (map.containsKey(4)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        // get을 사용할 때 없는 키 값에 접근하려하면 null이 리턴됨.
        System.out.println(map.get(4));

        // 위의 문제를 방지하기 위해 getOrDefault 사용
        // getOrDefault는 특정 값 몇 번 나왔는지 카운트 하는 문제에서 필수같으니 외우자.

        HashMap<Integer, Integer> mapInt = new HashMap<>();
        System.out.println(mapInt.getOrDefault(1, 0)); // 1이라는 키가 있으면 그 value를 반환, 없으면 0을 반환
        mapInt.put(1, mapInt.getOrDefault(1, 0) + 1);
        // 처음에 mapInt가 비어있었으니까, getOrDefault 메서드가 0을 반환함. 거기에 1을 더한 값을 키가 1인 값의 value가 됨.
        System.out.println(mapInt);
        mapInt.put(1, mapInt.getOrDefault(1, 0) + 1);
        // 이젠 1이란 키가 있던 상태니까 getOrDefault가 1을 반환, 거기에 1을 더한값을 키가 1인 값의 value가 됨.
        System.out.println(mapInt);

    }
}
