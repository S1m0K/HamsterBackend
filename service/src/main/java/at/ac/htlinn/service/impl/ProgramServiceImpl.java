package at.ac.htlinn.service.impl;

import at.ac.htlinn.database.repositories.ProgramRepository;
import at.ac.htlinn.model.entities.Program;
import at.ac.htlinn.model.entities.User;
import at.ac.htlinn.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    ProgramRepository programRepository;

    @Override
    public void compareAndUpdateDatabase(Program program) {
        program.setHashValue(program.hashCode());
        Set<Program> userPrograms = programRepository.findAllByUserID(program.getUserID());

        if (!userPrograms.isEmpty()) {
            userPrograms.forEach(t -> {
                if (t.getHashValue() == program.getHashValue()) {
                    t = program;
                    programRepository.save(t);
                }
            });
        } else {
            programRepository.save(program);
        }
    }

    @Override
    public void saveOrUpdate(Program program) {
        User u = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        program.setUserID(u.getId());
        compareAndUpdateDatabase(program);
    }

    @Override
    public void delete(long programId) {
        Optional<Program> o = programRepository.findById(programId);
        if (o.isPresent()) {
            Program p = o.get();
            programRepository.delete(p);
        }
    }
}
