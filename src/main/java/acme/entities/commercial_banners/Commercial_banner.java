
package acme.entities.commercial_banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Commercial_banner extends DomainEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Atributos
	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@URL
	private String				url;

	@CreditCardNumber
	private String				credit_card;
}
