package array;
import java.util.*;

public class q7 {

    private static boolean isnotValidoperation(int nx, int ny) {
        return (nx<-5 || nx>5 || ny<-5 || ny>5);
    }
    public static int solution(String dirs) {
        Set<String> visit = new HashSet<>();
        int x = 0;
        int y = 0;
        for(char i : dirs.toCharArray()) {
            int nx =x;
            int ny =y;
            if(i=='U') {
                ny +=1;
            } else if(i=='D') {
                ny -=1;
            } else if (i=='L') {
                nx +=1;
            } else if (i=='R') {
                nx -=1;
            }

            if(isnotValidoperation(nx, ny)) continue;

            String path1 = "." + x + y + nx + ny;
            String path2 = "." + nx + ny + x + y;
            visit.add(path1);
            visit.add(path2);
            x = nx;
            y = ny;
        }
        return visit.size()/2;
    }
}
