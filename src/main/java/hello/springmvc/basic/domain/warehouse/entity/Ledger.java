package hello.springmvc.basic.domain.warehouse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 엔티티 정의
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TLEDGER")
public class Ledger {
    @Id
    @Column(name = "OWNER_ITEM_ID")
    private String ownerItemId;

    @Column(name = "WAREHOUSE_ID")
    private String warehouseId;

    @Column(name = "OWNER_ID")
    private String ownerId;

    @Column(name = "CONTENT_YM")
    private String contentYm;

    @Column(name = "QTY")
    private BigDecimal qty;

    @Column(name = "DESCRIPTION")
    private String description;

    // getters and setters
}

