package healthcare.workout.service;

import healthcare.workout.domain.MuscleCategory;
import healthcare.workout.repository.MuscleCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MuscleCategoryService {
    private final MuscleCategoryRepository muscleCategoryRepository;

    @Transactional
    public void saveMuscleCategory(MuscleCategory muscleCategory) {
        muscleCategoryRepository.save(muscleCategory);
    }

    public MuscleCategory findByName(String name) {
        List<MuscleCategory> muscleCategories = muscleCategoryRepository.findByName(name);
        if (muscleCategories.size() > 0) {
            return muscleCategories.get(0);
        } else {
            return null;
        }
    }
    public List<MuscleCategory> findAll() {
        return muscleCategoryRepository.findAll();
    }

}
