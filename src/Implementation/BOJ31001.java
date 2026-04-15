package Implementation;

import java.io.*;
import java.util.*;

public class BOJ31001 {
    static long money;
    static int company, menu;
    // 회사가 몇 번 그룹인지, 회사의 주가가 얼마인지
    static HashMap<String, Integer> group = new HashMap<>();
    static HashMap<String, Integer> value = new HashMap<>();
    // 하이비가 소유한 주식 데이터
    static HashMap<String, Integer> data = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        company = Integer.parseInt(st.nextToken());
        money = Long.parseLong(st.nextToken());
        menu = Integer.parseInt(st.nextToken());

        for (int i = 0; i < company; i++){
            st = new StringTokenizer(br.readLine());
            int groupNum = Integer.parseInt(st.nextToken());
            String groupName = st.nextToken();
            int stockOne = Integer.parseInt(st.nextToken());

            putCompanyValue(groupNum, groupName, stockOne);
        }

        for (int i = 0; i < menu; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 6 || num == 7){
                if (num == 6){
                    System.out.println(money);
                } else {
                    printTotalAsset();
                }
            } else if (num >= 1 && num <= 3){
                String second = st.nextToken();
                int third = Integer.parseInt(st.nextToken());
                switch(num){
                    case 1:
                        buyStock(second, third);
                        break;
                    case 2:
                        sellStock(second, third);
                        break;
                    case 3:
                        increaseVal(second, third);
                        break;
                }
            } else if (num == 4 || num == 5){
                int groupNum = Integer.parseInt(st.nextToken());
                int how = Integer.parseInt(st.nextToken());
                if (num == 4){
                    increaseGroupVal(groupNum, how);
                } else {
                    increaseGroupValForPercentage(groupNum, how);
                }
            }

        }
    }
    public static void putCompanyValue(int num, String name, int v){
        group.put(name, num);
        value.put(name, v);
    }

    public static long cal(long current){ // 10원 단위로 거래하게끔
        if (current % 10 != 0){
            current = (current / 10) * 10;
        }
        return current;
    }

    public static long calValueForStock(String name, int week){
        int val = value.get(name);
        long newval = (long)val * week;
        return newval;
    }

    public static void buyStock(String name, int week){
        int val = value.get(name);
        long totalValue = (long)val * week;

        if (money >= totalValue){ // 살 수 있는 경우 -> 하이비의 보유 주식 업데이트 + 현금 차감
            data.put(name, data.getOrDefault(name, 0) + week);
            money -= totalValue;
        }
    }

    public static void sellStock(String name, int week){
        int stockCnt = data.getOrDefault(name, 0);
        if (stockCnt > 0){
            if (week >= stockCnt){
                data.put(name, 0);
                money += calValueForStock(name, stockCnt);
            } else {
                data.put(name, stockCnt - week);
                money += calValueForStock(name, week);
            }
        }
    }

    public static void increaseVal(String name, int how){
        int curVal = value.get(name);
        curVal += how;
        if (curVal < 0) {
            curVal = 0;
        }
        value.put(name, curVal);
    }

    public static void increaseValPercentage(String name, int how){
        int curVal = value.get(name);

        long changed = (long) curVal * (100 + how) / 100;
        if (changed < 0) changed = 0;

        curVal = (int) cal(changed);
        value.put(name, curVal);
    }

    public static void increaseGroupVal(int groupNum, int how){
        for (String name : group.keySet()){
            if (group.get(name) == groupNum){
                increaseVal(name, how);
            }
        }
    }

    public static void increaseGroupValForPercentage(int groupNum, int how){
        for (String name : group.keySet()){
            if (group.get(name) == groupNum){
                increaseValPercentage(name, how);
            }
        }
    }

    public static void printTotalAsset() {
        long total = money;
        for (String name : data.keySet()) {
            total += (long) data.get(name) * value.get(name);
        }
        System.out.println(total);
    }
}
