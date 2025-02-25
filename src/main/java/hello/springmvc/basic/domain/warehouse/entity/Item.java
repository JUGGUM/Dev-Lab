package hello.springmvc.basic.domain.warehouse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VITEM")
public class Item {
    @Id
    @Column(name = "OWNER_ITEM_ID")
    private String ownerItemId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_TEMP")
    private String itemTemp;

    @Column(name = "OUT_UNIT")
    private String outUnit;

    @Column(name = "USE_YN")
    private String useYn;

    // getters and setters
}

