package therapy.session.Service;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import therapy.session.Model.PatientsModel;
import therapy.session.Repository.PatientsRepository;

@Service
public class PatientsService {

    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private JavaMailSender mailSender;

    public PatientsModel registerPatient(PatientsModel patientsModel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("leahuwase93@gmail.com");
        message.setTo(patientsModel.getEmail());
        message.setText("Thank you for signing up with us ");
        message.setSubject("confirmation email");

        mailSender.send(message);
        return patientsRepository.save(patientsModel);

 }


    public PatientsModel authenticate(PatientsModel patient){
        return patientsRepository.findByEmailAndPassword(patient.getEmail(), patient.getPassword()).orElse(null);
    }
}
