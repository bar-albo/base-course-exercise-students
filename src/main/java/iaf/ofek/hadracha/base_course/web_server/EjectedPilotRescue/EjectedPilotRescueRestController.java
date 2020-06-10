package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.Data.CrudDataBase;
import iaf.ofek.hadracha.base_course.web_server.Data.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejectedPilotRescue/infos/")
public class EjectedPilotRescueRestController {
    private final InMemoryMapDataBase dataBase;

    @Autowired
    public EjectedPilotRescueRestController(InMemoryMapDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public <T extends Entity> List<T> get(Class<T> type){
        return dataBase.getAllOfType(type);
    }
}
