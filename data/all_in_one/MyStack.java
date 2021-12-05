import java.util.*;

public class MyStack<T> {
    private T[] dizi;
    private int es;// eleman sayısı

    public MyStack() {
        dizi = (T[]) new Object[10];
        es = 0;
    }

    public MyStack(int es) {
        dizi = (T[]) new Object[es];
    }

    public void push(T eleman) {
        if (es == dizi.length) {
            throw new RuntimeException("stack overflow");
        }
        dizi[++es] = eleman;
    }

    public T pop() {
        if (es == 0)
            throw new RuntimeException("Stack underflow");
        return dizi[--es];
    }

    public T peek() {
        if (es == 0)
            throw new RuntimeException("Stack underflow");
        return dizi[es - 1];
    }

    public boolean isEmpty() {
        return es == 0;
    }

    public void print() {
        for (int i = es - 1; i >= 0; i--) {
            System.out.println(dizi[i]);
        }
    }

    public static <T> Stack<T> tersCevir(Stack<T> s) {
        // Metodun gövdesini yazınız
        Stack<T> st = (Stack<T>) s.clone();
        Stack<T> r = new Stack<>();
        while (!st.isEmpty())
            r.push(st.pop());

        return r;
    }
    public static <T> Stack<T> tersCevir2(Stack<T> s) {
        // Metodun gövdesini yazınız
        //stacki clonla
        Stack<T> st = (Stack<T>) s.clone();
        //yeni stack oluştur
        Stack<T> r = new Stack<>();
        //clon stack empty olana kadar içindekileri yeni oluşturduğun stacke aktar
        while(!st.isEmpty())
            r.push(st.pop());
        return r;
    }

    public static <T> boolean esit(Stack<T> s1, Stack<T> s2) {
        // Metodun gövdesini yazınız
        if (s1 == s2)
            return true;

        if (s1 == null || s2 == null)
            return false;

        if (s1.size() != s2.size())
            return false;

        for (int i = 0; i < s1.size(); i++) {

            if (!s1.get(i).equals(s2.get(i))) {
                return false;
            }
        }

        return true;
    }
    public static <T> boolean esit2(Stack<T> s1, Stack<T> s2) {
        // Metodun gövdesini yazınız
        //iki stack eşit mi kontrol et
        if(s1 == s2)
            return true;
        //iki stackten herhangi birisi mu kontorl et
        if(s1==null || s2==null)
            return false;
        //stacklerin boyutları eşit değil mi kontrol et
        if(s1.size() == s2.size())
            return false;
        //stack içindeki elemanları tek tek get() fonksiyonu ile eşit mi kontrol et
        for(int i = 0; i< s1.size(); i++){
            if(!s1.get(i).equals(s2.get(i))){
                return false;
            }
        }
        return true;
    }

    public static int postfixDegerlendir(String girdi) {
        // Metodun gövdesini yazınız
        Stack<Integer> s = new Stack<>();
        String[] g = splitToTokens(girdi);
        int d1, d2;
        for (String d : g) {
            switch (d) {
            case "+":
                d1 = s.pop();
                d2 = s.pop();
                s.push(d1 + d2);
                break;
            case "-":
                d1 = s.pop();
                d2 = s.pop();
                s.push(d2 - d1);
                break;
            case "*":
                d1 = s.pop();
                d2 = s.pop();
                s.push(d2 * d1);
                break;
            case "/":
                d1 = s.pop();
                d2 = s.pop();
                s.push(d2 / d1);
                break;
            default:
                s.push(Integer.parseInt(d));
                break;
            }
        }
        return s.pop();
    }
    public static int postfixDegerlendir2(String girdi) {
        // Metodun gövdesini yazınız
        // boş stack oluştur
        Stack<Integer>  s = new Stack<>();  
        //stacki karakterlerine ayır ve string dizisine ata
        String[] g = splitToTokens(girdi);
        //dizinin başındaki karaktere(işlem operatörüne göre) stackin sonundaki sayıları işleme sok
        int d1, d2;
        for(String d : g){
            switch(d){
                case "+":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d1+d2);
                break;
                case "-":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2-d1);
                case "*":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2*d1);
                    break;
                case "/":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2/d1);
                    break;
                default:
                    s.push(Integer.parseInt(d));
                    break;
            }
        }
        //stackin sonundaki elemanı döndür(işlemin sonuncu olmuş oluyor)
        return s.pop();
    }

    public static int precedence(char c) {
        switch (c) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String girdi)
    // Metodun gövdesini yazınız
    {
        //boş string oluştur
        String result = "";
        //karakter türünde boş stack oluştur
        Stack<Character> stack = new Stack<>();
        //girdideki karakterleri döngü ile seç
        for (int i = 0; i < girdi.length(); i++) {
            char c = girdi.charAt(i);

            // check if char is operator
            if (precedence(c) > 0) {
                while (stack.isEmpty() == false && precedence(stack.peek()) >= precedence(c)) {
                    result += stack.pop();
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result += x;
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                // character is neither operator nor (
                if (c != (' ')) {
                    result += c;
                }
            }
        }
        for (int i = 0; i <= stack.size(); i++) {
            result += stack.pop();
        }
        result = result.replaceAll(".", "$0 ");
        result = result.substring(0, result.length() - 1);
        return result;
    }

    private static String[] splitToTokens(String girdi) {
        StringTokenizer t = new StringTokenizer(girdi, "+-*/^() ", true);
        List<String> tokenList = new ArrayList<>();
        while (t.hasMoreTokens()) {
            String s = t.nextToken().trim();
            if (!s.equals(""))
                tokenList.add(s);
        }
        String[] tl = new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }

}