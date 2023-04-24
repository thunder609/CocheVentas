package com.project.coches.projectcoche.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
/*
 *Dto de la consulta   de una compra
 */
public class PurchaseResponseDto {
    private Integer numberBill;
    private String cardIdCustomer;
    private LocalDateTime date;
    private Double total;
    private String paymentMethod;
   private List<CarPurchaseResponseDto> carsPurchase;
}
