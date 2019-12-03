package cn.net.immortal.user.dal.entity;

public class Account {
    private Long id;

    private String account;

    private String password;

    private Integer validate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getValidate() {
        return validate;
    }

    public void setValidate(Integer validate) {
        this.validate = validate;
    }
}