package edu.pnu.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.DBoard;

public interface Boardrepository extends CrudRepository<DBoard, Long> {

}
