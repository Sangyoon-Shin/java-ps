package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1713 {
    static class Student{
        int num;
        int recommend;
        int time;
        Student(int num, int cnt, int time){
            this.num = num;
            this.recommend = cnt;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] vote = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++){
            vote[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Student> frame = new ArrayList<>();

        for (int i = 0; i < k; i++){
            int cur = vote[i];

            // 이미 있는애인지 확인
            boolean found = false;
            for (Student s : frame){
                if (s.num == cur){
                    s.recommend++;
                    found = true;
                    break;
                }
            }
            if (found){
                continue;
            }
            // 새로운 애가 들어갈 자리가 있으면
            if (frame.size() < n){
                frame.add(new Student(cur, 1, i));
            } else { // 들어갈 자리가 없으면
                Student tmp = frame.get(0);
                for (Student s : frame){
                    if (s.recommend < tmp.recommend){ // 추천수가 작으면 무조건 걔가 삭제 후보
                        tmp = s;
                    } else if (s.recommend == tmp.recommend && s.time < tmp.time) { // 추천수가 같으면, 게시된 시간이 오래된(일찍 들어온) 애를 삭제
                        tmp = s;
                    }
                }
                frame.remove(tmp);
                frame.add(new Student(cur, 1, i));
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        for (Student s : frame){
            int idx = s.num;
            res.add(idx);
        }
        Collections.sort(res);

        StringBuilder sb = new StringBuilder();
        for (Integer val : res){
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}
