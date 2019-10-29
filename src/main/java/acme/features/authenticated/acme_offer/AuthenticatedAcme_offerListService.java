
package acme.features.authenticated.acme_offer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.acme_offers.Acme_offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAcme_offerListService implements AbstractListService<Authenticated, Acme_offer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedAcme_offerRepository repository;


	@Override
	public boolean authorise(final Request<Acme_offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Acme_offer> request, final Acme_offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline");
	}

	@Override
	public Collection<Acme_offer> findMany(final Request<Acme_offer> request) {
		assert request != null;

		Collection<Acme_offer> result;

		result = this.repository.findManyAll();
		return result;
	}
}
