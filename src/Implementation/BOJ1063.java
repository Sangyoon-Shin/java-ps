package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1063 {
    static int[][] map = new int[8][8];
    static HashMap<String, int[]> commands = new HashMap<>();
    static int[] pos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String rock = st.nextToken();

        int kingC = king.charAt(0) - 'A';
        int kingR = '8' - king.charAt(1);

        int rockC = rock.charAt(0) - 'A';
        int rockR = '8' - rock.charAt(1);
        pos = new int[] {kingR, kingC, rockR, rockC};

        int n = Integer.parseInt(st.nextToken());

        commands.put("R", new int[]{0, 1});
        commands.put("L", new int[]{0, -1});
        commands.put("B", new int[]{1, 0});
        commands.put("T", new int[]{-1, 0});
        commands.put("RT", new int[]{-1, 1});
        commands.put("LT", new int[]{-1, -1});
        commands.put("RB", new int[]{1, 1});
        commands.put("LB", new int[]{1, -1});

        for (int i = 0; i < n; i++){
            String command = br.readLine();
            move(command);
        }
        System.out.println(toString(pos[0], pos[1]));
        System.out.println(toString(pos[2], pos[3]));
    }
    static private void move(String c){
        int[] dir = commands.get(c);
        // 왕의 이동 방향에 돌이 있는지 여부 -> 돌 없으면 왕만 이동하면 됨
        // 돌이 있다면 그 돌도 같은 방향으로 갔을 때, 경계를 넘어가는지 여부 -> 경계 안넘어가면 왕, 돌 모두 같은 방향으로 이동. 돌이 넘어가는 경우 패스
        int nextKingR = pos[0] + dir[0];
        int nextKingC = pos[1] + dir[1];

        // 일단 왕 좌표도 범위 체크 해줘야됨.
        if (nextKingR >= 0 && nextKingR < 8 && nextKingC >= 0 && nextKingC < 8){
            if (nextKingR == pos[2] && nextKingC == pos[3]){ // 돌이 있으면
                int nextRockR = pos[2] + dir[0];
                int nextRockC = pos[3] + dir[1];
                // 돌 있는데 돌이 경계 안 넘어 가는 경우 둘 다 위치 업데이트
                if (nextRockR >= 0 && nextRockR < 8 && nextRockC >= 0 && nextRockC < 8){
                    // 왕은 이전 돌 위치로 업데이트 해주면 되고, 돌은 이동
                    pos[0] = pos[2];
                    pos[1] = pos[3];
                    pos[2] = nextRockR;
                    pos[3] = nextRockC;
                }
            } else { // 없으면 왕 좌표만 업데이트
                pos[0] = nextKingR;
                pos[1] = nextKingC;
            }
        }
    }
    static private String toString(int r, int c){
        String pos = "" + (char)(c + 'A') + (char)('8' - r);
        return pos;
    }
}
