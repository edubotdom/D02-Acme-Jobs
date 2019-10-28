
package acme.features.authenticated.acme_request;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.acme_requests.Acme_request;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAcme_requestListService implements AbstractListService<Authenticated, Acme_request> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedAcme_requestRepository repository;


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

		request.unbind(entity, model, "title", "moment", "deadline", "reward");
	}

	@Override
	public Collection<Acme_request> findMany(final Request<Acme_request> request) {
		assert request != null;

		Collection<Acme_request> result;

		result = this.repository.findManyAll();
		return result;
	}
}
