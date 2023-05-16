package therapy.session.Service;

import therapy.session.Model.Patient2Model;

import java.util.List;

public interface Patient2 {
    Patient2Model SavePatient2(Patient2Model patient2);
    Patient2Model UpdatePatience2(Patient2Model patient2);
    void deletePatient2ById(Patient2Model patient2);
    List<Patient2Model> Patient2List(String keyword);
    Patient2Model findPatient2ById(Patient2Model patient2);
}
