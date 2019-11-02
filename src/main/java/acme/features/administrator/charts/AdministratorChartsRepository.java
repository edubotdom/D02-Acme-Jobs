
package acme.features.administrator.charts;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartsRepository extends AbstractRepository {

	@Query("select count(cr), cr.sector from Company_records cr group by cr.sector")
	Collection<Object[]> getNumCompBySector();

	@Query("select count(ir), ir.sector from Investor_record ir group by ir.sector")
	Collection<Object[]> getNumInvestorBySector();
}
