package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    // Attributs
    private LinkedList<Event> myAgenda;
    
    
    // Constructeur
    public Agenda() {
        myAgenda = new LinkedList<>();
    }
    
    public void addEvent(Event e) {
        if (e.equals(null)) {
            throw new NullPointerException("Event can't be null");
        }
        myAgenda.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public ArrayList<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> myList = new ArrayList<>();
        for (Event e : myAgenda) {
            if (e.isInDay(day)) {
                myList.add(e);
            }
        }
        return myList;
    }
    
    
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList<Event> myList = new ArrayList<>();
        for (Event e : myAgenda) {
            if (e.getTitle() == title) {
                myList.add(e);
            }
        }   
        return myList;
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        LocalDate startE = e.getStart().toLocalDate();
        LocalDate endE = e.getStart().plus(e.getDuration()).toLocalDate();
        for (Event f : myAgenda) {
            LocalDate startF = f.getStart().toLocalDate();
            LocalDate endF = f.getStart().plus(f.getDuration()).toLocalDate();
            
            if ((startE.isAfter(startF)) && (startE.isBefore(endF)) || ((endE.isAfter(startF)) && (endE.isBefore(endF)))) {
                return false;
            }
        }
        return true;
    }
}
