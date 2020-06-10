package iaf.ofek.hadracha.base_course.web_server.EjectedPilotRescue;

import iaf.ofek.hadracha.base_course.web_server.Data.CrudDataBase;
import iaf.ofek.hadracha.base_course.web_server.Data.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejectedPilotRescue/infos/")
public class EjectedPilotRescueRestController {
    private CrudDataBase dataBase;

    public EjectedPilotRescueRestController(@Autowired CrudDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Entity get(int id){
        return this.dataBase.getByID(id);
    }
}
