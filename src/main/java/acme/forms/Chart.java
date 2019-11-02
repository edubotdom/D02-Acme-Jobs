
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chart implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Map<String, Long>			numCompBySector;
	Map<String, Long>			numInvestorBySector;

}
