package com.espressoshock.drinkle.models.IAction;

import com.espressoshock.drinkle.models.Account.Account;
import com.espressoshock.drinkle.models.Account.Team;

public interface IBusinessAccountAction {
    boolean addTeam(Team team);
    boolean addMember(Team team, Account member);
    boolean addMemberUsingIndex(int pos, Account member);
    boolean removeMember(Team team, Account member);
    boolean removeMemberUsingIndex(int pos, Team team);//TODO Question for Vincenzo
}
