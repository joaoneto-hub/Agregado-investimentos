package joaoneto_hub.agregadorinvestimentos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joaoneto_hub.agregadorinvestimentos.controller.dto.CreatStockDto;

import joaoneto_hub.agregadorinvestimentos.service.StockeService;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {

  private StockeService stockService;

  public StockController(StockeService stockService) {
    this.stockService = stockService;
  }

  @PostMapping()
  public ResponseEntity<Void> createStock(
      @RequestBody CreatStockDto createStockDto) {

    stockService.createStock(createStockDto);
    return ResponseEntity.ok().build();
  }

}
