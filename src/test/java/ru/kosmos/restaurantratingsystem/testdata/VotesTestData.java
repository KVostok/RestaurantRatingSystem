package ru.kosmos.restaurantratingsystem.testdata;

import ru.kosmos.restaurantratingsystem.MatcherFactory;
import ru.kosmos.restaurantratingsystem.model.Votes;

import static ru.kosmos.restaurantratingsystem.model.AbstractBaseEntity.START_SEQ;

public class VotesTestData {

    public static final MatcherFactory.Matcher<Votes> MATCHER = MatcherFactory.usingEqualsComparator(Votes.class);

    public static final int VOTES_ID = START_SEQ;

}
