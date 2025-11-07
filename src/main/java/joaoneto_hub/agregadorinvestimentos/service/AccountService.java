package joaoneto_hub.agregadorinvestimentos.service;

import java.lang.module.ResolutionException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import joaoneto_hub.agregadorinvestimentos.controller.dto.AssocieteAccountStockDto;
import joaoneto_hub.agregadorinvestimentos.entity.AccountStock;
import joaoneto_hub.agregadorinvestimentos.entity.AccountStockId;
import joaoneto_hub.agregadorinvestimentos.repository.AcconutRepository;
import joaoneto_hub.agregadorinvestimentos.repository.AcconutStockRepository;
import joaoneto_hub.agregadorinvestimentos.repository.StocktRepository;

@Service
public class AccountService {

  private final AcconutStockRepository acconutStockRepository;
  private AcconutRepository accountRepository;

  private StocktRepository stockRepository;

  public AccountService(AcconutRepository accountRepository, StocktRepository stockRepository,
      AcconutStockRepository acconutStockRepository) {
    this.accountRepository = accountRepository;
    this.stockRepository = stockRepository;
    this.acconutStockRepository = acconutStockRepository;
  }

  public void associateStock(String accountId, AssocieteAccountStockDto dto) {
    var account = accountRepository.findById(UUID.fromString(accountId))
        .orElseThrow(() -> new ResolutionException("Account not found"));
    var stock = stockRepository.findById(dto.stockId())
        .orElseThrow(() -> new ResolutionException("Stock not found"));

    var id = new AccountStockId(account.getAccountId(), stock.getStockId());

    var accountStock = new AccountStock(id, dto.quantity(), stock, account);
    acconutStockRepository.save(accountStock);

  }
}
