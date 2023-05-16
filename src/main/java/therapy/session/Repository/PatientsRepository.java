package therapy.session.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import therapy.session.Model.PatientsModel;

import java.util.Optional;
@Repository
public interface PatientsRepository extends JpaRepository<PatientsModel, Integer> {

    Optional<PatientsModel> findByEmailAndPassword(String email, String password);
    Optional<PatientsModel> findFirstByEmail(String email);

}
