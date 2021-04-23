package io.kentec.CoreBanking.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.kentec.CoreBanking.model.Parameters;

import java.io.Serializable;

public class TransactionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("action")
    private String action;
    @JsonProperty("parameters")
    private Parameters parameters;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;

    public TransactionRequest() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "action='" + action + '\'' +
                ", parameters=" + parameters +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
