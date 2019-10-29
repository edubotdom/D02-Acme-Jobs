
package acme.features.anonymous.company_records;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.company_records.Company_records;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/company_records/")
public class AnonymousCompany_recordsController extends AbstractController<Anonymous, Company_records> {

	@Autowired
	private AnonymousCompany_recordsListService	listService;

	@Autowired
	private AnonymousCompany_recordsShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
