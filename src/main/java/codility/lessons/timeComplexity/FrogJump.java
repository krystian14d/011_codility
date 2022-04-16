package codility.lessons.timeComplexity;

public class FrogJump {

    public static void main(String[] args) {
        int jumps = solution(10, 85, 30);
        System.out.println(jumps);
    }

    public static int solution(int x, int y, int d) {
        int distToGo = y - x;
        if (distToGo % d != 0) {
            return (distToGo / d) + 1;
        } else {
            return distToGo / d;
        }
    }
}
