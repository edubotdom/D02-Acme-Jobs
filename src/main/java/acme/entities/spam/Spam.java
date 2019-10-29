
package acme.entities.spam;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spam_words;

	@NotNull
	@Range(min = 0, max = 100, message = "spam_threshold is a percentage, number must be in range 0-100")
	private Double				spam_threshold;

	@NotBlank
	private String				lang;
}
