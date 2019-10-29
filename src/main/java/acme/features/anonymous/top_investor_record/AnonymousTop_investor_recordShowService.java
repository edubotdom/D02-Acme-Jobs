
package acme.features.anonymous.top_investor_record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investor_records.Investor_record;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousTop_investor_recordShowService implements AbstractShowService<Anonymous, Investor_record> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousTop_investor_recordRepository repository;


	// AbstractShowService<Administrator, Announcement>interface --------------
	@Override
	public boolean authorise(final Request<Investor_record> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Investor_record> request, final Investor_record entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "investing_statement", "stars");
	}

	@Override
	public Investor_record findOne(final Request<Investor_record> request) {
		assert request != null;

		Investor_record result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
