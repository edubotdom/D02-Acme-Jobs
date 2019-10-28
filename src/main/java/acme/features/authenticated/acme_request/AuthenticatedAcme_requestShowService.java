
package acme.features.authenticated.acme_request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.acme_requests.Acme_request;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAcme_requestShowService implements AbstractShowService<Authenticated, Acme_request> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedAcme_requestRepository repository;


	@Override
	public boolean authorise(final Request<Acme_request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Acme_request> request, final Acme_request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "moment", "deadline", "text", "reward");
	}

	@Override
	public Acme_request findOne(final Request<Acme_request> request) {
		assert request != null;

		Acme_request result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
