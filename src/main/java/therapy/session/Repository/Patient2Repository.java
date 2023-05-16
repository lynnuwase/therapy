package therapy.session.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import therapy.session.Model.Patient2Model;

import java.util.List;
import java.util.Optional;
@Repository
public interface Patient2Repository extends JpaRepository<Patient2Model, Integer> {
    Optional<Patient2Model> findById(Integer id);
    Optional<Patient2Model> findFirstById(Integer id);

    @Query("SELECT p FROM Patient2Model p WHERE CONCAT(p.id,'',p.email,'',p.firstname,'',p.lastname,'',p.dateofbirth,'',p.contactnumber,'',p.gender,'',p.insurance,'',p.insurance) LIKE %?1% ")
    public List<Patient2Model>search(String keyword);
}
