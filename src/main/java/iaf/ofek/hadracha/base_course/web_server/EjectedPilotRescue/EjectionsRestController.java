package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.Data.InMemoryMapDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ejectedPilotRescue/infos")
public class EjectionsRestController {
    InMemoryMapDataBase dataBase;

    public EjectionsRestController(@Autowired InMemoryMapDataBase dataBase){
        this.dataBase = dataBase;
    }

    @GetMapping("")
    public List<EjectedPilotInfo> sendEjectionClient(){
        return dataBase.getAllOfType(EjectedPilotInfo.class);
    }
}
