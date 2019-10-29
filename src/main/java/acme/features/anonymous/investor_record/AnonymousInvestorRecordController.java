
package acme.features.anonymous.investor_record;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investor_records.Investor_record;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/investor_record/")
public class AnonymousInvestorRecordController extends AbstractController<Anonymous, Investor_record> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousInvestorRecordListService	listService;

	@Autowired
	private AnonymousInvestorRecordShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
