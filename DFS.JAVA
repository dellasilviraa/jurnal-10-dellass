import java.util.*;

public class DFS {

    public static Set<Character> dfs(HashMap<Character, Character[]> graph, char start) {
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            char node = stack.pop();

            for (char neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        HashMap<Character, Character[]> graph = new HashMap<>();
        graph.put('A', new Character[]{'B', 'C', 'D'});
        graph.put('B', new Character[]{'A', 'E'});
        graph.put('C', new Character[]{'A', 'F'});
        graph.put('D', new Character[]{'A', 'G'});
        graph.put('E', new Character[]{'B', 'H'});
        graph.put('F', new Character[]{'C', 'I'});
        graph.put('G', new Character[]{'D'});
        graph.put('H', new Character[]{'E'});
        graph.put('I', new Character[]{'F'});

        char start = 'A';
        Set<Character> visited = dfs(graph, start);
        System.out.println("DFS: " + visited);
    }
}
