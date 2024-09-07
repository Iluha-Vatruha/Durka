package Illnesses;

import Patients.Patient;
import Stuff.Doctor;

public interface IAgression extends Ilness{
    void bite (Doctor doctor) throws Exception;
}
