package joaoneto_hub.agregadorinvestimentos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joaoneto_hub.agregadorinvestimentos.controller.dto.AssocieteAccountStockDto;
import joaoneto_hub.agregadorinvestimentos.service.AccountService;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/{stockId}/stocks")
  public ResponseEntity<Void> associeteStock(@PathVariable("stockId") String stockId,
      @RequestBody AssocieteAccountStockDto dto) {
    accountService.associateStock(stockId, dto);
    return ResponseEntity.ok().build();
  }
}
