package hello.springmvc.basic.domain.codeSandBox.controller.algorithm;

import java.util.*;

public class BFSDemo {
    private final Map<Integer, List<Integer>> graph;

    public BFSDemo() {
        graph = new HashMap<>();
    }

    // 그래프에 간선 추가
    public void addEdge(int source, int destination) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());
        graph.get(source).add(destination);
        graph.get(destination).add(source); // 무향 그래프
    }

    // BFS 탐색 메서드
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSDemo bfsDemo = new BFSDemo();

        // 그래프에 간선 추가
        bfsDemo.addEdge(1, 2);
        bfsDemo.addEdge(1, 3);
        bfsDemo.addEdge(2, 4);
        bfsDemo.addEdge(2, 5);
        bfsDemo.addEdge(3, 6);
        bfsDemo.addEdge(3, 7);

        System.out.println("BFS 탐색 결과:");
        bfsDemo.bfs(1); // 시작 정점: 1
    }
}
