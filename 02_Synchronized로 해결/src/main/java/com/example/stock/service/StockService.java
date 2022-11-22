package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    /*
     * synchronized를 메서드 선언부에 붙여줌
     * → 해당 메서드에 한 개의 thread만 접근 가능
     * But. Test 실패
     * @Transactional → 해당 메서드를 갖는 클래스를 새로 만들어서 실행
     * 따라서 @Transactional 을 주석처리 해야 함
     */
    @Transactional
    public synchronized void decrease(Long id, Long quantity){
        Stock stock = stockRepository.findById(id).orElseThrow();

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
