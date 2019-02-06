package org.pursuit.mapappfromscratch.model;

import java.util.List;

public class MuseumsList {

    public List<Museum> museums;

    public MuseumsList(List<Museum> museums) {
        this.museums = museums;
    }

    public List<Museum> getMuseums() {
        return museums;
    }

    public void setMuseums(List<Museum> museums) {
        this.museums = museums;
    }
}
