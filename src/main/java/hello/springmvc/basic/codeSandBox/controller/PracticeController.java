package hello.springmvc.basic.codeSandBox.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeController {

    public static int solution(int k, int[] tangerine) {
        // 귤 크기별 빈도를 계산합니다.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int size : tangerine) {
            frequencyMap.put(size, frequencyMap.getOrDefault(size, 0) + 1);
        }

        // 빈도를 리스트로 변환하여 빈도가 높은 순서대로 정렬합니다.
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        frequencies.sort(Collections.reverseOrder());

        // 귤의 종류 수와 선택한 귤 개수를 추적할 변수를 초기화합니다.
        int varietyCount = 0;
        int selectedCount = 0;

        // 빈도가 높은 귤부터 선택하여 k개를 채웁니다.
        for (int freq : frequencies) {
            selectedCount += freq;
            varietyCount++;
            if (selectedCount >= k) {
                break;
            }
        }
        return varietyCount;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int result = solution(k, tangerine);
        System.out.println(result);  // 예상 결과: 2
    }

    /*
     * 4	[1, 3, 2, 5, 4, 5, 2, 3]	2
     * 2	[1, 1, 1, 1, 2, 2, 2, 3]	1
     */
}

