package de.doubleslash.techdays.helm.simplespringapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleDataEntityRepository extends JpaRepository<SimpleDataEntity, Long> {

}
