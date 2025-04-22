/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admindtb;

import java.util.Date;

/**
 *
 * @author INDIA
 */
public class adminLoginTime {
    private String email_id;
    Date login;
    Date logout;

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public Date getLogout() {
        return logout;
    }

    public void setLogout(Date logout) {
        this.logout = logout;
    }
    

    public Date getLogin() {
        return login;
    }

    public void setLogin(Date Login) {
        this.login = Login;
    }
}
