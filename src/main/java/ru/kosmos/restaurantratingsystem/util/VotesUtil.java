package ru.kosmos.restaurantratingsystem.util;

import ru.kosmos.restaurantratingsystem.dto.VotesDTO;
import ru.kosmos.restaurantratingsystem.model.Votes;

import java.util.Collection;
import java.util.List;

public class VotesUtil {
    public static List<VotesDTO> getDTOs(Collection<Votes> votes) {
        return votes.stream()
                .map(vote -> createDTO(vote))
                .toList();
    }

    public static VotesDTO createDTO(Votes votes) {
        return new VotesDTO(votes);
    }
}
