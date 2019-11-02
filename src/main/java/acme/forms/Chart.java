
package acme.forms;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chart implements Serializable {

	private static final long	serialVersionUID	= 1L;

	//	Map<String, Long>			numCompBySector;
	List<String>				sectorComp;
	List<Long>					numComp;

	//	Map<String, Long>			numInvestorBySector;
	List<String>				sectorInv;
	List<Long>					numInv;

}
