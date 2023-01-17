package hackerrank;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {

//    private Stack<Integer> input = new Stack<>();
//    private Stack<Integer> output = new Stack<>();
//
//    public void enqueue(int x){
//        input.push(x);
//    }
//
//    public int dequeue(){
//        peek();
//        return output.pop();
//    }
//
//    public int peek(){
//        if(output.empty()){
//            while(!input.empty()){
//                output.push(input.pop());
//            }
//        }
//        return output.peek();
//    }
//
//    public boolean isEmpty(){
//        return input.empty() && output.empty();
//    }

    public static void transferStackOneToTwo(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (stack1.size()>0) {
            stack2.push(stack1.pop());
        }
    }

    public static boolean shouldTransferStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        return stack2.size()==0 && stack1.size()!=0;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Integer lastEle=null;
        int q, type, x;
        q = scanner.nextInt();
        for (int i=0; i<q; i++) {
            type = scanner.nextInt();
            switch(type) {
                case 1: {
                    x = scanner.nextInt();
                    if (stack1.isEmpty()) { lastEle=x;};
                    stack1.push(x);
                    break;
                }
                case 2: {
                    if (shouldTransferStack(stack1, stack2)) {
                        transferStackOneToTwo(stack1, stack2);
                    }
                    stack2.pop();
                    break;
                }
                case 3: {
                    if (stack2.isEmpty()) { System.out.println(lastEle); }
                    else { System.out.println(stack2.peek());}
                    break;
                }
                default: {
                    System.err.print("Invalid input");
                }
            }
        }
        scanner.close();
    }
}
