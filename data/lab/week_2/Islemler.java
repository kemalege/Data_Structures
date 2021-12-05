import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        //Metodun gövdesini yazınız
        Stack<T> st = (Stack<T>) s.clone();
        Stack<T> r= new Stack<>();
        while(!st.isEmpty())
            r.push(st.pop());

        return r;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2){
        //Metodun gövdesini yazınız
        if (s1 == s2) return true;

        if (s1 == null || s2 == null) return false;

        if (s1.size() != s2.size()) return false;

        for(int i=0; i < s1.size(); i++){

            if(!s1.get(i).equals(s2.get(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        //Metodun gövdesini yazınız
        Stack<Integer> s = new Stack<>();
        String[] g = splitToTokens(girdi);
        int d1, d2;
        for(String d:g){
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
                    break;
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
        return s.pop();
    }
    public static int precedence(char c){
        switch (c){
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
    /* This function returns associated precedence to an operator */
    public static String infixToPostfix(String girdi)
    //Metodun gövdesini yazınız
    {

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <girdi.length(); i++) {
            char c = girdi.charAt(i);

            //check if char is operator
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor (
                if(c!=(' ')){
                    result += c;

                }

            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        result = result.replaceAll(".", "$0 ");
        result = result.substring(0, result.length() - 1);
        return result;

    }

    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }

}