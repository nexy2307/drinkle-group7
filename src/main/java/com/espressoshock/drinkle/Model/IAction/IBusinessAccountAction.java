package com.espressoshock.drinkle.Model.IAction;

import com.espressoshock.drinkle.Model.Account.Account;
import com.espressoshock.drinkle.Model.Account.Team;

public interface IBusinessAccountAction {
    boolean addTeam(Team team);
    boolean addMember(Team team, Account member);
    boolean addMemberUsingIndex(int pos, Account member);
    boolean removeMember(Team team, Account member);
    boolean removeMemberUsingIndex(int pos, Team team);//TODO Question for Vincenzo
}
