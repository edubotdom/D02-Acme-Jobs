
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorDashboardRepository repository;


	// AbstractShowService<Administrator, Announcement>interface --------------
	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfAnnouncements", "totalNumberOfCompanyRecords", "totalNumberOfInvestorRecords", "minimumReward", "maximumReward", "averageReward", "standardDesviationReward", "minimumOffer", "maximumOffer",
			"averageOffer", "standardDesviationOffer", "companySectors", "numberCompanys", "investorSectors", "numberInvestors");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		result.setTotalNumberOfAnnouncements(this.repository.countAnnouncements());
		result.setTotalNumberOfCompanyRecords(this.repository.countCompanyRecords());
		result.setTotalNumberOfInvestorRecords(this.repository.countInvestorRecords());
		//Reward
		result.setMinimumReward(this.repository.minimumReward());
		result.setMaximumReward(this.repository.maximumReward());
		result.setAverageReward(this.repository.averageReward());
		result.setStandardDesviationReward(this.repository.standardDesviationReward());
		//Offer
		result.setMinimumOffer(this.repository.minimumOffer());
		result.setMaximumOffer(this.repository.maximumOffer());
		result.setAverageOffer(this.repository.averageOffer());
		result.setStandardDesviationOffer(this.repository.standardDesviationOffer());

		//		Chart's atts

		List<String> sectorComp = new ArrayList<>();
		List<Long> numComp = new ArrayList<>();

		Collection<Object[]> a = this.repository.getNumCompBySector();
		for (Object[] ob : a) {
			sectorComp.add((String) ob[1]);
			numComp.add((Long) ob[0]);
		}

		result.setCompanySectors(sectorComp);
		result.setNumberCompanys(numComp);

		List<String> sectorInv = new ArrayList<>();
		List<Long> numInv = new ArrayList<>();

		Collection<Object[]> b = this.repository.getNumInvestorBySector();
		for (Object[] ob : b) {
			sectorInv.add((String) ob[1]);
			numInv.add((Long) ob[0]);
		}

		result.setInvestorSectors(sectorInv);
		result.setNumberInvestors(numInv);

		return result;
	}

}
