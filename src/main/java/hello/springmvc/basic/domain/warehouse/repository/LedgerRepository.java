package hello.springmvc.basic.domain.warehouse.repository;

import hello.springmvc.basic.domain.warehouse.entity.Ledger;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LedgerRepository extends JpaRepository<Ledger, String> {
    @Query("SELECT l FROM Ledger l WHERE l.contentYm = :contentYm AND l.warehouseId = :warehouseId AND l.ownerId = :ownerId")
    List<Ledger> findLedgerData(@Param("contentYm") String contentYm,
            @Param("warehouseId") String warehouseId,
            @Param("ownerId") String ownerId);
}
