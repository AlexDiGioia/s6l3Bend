package alexdigioia.s6l3Bend.services;

import alexdigioia.s6l3Bend.entities.Autore;
import alexdigioia.s6l3Bend.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    private final List<Autore> autoreList = new ArrayList<>();

    public List<Autore> findAll() {
        return this.autoreList;
    }

    public Autore saveAutore(Autore body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 10000));
        this.autoreList.add(body);
        return body;
    }

    public Autore findById(int id) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) {
                found = autore;
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Autore findByIdAndUpdate(int id, Autore updatedAutore) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) {
                found = autore;
                found.setNome(updatedAutore.getNome());
                found.setCognome(updatedAutore.getCognome());
                found.setEmail(updatedAutore.getEmail());
                found.setDataDiNascita(updatedAutore.getDataDiNascita());
                found.setAvatar(updatedAutore.getAvatar());
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) {
                found = autore;
            }
        }
        if (found == null) throw new NotFoundException(id);
        this.autoreList.remove(found);
    }
}
