
package acme.features.authenticated.acme_offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.acme_offers.Acme_offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAcme_offerShowService implements AbstractShowService<Authenticated, Acme_offer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedAcme_offerRepository repository;


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

		request.unbind(entity, model, "ticker", "title", "moment", "deadline", "text", "min", "max");
	}

	@Override
	public Acme_offer findOne(final Request<Acme_offer> request) {
		assert request != null;

		Acme_offer result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
