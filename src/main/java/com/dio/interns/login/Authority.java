package com.dio.interns.login;

import java.io.Serializable;

public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String username;
    private String authority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
