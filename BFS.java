import java.util.*;

public class BFS {

    public static Set<Character> bfs(HashMap<Character, Character[]> graph, char start) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            char node = queue.poll();

            for (char neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
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
        Set<Character> visited = bfs(graph, start);
        System.out.println("BFS: " + visited);
    }
}
