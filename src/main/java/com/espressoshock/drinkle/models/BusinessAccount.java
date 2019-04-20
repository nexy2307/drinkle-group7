package com.espressoshock.drinkle.models;

public class BusinessAccount extends Account {

    private String vatID;
    private String businessName;
    private Country registrationCountry;
    private Team team;

    public BusinessAccount(String accountID, String accountName, String accountPassword,
                           Person registered, Blueprint blueprint, String vatID,
                           String businessName, Country registrationCountry, Team team) {
        super(accountID, accountName, accountPassword, registered, blueprint);
        this.vatID = vatID;
        this.businessName = businessName;
        this.registrationCountry = registrationCountry;
        this.team = team;
    }

    public String getVatID() {
        return vatID;
    }

    public void setVatID(String vatID) {
        this.vatID = vatID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Country getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(Country registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    // TODO
    public boolean addTeam(Team team){ return true;}

    //TODO
    public boolean addMember(Team team, Account member){ return true;}

    //TODO
    public boolean addMemberUsingIndex(int pos, Account member){return true;}

    //TODO
    public boolean removeMember(Team team, Account member){return true;}

    //TODO  ... the diagram is written "+removeMember(team:int, member:int)
    public boolean removeMemberUsingIndex(Team team, int pos){return true;}


}
