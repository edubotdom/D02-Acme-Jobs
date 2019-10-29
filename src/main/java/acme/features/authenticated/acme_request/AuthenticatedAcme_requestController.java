
package acme.features.authenticated.acme_request;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.acme_requests.Acme_request;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/acme_request/")
public class AuthenticatedAcme_requestController extends AbstractController<Authenticated, Acme_request> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedAcme_requestListService	listService;

	@Autowired
	private AuthenticatedAcme_requestShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
