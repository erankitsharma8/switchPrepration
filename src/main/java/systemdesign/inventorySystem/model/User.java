package systemdesign.inventorySystem.model;

import systemdesign.inventorySystem.constants.Containers;
import systemdesign.inventorySystem.constants.Locations;

import java.util.List;

public class User {
    List<Containers> containers;
    Locations from,to;

    String name;


    public User(List<Containers> containers,Locations from,Locations to,String name){
        this.containers=containers;
        this.from=from;
        this.to=to;
        this.name=name;
    }

    public List<Containers> getContainers() {
        return containers;
    }

    public void setContainers(List<Containers> containers) {
        this.containers = containers;
    }

    public Locations getFrom() {
        return from;
    }

    public void setFrom(Locations from) {
        this.from = from;
    }

    public Locations getTo() {
        return to;
    }

    public void setTo(Locations to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
