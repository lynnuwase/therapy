package therapy.session.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import therapy.session.Model.Patient2Model;
import therapy.session.Repository.Patient2Repository;

import java.util.List;

@Service
public class Patient2Service implements Patient2{
    @Autowired
    private Patient2Repository patientrepo;

    @Override
    public Patient2Model SavePatient2(Patient2Model patient2) {
        return patientrepo.save(patient2);
    }

    @Override
    public Patient2Model UpdatePatience2(Patient2Model patient2) {

        Patient2Model n = findPatient2ById(patient2);
        if (n != null) {
            n.setId(patient2.getId());
            n.setFirstname(patient2.getFirstname());
            n.setLastname(patient2.getLastname());
            n.setDateofbirth(patient2.getDateofbirth());
            n.setEmail(patient2.getEmail());
            n.setContactnumber(patient2.getContactnumber());
            n.setGender(patient2.getGender());
            n.setInsurance(patient2.getInsurance());
            n.setDoctors(patient2.getDoctors());
            return patientrepo.save(n);
        } else {
            return SavePatient2(patient2);
        }

    }

    @Override
    public void deletePatient2ById(Patient2Model patient2) {
        patientrepo.delete(patient2);
    }

    @Override
    public List<Patient2Model> Patient2List(String keyword) {
        if (keyword != null){
            return patientrepo.search(keyword);
        }
        return patientrepo.findAll();
    }

    @Override
    public Patient2Model findPatient2ById(Patient2Model patient2) {
        return patientrepo.findById(patient2.getId()).get();
    }
}

