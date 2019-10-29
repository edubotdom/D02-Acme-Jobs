
package acme.entities.investor_records;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Investor_record extends DomainEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Atributos
	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				investing_statement;

	@Range(min = 0, max = 5, message = "La puntuación debe de estar desde 0 a 5 estrellas")
	private Integer				stars;
}
