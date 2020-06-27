package beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class P10828 { // STACK

    // 전역변수
    public static int N;
    public static Stack<Integer> stack = new Stack<>();

    // Integer, String, Boolean, Long, Char, Double, Float = Reference Type
    // int, char, boolean, long, short, double, float = Primitive Type

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //System.in : 콘솔에서 읽어옴
        //System.out.println(scanner.nextLine()); // 입력되어있는 문자열 가져옴
        // next() : 띄어쓰기 전만 가져옴  ||  nextLine() : 한 줄을 가져옴

        N = scanner.nextInt();

        // for : 반복에 대한 인덱스를 가지고 있음.
        // while : 반복에 대한 인덱스를 가지고 있지 않음.
        for (int i = 0; i < N; i++) {
            String operator = scanner.next(); // 스캐너로부터 값을 가져오는 변수

            if (operator.equals("push")) { // 가져온 값이 "push"이면 (equals : 문자열 비교)
                stack.push(scanner.nextInt()); // 스택에 정수를 넣음
            } else if (operator.equals("pop")) {
                if (stack.empty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stack.pop()); // 스택에서 가장 위에 있는 정수를 꺼내고 반환
                }
            } else if (operator.equals("size")) {
                System.out.println(stack.size()); // 스택에 있는 정수의 개수 반환
            } else if (operator.equals("empty")) {
                if (stack.empty()){ // 스택이 비어있는 여부 반환
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            } else if (operator.equals("top")) {
                if (stack.empty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());// 스택의 최상위 정수 반환
                }
            }
        }

    }

}
