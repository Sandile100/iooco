package za.co.ioco.survivor.infrastructure.repository;

import za.co.ioco.survivor.domain.model.Survivor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long>
{
}
