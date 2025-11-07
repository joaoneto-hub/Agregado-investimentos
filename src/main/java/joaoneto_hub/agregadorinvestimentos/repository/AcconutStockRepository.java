package joaoneto_hub.agregadorinvestimentos.repository;

import joaoneto_hub.agregadorinvestimentos.entity.AccountStock;
import joaoneto_hub.agregadorinvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcconutStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
