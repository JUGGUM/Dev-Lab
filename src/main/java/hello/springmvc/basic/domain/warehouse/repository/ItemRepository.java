package hello.springmvc.basic.domain.warehouse.repository;

import hello.springmvc.basic.domain.warehouse.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findByOwnerItemIdIn(List<String> ownerItemIds);
}
