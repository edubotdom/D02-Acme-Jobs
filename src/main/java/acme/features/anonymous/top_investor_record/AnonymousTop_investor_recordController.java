
package acme.features.anonymous.top_investor_record;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investor_records.Investor_record;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/top_investor_record/")
public class AnonymousTop_investor_recordController extends AbstractController<Anonymous, Investor_record> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousTop_investorRecordListService	listService;

	@Autowired
	private AnonymousTop_investor_recordShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
