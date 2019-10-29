
package acme.entities.company_records;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company_records extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	// if Incorporated -> + "Inc", else -> + "LLC"
	@NotBlank
	private String				company_name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceo_name;

	@NotBlank
	private String				activities;

	@NotBlank
	private String				website;

	// Example of regular exp: +999 (9999) 99999999
	@NotBlank
	@Pattern(regexp = "[+][0-9]{3}[ ][(][0-9]{4}[)][ ][0-9]{6,10}")
	private String				contact_phone;

	@NotBlank
	@Email
	private String				contact_email;

	@Range(min = 1, max = 5, message = "The stars must be in range 1 to 5")
	@Digits(integer = 1, fraction = 1, message = "Stars must contain only one integer and one decimal number")
	private Double				stars;

}
