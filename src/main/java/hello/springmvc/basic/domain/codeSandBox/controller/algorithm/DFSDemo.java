package hello.springmvc.basic.domain.codeSandBox.controller.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DFSDemo {
        private final Map<Integer, List<Integer>> graph;

        public DFSDemo() {
            graph = new HashMap<>();
        }

        // 그래프에 간선 추가
        public void addEdge(int source, int destination) {
            graph.putIfAbsent(source, new ArrayList<>());
            graph.putIfAbsent(destination, new ArrayList<>());
            graph.get(source).add(destination);
            graph.get(destination).add(source); // 무향 그래프
        }

        // DFS 탐색 메서드
        public void dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            dfsUtil(start, visited);
        }

        // 재귀적으로 DFS 수행
        private void dfsUtil(int vertex, Set<Integer> visited) {
            visited.add(vertex);
            log.error("{} ", vertex);

            for (int neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    dfsUtil(neighbor, visited);
                }
            }
        }

        public static void main(String[] args) {
            DFSDemo dfsDemo = new DFSDemo();

            // 그래프에 간선 추가
            dfsDemo.addEdge(1, 2);
            dfsDemo.addEdge(1, 3);
            dfsDemo.addEdge(2, 4);
            dfsDemo.addEdge(2, 5);
            dfsDemo.addEdge(3, 6);
            dfsDemo.addEdge(3, 7);

            System.out.println("DFS 탐색 결과:");
            dfsDemo.dfs(1); // 시작 정점: 1
        }
    }