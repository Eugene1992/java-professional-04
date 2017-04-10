package homework.hw01;

/**
 * Created by dimon on 07.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(51);
        stack.push("sdahsdkjkla");
        stack.push('g');
        stack.push(212121);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
