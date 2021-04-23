package io.kentec.CoreBanking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameters {
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("account")
    private String account;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("msisdn")
    private String msisdn;

    public Parameters() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "currency='" + currency + '\'' +
                ", account='" + account + '\'' +
                ", amount='" + amount + '\'' +
                ", msisdn='" + msisdn + '\'' +
                '}';
    }
}
