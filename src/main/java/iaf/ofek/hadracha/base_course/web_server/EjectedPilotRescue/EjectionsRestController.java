package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.AirSituation.Airplane;
import iaf.ofek.hadracha.base_course.web_server.AirSituation.AirplaneKind;
import iaf.ofek.hadracha.base_course.web_server.AirSituation.SimulativeAirSituationProvider;
import iaf.ofek.hadracha.base_course.web_server.Data.InMemoryMapDataBase;
import iaf.ofek.hadracha.base_course.web_server.Utilities.GeographicCalculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ejectedPilotRescue")
public class EjectionsRestController {
    InMemoryMapDataBase dataBase;
    AirplanesAllocationManager airplanesAllocationManager;

    public EjectionsRestController(@Autowired InMemoryMapDataBase dataBase,@Autowired AirplanesAllocationManager airplanesAllocationManager){
        this.dataBase = dataBase;
        this.airplanesAllocationManager = airplanesAllocationManager;
    }

    @GetMapping("/infos")
    public List<EjectedPilotInfo> sendEjectionClient(){
        return dataBase.getAllOfType(EjectedPilotInfo.class);
    }

    @GetMapping("/takeResponsibility")
    public void takeResponsibility(@RequestParam int ejectionId, @CookieValue(value = "client-id", defaultValue = "") String clientId){
        EjectedPilotInfo currentEjection = this.dataBase.getByID(ejectionId, EjectedPilotInfo.class);
        if (currentEjection != null) {
            if (currentEjection.getRescuedBy() == null) {
                currentEjection.setRescuedBy(clientId);
                this.dataBase.update(currentEjection);
                this.airplanesAllocationManager.allocateAirplanesForEjection(currentEjection, clientId);
            }
        }
    }
}
