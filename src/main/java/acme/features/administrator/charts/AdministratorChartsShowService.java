
package acme.features.administrator.charts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

		request.unbind(entity, model, "numCompBySector", "numInvestorBySector");
	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		assert request != null;

		Chart result = new Chart();
		Map<String, Long> numCompBySector = new HashMap<String, Long>();
		Collection<Object[]> a = this.repository.getNumCompBySector();
		for (Object[] ob : a) {
			numCompBySector.put((String) ob[1], (Long) ob[0]);
		}

		result.setNumCompBySector(numCompBySector);

		Map<String, Long> numInvestorBySector = new HashMap<String, Long>();
		Collection<Object[]> b = this.repository.getNumInvestorBySector();
		for (Object[] ob : b) {
			numInvestorBySector.put((String) ob[1], (Long) ob[0]);
		}
		result.setNumInvestorBySector(numInvestorBySector);
		return result;
	}

}
