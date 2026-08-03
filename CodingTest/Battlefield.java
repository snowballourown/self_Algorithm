    package CodingTest;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Battlefield {

            static int current_x;
            static int current_y;
            static char current_direction;
            static char[][] chars;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int TC = Integer.parseInt(br.readLine());
            for (int i = 0; i < TC; i++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                int H = Integer.parseInt(stn.nextToken());
                int W = Integer.parseInt(stn.nextToken());

                chars = new char[H+1][W+1];

                for (int j = 1; j <= H; j++) { // 지형지물 선택
                    String a = br.readLine();
                    for (int k = 1; k <= W; k++) {
                        chars[j][k] = a.charAt(k-1);
                        if (a.charAt(k-1) == '<'||a.charAt(k-1) == 'v'
                        ||a.charAt(k-1) == '>'||a.charAt(k-1) == '^') {
                             current_x = k;
                             current_y = j;
                            current_direction = a.charAt(k - 1);
                        }
                    }
                }

                int cm = Integer.parseInt(br.readLine());

                char[] command = new char[cm+1];

                String a = br.readLine();
                for (int j = 0; j < cm; j++) { //전차이동
                    command[j] = a.charAt(j);
                }

                for (int j = 0; j < cm; j++) {
                    // 명령어에대한 상태 이동하면될듯?
                    play(command[j]);
                }

                sb.append("#").append(i + 1).append(" ");

                for (int j = 1; j <= H; j++) {
                    for (int k = 1; k <= W; k++) {
                        sb.append(chars[j][k]);
                    }
                    sb.append("\n");
                }



            }
            System.out.println(sb);

        }

        static void play(char command) {
            if (command == 'S') {
                // 현재 위치체크
                if (current_direction == '^') {
                    for (int i = current_y; i > 0; i--) {
                        if (chars[i][current_x] == '*') {
                            chars[i][current_x] = '.';
                            return;
                        } else if (chars[i][current_x] == '#') {
                            return;
                        }
                    }
                }else if (current_direction =='>')
                {
                    for (int i = current_x; i < chars[0].length; i++) {
                        if (chars[current_y][i] == '*') {
                            chars[current_y][i] = '.';
                            return;
                        } else if (chars[current_y][i] == '#') {
                            return;
                        }
                    }
                }
                else if (current_direction =='v') {
                    for (int i = current_y; i < chars.length; i++) {
                        if (chars[i][current_x] == '*') {
                            chars[i][current_x] = '.';
                            return;
                        } else if (chars[i][current_x] == '#') {
                            return;
                        }
                    }
                }
                else if (current_direction =='<') {
                    for (int i = current_x; i > 0; i--) {
                        if (chars[current_y][i] == '*') {
                            chars[current_y][i] = '.';
                            return;
                        } else if (chars[current_y][i] == '#') {
                            return;
                        }
                    }
                }

            } else
            {
                if (command == 'R') {
                    current_direction = '>';

                    int nx = current_x + 1;
                    int ny = current_y;

                    if (nx < chars[0].length  && chars[ny][nx] == '.') {
                        chars[current_y][current_x] = '.';
                        current_x = nx;
                        current_y = ny;
                    }

                    chars[current_y][current_x] = current_direction;
                } else if (command == 'D') {
                     current_direction = 'v';

                    int nx = current_x;
                    int ny = current_y+1;

                    if (ny < chars.length  && chars[ny][nx] == '.') {
                        chars[current_y][current_x] = '.';
                        current_x = nx;
                        current_y = ny;
                    }

                    chars[current_y][current_x] = current_direction;


                }else if (command == 'L') {
                    current_direction = '<';

                    int nx = current_x-1;
                    int ny = current_y;

                    if (nx > 0  && chars[ny][nx] == '.') {
                        chars[current_y][current_x] = '.';
                        current_x = nx;
                        current_y = ny;
                    }

                    chars[current_y][current_x] = current_direction;


                }else if (command == 'U') {
                    current_direction = '^';

                    int nx = current_x;
                    int ny = current_y-1;

                    if (ny > 0  && chars[ny][nx] == '.') {
                        chars[current_y][current_x] = '.';
                        current_x = nx;
                        current_y = ny;
                    }

                    chars[current_y][current_x] = current_direction;


                }

            // 현재 방향부터 체크

            // 이동 인지 슛인지 체크

            // 이동이면 현재 위치 체크
            // 갈수있은길이면 이동 없으면 제자리

            // 슛이면 보고있는 행 혹은 열에 부술수있는게 존재하는 확인



        }


    }
    }
