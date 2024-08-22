package org.example.interviewmanagement.repositories;

import org.example.interviewmanagement.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
