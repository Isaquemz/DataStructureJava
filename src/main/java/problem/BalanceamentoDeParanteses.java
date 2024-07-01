package problem;

import java.util.Set;
import java.util.Stack;

public class BalanceamentoDeParanteses {

    public static boolean solve (String expression) {
        Set<Character> openSymbols = Set.of('(', '{', '[');
        Set<Character> closeSymbols = Set.of(')', '}', ']');
        Stack<Character> stack = new Stack<>();

        for (char c: expression.toCharArray()) {
            // Se é um caracter de abertura, adiciona na lista
            if (openSymbols.contains(c)) stack.push(c);

            // Se é um caracter de fechamento...
            if (closeSymbols.contains(c)) {

                // Se lista vazia retorna falso pois
                // fechou sem ter adicionado abertura na lista.
                if (stack.isEmpty()) return false;

                // Se não, busca qual o ultimo caracter de abertura
                // que esta presente na lista e verifica se é condizente
                // com o caracter atual.
                var open = stack.pop();
                if (
                    (open == '(' && c != ')') ||
                    (open == '[' && c != ']') ||
                    (open == '{' && c != '}')
                ) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solve("2*(3+4+5*[2+3)]"));
        System.out.println(solve("[2*(3+4+5*[2+3]/(2+(3+(7+5)*9)*6)*[5+8]+17)+2]"));
    }

}
