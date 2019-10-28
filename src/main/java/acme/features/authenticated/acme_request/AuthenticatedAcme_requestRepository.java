/*
 * AuthenticatedAcmeRequestRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.acme_request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.acme_requests.Acme_request;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAcme_requestRepository extends AbstractRepository {

	@Query("select ac from Acme_request ac where ac.id = ?1")
	Acme_request findOneById(int id);

	@Query("select ac from Acme_request ac")
	Collection<Acme_request> findManyAll();

}
