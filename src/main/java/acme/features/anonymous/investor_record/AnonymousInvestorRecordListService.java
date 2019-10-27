
package acme.features.anonymous.investor_record;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investor_records.Investor_record;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousInvestorRecordListService implements AbstractListService<Anonymous, Investor_record> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousInvestorRecordRepository repository;


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
	public Collection<Investor_record> findMany(final Request<Investor_record> request) {
		assert request != null;

		Collection<Investor_record> result;

		result = this.repository.findManyAll();
		return result;
	}
}
