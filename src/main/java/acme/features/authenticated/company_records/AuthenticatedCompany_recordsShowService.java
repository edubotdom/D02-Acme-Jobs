
package acme.features.authenticated.company_records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.company_records.Company_records;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedCompany_recordsShowService implements AbstractShowService<Authenticated, Company_records> {

	@Autowired
	private AuthenticatedCompany_recordsRepository repository;


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
		request.unbind(entity, model, "company_name", "sector", "ceo_name", "activities", "website", "contact_phone", "contact_email", "stars");
	}

	@Override
	public Company_records findOne(final Request<Company_records> request) {
		assert request != null;

		Company_records result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}