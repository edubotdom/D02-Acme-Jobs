
package acme.features.administrator.charts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Chart;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorChartsShowService implements AbstractShowService<Administrator, Chart> {

	@Autowired
	private AdministratorChartsRepository repository;


	@Override
	public boolean authorise(final Request<Chart> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Chart> request, final Chart entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//		request.unbind(entity, model, "numCompBySector", "numInvestorBySector");
		request.unbind(entity, model, "sectorComp", "numComp", "sectorInv", "numInv");

	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		assert request != null;

		Chart result = new Chart();

		//		Map<String, Long> numCompBySector = new HashMap<String, Long>();
		List<String> sectorComp = new ArrayList<>();
		List<Long> numComp = new ArrayList<>();

		Collection<Object[]> a = this.repository.getNumCompBySector();
		for (Object[] ob : a) {
			//			numCompBySector.put((String) ob[1], (Long) ob[0]);
			sectorComp.add((String) ob[1]);
			numComp.add((Long) ob[0]);
		}
		//		result.setNumCompBySector(numCompBySector);
		result.setSectorComp(sectorComp);
		result.setNumComp(numComp);

		//		Map<String, Long> numInvestorBySector = new HashMap<String, Long>();

		List<String> sectorInv = new ArrayList<>();
		List<Long> numInv = new ArrayList<>();

		Collection<Object[]> b = this.repository.getNumInvestorBySector();
		for (Object[] ob : b) {
			//			numInvestorBySector.put((String) ob[1], (Long) ob[0]);
			sectorInv.add((String) ob[1]);
			numInv.add((Long) ob[0]);
		}
		//		result.setNumInvestorBySector(numInvestorBySector);
		result.setSectorInv(sectorInv);
		result.setNumInv(numInv);

		return result;
	}

}
