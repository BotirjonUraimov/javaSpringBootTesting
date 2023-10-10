package com.clean.code.springboot.model;

public class Transaction {

    private Long id;
    private Double amount;
    private String reasons;
    private  long userId;

//    public Transaction(Double amount, String reasons, long userId) {
//        this.amount = amount;
//        this.reasons = reasons;
//        this.userId = userId;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
