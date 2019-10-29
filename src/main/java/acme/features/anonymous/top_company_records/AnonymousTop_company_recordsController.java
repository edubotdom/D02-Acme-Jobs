
package acme.features.anonymous.top_company_records;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.company_records.Company_records;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/top_company_records/")
public class AnonymousTop_company_recordsController extends AbstractController<Anonymous, Company_records> {

	@Autowired
	private AnonymousTop_company_recordsListService	listService;

	@Autowired
	private AnonymousTop_company_recordsShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
