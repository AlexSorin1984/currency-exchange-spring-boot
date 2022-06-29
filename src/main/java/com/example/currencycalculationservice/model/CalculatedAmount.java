package com.example.currencycalculationservice.model;

import java.math.BigDecimal;

public class CalculatedAmount {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal TotalCalculatedAmount;
    private int port;

    public CalculatedAmount() {
    }

    public CalculatedAmount(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.TotalCalculatedAmount = totalCalculatedAmount;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return TotalCalculatedAmount;
    }

    public int getPort() {
        return port;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        TotalCalculatedAmount = totalCalculatedAmount;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "CalculatedAmount{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", quantity=" + quantity +
                ", TotalCalculatedAmount=" + TotalCalculatedAmount +
                ", port=" + port +
                '}';
    }
}
