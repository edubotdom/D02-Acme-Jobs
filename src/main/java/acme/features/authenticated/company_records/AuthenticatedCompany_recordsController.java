
package acme.features.authenticated.company_records;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.company_records.Company_records;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/company_records/")
public class AuthenticatedCompany_recordsController extends AbstractController<Authenticated, Company_records> {

	@Autowired
	private AuthenticatedCompany_recordsListService	listService;

	@Autowired
	private AuthenticatedCompany_recordsShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
