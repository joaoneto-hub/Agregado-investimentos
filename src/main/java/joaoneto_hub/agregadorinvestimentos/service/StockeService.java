package joaoneto_hub.agregadorinvestimentos.service;

import org.springframework.stereotype.Service;

import joaoneto_hub.agregadorinvestimentos.controller.dto.CreatStockDto;
import joaoneto_hub.agregadorinvestimentos.entity.Stock;
import joaoneto_hub.agregadorinvestimentos.repository.StocktRepository;

@Service
public class StockeService {
  private StocktRepository stockRepository;

  public StockeService(StocktRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public void createStock(CreatStockDto createStockDto) {
    if (createStockDto.stockId() == null || createStockDto.stockId().trim().isEmpty()) {
      throw new IllegalArgumentException("stockId não pode ser nulo ou vazio");
    }
    var stock = new Stock(createStockDto.stockId(), createStockDto.description());
    stockRepository.save(stock);
  }
}
