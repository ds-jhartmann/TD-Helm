package de.doubleslash.techdays.helm.simplespringapp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleDataService {
    private final SimpleDataEntityRepository entityRepository;

    public List<SimpleDataEntity> findAll() {
        return entityRepository.findAll();
    }

    public SimpleDataEntity findById(Long id) {
        return entityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public SimpleDataEntity save(SimpleDataEntity entity) {
        return entityRepository.save(entity);
    }
}
