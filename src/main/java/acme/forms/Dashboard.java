
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	// Serialization identifier -------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------

	Integer						totalNumberOfAnnouncements;
	Integer						totalNumberOfCompanyRecords;
	Integer						totalNumberOfInvestorRecords;
	//Reward
	Double						minimumReward;
	Double						maximumReward;
	Double						averageReward;
	Double						standardDesviationReward;
	//Offer
	Double						minimumOffer;
	Double						maximumOffer;
	Double						averageOffer;
	Double						standardDesviationOffer;

	// Derived attributes -------------------------------------------------

	// Relationships ------------------------------------------------------
}
