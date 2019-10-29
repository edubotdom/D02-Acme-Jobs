
package acme.features.anonymous.top_company_records;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.company_records.Company_records;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTop_company_recordsRepository extends AbstractRepository {

	@Query("select a from Company_records a where a.id = ?1")
	Company_records findOneById(int id);

	@Query("select a from Company_records a where a.stars=5")
	Collection<Company_records> findManyAll();

}
