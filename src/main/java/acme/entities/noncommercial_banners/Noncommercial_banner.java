
package acme.entities.noncommercial_banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Noncommercial_banner extends DomainEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Atributos
	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@URL
	private String				url;

	@URL
	private String				jingle;
}
