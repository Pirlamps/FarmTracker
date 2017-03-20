package br.com.pirlamps.farmtracker.foundation.model;

/**
 * Created by root-matheus on 20/03/17.
 */

public class UserVO {

    private String email;
    private String uuid;

    public UserVO() {
    }

    public UserVO(String email, String uuid) {
        this.email = email;
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
