package hello.springmvc.basic.domain.warehouse.service;

import hello.springmvc.basic.domain.warehouse.dto.InventoryDTO;
import hello.springmvc.basic.domain.warehouse.entity.Item;
import hello.springmvc.basic.domain.warehouse.entity.Ledger;
import hello.springmvc.basic.domain.warehouse.repository.ItemRepository;
import hello.springmvc.basic.domain.warehouse.repository.LedgerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final LedgerRepository ledgerRepository;

    private final ItemRepository itemRepository;

    private final EntityManager entityManager;

    // 해당 메소드가 전체 프로세스를 조정
/*    public List<InventoryDTO> getInventoryData(String contentYm, String warehouseId,
            String ownerId) {
        List<Ledger> ledgers = ledgerRepository.findLedgerData(contentYm, warehouseId, ownerId);
        List<String> ownerItemIds = ledgers.stream().map(Ledger::getOwnerItemId)
                .collect(Collectors.toList());
        List<Item> items = itemRepository.findByOwnerItemIdIn(ownerItemIds);

        // 이전 달 데이터 계산
        String prevMonth = calculatePreviousMonth(contentYm);
        List prevMonthData = getPrevMonthData(prevMonth, warehouseId, ownerId);

        // COMBINED_DATA 계산 (Native Query 사용)
        List<Object[]> combinedData = getCombinedData(contentYm, warehouseId, ownerId);

        // 최종 결과 계산
        return calculateFinalResult(ledgers, items, prevMonthData, combinedData);
    }

    private List getPrevMonthData(String prevMonth, String warehouseId, String ownerId) {
        String sql = "SELECT OWNER_ITEM_ID, WAREHOUSE_ID, SUM(QTY) FROM TLEDGER " +
                "WHERE CONTENT_YM = ?1 " // 인덱스 기반 파라미터
                + "AND WAREHOUSE_ID = ?2 "
                + "AND OWNER_ID = ?3 "
                + "GROUP BY OWNER_ITEM_ID, WAREHOUSE_ID";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, prevMonth);   // 1번째 파라미터
        query.setParameter(2, warehouseId); // 2번째 파라미터
        query.setParameter(3, ownerId);     // 3번째 파라미터
        return query.getResultList();
    }



    private List getCombinedData(String contentYm, String warehouseId, String ownerId) {
        // COMBINED_DATA 쿼리 구현 (Native SQL) 복잡한 서브쿼리를 이렇게 네이티브 쿼리로 처리해야함
        String sql = "... (COMBINED_DATA 쿼리 내용) ...";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("contentYm", contentYm);
        query.setParameter("warehouseId", warehouseId);
        query.setParameter("ownerId", ownerId);
        return query.getResultList();
    }

    private List<InventoryDTO> calculateFinalResult(List<Ledger> ledgers, List<Item> items,
            List<Object[]> prevMonthData, List<Object[]> combinedData) {
        // 최종 결과 계산 로직 구현
        // ...
        return new ArrayList<>();
    }

    private String calculatePreviousMonth(String contentYm) {
        // contentYm에서 이전 달 계산 로직
        // ...
        return "success";
    }*/
}