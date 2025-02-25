package hello.springmvc.basic.domain.ticketing;
import java.util.LinkedList;
import java.util.Queue;

public class TicketingSystem {
    private static int currentNumber = 1; // 대기 번호를 부여할 초기값
    private static final Queue<Integer> waitingQueue = new LinkedList<>(); // 대기열

    // 새로운 사용자가 대기열에 추가될 때 대기번호를 부여하는 메소드
    public static void addCustomer() {
        waitingQueue.add(currentNumber);
        System.out.println("대기 번호: " + currentNumber + "번이 부여되었습니다.");
        currentNumber++;
    }

    // 대기열에서 사용자 처리하기
    public static void processNextCustomer() {
        if (waitingQueue.isEmpty()) {
            System.out.println("대기 중인 사용자가 없습니다.");
        } else {
            int nextCustomer = waitingQueue.poll(); // 대기열에서 맨 앞의 사용자 꺼내기
            System.out.println("대기 번호 " + nextCustomer + "번 사용자가 처리되었습니다.");
        }
    }

    // 현재 대기열 출력하기
    public static void printWaitingQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("현재 대기열이 비어 있습니다.");
        } else {
            System.out.println("현재 대기 중인 사용자 번호: " + waitingQueue);
        }
    }

    public static void main(String[] args) {
        // 대기열 테스트 예제
        addCustomer(); // 1번 대기번호
        addCustomer(); // 2번 대기번호
        addCustomer(); // 3번 대기번호

        printWaitingQueue(); // 현재 대기열 확인

        processNextCustomer(); // 첫 번째 사용자 처리
        printWaitingQueue();   // 처리 후 대기열 확인

        processNextCustomer(); // 두 번째 사용자 처리
        processNextCustomer(); // 세 번째 사용자 처리
        processNextCustomer(); // 대기열 비어있을 때 처리

        printWaitingQueue(); // 최종 대기열 확인
    }
}

