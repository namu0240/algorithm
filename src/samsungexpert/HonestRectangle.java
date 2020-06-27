package samsungexpert;

public class HonestRectangle {
    public static long solution(int w, int h) {
        long answer = w * h;
        long small = gcd(w, h);

        long W = w / small;
        long H = h / small;

        double angle = 1.0 * W / -H;

        System.out.println(String.format("angle: %f", angle));

        long area = 0;

        for (int i = 0; i < H; i++) {
            double y = i + 0.5;
            double x = angle / y;

            System.out.println(String.format("x: %f, y: %f", x, y));
            if (i + 0.5 * angle % 1 == 0) {
                area += 1;
            } else {
                area += 2;
            }
        }

        System.out.println(String.format("W: %d ,H: %d", W, H));

        return answer - area * small;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }
}