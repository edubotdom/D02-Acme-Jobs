
package acme.entities.commercial_banners;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.entities.banners.Banner;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Commercial_banner extends Banner {

	// Serialisation identifier
	private static final long serialVersionUID = 1L;

	// Atributos

	@CreditCardNumber
	private String credit_card;
}
