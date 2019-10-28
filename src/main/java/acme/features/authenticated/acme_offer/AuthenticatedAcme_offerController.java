
package acme.features.authenticated.acme_offer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.acme_offers.Acme_offer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/acme_offer/")
public class AuthenticatedAcme_offerController extends AbstractController<Authenticated, Acme_offer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedAcme_offerListService	listService;

	@Autowired
	private AuthenticatedAcme_offerShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
