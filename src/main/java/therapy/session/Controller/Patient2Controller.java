package therapy.session.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import therapy.session.Model.Patient2Model;
import therapy.session.Repository.Patient2Repository;
import therapy.session.Service.Patient2Service;

import java.util.List;
import java.util.Optional;

@Controller
public class Patient2Controller {


    private final Patient2Service patient2Service;
    @Autowired
    private Patient2Repository patient2Repository;

    public Patient2Controller(Patient2Service patient2Service) {
        this.patient2Service = patient2Service;
    }


    @GetMapping("/datas")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String Patient2List(Model model, @Param("keyword") String keyword, Authentication authentication){
        List<Patient2Model> ListOfPatient = patient2Service.Patient2List(keyword);
        model.addAttribute("ListOfPatient", ListOfPatient);
        return "display";
    }


    @GetMapping("/Appointment")
    public  String signup (Model model){
        model.addAttribute("requestAppointment", new Patient2Model());
        return "signup";
    }
    @PostMapping("/appointment")
    public  String appointment(@ModelAttribute Patient2Model patient2){
        System.out.println("request appointment: " + patient2 );
//        Patient2Model registerAppointment= patient2Service.SavePatient2(patient2);
        Patient2Model registeredUser = patient2Service.SavePatient2(patient2);
        return registeredUser == null ? "signup" : "redirect:/datas";
    }
    @GetMapping("/UpdatePatient2/{id}")
    public String UpdatePatience2(@PathVariable("id") Integer id, Model model){
        Optional<Patient2Model> info = patient2Repository.findFirstById(id);
        Patient2Model patient2 = info.get();
        model.addAttribute("patient2",patient2);
        return "Edit";

    }
    @GetMapping("/DeletePatient2/{id}")
    public  String deletePatient2(@PathVariable("id") Integer id){
        patient2Repository.deleteById(id);
        System.out.println("Appointment deleted successfully!!");
        return"redirect:/datas";
    }

}
