public class Team {

    private final int TEAM_MEMBERS_COUNT = 4;
    String name;
    TeamMember[] teamMembers = new TeamMember[TEAM_MEMBERS_COUNT];
    private int teamResult;

    public Team(String name) {
        this.name = name;
        for (int i=0;i<TEAM_MEMBERS_COUNT;i++){
            teamMembers[i] = new TeamMember();
        }
    }

    public void doIt(Course c){
        // прохождение командой полосы препятствий
        teamResult = 0;
        for (int i = 0; i < TEAM_MEMBERS_COUNT; i++) {
            teamMembers[i].setResult(0);
            if (c.getMaxHeight()<=teamMembers[i].getJumpHeight() && c.getMaxLength()<=teamMembers[i].getJumpLength()){
                double efficiency = Math.pow(c.getLength(),2) * 0.1f * (1/teamMembers[i].getStamina())/12000;
                teamMembers[i].setResult( (float)
                        efficiency *
                        ( c.getRunLength() / ( teamMembers[i].getRunSpeed() * 10f / 36f ) ) +
                        ( c.getSwimLength() / ( teamMembers[i].getSwimSpeed() * 10f / 36f ) )
                );
                teamResult += teamMembers[i].getResult();
            }
        }
    }

    public void showResults(){
        // вывод результатов прохождения полосы препятствий
        System.out.println("Результаты прохождения дистанции командой \"" + name+"\"");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < TEAM_MEMBERS_COUNT; i++) {
            float res = teamMembers[i].getResult();
            System.out.print("Спортстмен " + teamMembers[i].getName());
            if (res == 0) System.out.println(" не смог пройти дистанцию.");
            else {
                System.out.println(" прошел дистанцию за " + Math.round(teamMembers[i].getResult()/60) + " мин. " + Math.round(teamMembers[i].getResult()%60)+" сек.");
            }
        }
        System.out.println("Общий результат команды = " + Math.round(teamResult / 60) + " мин. " + Math.round(teamResult % 60)+ " сек.");
    }


}
