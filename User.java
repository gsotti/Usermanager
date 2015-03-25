/**
 * User.java 1.0 Copyright Stefan Gsottbauer © 2015. all rights reserved
 *
 * @author: Stefan Gsottbauer
 */

import android.util.Log;
import org.ksoap2.serialization.SoapObject;
import java.util.HashMap;

public class User {

    private boolean accepted;
    private String hmac;
    private int id;
    private String login_message;
    private HashMap<String, Integer> roles;

    public static User parseSOAPResponse(SoapObject object) {
        
        User user = new User();

        SoapObject return_obj = (SoapObject) object.getProperty("return");

        user.setAccepted((boolean) return_obj.getProperty("accepted"));
        user.setHmac((String) return_obj.getProperty("hmac"));
        user.setId((int) return_obj.getProperty("idUser"));
        user.setLogin_message((String) return_obj.getProperty("message"));

        SoapObject roles_obj = (SoapObject) return_obj.getProperty("roles");
        roles_obj = (SoapObject) roles_obj.getProperty("roles");

        HashMap<String, Integer> roles = new HashMap<>();

        for(int i = 0; i<roles_obj.getPropertyCount();i++)
        {
            SoapObject item = (SoapObject) roles_obj.getProperty(i);
            roles.put((String) item.getProperty("name"), (Integer)item.getProperty("rank"));
        }

        user.setRoles(roles);

        return user;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getHmac() {
        return hmac;
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_message() {
        return login_message;
    }

    public void setLogin_message(String login_message) {
        this.login_message = login_message;
    }

    public HashMap<String, Integer> getRoles() {
        return roles;
    }

    public void setRoles(HashMap<String, Integer> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "accepted=" + accepted +
                ", hmac='" + hmac + '\'' +
                ", id='" + id + '\'' +
                ", login_message='" + login_message + '\'' +
                ", roles=" + roles +
                '}';
    }
}
