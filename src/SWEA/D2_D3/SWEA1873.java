package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1873 {
    static int t;
    static int h, w;
    static char[][] map;
    static int com;
    static String command;
    static int r, c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            for (int i = 0; i < h; i++){
                String s = br.readLine();
                for (int j = 0; j < w; j++){
                    char cur = s.charAt(j);
                    if (cur == '^' || cur == 'v' || cur == '<' || cur == '>'){
                        r = i;
                        c = j;
                    }
                    map[i][j] = cur;
                }
            }

            com = Integer.parseInt(br.readLine());
            command = br.readLine();

            for (int i = 0; i < com; i++){
                char cur = command.charAt(i);

                switch (cur){
                    case 'U':
                        moveUp(r, c);
                        break;
                    case 'D':
                        moveDown(r, c);
                        break;
                    case 'L':
                        moveLeft(r, c);
                        break;
                    case 'R':
                        moveRight(r, c);
                        break;
                    default:
                        shoot(r, c);

                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void moveUp(int x, int y){
        map[x][y] = '^';
        if (x - 1 >= 0 && x - 1 < h && y >= 0 && y < w){
            if (map[x - 1][y] == '.'){
                map[x][y] = '.';
                map[x - 1][y] = '^';
                r = x - 1;
                c = y;
            }
        }
    }
    public static void moveDown(int x, int y){
        map[x][y] = 'v';
        if (x + 1 >= 0 && x + 1 < h && y >= 0 && y < w){
            if (map[x + 1][y] == '.'){
                map[x][y] = '.';
                map[x + 1][y] = 'v';
                r = x + 1;
                c = y;
            }
        }
    }
    public static void moveLeft(int x, int y){
        map[x][y] = '<';
        if (x >= 0 && x < h && y - 1 >= 0 && y - 1 < w){
            if (map[x][y - 1] == '.'){
                map[x][y] = '.';
                map[x][y - 1] = '<';
                r = x;
                c = y - 1;
            }
        }
    }
    public static void moveRight(int x, int y){
        map[x][y] = '>';
        if (x >= 0 && x  < h && y + 1 >= 0 && y + 1 < w){
            if (map[x][y + 1] == '.'){
                map[x][y] = '.';
                map[x][y + 1] = '>';
                r = x;
                c = y + 1;
            }
        }
    }
    public static void shoot(int x, int y){
        if (map[x][y] == '^'){
            for (int i = r - 1; i >= 0; i--){
                if (map[i][c] == '*'){
                    map[i][c] = '.';
                    break;
                } else if (map[i][c] == '#'){
                    break;
                }
            }
        } else if (map[x][y] == 'v'){
            for (int i = r + 1; i < h; i++){
                if (map[i][c] == '*'){
                    map[i][c] = '.';
                    break;
                } else if (map[i][c] == '#'){
                    break;
                }
            }
        } else if (map[x][y] == '<'){
            for (int i = c - 1; i >= 0; i--){
                if (map[r][i] == '*'){
                    map[r][i] = '.';
                    break;
                } else if (map[r][i] == '#'){
                    break;
                }
            }
        } else if (map[x][y] == '>'){
            for (int i = c + 1; i < w; i++){
                if (map[r][i] == '*'){
                    map[r][i] = '.';
                    break;
                } else if (map[r][i] == '#'){
                    break;
                }
            }
        }
    }
}
