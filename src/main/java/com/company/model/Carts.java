package com.company.model;

import java.time.LocalDateTime;

public class Carts {
    private int id;
    private Account account;
    private BusinessProduct businessProduct;
    private LocalDateTime addedAt;
    private boolean process;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BusinessProduct getBusinessProduct() {
        return businessProduct;
    }

    public void setBusinessProduct(BusinessProduct businessProduct) {
        this.businessProduct = businessProduct;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public boolean isProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }
}
