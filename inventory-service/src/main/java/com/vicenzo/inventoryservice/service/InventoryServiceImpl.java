package com.vicenzo.inventoryservice.service;

import com.vicenzo.inventoryservice.dto.InventoryResponse;
import com.vicenzo.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class InventoryServiceImpl implements InventoryService{

    /*
     *  @SneakyThrows consumes the exception, do not se this in production code.
     * */

    private  final InventoryRepository inventoryRepository;
    @Override
    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode)  {
//        log.info("Wait Started");
//        Thread.sleep(10000);
//        log.info("Wait Ended");

        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() >0)
                            .build()
                ).toList();
    }
}
