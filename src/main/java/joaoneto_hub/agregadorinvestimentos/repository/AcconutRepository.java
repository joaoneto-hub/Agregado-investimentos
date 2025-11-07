package joaoneto_hub.agregadorinvestimentos.repository;

import joaoneto_hub.agregadorinvestimentos.entity.Account;
import joaoneto_hub.agregadorinvestimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcconutRepository extends JpaRepository<Account, UUID> {
}
