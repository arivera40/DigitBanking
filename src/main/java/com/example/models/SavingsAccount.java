package com.example.models;

import java.math.BigDecimal;
import java.util.Date;

public class SavingsAccount extends BankAccount {
    private int withdrawalCount;
    private Date creationDate;

    public SavingsAccount() {
        super();
        this.setWithdrawalCount(0);
        this.setCreationDate(null);
    }

    public SavingsAccount(int accountId, int userId, BigDecimal balance, int withdrawalCount, Date creationDate) {
        super(accountId, userId, balance);
        this.setWithdrawalCount(withdrawalCount);
        this.setCreationDate(creationDate);
    }

    /**
     * @return the withdrawalCount
     */
    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    /**
     * @param withdrawalCount the withdrawalCount to set
     */
    public void setWithdrawalCount(int withdrawalCount) {
        this.withdrawalCount = withdrawalCount;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}