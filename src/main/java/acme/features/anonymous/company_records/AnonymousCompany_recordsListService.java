
package acme.features.anonymous.company_records;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.company_records.Company_records;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousCompany_recordsListService implements AbstractListService<Anonymous, Company_records> {

	@Autowired
	AnonymousCompany_recordsRepository repository;


	@Override
	public boolean authorise(final Request<Company_records> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Company_records> request, final Company_records entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "company_name", "sector", "website");
	}

	@Override
	public Collection<Company_records> findMany(final Request<Company_records> request) {
		assert request != null;
		Collection<Company_records> result;
		result = this.repository.findManyAll();
		return result;
	}

}
