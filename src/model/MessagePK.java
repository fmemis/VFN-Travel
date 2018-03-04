package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the message database table.
 * 
 */
@Embeddable
public class MessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idmessage;

	@Column(name="client_username", insertable=false, updatable=false)
	private String clientUsername;

	@Column(name="provider_username", insertable=false, updatable=false)
	private String providerUsername;

	public MessagePK() {
	}
	public int getIdmessage() {
		return this.idmessage;
	}
	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}
	public String getClientUsername() {
		return this.clientUsername;
	}
	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}
	public String getProviderUsername() {
		return this.providerUsername;
	}
	public void setProviderUsername(String providerUsername) {
		this.providerUsername = providerUsername;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MessagePK)) {
			return false;
		}
		MessagePK castOther = (MessagePK)other;
		return 
			(this.idmessage == castOther.idmessage)
			&& this.clientUsername.equals(castOther.clientUsername)
			&& this.providerUsername.equals(castOther.providerUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idmessage;
		hash = hash * prime + this.clientUsername.hashCode();
		hash = hash * prime + this.providerUsername.hashCode();
		
		return hash;
	}
}