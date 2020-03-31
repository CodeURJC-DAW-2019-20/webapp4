package es.urjc.daw.urjc_share.component;

import es.urjc.daw.urjc_share.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserComponent {

    private User entityUser;

    public User getEntityUser() {
        return entityUser;
    }

    public void setEntityUser(User entityUser) {
        this.entityUser = entityUser;
    }
    
    public boolean isEntityUser() {
    	return this.entityUser != null;
    }
    public User getLoggedUser() {
		return this.entityUser;
	}

	public void setLoggedUser(User user) {
		this.entityUser = user;
	}

	public boolean isLoggedUser() {
		return this.entityUser != null;
	}
}
