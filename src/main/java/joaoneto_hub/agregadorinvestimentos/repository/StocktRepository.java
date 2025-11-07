package joaoneto_hub.agregadorinvestimentos.repository;

import joaoneto_hub.agregadorinvestimentos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocktRepository extends JpaRepository<Stock, String> {

}
